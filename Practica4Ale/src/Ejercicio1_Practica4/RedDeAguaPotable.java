package Ejercicio1_Practica4;

public class RedDeAguaPotable {
	ArbolGeneral<T> Arbol;

	public RedDeAguaPotable(ArbolGeneral<T> arbol) {
		Arbol = arbol;
	}
	    public double minimoCaudal(double caudal) {
	        if (Arbol.esHoja()) {
	            return caudal;
	        } else {
	            ListaGenerica<ArbolGeneral<T>> lHijos = Arbol.getHijos();
	            lHijos.comenzar();
	            double caudalHijos = caudal/lHijos.tamanio();
	            while (!lHijos.fin()) {
	                caudal = Math.min(caudal, new RedDeAguaPotable<T>(lHijos.proximo()).minimoCaudal(caudalHijos));
	            }
	        }
	        return caudal;
	    }
	}
