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
	private JMapViewer mapa;

	/**
	 * Create the frame.
	 */
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
		mapa = Mapa.generar(Mapa.coordenada(-34.6179915, -58.5033382), 10);
		contenido.add(mapa);
	}
}
