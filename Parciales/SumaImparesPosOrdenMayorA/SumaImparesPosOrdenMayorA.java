package SumaImparesPosOrdenMayorA;

import tp03.ejercicio1.ArbolBinario;

public class SumaImparesPosOrdenMayorA {
	
	public int calcular(ArbolBinario<Integer> ab, int limite){
		int aux = Integer.MIN_VALUE;
		if (!ab.esVacio())
			aux = procesar(ab, limite);
		return aux;
	}

	private int procesar(ArbolBinario<Integer> ab, int limite) {
		int aux = 0;
		
		if (ab.tieneHijoIzquierdo())
			aux =+ procesar(ab.getHijoIzquierdo(), limite);
		
		if (ab.tieneHijoDerecho()) {
			aux =+ procesar(ab.getHijoDerecho(), limite);
		}
		
		if (ab.getDato() > limite && ab.getDato() % 2 != 0)
			aux = ab.getDato();
		
		return aux;
	}
	
}
