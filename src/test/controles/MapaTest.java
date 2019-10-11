package test.controles;

import static org.junit.Assert.*;

import org.junit.Test;

import main.interfaz.controles.Mapa;

public class MapaTest {

	@Test(expected = IllegalArgumentException.class)
	public void EstablecerVistaSinCoordenadaTest() {
		Mapa mapa = new Mapa();
		
		mapa.establecerVista(null, 0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void AgregarLineaSinCoordenadaTest() {
		Mapa mapa = new Mapa();
		
		mapa.agregarLinea(null, null);
	}
}
