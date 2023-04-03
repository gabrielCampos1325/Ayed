package tp03.ejercicio4;
import tp03.ejercicio1.ArbolBinario;

public class RedBinariaLlena {
	private ArbolBinario<Integer> arbol;
	
	public RedBinariaLlena (ArbolBinario<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public int retardoReenvio () {
		return tiempoMax(arbol);
	}
	
	private int tiempoMax(ArbolBinario<Integer> a) {
		
		int max1 = a.getDato();
		int max2 = a.getDato();
		
		if(!a.esHoja()) {
			max1 += tiempoMax(a.getHijoIzquierdo());
			max2 += tiempoMax(a.getHijoDerecho());
		}
		
		return Math.max(max1, max2);	
		
	};
}
