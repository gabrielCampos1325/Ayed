package ejercicio_7;
import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.*;

public class RedDeAguaPotable<T> {
	private ArbolGeneral<T> ag;	
	
	public RedDeAguaPotable(ArbolGeneral<T> ag) {
		this.ag = ag;
	}

	public double minimoCaudal(double caudal) {
		if (ag.esHoja()) {
			return caudal;
		} else {
			ListaGenerica<ArbolGeneral<T>> lHijos = ag.getHijos();
			lHijos.comenzar();
			double caudalHijos = caudal/lHijos.tamanio();
			while (!lHijos.fin()) {
				caudal = Math.min(caudal, new RedDeAguaPotable<T>(lHijos.proximo()).minimoCaudal(caudalHijos));
			}
		}
		return caudal;		
	}
	
}
