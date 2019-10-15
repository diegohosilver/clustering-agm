package main.interfaz.controles.general;

public class Dimensiones {
	private int _x;
	private int _y;
	private int _width;
	private int _height;
	
	public Dimensiones(int x, int y, int width, int height) {
		_x = x;
		_y = y;
		_width = width;
		_height = height;
	}
	
	public int obtenerX() {
		return _x;
	}
	
	public int obtenerY() {
		return _y;
	}
	
	public int obtenerAncho() {
		return _width;
	}
	
	public int obtenerAlto() {
		return _height;
	}
	
}
