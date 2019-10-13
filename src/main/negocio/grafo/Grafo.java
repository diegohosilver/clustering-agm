package main.negocio.grafo;

import java.util.ArrayList;
import java.util.Hashtable;

public class Grafo {
	ArrayList <Integer> _idsVertices;
 	ArrayList <Arista> _aristas;
 	Hashtable <Integer, Vertice> _vertices;
 
 	public Grafo()
 	{
 		_idsVertices = new ArrayList<Integer>();
 		_vertices = new Hashtable <Integer, Vertice>();
 		_aristas = new ArrayList <Arista>();
 	}
 
 	public void agregarVertice(int id)
 	{
 		_idsVertices.add(id);
 		_vertices.put(id, new Vertice(id));
 	}

 	private void validarVertices(int verticeInicial, int verticeFinal) {
 		if (verticeInicial < 0 || verticeFinal < 0) {
 			throw new IllegalArgumentException("Vertice no puede ser negativo");
 		}
 		
 		if (verticeInicial == verticeFinal) {
 			throw new IllegalArgumentException("No existen aristas entre un vertice y si mismo! vertice = " + verticeInicial);
 		}
 		
 		verticeExiste(verticeInicial);
 		verticeExiste(verticeFinal);
 	}
 	
 	private void verticeExiste(int vertice) {
 		if (!obtenerIdsVertices().contains(vertice)) {
 			throw new IllegalArgumentException("El vertice " + vertice + " no existe!");
 		}
 	}
 	
 	public void agregarArista(int verticeInicial, int verticeFinal, float peso)
 	{
 		validarVertices(verticeInicial, verticeFinal);
 		
 		Arista arista = new Arista(verticeInicial, verticeFinal, peso);
 		int indice = buscarIndiceAristaPorPeso(arista.obtenerPeso());
 
 		if (indice == -1)
 			_aristas.add(arista);
 		else
 			_aristas.add(indice, arista);
 
 		_vertices.get(verticeInicial).agregarArista(verticeFinal, peso);
 		_vertices.get(verticeFinal).agregarArista(verticeInicial, peso);
 	}
 	
 	public boolean existeArista(Arista arista)
 	{
 		for (int i = 0; i < _aristas.size(); i++)
 		{
 			Arista resultado = _aristas.get(i);
 			
 			
 			if (arista.obtenerVerticeInicial() == resultado.obtenerVerticeInicial() 
 					&& arista.obtenerVerticeFinal() == resultado.obtenerVerticeFinal()
 					&& arista.obtenerPeso() == resultado.obtenerPeso())
 			{
 				_aristas.remove(resultado);
 				return true;
 			}
 		}
 		return false;
 	}
 	
 	public int buscarIndiceAristaPorPeso(float peso)
 	{
 		for(int i = 0; i < _aristas.size(); i++)
 		{
  			if ( peso < _aristas.get(i).obtenerPeso())
 				return i;
 		}
 		
 		return -1;
 	}
 	
 	public Hashtable obtenerVertices()
 	{
 		return _vertices;
 	}
 	
 	public ArrayList<Integer> obtenerIdsVertices()
 	{
 		return _idsVertices;
 	}
 	
 	public Vertice obtenerVertice(int id)
 	{
 		return _vertices.get(id);
 	}
 
 	public ArrayList<Arista> obtenerAristas() {
 		return _aristas;
 	}
 
}
