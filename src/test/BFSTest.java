package GrafosTest;

import static org.junit.Assert.*;

import org.junit.Test;

import grafos.BFS;
import grafos.Grafo;

public class BFSTest
{
	@Test
	public void todosAisladosTest()
	{
		Grafo grafo = new Grafo(3);
		assertFalse(new BFS(grafo).esConexo());
	}
	
	@Test
	public void trianguloTest()
	{
		Grafo grafo = new Grafo(3);
		grafo.agregarArista(0, 1);
		grafo.agregarArista(0, 2);
		grafo.agregarArista(1, 2);
		
		assertTrue(new BFS(grafo).esConexo());
	}
	
	@Test
	public void dosTriangulosTest()
	{
		Grafo grafo = new Grafo(6);
		grafo.agregarArista(0, 1);
		grafo.agregarArista(0, 2);
		grafo.agregarArista(1, 2);
		grafo.agregarArista(3, 4);
		grafo.agregarArista(4, 5);
		grafo.agregarArista(3, 5);
		
		assertFalse(new BFS(grafo).esConexo());
	}
	
	@Test
	public void verticeAisladoTest()
	{
		Grafo grafo = new Grafo(4);
		grafo.agregarArista(0, 1);
		grafo.agregarArista(0, 2);
		grafo.agregarArista(1, 2);
		
		assertFalse(new BFS(grafo).esConexo());
	}
	
	@Test
	public void verticeCeroAisladoTest()
	{
		Grafo grafo = new Grafo(4);
		grafo.agregarArista(1, 2);
		grafo.agregarArista(2, 3);
		
		assertFalse(new BFS(grafo).esConexo());
	}
}











