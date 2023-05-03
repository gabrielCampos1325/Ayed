package ProcesadorDeArbolTema1;

import tp03.ejercicio1.ArbolBinario;

public class ProcesadorDeArbolTema1 {
	
	ArbolBinario<Integer> ab;
	
	public ProcesadorDeArbolTema1(ArbolBinario<Integer> arbol) {
		this.ab = arbol;
	}
	
	public Datos procesar(){
		Datos d = new Datos();		
		if (!this.ab.esVacio()) {			
			procesar(this.ab, d);
		}
		return d;
	}
	
	private void procesar(ArbolBinario<Integer> ab, Datos d) {
		if (ab.getDato() % 2 == 0)
			d.incCantPares();
		if (ab.tieneHijoIzquierdo() && ab.tieneHijoDerecho())
			d.getLista().agregarFinal(ab);
		
		if (ab.tieneHijoIzquierdo())
			procesar(ab.getHijoIzquierdo(), d);
		if (ab.tieneHijoDerecho())
			procesar(ab.getHijoDerecho(), d);
	}
	
}
