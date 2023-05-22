package isTwoTree;

import tp03.ejercicio1.ArbolBinario;

public class Parcial_6_5_2023_Correccion {
	
	ArbolBinario<Integer> ab;
	
	public Parcial_6_5_2023_Correccion(ArbolBinario<Integer> ab) {
		this.ab = ab;
	}
	
	public boolean isTwoTree(int num) {
		boolean aux = false;
		ArbolBinario<Integer> subA = buscar(this.ab, num);
		if (!subA.esVacio()) {
			aux = contar(subA.getHijoIzquierdo()) == contar(subA.getHijoDerecho());
		}			
		
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
	
	private int contar(ArbolBinario<Integer> ab) {		
		if (ab == null) {
			return -1;
		}
		
		int cont = 0;
		
		if (!ab.esHoja())
			if (ab.tieneHijoIzquierdo())
				cont += contar(ab.getHijoIzquierdo());
			if (ab.tieneHijoDerecho())
				cont += contar(ab.getHijoDerecho());
			if (ab.tieneHijoIzquierdo() && ab.tieneHijoDerecho())
				cont++;
			
		return cont;			
	}	

}
