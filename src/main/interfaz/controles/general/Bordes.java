package main.interfaz.controles.general;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

import main.interfaz.util.Varios;

public class Bordes {
	private Border _borde;
	
	public Bordes(Color color) {
		if (Varios.objetoEsNulo(color)) {
			throw new IllegalArgumentException("Color no puede estar vacio");
		}
		
		_borde = BorderFactory.createLineBorder(color);
	}
	
	public Border obtenerBorde() {
		return _borde;
	}
}
