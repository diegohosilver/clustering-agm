package GrafosTest;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;

import grafos.Grafo;

public class VecinosTest
{
	@Test(expected = IllegalArgumentException.class)
	public void verticeNegativoTest()
	{
		Grafo grafo = new Grafo(5);
		grafo.vecinos(-1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void verticeExcedidoTest()
	{
		Grafo grafo = new Grafo(5);
		grafo.vecinos(5);
	}
	
	@Test
	public void grafoSinAristasTest()
	{
		Grafo grafo = new Grafo(5);
		assertEquals(0, grafo.vecinos(2).size());
	}

	@Test
	public void verticeAisladoTest()
	{
		Grafo grafo = cuadradoMasPunto();
		assertEquals(0, grafo.vecinos(0).size());
	}
	
	@Test
	public void dosVecinosTest()
	{
		Grafo grafo = cuadradoMasPunto();
		Set<Integer> vecinos = grafo.vecinos(2);

		int[] esperado = {1, 4};
		Assert.iguales(esperado, vecinos);
	}
	
	@Test
	public void verticeUniversalTest()
	{
		Grafo grafo = cuatroRueda();
		Set<Integer> vecinos = grafo.vecinos(0);
		
		int[] esperado = {1, 2, 3, 4};
		Assert.iguales(esperado, vecinos);
	}
	
	private Grafo cuatroRueda()
	{
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(0, 1);
		grafo.agregarArista(0, 2);
		grafo.agregarArista(0, 3);
		grafo.agregarArista(0, 4);
		grafo.agregarArista(1, 2);
		grafo.agregarArista(2, 3);
		grafo.agregarArista(3, 4);
		grafo.agregarArista(1, 4);
		
		return grafo;
	}
	
	private Grafo cuadradoMasPunto()
	{
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(1, 2);
		grafo.agregarArista(1, 3);
		grafo.agregarArista(2, 4);
		grafo.agregarArista(3, 4);
		
		return grafo;
	}
}













