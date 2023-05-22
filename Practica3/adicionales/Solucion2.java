package adicionales;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class Solucion2 {
	
	public ListaGenerica<Integer> caminoMasLargo(ArbolBinario<Integer> ab) {
		ListaGenerica<Integer> listaAct = new ListaEnlazadaGenerica<>();
		ListaGenerica<Integer> listaRes = new ListaEnlazadaGenerica<>();
		if (!ab.esVacio()) {
			caminoMasLargo(ab, listaAct, listaRes);
		}
		return listaRes;
	}

	private void caminoMasLargo(ArbolBinario<Integer> ab, ListaGenerica<Integer> listaAct, ListaGenerica<Integer> listaRes) {
		
		listaAct.agregarFinal(ab.getDato());
		
		if (ab.esHoja()) {
			if (listaAct.tamanio() > listaRes.tamanio()) {
				listaRes.comenzar();
				while (!listaRes.fin()) {
					listaRes.eliminar(listaRes.proximo());
				}
				
				listaAct.comenzar();
				while (!listaAct.fin())
					listaRes.agregarFinal(listaAct.proximo());
			}
		}
		
		if (ab.tieneHijoIzquierdo())
			caminoMasLargo(ab.getHijoIzquierdo(), listaAct, listaRes);
		if (ab.tieneHijoDerecho())
			caminoMasLargo(ab.getHijoDerecho(), listaAct, listaRes);
		
		listaAct.eliminarEn(listaAct.tamanio());
	}
	
	public ListaGenerica<ListaGenerica<Integer>> todosCaminosMasLargos(ArbolBinario<Integer> ab){
		ListaGenerica<Integer> listaAct = new ListaEnlazadaGenerica<>();
		ListaGenerica<ListaGenerica<Integer>> listaRes = new ListaEnlazadaGenerica<ListaGenerica<Integer>>();		
		if (!ab.esVacio()) {
			todosCaminosMasLargos(ab, listaAct, listaRes);
		}
		return listaRes;
	}

	private void todosCaminosMasLargos(ArbolBinario<Integer> ab, ListaGenerica<Integer> listaAct, ListaGenerica<ListaGenerica<Integer>> listaRes) {	
		
		listaAct.agregarFinal(ab.getDato());
		
		if (ab.esHoja()) {
			if (listaAct.tamanio() > listaRes.elemento(1).tamanio()) {
				listaRes.comenzar();
				while (!listaRes.fin()) {
					listaRes.eliminar(listaRes.proximo());
				}
				
				listaRes.agregarFinal(listaAct.clonar());
			}
			
			if (listaAct.tamanio() == listaRes.elemento(1).tamanio()) {
				listaRes.agregarFinal(listaAct.clonar());
			}				
		}
		
		if (ab.tieneHijoIzquierdo())
			todosCaminosMasLargos(ab.getHijoIzquierdo(), listaAct, listaRes);
		if (ab.tieneHijoDerecho())
			todosCaminosMasLargos(ab.getHijoDerecho(), listaAct, listaRes);
		
		listaAct.eliminarEn(listaAct.tamanio());
		
	}
	
	public ListaGenerica<Integer> caminoMasLargoYMayorValor(ArbolBinario<Integer> ab) {
		ListaGenerica<Integer> listaAct = new ListaEnlazadaGenerica<>();
		ListaGenerica<Integer> listaRes = new ListaEnlazadaGenerica<>();
		if (!ab.esVacio()) {
			caminoMasLargoYMayorValor(ab, listaAct, listaRes, 0, Integer.MAX_VALUE);
		}
		return listaRes;
	}
	
	private int caminoMasLargoYMayorValor(ArbolBinario<Integer> ab, ListaGenerica<Integer> listaAct, ListaGenerica<Integer> listaRes, int valorAct, int valorMax) {
		
		listaAct.agregarFinal(ab.getDato());
		valorAct =+ ab.getDato();
		
		if (ab.esHoja()) {		
			if (listaAct.tamanio() > listaRes.tamanio() ||
				(listaAct.tamanio() == listaRes.tamanio() && valorAct > valorMax)) {
				
				listaRes.comenzar();
				while (!listaRes.fin()) {
					listaRes.eliminar(listaRes.proximo());
				}
				
				valorMax = valorAct;
				
				listaAct.comenzar();
				while (!listaAct.fin())
					listaRes.agregarFinal(listaAct.proximo());
			}			
					
		}
		
		if (ab.tieneHijoIzquierdo())
			valorMax = caminoMasLargoYMayorValor(ab.getHijoIzquierdo(), listaAct, listaRes, valorAct, valorMax);
		if (ab.tieneHijoDerecho())
			valorMax = caminoMasLargoYMayorValor(ab.getHijoDerecho(), listaAct, listaRes, valorAct, valorMax);
		
		listaAct.eliminarEn(listaAct.tamanio());
		
		return valorMax;
	}
	
}
