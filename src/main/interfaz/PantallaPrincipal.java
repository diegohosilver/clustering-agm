package main.interfaz;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.openstreetmap.gui.jmapviewer.JMapViewer;

import main.interfaz.controles.Mapa;
import main.interfaz.controles.Panel;
import main.interfaz.controles.general.Bordes;
import main.interfaz.controles.general.Esquema;

public class PantallaPrincipal extends JFrame {

	private JPanel contenido;
	private Mapa mapa;

	public PantallaPrincipal() {	
		inicializarMarco();	
		inicializarMapa();
	}
	
	private void inicializarMarco() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contenido = Panel.generar(new Bordes(5, 5, 5, 5), new Esquema(0, 0));
		setContentPane(contenido);
	}

	private void inicializarMapa() {
		mapa = new Mapa(Mapa.generarCoordenada(-34.6179915, -58.5033382), 10);
		contenido.add(mapa.obtenerViewer());
		
		mapa.agregarMarcador(-34.6179915, -58.5033382);
		
		mapa.agregarLinea(Mapa.generarCoordenada(-34.6179915, -58.5033382), Mapa.generarCoordenada(-34.6179915, -60.5033382));
	}
}
