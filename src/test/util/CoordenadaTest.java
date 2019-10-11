package test.util;

import static org.junit.Assert.*;

import org.junit.Test;

import main.interfaz.controles.Mapa;
import main.interfaz.util.Coordenada;
import main.interfaz.util.Unidad;
import main.interfaz.util.Varios;

public class CoordenadaTest {

	@Test
	public void LongitudValidaTest() {
		assertTrue(Coordenada.longitudEsValida(0));
	}
	
	@Test
	public void LongitudInvalidaTest() {
		assertFalse(Coordenada.longitudEsValida(-180));
		assertFalse(Coordenada.longitudEsValida(180));
	}
	
	@Test
	public void LatitudValidaTest() {
		assertTrue(Coordenada.latitudEsValida(0));
	}
	
	@Test
	public void LatitudInvalidaTest() {
		assertFalse(Coordenada.latitudEsValida(-90));
		assertFalse(Coordenada.latitudEsValida(90));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void CalcularDistanciaSinCoordenadaTest() {
		Coordenada.distanciaEntreCoordenadas(null, null, Unidad.Kilometros);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void CoordenadaConLatitudInvalidaTest() {
		Coordenada.generar(10000, 80);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void CoordenadaConLongitudInvalidaTest() {
		Coordenada.generar(-54.2, 10000);
	}
	
	@Test
	public void CalcularDistanciaEnKilometros() {
		double distancia = Coordenada.distanciaEntreCoordenadas(Coordenada.generar(-34.501719, -58.623297), Coordenada.generar(-34.521492, -58.700788), Unidad.Kilometros);
		
		assertEquals(7.42, distancia, 0.5);
	}
	
	@Test
	public void CalcularDistanciaEnMillas() {
		double distancia = Coordenada.distanciaEntreCoordenadas(Coordenada.generar(-34.501719, -58.623297), Coordenada.generar(-34.521492, -58.700788), Unidad.Millas);
		
		assertEquals(4.61, distancia, 0.5);
	}

}
