package main.interfaz;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.openstreetmap.gui.jmapviewer.Coordinate;

import main.interfaz.util.Varios;

public class Coleccion {
	private static Coleccion _instancia = null;
	private Map<Integer, Coordinate> _items;
	
	private Coleccion() {
		_items = new HashMap<Integer, Coordinate>();
	}

	public static Coleccion obtenerInstancia() {
		if (_instancia == null) {
			_instancia = new Coleccion();
		}
		
		return _instancia;
	}
	
	public Coordinate obtenerCoordenada(int vertice) {
		Optional<Coordinate> coordenada = _items.entrySet().stream()
			.filter(x -> vertice == x.getKey())
			.map(Map.Entry::getValue)
			.findFirst();
		
		if (!coordenada.isPresent()) {
			throw new NoSuchElementException("El vertice ingresado no existe");
		}
		
		return coordenada.get();
	}
	
	public void agregarCoordenada(int vertice, Coordinate coordenada) {
		if (Varios.objetoEsNulo(coordenada)) {
			throw new IllegalArgumentException("Coordenada no puede estar vacia");
		}
		
		_items.put(vertice, coordenada);
	}
	
	public Map<Integer, Coordinate> obtenerCoordenadas() {
		return _items;
	}
	
	public void limpiarCoordenadas() {
		_items.clear();
	}
}
