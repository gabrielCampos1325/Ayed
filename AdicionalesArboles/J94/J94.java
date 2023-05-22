package J94;

import tp03.ejercicio1.ArbolBinario;

public class J94 {
	
	ArbolBinario<Character> ab1;
	ArbolBinario<Character> ab2;
	
	public boolean mismaEstructura() {
		boolean aux = false;
		if (!this.ab1.esVacio() && !this.ab2.esVacio()) {
			aux= mismaEstructura(ab1, ab2);
		}		
		return aux;
	}
	
	//OPCION 1
	private boolean mismaEstructura(ArbolBinario<Character> ab1, ArbolBinario<Character> ab2){
		boolean cumple = true;
		
		if (ab1.tieneHijoIzquierdo() && ab2.tieneHijoIzquierdo())
			cumple = mismaEstructura(ab1.getHijoIzquierdo(), ab2.getHijoIzquierdo());
		else
			cumple = false;
		
		if (cumple) {
			if (ab1.tieneHijoDerecho() && ab2.tieneHijoDerecho())
				cumple = mismaEstructura(ab1.getHijoDerecho(), ab2.getHijoDerecho());
			else
				cumple = false;
		}		
		
		return cumple;
	}
	
	//OPCION 2
	private boolean mismaEstructura2(ArbolBinario<Character> ab1, ArbolBinario<Character> ab2){
		boolean cumpleHI = true;
		boolean cumpleHD = true;
		
		if (ab1.tieneHijoIzquierdo() && ab2.tieneHijoIzquierdo())
			cumpleHI = mismaEstructura2(ab1.getHijoIzquierdo(), ab2.getHijoIzquierdo());
		else
			cumpleHI = false;
		
		if (cumpleHI && ab1.tieneHijoDerecho() && ab2.tieneHijoDerecho())
			cumpleHD = mismaEstructura2(ab1.getHijoDerecho(), ab2.getHijoDerecho());
				
		return cumpleHI == cumpleHD;
	}

	
}
