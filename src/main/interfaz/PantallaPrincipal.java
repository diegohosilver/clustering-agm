package main.interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import main.interfaz.controles.Boton;
import main.interfaz.controles.Mapa;
import main.interfaz.controles.Panel;
import main.interfaz.controles.SelectorArchivo;
import main.interfaz.controles.general.Bordes;
import main.interfaz.controles.general.Dimensiones;
import main.interfaz.controles.general.Esquema;
import java.awt.FlowLayout;
import javax.swing.border.LineBorder;

import java.awt.BorderLayout;
import java.awt.Color;

public class PantallaPrincipal extends JFrame {

	private SelectorArchivo selectorDeArchivo;
	private JPanel acciones;
	private Mapa mapa;

	public PantallaPrincipal() {
		super();
		inicializarMarco();	
		inicializarMapa();
		inicializarSelectorDeArchivos();
	}
	
	private void inicializarMarco() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 1280, 720);
		this.setResizable(false);
		this.getContentPane().setLayout(null);
		
		acciones = Panel.generar(new Dimensiones(5, 635, 1263, 50), new Bordes(Color.black));
		
		this.getContentPane().add(acciones);
	}

	private void inicializarMapa() {
		mapa = new Mapa(Mapa.generarCoordenada(-34.6179915, -58.5033382), 10);
		this.getContentPane().add(mapa.obtenerViewer());
	}
	
	private void inicializarSelectorDeArchivos() {
		selectorDeArchivo = new SelectorArchivo();
		
		acciones.add(Boton.generar("Abrir archivo", new Dimensiones(5, 5, 130, 20), new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				File archivo = selectorDeArchivo.seleccionarArchivo();
				
				if (!Utilidades.objetoEsNulo(archivo)) {
					List<String> coordenadas = Utilidades.leerArchivo(archivo.getAbsolutePath());
					
					mapa.cargarCoordenadas(coordenadas);
				}
			}
		}));
	}
}
