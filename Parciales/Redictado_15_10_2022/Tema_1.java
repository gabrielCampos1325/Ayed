package Redictado_15_10_2022;

import tp02.ejercicio2.*;
import tp03.ejercicio1.*;

public class Tema_1 {
	
	public ListaGenerica<Integer> resolver(ArbolBinario<Integer> ab, int min){
		ListaGenerica<Integer> camAct = new ListaEnlazadaGenerica<>();
		ListaGenerica<Integer> camRes = new ListaEnlazadaGenerica<>();
		if (!ab.esVacio())
			resolver(ab, camAct, camRes, min);
		return camRes;
	}

	private void resolver(ArbolBinario<Integer> ab, ListaGenerica<Integer> camAct, ListaGenerica<Integer> camRes, int min) {
		
		camAct.agregarFinal(ab.getDato());
		
		if (ab.getDato() % 2 == 0)
			min--;
		
		if (ab.esHoja()) {
			if (min <= 0) {
				camAct.comenzar();
				while (!camAct.fin())
					camRes.agregarFinal(camAct.proximo());
			}
		}		
		
		if (camRes.esVacia() && ab.tieneHijoIzquierdo())
			resolver(ab.getHijoIzquierdo(), camAct, camRes, min);
		
		if (camRes.esVacia() && ab.tieneHijoDerecho())
			resolver(ab.getHijoDerecho(), camAct, camRes, min);
		
		camAct.eliminarEn(camAct.tamanio());
	}
	
}
