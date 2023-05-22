package Redictado_15_10_2022;

import tp02.ejercicio2.*;
import tp03.ejercicio1.*;

public class Tema_2 {
	
	public ListaGenerica<Integer> resolver(ArbolBinario<Integer> ab, int max){
		ListaGenerica<Integer> camAct = new ListaEnlazadaGenerica<>();
		ListaGenerica<Integer> camRes = new ListaEnlazadaGenerica<>();
		if (!ab.esVacio())
			resolver(ab, camAct, camRes, max);
		return camRes;
	}

	private void resolver(ArbolBinario<Integer> ab, ListaGenerica<Integer> camAct, ListaGenerica<Integer> camRes, int max) {
		
		camAct.agregarFinal(ab.getDato());		
		
		if (ab.esHoja()) {			
			if (ab.getDato() <= max) {
				camAct.comenzar();
				while (!camAct.fin())
					camRes.agregarFinal(camAct.proximo());		
			}				
		}		
		
		if (camRes.esVacia() && ab.tieneHijoIzquierdo())
			resolver(ab.getHijoIzquierdo(), camAct, camRes, max);
		
		if (camRes.esVacia() && ab.tieneHijoDerecho())
			resolver(ab.getHijoDerecho(), camAct, camRes, max);
		
		camAct.eliminarEn(camAct.tamanio());
	}
	
}
