package Ej_2;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class Ej_2 {
	
	public ListaGenerica<Character> calcular(ArbolBinario<Character> ab) {
		ListaGenerica<Character> listaRes = new ListaEnlazadaGenerica<Character>();
		if(!ab.esVacio()) {
			calcular(ab, 0, listaRes);
		}			
		return listaRes;
	}

	private void calcular(ArbolBinario<Character> ab, int ancestros, ListaGenerica<Character> listaRes) {		
			
		if (ab.esHoja()) {
			if (ancestros == 0)
				listaRes.agregarFinal(ab.getDato());
		}		
		
		if (ancestros > 0) {
			if (ab.tieneHijoIzquierdo() && !ab.tieneHijoDerecho() ||
					!ab.tieneHijoIzquierdo() && ab.tieneHijoDerecho()) {
					ancestros--;
				}
		}		
		
		if (ab.tieneHijoIzquierdo())
			calcular(ab.getHijoIzquierdo(), ancestros, listaRes);
		if (ab.tieneHijoDerecho())
			calcular(ab.getHijoDerecho(), ancestros, listaRes);				
	}
	
}
