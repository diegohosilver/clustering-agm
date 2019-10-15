package main.negocio;

import java.util.ArrayList;
import java.util.List;

import main.negocio.grafo.Arista;
import main.negocio.grafo.Grafo;

public class Kruskal {
	
	private int _vertices;
	
	private Grafo generarGrafoConVertices(List<Integer> idsVertices) {
		Grafo grafo = new Grafo();
		
		for (int id : idsVertices) {
			grafo.agregarVertice(id);
		}
		
		return grafo;
	}
	
	public Grafo ejecutarAlgoritmo(Grafo grafo) {
		Grafo agm = generarGrafoConVertices(grafo.obtenerIdsVertices());
		
		_vertices = grafo.obtenerIdsVertices().size();
		
		List<Arista> aristas = new ArrayList<Arista>();
 		aristas.addAll(grafo.obtenerAristas());
		
        int [] grupoMaestro = new int[_vertices];
        inicializarGrupoMaestro(grupoMaestro);

        while(aristas.size() != 0) {
            Arista arista = aristas.get(0);
            
            // Verificar si hay circuito al agregar esta arista
            int x = buscarVertice(grupoMaestro, arista.obtenerVerticeInicial());
            int y = buscarVertice(grupoMaestro, arista.obtenerVerticeFinal());

            if(x != y) {
            	
            	agm.agregarArista(arista.obtenerVerticeInicial(), arista.obtenerVerticeFinal(), arista.obtenerPeso());
            	actualizarGrupoMaestro(grupoMaestro, x, y);
            }
            
            aristas.remove(arista);
        }
        
        return agm;
	}
	
	public int buscarVertice(int [] grupoMaestro, int vertice) {
		// Cadena de elementos maestros desde x hacia arriba a través del árbol
        // hasta que se encuentre un elemento cuyo padre es el mismo
		
        if (grupoMaestro[vertice] != vertice) {
            return buscarVertice(grupoMaestro, grupoMaestro[vertice]);
        }
        return vertice;
    }

    public void actualizarGrupoMaestro(int [] grupoMaestro, int x, int y){
        int x_maestro = buscarVertice(grupoMaestro, x);
        int y_maestro = buscarVertice(grupoMaestro, y);
        
        // Marcar x como padre de y
        grupoMaestro[y_maestro] = x_maestro;
    }
	
	public void inicializarGrupoMaestro(int [] grupoMaestro) {
		// Llenar grupo maestro con elementos cuyo padre apunta a si mismo
        for (int i = 0; i < _vertices ; i++) {
        	grupoMaestro[i] = i;
        }
    }
}
