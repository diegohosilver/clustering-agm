package main.interfaz.util;

import java.awt.event.ActionListener;
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
import main.interfaz.controles.general.Dimensiones;

public class Varios {
	
	public static boolean stringEsVacioONulo(String cadena) {
		return !(cadena != null && cadena.length() > 0);
	}

	public static boolean objetoEsNulo(Object instancia) {
		return instancia == null;
	}
	
	public static double stringADouble(String valor) {
		try {
			return Double.parseDouble(valor);
		}
		catch(Exception ex) {
			return 0;
		}
	}
	
	public static void validarTextoVacio(String texto) {
		if (Varios.stringEsVacioONulo(texto)) {
			throw new IllegalArgumentException("Texto no puede estar vacio");
		}
	}
	
	public static void validarEvento(ActionListener evento) {
		if (Varios.objetoEsNulo(evento)) {
			throw new IllegalArgumentException("Evento no puede estar vacio");
		}
	}
	
	public static void validarDimensiones(Dimensiones dimensiones) {
		if (Varios.objetoEsNulo(dimensiones)) {
			throw new IllegalArgumentException("Dimensiones no puede estar vacio");
		}
	}
}
