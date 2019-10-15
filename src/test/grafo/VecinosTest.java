package test.grafo;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import main.negocio.grafo.Grafo;
import main.negocio.grafo.Vecino;

public class VecinosTest {
	
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
	public void verticeNegativoTest()
	{
		grafo.obtenerVertice(-1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void verticeExcedidoTest()
	{
		Grafo grafo = new Grafo();
		grafo.obtenerVertice(5);
	}
	
	@Test
	public void grafoSinAristasTest()
	{
		agregarVertices(Arrays.asList(5));
		
		assertEquals(0, grafo.obtenerVertice(5).obtenerVecinos().size());
	}

	@Test
	public void verticeAisladoTest()
	{
		cuadradoMasPunto();
		
		assertEquals(0, grafo.obtenerVertice(5).obtenerVecinos().size());
	}
	
	@Test
	public void dosVecinosTest()
	{
		cuadradoMasPunto();
		List<Vecino> vecinos = grafo.obtenerVertice(2).obtenerVecinos();

		int[] esperado = {1, 4};
		Assert.iguales(esperado, vecinos);
	}
	
	@Test
	public void verticeUniversalTest()
	{
		cuatroRueda();
		List<Vecino> vecinos = grafo.obtenerVertice(0).obtenerVecinos();
		
		int[] esperado = {1, 2, 3, 4};
		Assert.iguales(esperado, vecinos);
	}
	
	private void cuatroRueda()
	{
		agregarVertices(Arrays.asList(0, 1, 2, 3, 4, 5));
		
		grafo.agregarArista(0, 1, 1);
		grafo.agregarArista(0, 2, 1);
		grafo.agregarArista(0, 3, 1);
		grafo.agregarArista(0, 4, 1);
		grafo.agregarArista(1, 2, 1);
		grafo.agregarArista(2, 3, 1);
		grafo.agregarArista(3, 4, 1);
		grafo.agregarArista(1, 4, 1);
	}
	
	private void cuadradoMasPunto()
	{
		agregarVertices(Arrays.asList(0, 1, 2, 3, 4, 5));
		
		grafo.agregarArista(1, 2, 1);
		grafo.agregarArista(1, 3, 1);
		grafo.agregarArista(2, 4, 1);
		grafo.agregarArista(3, 4, 1);
	}
	
}
