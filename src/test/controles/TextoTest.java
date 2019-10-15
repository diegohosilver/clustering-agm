package test.controles;

import org.junit.Test;

import main.interfaz.controles.Texto;
import main.interfaz.controles.general.Dimensiones;

public class TextoTest {

	@Test(expected = IllegalArgumentException.class)
	public void TextoNuevoSinDimensiones() {
		Texto.generar(null, null, false);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void TextoNuevoSinColor() {
		Texto.generar(new Dimensiones(1, 1, 1, 1), null, false);
	}
	
}
