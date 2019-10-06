package GrafosTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Set;

public class Assert
{
	public static void iguales(int[] expected, Set<Integer> obtained)
	{
		assertEquals(expected.length, obtained.size());
		
		for(Integer valor: expected)
			assertTrue( obtained.contains(valor) );
	}
}
