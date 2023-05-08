package adicionales;
import tp03.ejercicio1.ArbolBinario;

public class MandatoBinario {
	
	private ArbolBinario<Integer> ab;
	
	public MandatoBinario(ArbolBinario<Integer> arbol) {
		this.ab = arbol;
	}

	public Boolean esMandato (int k) {
		Boolean es = false;
		if (!this.ab.esVacio()) {
			es = esMandato(k, this.ab);
		}
		return es;
	}
	
	private Boolean esMandato(int k, ArbolBinario<Integer> ab) {		
		boolean es = true;
		k = k - ab.getDato();
		
		if (!ab.esHoja()) {
			
			if (es && ab.tieneHijoIzquierdo()) {
				es = esMandato(k, ab.getHijoIzquierdo());
			}
			
			if (es && ab.tieneHijoDerecho()) {
				es = esMandato(k, ab.getHijoDerecho());
			}
			
		} else if (k != 0){
			es = false;
		}
		
		return es;		
	}
	
	
}
