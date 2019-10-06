package main.interfaz.controles;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.interfaz.controles.general.Bordes;
import main.interfaz.controles.general.Esquema;

public class Panel {
	
	private static JPanel generarConPropiedades(Bordes bordes, Esquema esquema) {
		JPanel panel = new JPanel();
		
		panel.setBorder(new EmptyBorder(
					bordes.obtenerArriba(),
					bordes.obtenerIzquierda(),
					bordes.obtenerAbajo(),
					bordes.obtenerDerecha()
				));
		panel.setLayout(new BorderLayout(
					esquema.obtenerEspacioHorizontal(),
					esquema.obtenerEspacioVertical()
				));
		
		return panel;
	}
	
	public static JPanel generar(Bordes bordes, Esquema esquema) {
		return generarConPropiedades(bordes, esquema);
	}

}
