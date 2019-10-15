package main.interfaz.controles;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import main.interfaz.controles.general.Dimensiones;
import main.interfaz.util.Varios;

public class Boton {

	private static JButton generarBotonConPropiedades(String texto, Dimensiones dimensiones, int fuente, float tamanio) {
		Varios.validarTextoVacio(texto);	
		Varios.validarDimensiones(dimensiones);
		
		JButton boton = new JButton(texto);
		
		boton.setFont(boton.getFont().deriveFont(boton.getFont().getStyle() | fuente, tamanio));
		boton.setBounds(dimensiones.obtenerX(), dimensiones.obtenerY(), dimensiones.obtenerAncho(), dimensiones.obtenerAlto());
		
		return boton;
	}
	
	public static JButton generar(String texto, Dimensiones dimensiones, ActionListener evento) {
		Varios.validarEvento(evento);
		
		JButton boton = generarBotonConPropiedades(texto, dimensiones, Font.BOLD, 15F);
		boton.addActionListener(evento);
		return boton;
	}

}
