package CaminosPares;

import tp02.ejercicio2.*;
import tp04.ejercicio1.ArbolGeneral;

public class CaminosPares2 {
	
	public ListaGenerica<ListaGenerica<Character>> calcular (ArbolGeneral<Character> ag){
		ListaGenerica<ListaGenerica<Character>> camRes = new ListaEnlazadaGenerica<ListaGenerica<Character>>();
		ListaGenerica<Character> camAct = new ListaEnlazadaGenerica<>();
		if(!ag.esVacio()) {
			calcular(ag, camAct, camRes);
		}
		return camRes;
	}

	private void calcular(ArbolGeneral<Character> ag, ListaGenerica<Character> camAct, ListaGenerica<ListaGenerica<Character>> camRes) {
		
		camAct.agregarFinal(ag.getDato());
		
		if (ag.esHoja()) {
			if (camAct.tamanio() % 2 == 0) {
				camRes.agregarFinal(camAct.clonar());
			}
		}
		
		ListaGenerica<ArbolGeneral<Character>> hijos = ag.getHijos();
		hijos.comenzar();
		while (!hijos.fin()) {
			calcular(hijos.proximo(), camAct, camRes);
			camAct.eliminarEn(camAct.tamanio());
		}
		
		
	}
	
}
