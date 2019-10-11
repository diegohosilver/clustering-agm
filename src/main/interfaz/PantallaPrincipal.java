package main.interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.io.File;

import java.util.List;

import main.interfaz.controles.Boton;
import main.interfaz.controles.Etiqueta;
import main.interfaz.controles.Mapa;
import main.interfaz.controles.Panel;
import main.interfaz.controles.SelectorArchivo;
import main.interfaz.controles.combo.Combo;
import main.interfaz.controles.combo.ComboItem;
import main.interfaz.controles.general.Bordes;
import main.interfaz.controles.general.Dimensiones;
import main.interfaz.util.*;

import java.awt.Color;

public class PantallaPrincipal extends JFrame {

	private SelectorArchivo selectorDeArchivo;
	private JPanel acciones;
	private JButton botonArchivo;
	private JButton botonLimpiar;
	private Mapa mapa;

	public PantallaPrincipal() {
		super();
		inicializarMarco();	
		inicializarMapa();
		inicializarSelectorDeArchivos();
		inicializarSelectorDeInstancias();

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
	}

	private void inicializarSelectorDeArchivos() {
		selectorDeArchivo = new SelectorArchivo();

		botonArchivo = Boton.generar("Abrir archivo", new Dimensiones(145, 28, 130, 20), new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				File archivo = selectorDeArchivo.seleccionarArchivo();

				if (!Varios.objetoEsNulo(archivo)) {
					levantarCoordenadasDesdeArchivo(archivo.getAbsolutePath());
	
					establecerEstadoBotonArchivo(false);
					establecerEstadoBotonLimpiar(true);
				}
			}
		});

		botonLimpiar = Boton.generar("Limpiar mapa", new Dimensiones(285, 28, 130, 20), new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mapa.vaciar();

				establecerEstadoBotonArchivo(true);
				establecerEstadoBotonLimpiar(false);
			}
		});

		acciones.add(botonArchivo);
		acciones.add(botonLimpiar);
	}

	private void inicializarSelectorDeInstancias() {	
		acciones.add(Etiqueta.generar("Seleccione una instancia para cargar un conjunto de coordenadas por defecto, o suba un archivo con coordenadas:", new Dimensiones(5, 5, 1000, 20)));
		
		acciones.add(Combo.generar(new Dimensiones(5, 28, 130, 20), Instancias.listar(), new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mapa.removerMarcadores();
				
				JComboBox c = (JComboBox) e.getSource();
				ComboItem item = (ComboItem) c.getSelectedItem();
				
				cargarInstancia(item.obtenerId());
				
				establecerEstadoBotonArchivo(false);
				establecerEstadoBotonLimpiar(true);
			}
		}));
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

	private void establecerEstadoBotonArchivo(Boolean activo) {
		botonArchivo.setEnabled(activo);
	}

	private void establecerEstadoBotonLimpiar(Boolean activo) {
		botonLimpiar.setEnabled(activo);
	}
}
