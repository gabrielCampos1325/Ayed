package tp03.ejercicio5;
import tp03.ejercicio1.*;

public class ProfundidadDeArbolBinario {
	private ArbolBinario<Integer> ab;
	
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
		int p -= 1;		
		return sumaRecursiva(a.getHijoDerecho(), p) + 
			   sumaRecursiva(a.getHijoIzquierdo(), p);
	}	
}

public class ProfundidadDeArbolBinario {
	private ArbolBinario<Integer> a;
	
	public ProfundidadDeArbolBinario(ArbolBinario<Integer> unArbol){
		a = unArbol;
	}

	private int sumaRecursiva(int p) {
		if (a.esVacio()) {
			return 0;
		}
		if (p == 0) {
			return a.getDato();
		}
		p --;		
		return new ProfundidadDeArbolBinario(this.getHijoDerecho()).sumaRecursiva(p) 
		    +  new ProfundidadDeArbolBinario(this.getHijoIzquierdo()).sumaRecursiva(p);
	}	
}