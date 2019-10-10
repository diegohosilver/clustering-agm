package main.interfaz.controles;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import main.interfaz.controles.general.Dimensiones;
import main.interfaz.util.Utilidades;

public class Boton {
	
	// Arrojar excepcion por texto vacio
	private static void validarTextoVacio(String texto) {
		if (Utilidades.stringEsVacioONulo(texto)) {
			throw new IllegalArgumentException("Texto no puede estar vacio");
		}
	}
	
	private static void validarEvento(ActionListener evento) {
		if (Utilidades.objetoEsNulo(evento)) {
			throw new IllegalArgumentException("Evento no puede estar vacio");
		}
	}
	
	private static void validarDimensiones(Dimensiones dimensiones) {
		if (Utilidades.objetoEsNulo(dimensiones)) {
			throw new IllegalArgumentException("Dimensiones no puede estar vacio");
		}
	}
	

	private static JButton generarBotonConPropiedades(String texto, Dimensiones dimensiones, int fuente, float tamanio) {
		validarTextoVacio(texto);	
		validarDimensiones(dimensiones);
		
		JButton boton = new JButton(texto);
		
		boton.setFont(boton.getFont().deriveFont(boton.getFont().getStyle() | fuente, tamanio));
		boton.setBounds(dimensiones.obtenerX(), dimensiones.obtenerY(), dimensiones.obtenerAncho(), dimensiones.obtenerAlto());
		
		return boton;
	}
	
	public static JButton generar(String texto, Dimensiones dimensiones, ActionListener evento) {
		validarEvento(evento);
		
		JButton boton = generarBotonConPropiedades(texto, dimensiones, Font.BOLD, 15F);
		boton.addActionListener(evento);
		return boton;
	}

}
