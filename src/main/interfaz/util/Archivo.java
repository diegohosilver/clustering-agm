package main.interfaz.util;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import main.interfaz.controles.Alerta;

public class Archivo {
	
	public static List<String> leer(String path) {
		 List<String> renglones = new ArrayList<String>();
		
		try {
			Stream<String> lineas = Files.lines(Paths.get(path), Charset.defaultCharset());
			renglones = lineas.collect(Collectors.toList());
			lineas.close();
		}
		catch(Exception ex) {
			Alerta.mostrar("Ocurrio un error al abrir el archivo");
		}
		
		return renglones;
	}
}
