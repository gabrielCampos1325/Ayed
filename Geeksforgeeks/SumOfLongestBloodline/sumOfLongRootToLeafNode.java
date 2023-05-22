package SumOfLongestBloodline;

import tp03.ejercicio1.ArbolBinario;

public class sumOfLongRootToLeafNode {
	
	private int maxHd;

	public int solucion(ArbolBinario<Integer> ab) {
		int sumMax = Integer.MIN_VALUE;
		if (!ab.esVacio()) {
			sumMax = solucion(ab, 0, 0, 0);
		}
		return sumMax;
	}

	private int solucion(ArbolBinario<Integer> ab, int nodosAct, int maxNodos, int sumAct) {
		nodosAct++;
		
		if (ab.esHoja()) {
			if (nodosAct > maxNodos) {
				maxNodos = nodosAct;
				
			}			
				
		}
		int maxHi;
		int maxHd;
		if (ab.tieneHijoIzquierdo())
			maxHi = solucion(ab.getHijoIzquierdo(), nodos, maxNodos);
		if (ab.tieneHijoDerecho())
			maxHd = solucion(ab.getHijoDerecho(), nodos, maxNodos);
		
		
	}
	
}
