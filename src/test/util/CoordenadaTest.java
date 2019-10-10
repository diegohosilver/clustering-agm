package test.util;

import static org.junit.Assert.*;

import org.junit.Test;

import main.interfaz.controles.Mapa;
import main.interfaz.util.Unidad;
import main.interfaz.util.Utilidades;

public class CoordenadaTest {

	@Test
	public void LongitudValidaTest() {
		assertTrue(Utilidades.longitudEsValida(0));
	}
	
	@Test
	public void LongitudInvalidaTest() {
		assertFalse(Utilidades.longitudEsValida(-180));
		assertFalse(Utilidades.longitudEsValida(180));
	}
	
	@Test
	public void LatitudValidaTest() {
		assertTrue(Utilidades.latitudEsValida(0));
	}
	
	@Test
	public void LatitudInvalidaTest() {
		assertFalse(Utilidades.latitudEsValida(-90));
		assertFalse(Utilidades.latitudEsValida(90));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void CalcularDistanciaSinCoordenadaTest() {
		Utilidades.distanciaEntreCoordenadas(null, null, Unidad.Kilometros);
	}
	
	@Test
	public void CalcularDistanciaEnKilometros() {
		double distancia = Utilidades.distanciaEntreCoordenadas(Mapa.generarCoordenada(-34.501719, -58.623297), Mapa.generarCoordenada(-34.521492, -58.700788), Unidad.Kilometros);
		
		assertEquals(7.42, distancia, 0.5);
	}
	
	@Test
	public void CalcularDistanciaEnMillas() {
		double distancia = Utilidades.distanciaEntreCoordenadas(Mapa.generarCoordenada(-34.501719, -58.623297), Mapa.generarCoordenada(-34.521492, -58.700788), Unidad.Millas);
		
		assertEquals(4.61, distancia, 0.5);
	}

}
