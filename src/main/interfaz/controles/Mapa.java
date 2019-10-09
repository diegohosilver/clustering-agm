package main.interfaz.controles;

import java.util.List;

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
		if (Utilidades.objetoEsNulo(coordenada)) {
			throw new IllegalArgumentException("Coordenada no puede estar vacia");
		}
		
		_viewer = new JMapViewer();
		_viewer.setDisplayPosition(coordenada, zoom);
		_viewer.setSize(1280, 620);
	}
	
	public static Coordinate generarCoordenada(double latitud, double longitud) {
		if (!Utilidades.latitudEsValida(latitud)) {
			throw new IllegalArgumentException("Latitud debe ser mayor a -90 y menor a 90");
		}
		
		if (!Utilidades.longitudEsValida(longitud)) {
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
		
		if (Utilidades.stringEsVacioONulo(nombre)) {
			agregarMarcador(latitud, longitud);
		}
		else {
			_viewer.addMapMarker(new MapMarkerDot(_capa, nombre, latitud, longitud));
		}
	}
	
	public void agregarLinea(Coordinate coordenada1, Coordinate coordenada2) {
		if (Utilidades.objetoEsNulo(coordenada1) || Utilidades.objetoEsNulo(coordenada2)) {
			throw new IllegalArgumentException("Coordenada no puede estar vacia");
		}
		
		_viewer.addMapPolygon(new MapPolygonImpl(coordenada1, coordenada2, coordenada1));
	}
	
	private void inicializarCapas() {
		_capaMaestra = new LayerGroup("CapaMaestra");
		_capa = _capaMaestra.addLayer("Capa");
	}
	
	private boolean viewerPoseeCapas() {
		return !Utilidades.objetoEsNulo(_capaMaestra) && Utilidades.objetoEsNulo(_capa);
	}
	
	public void cargarCoordenadas(List<String> coordenadas) {
		for(String coordenada : coordenadas) {
			String[] latitudYLongitud = coordenada.split(" ", 2);
			
			if (latitudYLongitud.length > 1) {		
				agregarMarcador(
						Utilidades.stringADouble(latitudYLongitud[0]),
						Utilidades.stringADouble(latitudYLongitud[1])
						);
			}
		}	
	}
}
