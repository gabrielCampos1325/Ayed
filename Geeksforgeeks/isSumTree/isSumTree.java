package isSumTree;

import tp03.ejercicio1.ArbolBinario;

public class isSumTree {
	
	public boolean calcular(ArbolBinario<Integer> ab) {
		if (!ab.esVacio()) {
			return false;
		}
		if (ab.esHoja()) {
			return true;
		}
		return (suma(ab.getHijoIzquierdo()) + 
				suma(ab.getHijoDerecho()) == ab.getDato());
	}

	private int suma(ArbolBinario<Integer> ab) {
		if (ab == null) {
			return 0;
		}
		
		return suma(ab.getHijoIzquierdo()) + 
			   suma(ab.getHijoDerecho()) + 
			   ab.getDato();					
	}
	
	public boolean calcular2(ArbolBinario<Integer> ab) {
		boolean aux;
		
		if (!ab.esVacio()) {
			aux = false;
		} else {
			if (ab.esHoja()) {
				aux = true;
			} else {
				aux = suma2(ab.getHijoIzquierdo()) +
					  suma2(ab.getHijoDerecho()) == ab.getDato();
			}
		}				
		
		return aux;
	}

	private int suma2(ArbolBinario<Integer> ab) {
		int aux;
		if (ab == null) {
			aux = 0;
		} else {
			if (ab.tieneHijoIzquierdo())
				aux =+ suma2(ab.getHijoIzquierdo());
			if (ab.tieneHijoDerecho())
				aux =+ suma2(ab.getHijoDerecho());
					  
		}
		aux =+ ab.getDato();
	}
	
	
	
}
