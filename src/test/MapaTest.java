package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.interfaz.controles.Mapa;

public class MapaTest {

	@Test(expected = IllegalArgumentException.class)
	public void MapaNuevoSinCoordenada() {
		Mapa mapa = new Mapa(null, 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void CoordenadaConLatitudInvalida() {
		Mapa.generarCoordenada(10000, 80);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void CoordenadaConLongitudInvalida() {
		Mapa.generarCoordenada(-54.2, 10000);
	}
}
