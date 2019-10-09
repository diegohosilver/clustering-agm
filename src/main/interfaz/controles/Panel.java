package main.interfaz.controles;

import javax.swing.JPanel;

import main.interfaz.Utilidades;
import main.interfaz.controles.general.Bordes;
import main.interfaz.controles.general.Dimensiones;

public class Panel {
	
	private static void validarDimensiones(Dimensiones dimensiones) {
		if (Utilidades.objetoEsNulo(dimensiones)) {
			throw new IllegalArgumentException("Dimensiones no puede estar vacio");
		}
	}
	
	private static void validarBordes(Bordes bordes) {
		if (Utilidades.objetoEsNulo(bordes)) {
			throw new IllegalArgumentException("Bordes no puede estar vacio");
		}
	}
	
	private static JPanel generarConPropiedades(Dimensiones dimensiones) {
		validarDimensiones(dimensiones);
		
		JPanel panel = new JPanel();

		panel.setLayout(null);		
		panel.setBounds(dimensiones.obtenerX(), dimensiones.obtenerY(), dimensiones.obtenerAncho(), dimensiones.obtenerAlto());
		
		return panel;
	}
	
	public static JPanel generar(Dimensiones dimensiones) {
		return generarConPropiedades(dimensiones);
	}
	
	public static JPanel generar(Dimensiones dimensiones, Bordes bordes) {
		validarBordes(bordes);
		
		JPanel panel = generarConPropiedades(dimensiones);
		
		panel.setBorder(bordes.obtenerBorde());
		
		return panel;
	}

}
