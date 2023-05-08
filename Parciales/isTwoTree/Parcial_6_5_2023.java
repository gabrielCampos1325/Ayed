package isTwoTree;

import tp03.ejercicio1.ArbolBinario;

public class Parcial_6_5_2023 {
	
	ArbolBinario<Integer> ab;
	
	public Parcial_6_5_2023(ArbolBinario<Integer> ab) {
		this.ab = ab;
	}
	
	public boolean isTwoTree(int num) {
		boolean aux = false;
		ArbolBinario<Integer> subA = buscar(this.ab, num);
		if (!subA.esVacio())
			aux = isTwoTree(subA);
		return aux;
	}
	
	private ArbolBinario<Integer> buscar(ArbolBinario<Integer> ab, int num){
		ArbolBinario<Integer> aux = new ArbolBinario<Integer>();
		
		if (ab.getDato().equals(num))
			aux = ab;
		else
			if (ab.tieneHijoIzquierdo() & aux.esVacio())
				aux = buscar(ab.getHijoIzquierdo(), num);
			if (ab.tieneHijoDerecho() & aux.esVacio())
				aux = buscar(ab.getHijoDerecho(), num);
		return aux;
	}
	
	private boolean isTwoTree(ArbolBinario<Integer> ab) {
		int aux1= 0;
		int aux2= 0;
		
		if (!ab.esHoja()) {
			if (ab.tieneHijoIzquierdo()) {
				if (isTwoTree(ab.getHijoIzquierdo()))
					aux1++;
				//aux1 += cumple(ab.getHijoIzquierdo());
				//isTwoTree(ab.getHijoIzquierdo());
			}
			if (ab.tieneHijoDerecho()) {
				if (isTwoTree(ab.getHijoDerecho()))
					aux2++;				
				//aux2 += cumple(ab.getHijoDerecho());
				//isTwoTree(ab.getHijoDerecho());
			}
		}			
		
		return aux1 == aux2;
	}
	
	private int cumple(ArbolBinario<Integer> ab) {
		int aux = 0;
		
		/*if (ab.esHoja())
			aux++;*/
		if (ab.tieneHijoIzquierdo() & ab.tieneHijoDerecho())
			aux++;
		
		return aux;
	}
}
