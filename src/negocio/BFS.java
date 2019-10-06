package grafos;

import java.util.HashSet;
import java.util.Set;

public class BFS
{
	// Grafo
	private Grafo grafo;
	
	// Auxiliares para BFS
	private Set<Integer> pendientes;
	private boolean[] marcados;
	
	public BFS(Grafo g)
	{
		grafo = g;
	}

	// Determina si el grafo es conexo
	public boolean esConexo()
	{
		inicializarAuxiliares();
		
		while( pendientes.size() != 0 )
		{
			int i = seleccionarPendiente();
			marcados[i] = true;
			
			pendientes.addAll(vecinosNoMarcados(i));
			pendientes.remove(i);
		}
			
		return todosMarcados();
	}
	
	// Inicializa los elementos auxiliares
	private void inicializarAuxiliares()
	{
		pendientes = singleton(0);
		marcados = new boolean[grafo.tamano()]; // Todos false
	}

	// Vecinos no marcados de un vertice
	private Set<Integer> vecinosNoMarcados(int i)
	{
		Set<Integer> ret = new HashSet<Integer>();
		for(Integer j: grafo.vecinos(i) ) if( marcados[j] == false )
			ret.add(j);
		
		return ret;
	}

	// Construye un set con el parametro como unico elemento
	private Set<Integer> singleton(int elemento)
	{
		Set<Integer> L = new HashSet<Integer>();
		L.add(elemento);
		
		return L;
	}

	// Determina estan todos marcados
	private boolean todosMarcados()
	{
		int i = 0;
		while( i < marcados.length && marcados[i] == true )
			++i;
		
		return i == marcados.length;
	}

	// Obtiene un elemento del set, si no esta vacio
	private int seleccionarPendiente()
	{
		for(Integer elemento: pendientes)
			return elemento;
		
		throw new IllegalArgumentException("El set esta vacio!");
	}
}








