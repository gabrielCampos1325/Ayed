package ejercicio_3;
import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class RecorridosAG {	
	
	//Método que retorna una lista con los elementos impares del árbol “a” que sean mayores al valor “n”
	//pasados como parámetros, recorrido en preorden.
	public ListaGenerica<Integer> numerosImparesMayoresQuePreOrden (ArbolGeneral <Integer> a, Integer n){
		ListaGenerica<Integer> l = new ListaEnlazadaGenerica<Integer>();
		
		if ((a.getDato() > n) && (a.getDato() % 2 == 1)) {			
			l.agregarFinal(a.getDato());
		}			
		
		ListaGenerica<ArbolGeneral<Integer>> lHijos = a.getHijos();
		lHijos.comenzar();
		while(!lHijos.fin()) {		
			ListaGenerica<Integer> res = new RecorridosAG().numerosImparesMayoresQuePreOrden(lHijos.proximo(), n);
			while (!res.esVacia() && !res.fin()) {
				l.agregarFinal(res.proximo());
			}
			//l.agregarFinal(new RecorridosAG().numerosImparesMayoresQuePreOrden(lHijos.proximo(), n).proximo());
		}
		
		return l; 
	}
		
	//Método que retorna una lista con los elementos impares del árbol “a” que sean mayores al valor “n”
	//pasados como parámetros, recorrido en inorden.
	public ListaGenerica< Integer > numerosImparesMayoresQueInOrden (ArbolGeneral <Integer> a, Integer n){
		ListaGenerica<Integer> l = new ListaEnlazadaGenerica<Integer>();
		ListaGenerica<ArbolGeneral<Integer>> lHijos = a.getHijos();
		
		if (a.tieneHijos()) {			
			lHijos.comenzar();
			ListaGenerica<Integer> res = new RecorridosAG().numerosImparesMayoresQueInOrden(lHijos.proximo(), n);
			if (!res.esVacia() && !res.fin()) {
				l.agregarFinal(res.proximo());
			}
		}				
		
		if ((a.getDato() > n) && (a.getDato() % 2 == 1)) {			
			l.agregarFinal(a.getDato());
		}
		
		while(!lHijos.fin()) {
			ListaGenerica<Integer> res = new RecorridosAG().numerosImparesMayoresQueInOrden(lHijos.proximo(), n);
			if (!res.esVacia() && !res.fin()) {
				l.agregarFinal(res.proximo());
			}
		}
		
		return l;
	}
	
	//Método que retorna una lista con los elementos impares del árbol “a” que sean mayores al valor “n”
	//pasados como parámetros recorrido en postorden.
	public ListaGenerica< Integer > numerosImparesMayoresQuePostOrden (ArbolGeneral <Integer> a, Integer n){
		ListaGenerica<Integer> l = new ListaEnlazadaGenerica<Integer>();
		
		ListaGenerica<ArbolGeneral<Integer>> lHijos = a.getHijos();
		lHijos.comenzar();
		while(!lHijos.fin()) {		
			ListaGenerica<Integer> res = new RecorridosAG().numerosImparesMayoresQuePreOrden(lHijos.proximo(), n);
			if (!res.esVacia() && !res.fin()) {
				l.agregarFinal(res.proximo());
			}
			//l.agregarFinal(new RecorridosAG().numerosImparesMayoresQuePreOrden(lHijos.proximo(), n).proximo());
		}

		if ((a.getDato() > n) && (a.getDato() % 2 == 1)) {			
			l.agregarFinal(a.getDato());
		}			
		
		return l; 
	}
		
	//Método que retorna una lista con los elementos impares del árbol “a” que sean mayores al valor “n”
	//pasados como parámetros, recorrido por niveles.
	/*public ListaGenerica< Integer > numerosImparesMayoresQuePorNiveles(ArbolGeneral	<Integer> a, Integer n){
		
	}*/
	
}
