package Recuperatorio_1sem_2023;

import tp02.ejercicio2.*;
import tp04.ejercicio1.*;

public class Parcial {
	ArbolGeneral<Integer> ag;
	
	public Parcial(ArbolGeneral<Integer> ag) {
		this.ag = ag;
	}
	
	public ListaGenerica<Integer> recorrer(int num){
		ListaGenerica<Integer> lisAct = new ListaEnlazadaGenerica<Integer>();
		ListaGenerica<Integer> lisRes = new ListaEnlazadaGenerica<Integer>();
		if (!this.ag.esVacio()) {
			if(this.ag.getDato() % num == 0) {
				recorrer(this.ag, lisAct, lisRes, num);
			}
		}
		return lisRes;
	}

	private void recorrer(ArbolGeneral<Integer> ag, ListaGenerica<Integer> lisAct, ListaGenerica<Integer> lisRes, int num) {
		// TODO Auto-generated method stub
		lisAct.agregarFinal(ag.getDato());
		
		if(ag.esHoja()) {
			lisAct.comenzar();
			while(!lisAct.fin()) {
				lisRes.agregarFinal(lisAct.proximo());
			}
		}
		
		if(ag.tieneHijos() && lisRes.esVacia()) {
			ListaGenerica<ArbolGeneral<Integer>> hijos = ag.getHijos();
			hijos.comenzar();
			while(!hijos.fin() && lisRes.esVacia()) {
				ArbolGeneral<Integer> aux = hijos.proximo();
				if(aux.getDato() % num == 0) {
					recorrer(aux, lisAct, lisRes, num);
					lisAct.eliminar(lisAct.tamanio());
				}
			}
		}
	}
	
}
