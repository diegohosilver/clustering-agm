package main.interfaz.controles.combo;

import java.awt.Component;

import javax.swing.JList;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

public class ComboItemRender extends BasicComboBoxRenderer {
	
	@Override
	public Component getListCellRendererComponent(JList list, Object value,
			int index, boolean isSelected, boolean cellHasFocus) {
		
		super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		
		if (value != null) {
			ComboItem item = (ComboItem) value;
			setText(item.obtenerDescripcion().toUpperCase());
		}
		
		if (index == -1) {
			ComboItem item = (ComboItem) value;
			setText("" + item.obtenerId());
		}
		
		return this;
	}
}
