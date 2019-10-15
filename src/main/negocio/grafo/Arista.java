package main.negocio.grafo;

public class Arista {
	private int _verticeInicial;
 	private int _verticeFinal;
 	private double _peso;
 
 	public Arista(int verticeInicial, int verticeFinal, double peso)
 	{
 		_verticeInicial = verticeInicial;
 		_verticeFinal = verticeFinal;
 		_peso = peso;
 	}
 
 	public double obtenerPeso()
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
 	
 	@Override
 	public boolean equals(Object o) {
 		if (o == null) {
 			return false;
 		}
 		
 		if (o == this) {
 			return true;
 		}
 		
 		if (!(o instanceof Arista)) { 
            return false; 
        } 
 		
 		Arista a = (Arista) o;
 		
 		return (this.obtenerVerticeInicial() == a.obtenerVerticeInicial() || this.obtenerVerticeInicial() == a.obtenerVerticeFinal()) 
					&& (this.obtenerVerticeFinal() == a.obtenerVerticeFinal() || this.obtenerVerticeFinal() == a.obtenerVerticeInicial())
					&& this.obtenerPeso() == a.obtenerPeso();
 	}
}
