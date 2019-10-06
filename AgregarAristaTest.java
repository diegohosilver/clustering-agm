package GrafosTest;

import static org.junit.Assert.*;

import org.junit.Test;

import grafos.Grafo;

public class AgregarAristaTest
{
	@Test(expected = IllegalArgumentException.class)
	public void primerVerticeNegativoTest()
	{
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(-1, 4);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void primerVerticeExcedidoTest()
	{
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(5, 4);
	}

	@Test(expected = IllegalArgumentException.class)
	public void segundoVerticeNegativoTest()
	{
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(3, -1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void segundoVerticeExcedidoTest()
	{
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(2, 5);
	}

	@Test(expected = IllegalArgumentException.class)
	public void verticesIgualesTest()
	{
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(2, 2);
	}

	@Test
	public void aristaExistenteTest()
	{
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(2, 4);
		assertTrue( grafo.existeArista(2, 4) );
	}

	@Test
	public void aristaRepetidaTest()
	{
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(2, 4);
		
		grafo.agregarArista(2, 4);
		assertTrue( grafo.existeArista(2, 4) );
	}
	
	@Test
	public void aristaInvertidaTest()
	{
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(2, 3);
		assertTrue( grafo.existeArista(3, 2) );
	}
	
	@Test
	public void aristaInexistenteTest()
	{
		Grafo grafo = new Grafo(5);
		assertFalse( grafo.existeArista(2, 0) );
	}
}





