package GrafosTest;

import java.util.Random;

import grafos.BFS;
import grafos.Grafo;

public class StressTest
{
	public static void main(String[] args)
	{
		for(int n=400; n<=1000; n+=100)
		{
			Grafo grafo = aleatorio(n, 0.25);
			
			long repeticiones = 1000;
			long inicio = System.currentTimeMillis();
			
			BFS bfs = new BFS(grafo);
			for(int i=0; i<repeticiones; ++i)
				bfs.esConexo();
			
			long fin = System.currentTimeMillis();
			
			double tiempo = (fin - inicio) / 1000.0 / repeticiones;
			System.out.println("n = " + n + ", Tiempo: " + tiempo + " seg.");
		}
	}
	
	private static Grafo aleatorio(int n, double densidad)
	{
		Grafo ret = new Grafo(n);
		Random random = new Random();
		
		int aristas = (int)(n * (n-1) * densidad / 2);
		for(int k=0; k<aristas; ++k)
		{
			int i = random.nextInt(n); // Entre 0 y n-1
			int j = random.nextInt(n);
			
			if( i != j )
				ret.agregarArista(i,j);
		}
		
		return ret;
	}
}


















