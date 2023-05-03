package adicionales;
import tp02.ejercicio2.ListaGenerica;
import tp03.ejercicio1.ArbolBinario;
import tp04.ejercicio1.ArbolGeneral;

public class MandatoGeneral {
	
	private ArbolGeneral<Integer> ag;
	
	public MandatoGeneral(ArbolGeneral<Integer> arbol) {
		this.ag = arbol;
	}

	public Boolean esMandato (int k) {
		Boolean es = false;
		if (!this.ag.esVacio()) {
			es = esMandato(k, this.ag);
		}
		return es;
	}
	
	private Boolean esMandato(int k, ArbolGeneral<Integer> ab) {		
		boolean es = true;
		k = k - ab.getDato();
		
		if (k > 0 && !ab.esHoja()) {
			
			ListaGenerica<ArbolGeneral<Integer>> lHijos = ab.getHijos();
			lHijos.comenzar();
			while (!lHijos.fin() & es) {
				es = esMandato(k, lHijos.proximo());
			}
			
		} else if (k != 0){
			es = false;
		}
		
		return es;		
	}
	
	
}
