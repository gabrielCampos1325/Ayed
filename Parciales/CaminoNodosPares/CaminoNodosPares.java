package CaminoNodosPares;
import tp02.ejercicio2.*;
import tp03.ejercicio1.*;

public class CaminoNodosPares {
	
	public ListaGenerica<Integer> resolver (ArbolBinario<Integer> ab, int min){
		ListaGenerica<Integer> lista = new ListaEnlazadaGenerica<Integer>();
		if (!ab.esVacio())
			resolver(ab, min, lista);
		return lista;
	}
	
	private boolean resolver (ArbolBinario<Integer> ab, int min, ListaGenerica<Integer> lista){
		lista.agregarFinal(ab.getDato());
		boolean cumple = false;
		
		if (ab.getDato() % 2 == 0)
			min--;
		
		if (ab.esHoja()) {
			if (min <= 0)
				cumple = true;
			else
				lista.eliminarEn(lista.tamanio());
			
		} else {
			if (ab.tieneHijoIzquierdo() && !cumple)
				cumple = resolver(ab.getHijoIzquierdo(), min, lista);
			if (ab.tieneHijoDerecho() && !cumple)
				cumple = resolver(ab.getHijoDerecho(), min, lista);
			if (!cumple)
				lista.eliminarEn(lista.tamanio());
		}
		
		return cumple;
	}
	
}
