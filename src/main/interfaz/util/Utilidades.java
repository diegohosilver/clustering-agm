package main.interfaz.util;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.JOptionPane;

import org.openstreetmap.gui.jmapviewer.Coordinate;

import main.interfaz.controles.Alerta;

public class Utilidades {
	
	public static boolean stringEsVacioONulo(String cadena) {
		return !(cadena != null && cadena.length() > 0);
	}

	public static boolean objetoEsNulo(Object instancia) {
		return instancia == null;
	}
	
	public static boolean latitudEsValida(double latitud) {
		return (latitud > -90 && latitud < 90);
	}
	
	public static boolean longitudEsValida(double longitud) {
		return (longitud > -180 && longitud < 180);
	}
	
	public static List<String> leerArchivo(String path) {
		 List<String> renglones = new ArrayList<String>();
		
		try {
			Stream<String> lineas = Files.lines(Paths.get(path), Charset.defaultCharset());
			renglones = lineas.collect(Collectors.toList());
			lineas.close();
		}
		catch(Exception ex) {
			Alerta.mostrar("Ocurrio un error al abrir el archivo");
		}
		
		return renglones;
	}
	
	public static double stringADouble(String valor) {
		try {
			return Double.parseDouble(valor);
		}
		catch(Exception ex) {
			return 0;
		}
	}
	
	// Función extraída del siguiente enlace -> https://www.geodatasource.com/developers/java
	public static double distanciaEntreCoordenadas(Coordinate coordenada1, Coordinate coordenada2, Unidad unidad) {
		if (objetoEsNulo(coordenada1) || objetoEsNulo(coordenada2)) {
			throw new IllegalArgumentException("Coordenada no puede estar vacio");
		}
		
		double lat1, lat2, lon1, lon2;
		
		lat1 = coordenada1.getLat();
		lat2 = coordenada2.getLat();
		lon1 = coordenada1.getLon();
		lon2 = coordenada2.getLon();
		
		if ((lat1 == lat2) && (lon1 == lon2)) {
			return 0;
		}
		else {
			double theta = lon1 - lon2;
			double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
			dist = Math.acos(dist);
			dist = Math.toDegrees(dist);
			dist = dist * 60 * 1.1515;
			
			if (unidad == Unidad.Kilometros) {
				dist = dist * 1.609344;
			}
			
			return dist;
		}
	}
}
