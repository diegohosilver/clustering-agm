package main.interfaz.util.archivos;

import java.util.ArrayList;
import java.util.List;

import org.openstreetmap.gui.jmapviewer.Coordinate;

import main.interfaz.controles.combo.ComboItem;
import main.interfaz.util.Coordenada;

public class Instancias {
	
	public static List<ComboItem> listar() {
		List<ComboItem> items = new ArrayList<ComboItem>();
		
		items.add(new ComboItem(1, "Instancia 1"));
		items.add(new ComboItem(2, "Instancia 2"));
		items.add(new ComboItem(3, "Instancia 3"));
		items.add(new ComboItem(4, "Instancia 4"));
		items.add(new ComboItem(5, "Instancia 5"));
		
		return items;
	}
	
	public static Instancia obtenerDatosDeInstancia(int id) {
		return new Instancia(
					obtenerPathInstancia(id),
					obtenerCoordenadasInstancia(id),
					obtenerZoomInstancia(id)
				);
	}
	
	private static int obtenerZoomInstancia(int instancia) {
		switch(instancia) {
			case 1:
				return 14;
			case 2:
				return 13;
			case 3:
				return 13;
			case 4:
				return 14;
			default:
				return 18;
		}
	}
	
	private static Coordinate obtenerCoordenadasInstancia(int instancia) {
		switch(instancia) {
			case 1:
				return Coordenada.generar(-34.526649, -58.703133);
			case 2:
				return Coordenada.generar(-34.521388, -58.697566);
			case 3:
				return Coordenada.generar(-34.642463, -58.423129);
			case 4:
				return Coordenada.generar(-34.524541, -58.517721);
			default:
				return Coordenada.generar(-34.522138, -58.699907);
		}
	}
	
	private static String obtenerPathInstancia(int instancia) {
		return "instancias/instancia" + instancia + ".txt";
	}

}
