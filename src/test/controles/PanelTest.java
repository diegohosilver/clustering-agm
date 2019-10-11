package test.controles;

import static org.junit.Assert.*;

import org.junit.Test;

import main.interfaz.controles.Panel;

public class PanelTest {

	@Test(expected = IllegalArgumentException.class)
	public void PanelNuevoSinDimensionesTest() {
		Panel.generar(null);
	}

}
