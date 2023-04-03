package tp03.ejercicio3;
import tp02.ejercicio2.*;
import tp03.ejercicio1.*;

public class ContadorArbol {
	private ArbolBinario<Integer> ab;
	
	public ListaGenerica<Integer> numerosPares() {
		ListaGenerica<Integer> lista = new ListaEnlazadaGenerica<Integer>();
		
		if (ab.getDato() % 2 == 0) {
			lista.agregarFinal(ab.getDato());
		}
		if (ab.tieneHijoDerecho()) {
			return numerosPares();
		}
		
		return lista;
	}
}
