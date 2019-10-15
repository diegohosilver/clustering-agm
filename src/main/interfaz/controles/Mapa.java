package main.interfaz.controles;

import java.util.List;
import java.util.stream.Collectors;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.Layer;
import org.openstreetmap.gui.jmapviewer.LayerGroup;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;
import org.openstreetmap.gui.jmapviewer.MapPolygonImpl;
import org.openstreetmap.gui.jmapviewer.interfaces.MapMarker;

import main.interfaz.util.*;

public class Mapa {
	
	private JMapViewer _viewer;
	private LayerGroup _capaMaestra;
	private Layer _capa;
	
	public Mapa() {		
		_viewer = new JMapViewer();
		_viewer.setSize(1280, 620);
	}
	
	public JMapViewer obtenerViewer() {
		return _viewer;
	}
	
	public void establecerVista(Coordinate coordenada, int zoom) {
		if (Varios.objetoEsNulo(coordenada)) {
			throw new IllegalArgumentException("Coordenada no puede estar vacia");
		}
		
		_viewer.setDisplayPosition(coordenada, zoom);
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
		
		if (Varios.stringEsVacioONulo(nombre)) {
			agregarMarcador(latitud, longitud);
		}
		else {
			_viewer.addMapMarker(new MapMarkerDot(_capa, nombre, latitud, longitud));
		}
	}
	
	public void agregarLinea(Coordinate coordenada1, Coordinate coordenada2) {
		if (Varios.objetoEsNulo(coordenada1) || Varios.objetoEsNulo(coordenada2)) {
			throw new IllegalArgumentException("Coordenada no puede estar vacia");
		}
		
		_viewer.addMapPolygon(new MapPolygonImpl(coordenada1, coordenada2, coordenada1));
	}
	
	private void inicializarCapas() {
		_capaMaestra = new LayerGroup("CapaMaestra");
		_capa = _capaMaestra.addLayer("Capa");
	}
	
	private boolean viewerPoseeCapas() {
		return !Varios.objetoEsNulo(_capaMaestra) && Varios.objetoEsNulo(_capa);
	}
	
	public void cargarCoordenadas(List<String> coordenadas) {
		for(String coordenada : coordenadas) {
			
			String[] latitudYLongitud = coordenada.trim().split(" ", 2);
			
			if (latitudYLongitud.length > 1) {		
				agregarMarcador(
						Varios.stringADouble(latitudYLongitud[0]),
						Varios.stringADouble(latitudYLongitud[1])
						);
			}
		}	
	}
	
	public List<Coordinate> obtenerCoordenadas() {
		List<MapMarker> marcadores = _viewer.getMapMarkerList();
		
		return marcadores.stream().map(x -> x.getCoordinate()).collect(Collectors.toList());
	}
	
	public void vaciar() {
		removerMarcadores();
		removerLineas();
	}
	
	public void removerMarcadores() {
		_viewer.removeAllMapMarkers();
	}
	
	public void removerLineas() {
		_viewer.removeAllMapPolygons();
	}
}
