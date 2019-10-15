package main.interfaz.util.archivos;

import org.openstreetmap.gui.jmapviewer.Coordinate;

public class Instancia {
	private String _path;
	private Coordinate _coordenadaInicial;
	private int _zoomInicial;
	
	public Instancia(String path, Coordinate coordenadaInicial, int zoomInicial) {
		_path = path;
		_coordenadaInicial = coordenadaInicial;
		_zoomInicial = zoomInicial;
	}
	
	public String obtenerRutaArchivo() {
		return _path;
	}
	
	public Coordinate obtenerCoordenadaInicial() {
		return _coordenadaInicial;
	}
	
	public int obtenerZoomInicial() {
		return _zoomInicial;
	}
}
