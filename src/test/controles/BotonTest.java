package test.controles;

import static org.junit.Assert.*;

import org.junit.Test;

import main.interfaz.controles.Boton;
import main.interfaz.controles.general.Dimensiones;

public class BotonTest {

	@Test(expected = IllegalArgumentException.class)
	public void BotonNuevoSinTextoTest() {
		Boton.generar(null, null, null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void BotonNuevoTextoVacioTest() {
		Boton.generar("", null, null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void BotonNuevoSinDimensiones() {
		Boton.generar("Mi boton", null, null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void BotonNuevoSinEvento() {
		Boton.generar("Mi boton", new Dimensiones(0, 0, 0, 0), null);
	}
}
