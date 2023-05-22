package Parcial_Agus_5;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp03.ejercicio1.ArbolBinario;
import tp04.ejercicio1.ArbolGeneral;

public class Solucion {
	
	public ListaGenerica<Integer> resolver(ArbolBinario<Integer> ab){
		ListaGenerica<Integer> lista = new ListaEnlazadaGenerica<>();
		if (!ab.esVacio()) {
			resolver(ab, lista);
		}
		return lista;
	}	
	
	private int resolver(ArbolBinario<Integer> ab, ListaGenerica<Integer> lista){
		
		if (ab == null)
			return 0;
		
		int cantD = 0;
		int cantI = 0;
		
		cantD += resolver(ab.getHijoDerecho(), lista);
		cantI += resolver(ab.getHijoIzquierdo(), lista);		
		
		if (cantI == cantD)
			lista.agregarInicio(ab.getDato());
		
		return cantI + cantD + 1;
	}
	
}
