package main.interfaz.controles;

import javax.swing.JOptionPane;

import main.interfaz.util.Varios;

public class Alerta {

	public static void mostrar(String mensaje) {
		if (Varios.stringEsVacioONulo(mensaje)) {
			throw new IllegalArgumentException("Mensaje no puede estar vacio");
		}
		
		JOptionPane.showMessageDialog(null, mensaje);
	}

}
