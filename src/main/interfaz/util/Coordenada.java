package main.interfaz.util;

import org.openstreetmap.gui.jmapviewer.Coordinate;

public class Coordenada {
	
	public static boolean latitudEsValida(double latitud) {
		return (latitud > -90 && latitud < 90);
	}
	
	public static boolean longitudEsValida(double longitud) {
		return (longitud > -180 && longitud < 180);
	}
	
	// Función extraída del siguiente enlace -> https://www.geodatasource.com/developers/java
	public static double distanciaEntreCoordenadas(Coordinate coordenada1, Coordinate coordenada2, Unidad unidad) {
		if (Varios.objetoEsNulo(coordenada1) || Varios.objetoEsNulo(coordenada2)) {
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
	
	public static Coordinate generar(double latitud, double longitud) {
		if (!Coordenada.latitudEsValida(latitud)) {
			throw new IllegalArgumentException("Latitud debe ser mayor a -90 y menor a 90");
		}
		
		if (!Coordenada.longitudEsValida(longitud)) {
			throw new IllegalArgumentException("Longitud debe ser mayor a -180 y menor a 180");
		}
		
		return new Coordinate(latitud, longitud);
	}

}
