package main.interfaz.controles;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.JMapViewer;

public class Mapa {

	public static JMapViewer generar(Coordinate coordenada, int zoom) {
		JMapViewer mapa = new JMapViewer();
		mapa.setDisplayPosition(coordenada, zoom);
		return mapa;
	}
	
	public static Coordinate coordenada(double latitud, double longitud) {
		return new Coordinate(latitud, longitud);
	}
}
