package main.interfaz.controles;

import javax.swing.JOptionPane;

import main.interfaz.util.Utilidades;

public class Alerta {

	public static void mostrar(String mensaje) {
		if (Utilidades.stringEsVacioONulo(mensaje)) {
			throw new IllegalArgumentException("Mensaje no puede estar vacio");
		}
		
		JOptionPane.showMessageDialog(null, mensaje);
	}

}
