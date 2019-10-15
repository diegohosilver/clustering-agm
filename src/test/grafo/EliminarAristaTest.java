package test.grafo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import main.negocio.grafo.Arista;
import main.negocio.grafo.Grafo;
import main.negocio.grafo.Vertice;

public class EliminarAristaTest {
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
	
	@Test
	public void eliminarAristaTest() {
		agregarVertices(Arrays.asList(1, 2, 3, 4));
		
		grafo.agregarArista(1, 2, 10);
		grafo.agregarArista(2, 3, 5);
		grafo.agregarArista(3, 4, 3);
		
		Arista arista = new Arista(3, 4, 3);
		
		grafo.eliminarArista(arista);
		
		assertFalse( grafo.existeArista(arista) );
	}
	
	@Test
	public void eliminarAristaSacaVecinoTest() {
		agregarVertices(Arrays.asList(1, 2, 3, 4));
		
		grafo.agregarArista(1, 2, 10);
		grafo.agregarArista(2, 3, 5);
		grafo.agregarArista(3, 4, 3);
		
		Arista arista = new Arista(3, 4, 3);
		
		grafo.eliminarArista(arista);
		
		Vertice vertice = grafo.obtenerVertice(3);
		
		assertEquals(1, vertice.obtenerCantidadVecinos());
	}
}
