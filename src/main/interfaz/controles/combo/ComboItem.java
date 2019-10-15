package main.interfaz.controles.combo;

public class ComboItem {
	private int _id;
	private String _descripcion;

	public ComboItem(int id, String descripcion) {
		this._id = id;
		this._descripcion = descripcion;
	}

	public int obtenerId() {
		return _id;
	}

	public String obtenerDescripcion() {
		return _descripcion;
	}

	@Override
	public String toString() {
		return _descripcion;
	}
}
