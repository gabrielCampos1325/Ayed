package ejercicio_7;
import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.*;

public class RedDeAguaPotable<T> {
	private ArbolGeneral<T> ag;	
	
	public RedDeAguaPotable(ArbolGeneral<T> ag) {
		this.ag = ag;
	}

	/*public double minimoCaudal(double caudal) {
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
	}*/
	
	
	public double minimoCaudal(double caudal) {
		if(!this.ag.esVacio()){
            caudal= this.minimoCaudal(ag, caudal);
        }
        return caudal;
	}
	
	private double minimoCaudal(ArbolGeneral<T> ag, double caudal) {
		
		if (!ag.esHoja()) {
			ListaGenerica<ArbolGeneral<T>> lHijos = ag.getHijos();
			lHijos.comenzar();
			double caudalHijos = caudal/lHijos.tamanio();
			while (!lHijos.fin()) {
				caudal = Math.min(caudal, minimoCaudal(lHijos.proximo(), caudalHijos));
			}
		}	
		
		return caudal;
	}
	
	/*public double minimoCaudal( double caudal) ALE
    {

        if(!Arbol.esVacio())
        {
            caudal= this.minimoCaudal(Arbol, caudal);
        }
        return caudal;
    }
    private double minimoCaudal(ArbolGeneral<T> a, double caudal)
    {
        if(!a.esHoja())
        {

            ListaGenerica<ArbolGeneral<T>> hijos= a.getHijos();
            hijos.comenzar();
            double min= caudal/a.getHijos().tamanio();
            while(!hijos.fin()) {
                caudal= Math.min(caudal, minimoCaudal(hijos.proximo(),min));


        }
        }
        return caudal;
    }*/
	
}
