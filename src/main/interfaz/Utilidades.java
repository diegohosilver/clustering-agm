package main.interfaz;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.JOptionPane;

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
			JOptionPane.showMessageDialog(null, "Ocurrió un error al abrir el archivo");
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
}
