package main.interfaz.controles;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

import main.interfaz.controles.general.Dimensiones;
import main.interfaz.util.Varios;

public class Texto {
	
	private static JTextField generarTextoConPropiedades(Dimensiones dimensiones, Color colorFondo, boolean editable, int fuente, float tamanio, int alineacion, int columnas) {
		JTextField texto = new JTextField();
		
		texto.setBackground(colorFondo);
		texto.setEditable(editable);
		texto.setFont(texto.getFont().deriveFont(texto.getFont().getStyle() | fuente, texto.getFont().getSize() + tamanio));
		texto.setHorizontalAlignment(alineacion);
		texto.setBounds(dimensiones.obtenerX(), dimensiones.obtenerY(), dimensiones.obtenerAncho(), dimensiones.obtenerAlto());
		texto.setColumns(columnas);
		
		return texto;
	}
	
	public static JTextField generar(Dimensiones dimensiones, Color colorFondo, boolean editable) {
		if (Varios.objetoEsNulo(dimensiones)) {
			throw new IllegalArgumentException("Dimensiones no puede estar vacio");
		}
		
		if (Varios.objetoEsNulo(colorFondo)) {
			throw new IllegalArgumentException("Color no puede estar vacio");
		}
		
		return generarTextoConPropiedades(dimensiones, colorFondo, editable, Font.BOLD, 3f, SwingConstants.RIGHT, 10);
	}

}
