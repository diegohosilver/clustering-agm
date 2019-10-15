package test.grafo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import main.negocio.Kruskal;
import main.negocio.grafo.Arista;
import main.negocio.grafo.Grafo;

public class KruskalTest {
	
	private Grafo grafo;
	private Kruskal kruskal;
	
	@Before
	public void inicializarGrafo() {
		grafo = new Grafo();
		kruskal = new Kruskal();
	}
	
	private void agregarVertices(List<Integer> vertices) {
		for (int vertice : vertices) {
			grafo.agregarVertice(vertice);
		}
	}
	
	private void grafoConTresAristas() {
		agregarVertices(Arrays.asList(0, 1, 2));
		
		grafo.agregarArista(0, 1, 11);
		grafo.agregarArista(1, 2, 9);
		grafo.agregarArista(2, 0, 10);
	}
	
	private void grafoConSieteAristas() {
		agregarVertices(Arrays.asList(0, 1, 2, 3, 4));
		
		grafo.agregarArista(0, 1, 5);
		grafo.agregarArista(1, 2, 10);
		grafo.agregarArista(2, 3, 4);
		grafo.agregarArista(3, 4, 8);
		grafo.agregarArista(4, 0, 10);
		
		grafo.agregarArista(0, 2, 8);		
		grafo.agregarArista(2, 4, 7);
	}
	
	@Test
	public void ArbolCuatroAristasTest() {
		grafoConSieteAristas();
				
		Grafo agm = kruskal.ejecutarAlgoritmo(grafo);
		
		assertEquals(4, agm.obtenerAristas().size());
	}
	
	@Test
	public void ArbolDosAristasTest() {
		grafoConTresAristas();

		Grafo agm = kruskal.ejecutarAlgoritmo(grafo);
		
		assertEquals(2, agm.obtenerAristas().size());
	}
	
	@Test
	public void AristasExistentesTest() {
		grafoConSieteAristas();
				
		Grafo agm = kruskal.ejecutarAlgoritmo(grafo);
		
		assertTrue(agm.existeArista(new Arista(1, 0, 5)));
		assertTrue(agm.existeArista(new Arista(0, 2, 8)));
		assertTrue(agm.existeArista(new Arista(4, 2, 7)));
		assertTrue(agm.existeArista(new Arista(3, 2, 4)));
	}

}
