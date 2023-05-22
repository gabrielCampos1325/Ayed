package Ej_1;

import tp03.ejercicio1.ArbolBinario;

public class Ej_1 {
	
	public int calcular(ArbolBinario<Character> ab) {
		int aux = Integer.MIN_VALUE;
		if(!ab.esVacio())
			aux = calcular(ab, 0);
		return aux;
	}

	private int calcular(ArbolBinario<Character> ab, int ancestros) {		
		int res = 0;
		
		if (ab.esHoja()) {
			if (ancestros == 0)
				res++;
		}		
		
		if (ab.tieneHijoIzquierdo() && !ab.tieneHijoDerecho() ||
			!ab.tieneHijoIzquierdo() && ab.tieneHijoDerecho()) {
			ancestros--;
		}
		
		if (ab.tieneHijoIzquierdo())
			res += calcular(ab.getHijoIzquierdo(), ancestros);
		if (ab.tieneHijoDerecho())
			res += calcular(ab.getHijoDerecho(), ancestros);
		
		return res;		
	}
	
}
