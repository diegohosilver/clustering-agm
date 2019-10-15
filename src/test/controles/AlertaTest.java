package test.controles;

import org.junit.Test;

import main.interfaz.controles.Alerta;

public class AlertaTest {
	
	@Test(expected = IllegalArgumentException.class)
	public void AlertaNuevaSinTextoTest() {
		Alerta.mostrar(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void AlertaNuevaTextoVacio() {
		Alerta.mostrar("");
	}
}
