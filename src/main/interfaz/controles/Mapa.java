package main.interfaz.controles;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.Layer;
import org.openstreetmap.gui.jmapviewer.LayerGroup;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;
import org.openstreetmap.gui.jmapviewer.MapPolygonImpl;

import main.interfaz.Utilidades;

public class Mapa {
	
	private JMapViewer _viewer;
	private LayerGroup _capaMaestra;
	private Layer _capa;
	
	public Mapa(Coordinate coordenada, int zoom) {
		if (Utilidades.ObjetoEsNulo(coordenada)) {
			throw new IllegalArgumentException("Coordenada no puede estar vacia");
		}
		
		_viewer = new JMapViewer();
		_viewer.setDisplayPosition(coordenada, zoom);
	}
	
	public static Coordinate generarCoordenada(double latitud, double longitud) {
		if (!Utilidades.LatitudEsValida(latitud)) {
			throw new IllegalArgumentException("Latitud debe ser mayor a -90 y menor a 90");
		}
		
		if (!Utilidades.LongitudEsValida(longitud)) {
			throw new IllegalArgumentException("Longitud debe ser mayor a -180 y menor a 180");
		}
		
		return new Coordinate(latitud, longitud);
	}
	
	public JMapViewer obtenerViewer() {
		return _viewer;
	}
	
	public void agregarMarcador(double latitud, double longitud) {
		if (!viewerPoseeCapas()) {
			inicializarCapas();
		}
		
		_viewer.addMapMarker(new MapMarkerDot(_capa, latitud, longitud));
	}
	
	public void agregarMarcador(double latitud, double longitud, String nombre) {
		if (!viewerPoseeCapas()) {
			inicializarCapas();
		}
		
		if (Utilidades.StringEsVacioONulo(nombre)) {
			agregarMarcador(latitud, longitud);
		}
		else {
			_viewer.addMapMarker(new MapMarkerDot(_capa, nombre, latitud, longitud));
		}
	}
	
	public void agregarLinea(Coordinate coordenada1, Coordinate coordenada2) {
		if (Utilidades.ObjetoEsNulo(coordenada1) || Utilidades.ObjetoEsNulo(coordenada2)) {
			throw new IllegalArgumentException("Coordenada no puede estar vacia");
		}
		
		_viewer.addMapPolygon(new MapPolygonImpl(coordenada1, coordenada2, coordenada1));
	}
	
	private void inicializarCapas() {
		_capaMaestra = new LayerGroup("CapaMaestra");
		_capa = _capaMaestra.addLayer("Capa");
	}
	
	private boolean viewerPoseeCapas() {
		return _capaMaestra != null && _capa != null;
	}
}
