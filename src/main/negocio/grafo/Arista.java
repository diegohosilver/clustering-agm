package main.negocio.grafo;

public class Arista {
	private int _verticeInicial;
 	private int _verticeFinal;
 	private float _peso;
 
 	public Arista(int verticeInicial, int verticeFinal, float peso)
 	{
 		_verticeInicial = verticeInicial;
 		_verticeFinal = verticeFinal;
 		_peso = peso;
 	}
 
 	public float obtenerPeso()
 	{
 		return _peso;
 	}

 
 	public int obtenerVerticeInicial()
 	{
 		return _verticeInicial;
 	}
 
 	public int obtenerVerticeFinal()
 	{
 		return _verticeFinal;
 	}
}
