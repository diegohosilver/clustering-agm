package test.grafo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.stream.Collectors;

import main.negocio.grafo.Vecino;

public class Assert
{
	public static void iguales(int[] expected, List<Vecino> obtained)
	{
		assertEquals(expected.length, obtained.size());
		
		for(Integer valor: expected)
			assertTrue( obtained.stream().map(x -> x.obtenerDestino()).collect(Collectors.toList()).contains(valor) );
	}
}
