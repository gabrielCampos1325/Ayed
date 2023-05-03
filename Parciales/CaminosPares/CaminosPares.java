package CaminosPares;

import tp02.ejercicio2.*;
import tp04.ejercicio1.ArbolGeneral;

public class CaminosPares {
	
	public ListaGenerica<ListaGenerica<Character>> caminosPares(ArbolGeneral<Character> arbol){
		ListaGenerica<ListaGenerica<Character>> listaResultado = new ListaEnlazadaGenerica<ListaGenerica<Character>>();
		ListaGenerica<Character> listaActual = new ListaEnlazadaGenerica<Character>();
		if (!arbol.esVacio())
			caminosPares1(arbol, listaActual, listaResultado);
		return listaResultado;
	}
	
	private void caminosPares1(ArbolGeneral<Character> arbol, ListaGenerica<Character> listaActual, ListaGenerica<ListaGenerica<Character>> listaResultado) {
		listaActual.agregarFinal(arbol.getDato());
		
		if (!arbol.esHoja()) {
			ListaGenerica<ArbolGeneral<Character>> hijos = arbol.getHijos();
			hijos.comenzar();
			while (!hijos.fin()) {
				caminosPares1(hijos.proximo(), listaActual, listaResultado);				
			}
			listaActual.eliminarEn(listaActual.tamanio());
			
		} else {
			if (listaActual.tamanio() % 2 == 0) {
				listaResultado.agregarFinal(listaActual.clonar());
			}
			listaActual.eliminarEn(listaActual.tamanio());
		}
		
	}
	
	//Hacer con lista de strings
	
}
