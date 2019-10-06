package main.interfaz.controles.general;

public class Bordes {
	private int _up;
	private int _left;
	private int _down;
	private int _right;
	
	public Bordes(int up, int left, int down, int right) {
		_up = up;
		_left = left;
		_down = down;
		_right = right;
	}
	
	public int obtenerArriba() {
		return _up;
	}
	
	public int obtenerIzquierda() {
		return _left;
	}
	
	public int obtenerAbajo() {
		return _down;
	}
	
	public int obtenerDerecha() {
		return _right;
	}
	
}
