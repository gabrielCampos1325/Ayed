package tp03.ejercicio5;
import tp03.ejercicio1.*;

public class ProfundidadDeArbolBinario {	
	
	private ArbolBinario<Integer> ab;
	
	public ProfundidadDeArbolBinario (ArbolBinario<Integer> arbol) {
		ab = arbol;
	}
	
	// OPCION 1
	public int sumaElementosProfundidad(int p) {		
		return sumaRecursiva(ab, p);
	}

	private int sumaRecursiva(ArbolBinario<Integer> ab, int p) {
		if (ab == null) {
			return 0;
		}
		if (p == 0) {
			return ab.getDato();
		}
		p--;
		return sumaRecursiva(ab.getHijoDerecho(), p) + 
			   sumaRecursiva(ab.getHijoIzquierdo(), p);
	}
	
	// OPCION 2	
	public int sumaRecursiva(int p) {
		if (ab == null) {
			return 0;
		}
		if (p == 0) {
			return ab.getDato();
		}
		p --;		
		return new ProfundidadDeArbolBinario(this.ab.getHijoDerecho()).sumaRecursiva(p) 
		    +  new ProfundidadDeArbolBinario(this.ab.getHijoIzquierdo()).sumaRecursiva(p);
	}
	
}
