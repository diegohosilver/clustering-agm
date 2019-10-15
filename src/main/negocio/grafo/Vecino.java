package main.negocio.grafo;

public class Vecino {
	private int _destino;
 	private double _peso;
 
 	public Vecino(int verticeDestino, double peso)
 	{
 		_destino = verticeDestino;
 		_peso = peso;
 	}
 
 	public Vecino(int verticeDestino)
 	{
 		_destino = verticeDestino;
 		_peso = -1;
 	}
 
 	public void establecerPeso(double nuevoPeso)
 	{
 		_peso = nuevoPeso;
 	}
 
 	public int obtenerDestino()
 	{
 		return _destino;
 	}
 
 	public double obtenerPeso()
 	{
 		return _peso;
 	}
}
