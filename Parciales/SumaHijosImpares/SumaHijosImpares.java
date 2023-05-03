package SumaHijosImpares;

import tp02.ejercicio2.*;
import tp04.ejercicio1.ArbolGeneral;

public class SumaHijosImpares {
	
	ArbolGeneral<Integer> ag;
	
	public SumaHijosImpares(ArbolGeneral<Integer> arbol) {
		this.ag = arbol;
	}
	
	public ListaGenerica<Integer> resolver(){
		ListaGenerica<Integer> listaResultado = new ListaEnlazadaGenerica<Integer>();
		if (!this.ag.esVacio()) {
			resolver(this.ag, listaResultado);
		}
		return listaResultado;
	}
	
	private void resolver(ArbolGeneral<Integer> a, ListaGenerica<Integer> lista) {
		ListaGenerica<ArbolGeneral<Integer>> hijos = a.getHijos();
		int cant = 0;
		boolean impar = false;
		if (hijos.tamanio() % 2 != 0) {
			impar = true;
		}
		
		hijos.comenzar();
		while (!hijos.fin()) {	
			ArbolGeneral<Integer> hijo = hijos.proximo();
			resolver(hijo, lista);
			if (impar) {
				cant += hijo.getDato();
			}			
		}
		if (impar) {
			lista.agregarInicio(cant);
		}
	}
	
}
