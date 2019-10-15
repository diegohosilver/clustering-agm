package main.interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

import org.openstreetmap.gui.jmapviewer.Coordinate;

import java.io.File;

import java.util.List;
import java.util.Map;

import main.interfaz.controles.Boton;
import main.interfaz.controles.Etiqueta;
import main.interfaz.controles.Mapa;
import main.interfaz.controles.Panel;
import main.interfaz.controles.SelectorArchivo;
import main.interfaz.controles.Texto;
import main.interfaz.controles.combo.Combo;
import main.interfaz.controles.combo.ComboItem;
import main.interfaz.controles.general.Bordes;
import main.interfaz.controles.general.Dimensiones;
import main.interfaz.util.*;
import main.negocio.Kruskal;
import main.negocio.grafo.Arista;
import main.negocio.grafo.Grafo;

import java.awt.Color;

public class PantallaPrincipal extends JFrame {

	private SelectorArchivo selectorDeArchivo;
	private JTextField texto;
	private JPanel acciones;
	private JButton botonArchivo;
	private JButton botonLimpiar;
	private JButton botonKruskal;
	private Mapa mapa;

	private Coleccion coleccion;
	
	// 
	private Grafo grafo;
	private Kruskal kruskal;

	public PantallaPrincipal() {
		super();
		
		coleccion = Coleccion.obtenerInstancia();
		kruskal = new Kruskal();
		
		inicializarMarco();	
		inicializarMapa();
		inicializarBotones();
		inicializarSelectorDeInstancias();
		inicializarTexto();

		establecerEstadoBotonArchivo(false);
	}

	private void inicializarMarco() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 1280, 720);
		this.setResizable(false);
		this.getContentPane().setLayout(null);

		acciones = Panel.generar(new Dimensiones(5, 635, 1263, 53), new Bordes(Color.black));

		this.getContentPane().add(acciones);
	}

	private void inicializarMapa() {		
		mapa = new Mapa();
		this.getContentPane().add(mapa.obtenerViewer());
		
		cargarInstancia(1);
		
		generarGrafo();
	}

	private void inicializarBotones() {
		selectorDeArchivo = new SelectorArchivo();

		botonArchivo = Boton.generar("Abrir archivo", new Dimensiones(145, 28, 130, 20), new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				File archivo = selectorDeArchivo.seleccionarArchivo();

				if (!Varios.objetoEsNulo(archivo)) {
					levantarCoordenadasDesdeArchivo(archivo.getAbsolutePath());
					
					generarGrafo();
	
					establecerEstadoBotonArchivo(false);
					establecerEstadoBotonLimpiar(true);
					establecerEstadoBotonKruskal(true);
				}
			}
		});

		botonLimpiar = Boton.generar("Limpiar mapa", new Dimensiones(285, 28, 130, 20), new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mapa.vaciar();

				establecerEstadoBotonArchivo(true);
				establecerEstadoBotonLimpiar(false);
				establecerEstadoBotonKruskal(false);
			}
		});
		
		botonKruskal = Boton.generar("Ejecutar kruskal", new Dimensiones(1107, 28, 150, 20), new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				establecerEstadoBotonKruskal(false);			
				mapa.removerLineas();				
				validarDensidad();
				
				try {
					new SwingWorker() {

						@Override
						protected Boolean doInBackground() throws Exception {							
							algoritmoKruskal();

							return true;
						}
						
						@Override
					       protected void done() {
					           try {
									dibujarAristas();
									
									establecerEstadoBotonKruskal(true);
					           } catch (Exception ex) {}
					       }
						
					}.execute();			
					
				} catch (Exception ex) {}
			}
		});

		acciones.add(botonArchivo);
		acciones.add(botonLimpiar);
		acciones.add(botonKruskal);
	}

	private void inicializarSelectorDeInstancias() {	
		acciones.add(Etiqueta.generar("Seleccione una instancia para cargar un conjunto de coordenadas por defecto, o suba un archivo con coordenadas:", new Dimensiones(5, 5, 1000, 20)));
		
		acciones.add(Combo.generar(new Dimensiones(5, 28, 130, 20), Instancias.listar(), new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mapa.vaciar();
				
				JComboBox c = (JComboBox) e.getSource();
				ComboItem item = (ComboItem) c.getSelectedItem();
				
				cargarInstancia(item.obtenerId());
				
				generarGrafo();
				
				establecerEstadoBotonArchivo(false);
				establecerEstadoBotonLimpiar(true);
			}
		}));
	}
	
	private void inicializarTexto() {
		acciones.add(Etiqueta.generar("% Densidad:", new Dimensiones(1010, 5, 150, 20)));
		
		texto = Texto.generarTexto(new Dimensiones(1107, 5, 150, 20), Color.WHITE, true);
		acciones.add(texto);
	}
	
	private void cargarInstancia(int instancia) {		
		Instancia datosDeInstancia = Instancias.obtenerDatosDeInstancia(instancia);
		
		mapa.establecerVista(datosDeInstancia.obtenerCoordenadaInicial(), datosDeInstancia.obtenerZoomInicial());
		
		levantarCoordenadasDesdeArchivo(datosDeInstancia.obtenerRutaArchivo());
	}

	private void levantarCoordenadasDesdeArchivo(String path) {
		if (!Varios.stringEsVacioONulo(path)) {
			List<String> coordenadas = Archivo.leer(path);

			mapa.cargarCoordenadas(coordenadas);
		}
	}
	
	private void generarGrafo() {	
		grafo = new Grafo();
		coleccion.limpiarCoordenadas();
		
		int vertice = 0;		
		
		for (Coordinate coordenada : mapa.obtenerCoordenadas()) {
			coleccion.agregarCoordenada(vertice, coordenada);
			
			grafo.agregarVertice(vertice);
			
			vertice ++;
		}
	}
	
	private void validarDensidad() {
		texto.setText(Double.toString(Varios.stringADouble(texto.getText())));
	}

	private void algoritmoKruskal() {		
		generarAristas();
		
		grafo = kruskal.ejecutarAlgoritmo(grafo);
		
		grafo.eliminarAristasSobreMedia(Varios.stringADouble(texto.getText()));
	}
	
	private void generarAristas() {
		for (Map.Entry<Integer, Coordinate> item1 : coleccion.obtenerCoordenadas().entrySet()) {
			for (Map.Entry<Integer, Coordinate> item2 : coleccion.obtenerCoordenadas().entrySet()) {
				
				// Evitar aristas sobre un mismo vertice
				int vertice1 = item1.getKey();
				int vertice2 = item2.getKey();
				
				if (vertice1 != vertice2) {
					double distancia = Coordenada.distanciaEntreCoordenadas(item1.getValue(), item2.getValue(), Unidad.Kilometros);
				
					grafo.agregarArista(vertice1, vertice2, distancia);
				}
			}
		}
	}
	
	private void dibujarAristas() {
		for (Arista arista : grafo.obtenerAristas()) {
			Coordinate coordenada1 = coleccion.obtenerCoordenada(arista.obtenerVerticeInicial());
			Coordinate coordenada2 = coleccion.obtenerCoordenada(arista.obtenerVerticeFinal());
			
			mapa.agregarLinea(coordenada1, coordenada2);
		}
	}

	private void establecerEstadoBotonArchivo(Boolean activo) {
		botonArchivo.setEnabled(activo);
	}

	private void establecerEstadoBotonLimpiar(Boolean activo) {
		botonLimpiar.setEnabled(activo);
	}
	
	private void establecerEstadoBotonKruskal(Boolean activo) {
		botonKruskal.setEnabled(activo);
	}
}
