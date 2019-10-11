package main.interfaz.controles.general;

public class Esquema {

	private int _hgap;
	private int _vgap;
	
	public Esquema(int hgap, int vgap) {
		_hgap = hgap;
		_vgap = vgap;
	}
	
	public int obtenerEspacioVertical() {
		return _vgap;
	}
	
	public int obtenerEspacioHorizontal() {
		return _hgap;
	}
}
