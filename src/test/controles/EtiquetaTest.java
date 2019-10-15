package test.controles;

import org.junit.Test;

import main.interfaz.controles.Etiqueta;

public class EtiquetaTest {
	
	@Test(expected = IllegalArgumentException.class)
	public void EtiquetaNuevaSinTextoTest() {
		Etiqueta.generar(null, null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void EtiquetaNuevaTextoVacioTest() {
		Etiqueta.generar("", null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void EtiquetaNuevaSinDimensionesTest() {
		Etiqueta.generar("Etiqueta", null);
	}
}
