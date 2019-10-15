package main.interfaz.controles;

import java.awt.Font;

import javax.swing.JLabel;

import main.interfaz.controles.general.Dimensiones;
import main.interfaz.util.Varios;

public class Etiqueta {

	private static JLabel generarEtiquetaConPropiedades(String texto, Dimensiones dimensiones, int fuente, float tamanio) {		
		JLabel etiqueta = new JLabel(texto);
		
		etiqueta.setFont(etiqueta.getFont().deriveFont(etiqueta.getFont().getStyle() | fuente, tamanio));
		etiqueta.setBounds(dimensiones.obtenerX(), dimensiones.obtenerY(), dimensiones.obtenerAncho(), dimensiones.obtenerAlto());
		
		return etiqueta;
	}
	
	public static JLabel generar(String texto, Dimensiones dimensiones) {	
		Varios.validarTextoVacio(texto);	
		Varios.validarDimensiones(dimensiones);
		
		return generarEtiquetaConPropiedades(texto, dimensiones, Font.BOLD, 15F);
	}
	
}
