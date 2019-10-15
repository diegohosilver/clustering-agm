package test.grafo;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import main.negocio.grafo.*;

public class AgregarAristaTest
{
	private Grafo grafo;
	
	@Before
	public void inicializarGrafo() {
		grafo = new Grafo();
	}
	
	private void agregarVertices(List<Integer> vertices) {
		for (int vertice : vertices) {
			grafo.agregarVertice(vertice);
		}
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void primerVerticeNegativoTest()
	{
		Grafo grafo = new Grafo();
		grafo.agregarArista(-1, 4, 1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void primerVerticeExcedidoTest()
	{
		Grafo grafo = new Grafo();
		grafo.agregarArista(5, 4, 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void segundoVerticeNegativoTest()
	{
		Grafo grafo = new Grafo();
		grafo.agregarArista(3, -1, 1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void segundoVerticeExcedidoTest()
	{
		Grafo grafo = new Grafo();
		grafo.agregarArista(2, 5, 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void verticesIgualesTest()
	{
		Grafo grafo = new Grafo();
		grafo.agregarArista(2, 2, 1);
	}

	@Test
	public void aristaExistenteTest()
	{
		agregarVertices(Arrays.asList(2, 4));
		
		grafo.agregarArista(2, 4, 1);
		assertTrue( grafo.existeArista(new Arista(2, 4, 1)) );
	}
	
	@Test
	public void aristaInvertidaTest()
	{
		agregarVertices(Arrays.asList(2, 4));
		
		grafo.agregarArista(2, 4, 1);
		assertTrue( grafo.existeArista(new Arista(4, 2, 1)) );
	}

	@Test
	public void aristaRepetidaTest()
	{
		agregarVertices(Arrays.asList(2, 4));
		grafo.agregarArista(2, 4, 1);
		
		grafo.agregarArista(2, 4, 1);
		assertTrue( grafo.existeArista(new Arista(2, 4, 1)) );
	}

	@Test
	public void aristaInexistenteTest()
	{
		assertFalse( grafo.existeArista( new Arista(2, 0, 1)) );
	}
	
	@Test
	public void aristaPorPesoTest() {
		agregarVertices(Arrays.asList(1, 2, 3, 4));
		
		grafo.agregarArista(1, 2, 10);
		grafo.agregarArista(2, 3, 5);
		grafo.agregarArista(3,  4, 3);
		
		// Buscar el índice indicado donde debería ir una nueva arista con peso 2
		assertEquals(0, grafo.buscarIndiceAristaPorPeso(2) );
	}
}