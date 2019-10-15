package main.interfaz.controles;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

public class SelectorArchivo {
	private JFileChooser _selectorDeArchivo;
	
	public SelectorArchivo() {
		_selectorDeArchivo = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		
		FileFilter filter = new FileNameExtensionFilter("TXT File", "txt");
		_selectorDeArchivo.setFileFilter(filter);
		_selectorDeArchivo.setAcceptAllFileFilterUsed(false);
	}
	
	public File seleccionarArchivo() {
		int codigoDevuelto = _selectorDeArchivo.showOpenDialog(null);
		
		if (codigoDevuelto == JFileChooser.APPROVE_OPTION) {
			return _selectorDeArchivo.getSelectedFile();
		}
		else {
			return null;
		}
	}

}
