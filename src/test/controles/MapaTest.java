package test.controles;

import static org.junit.Assert.*;

import org.junit.Test;

import main.interfaz.controles.Mapa;

public class MapaTest {

	@Test(expected = IllegalArgumentException.class)
	public void MapaNuevoSinCoordenadaTest() {
		Mapa mapa = new Mapa(null, 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void CoordenadaConLatitudInvalidaTest() {
		Mapa.generarCoordenada(10000, 80);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void CoordenadaConLongitudInvalidaTest() {
		Mapa.generarCoordenada(-54.2, 10000);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void AgregarLineaSinCoordenadaTest() {
		Mapa mapa = new Mapa(Mapa.generarCoordenada(90, 90), 10);
		
		mapa.agregarLinea(null, null);
	}
}
