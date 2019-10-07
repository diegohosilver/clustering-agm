package main.interfaz;

public class Utilidades {
	
	public static boolean StringEsVacioONulo(String cadena) {
		return !(cadena != null && cadena.length() > 0);
	}

	public static boolean ObjetoEsNulo(Object instancia) {
		return instancia == null;
	}
	
	public static boolean LatitudEsValida(double latitud) {
		return (latitud > -90 && latitud < 90);
	}
	
	public static boolean LongitudEsValida(double longitud) {
		return (longitud > -180 && longitud < 180);
	}
}
