package Parcial_Agus_3;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class Solucion {
	
	public ListaGenerica<Integer> resolver(ArbolGeneral<Integer> ag){
		ListaGenerica<Integer> lista = new ListaEnlazadaGenerica<>();
		if (!ag.esVacio()) {
			resolver2(ag, lista);
		}
		return lista;
	}	
	
	private void resolver2(ArbolGeneral<Integer> ag, ListaGenerica<Integer> lista){

		int suma = 0;
		boolean cumple = false;
		
		ListaGenerica<ArbolGeneral<Integer>> hijos = ag.getHijos();
		if (hijos.tamanio() % 2 != 0)
			cumple = true;
		hijos.comenzar();
		while(!hijos.fin()){
			ArbolGeneral<Integer> aux = hijos.proximo();
			resolver2(aux, lista);			
			if (cumple)
				suma += aux.getDato();
		}
		
		if (cumple)
			lista.agregarFinal(suma);
	}
	
}
