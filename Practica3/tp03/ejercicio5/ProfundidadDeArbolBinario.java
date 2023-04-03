package tp03.ejercicio5;
import tp03.ejercicio1.*;

public class ProfundidadDeArbolBinario {
	private ArbolBinario<Integer> ab = new ArbolBinario<Integer>();
	
	public int sumaElementosProfundidad(int p) {		
		return sumaRecursiva(ab,p);
	}

	private int sumaRecursiva(ArbolBinario<Integer> a, int p) {
		if (a.esVacio()) {
			return 0;
		}
		if (p == 0) {
			return a.getDato();
		}		
		return sumaRecursiva(a.getHijoDerecho(), p--) + 
			   sumaRecursiva(a.getHijoDerecho(), p--);
	}	
}
