package balancedTree;

import tp03.ejercicio1.ArbolBinario;

public class isBalanced {
	
	public boolean calcular(ArbolBinario<Integer> ab) {
		boolean aux = false;
		if (!ab.esVacio()) {
			aux = Math.abs(altura(ab.getHijoIzquierdo()) - 
					 altura(ab.getHijoDerecho())) <= 1;
		}
		return aux;
	}

	private int altura(ArbolBinario<Integer> ab) {
		Math.abs(altura(ab.getHijoIzquierdo()) - 
				 altura(ab.getHijoDerecho())) <= 1;
	}
	
}
