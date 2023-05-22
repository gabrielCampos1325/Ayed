package Parcial_Agus_8;

import tp02.ejercicio2.*;
import tp04.ejercicio1.ArbolGeneral;

public class Solucion {
	
	public ListaGenerica<Integer> calcular(ArbolGeneral<Integer> ag){
		ListaGenerica<Integer> lista = new ListaEnlazadaGenerica<>();
		if (!ag.esVacio())
			lista.agregarFinal(ag.getDato());
			calcular(ag, lista);
		return lista;
	}

	private void calcular(ArbolGeneral<Integer> ag, ListaGenerica<Integer> lista) {
		
		if (ag.tieneHijos()) {
			ListaGenerica<ArbolGeneral<Integer>> hijos = ag.getHijos();
			ArbolGeneral<Integer> aux = hijos.elemento(ag.getDato());
			lista.agregarFinal(aux.getDato());	
			calcular(aux, lista);
		}
		
	}
	
}
