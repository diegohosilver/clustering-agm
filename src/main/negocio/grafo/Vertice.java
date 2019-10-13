package main.negocio.grafo;

import java.util.ArrayList;

public class Vertice {
	private int _id;
	private ArrayList<Vecino> _vecinos;
 	private int _aristasExistentes;
 
 	public ArrayList<Vecino> obtenerVecinos()
 	{
 		return _vecinos;
 	}
 
 	public Vertice(int id)
 	{
 		_id = id;
 		_aristasExistentes = -1;
 		_vecinos = new ArrayList<Vecino>();
 	}
 
 	public int obtenerCantidadAristas()
 	{
 		return _aristasExistentes;
 	}
 
 	public int obtenerId()
 	{
 		return _id;
 	}
 
 	public void agregarArista(int verticeDestino, double peso)
 	{
 		if (_aristasExistentes == -1)
 		{
 			_vecinos.add(new Vecino(verticeDestino, peso));
 			_aristasExistentes ++;
 		}
 		else
 		{
 			int posicion;
 			posicion = existeArista(verticeDestino);
 			if (posicion == -1)
 			{
 				_vecinos.add(new Vecino(verticeDestino, peso));
 				_aristasExistentes++;
 			}
 		}
 	}
 
 	public int existeArista(int verticeDestino)
 	{
 		for (int i = 0; i < _vecinos.size(); i++)
 		{
 			Vecino vecino = _vecinos.get(i);
 			if (vecino.obtenerDestino() == verticeDestino)
 				return i;
 		}
 		
 		return -1;
 	}
}
