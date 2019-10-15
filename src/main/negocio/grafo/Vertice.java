package main.negocio.grafo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Vertice {
	private int _id;
	private List<Vecino> _vecinos;
 	private int _aristasExistentes;
 
 	public List<Vecino> obtenerVecinos()
 	{
 		return _vecinos;
 	}
 
 	public Vertice(int id)
 	{
 		_id = id;
 		_aristasExistentes = 0;
 		_vecinos = new ArrayList<Vecino>();
 	}
 
 	public int obtenerCantidadVecinos()
 	{
 		return _aristasExistentes;
 	}
 
 	public int obtenerId()
 	{
 		return _id;
 	}
 
 	public void agregarVecino(int verticeDestino, double peso)
 	{
 		if (_aristasExistentes == 0)
 		{
 			_vecinos.add(new Vecino(verticeDestino, peso));
 			_aristasExistentes ++;
 		}
 		else
 		{
 			int posicion;
 			posicion = vecinoUnidoPorArista(verticeDestino);
 			if (posicion == -1)
 			{
 				_vecinos.add(new Vecino(verticeDestino, peso));
 				_aristasExistentes++;
 			}
 		}
 	}
 	
 	public void eliminarVecino(int verticeFinal) {
 		Optional<Vecino> vecino = _vecinos.stream().filter(x -> verticeFinal == x.obtenerDestino()).findFirst();
 		
 		if (vecino.isPresent()) {
 			_aristasExistentes --;
 			_vecinos.remove(vecino.get());
 		}
 	}
 
 	public int vecinoUnidoPorArista(int verticeDestino)
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
