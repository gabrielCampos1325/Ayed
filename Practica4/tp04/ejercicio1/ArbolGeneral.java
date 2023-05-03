package tp04.ejercicio1;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp02.ejercicio3.*;

public class ArbolGeneral<T> {

	private T dato;

	private ListaGenerica<ArbolGeneral<T>> hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();

	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public void setHijos(ListaGenerica<ArbolGeneral<T>> hijos) {
		if (hijos==null)
			this.hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		else
			this.hijos = hijos;
	}

	public ArbolGeneral(T dato) {
		this.dato = dato;
	}

	public ArbolGeneral(T dato, ListaGenerica<ArbolGeneral<T>> hijos) {
		this(dato);
		if (hijos==null)
			this.hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		else
			this.hijos = hijos;
	}

	public ListaGenerica<ArbolGeneral<T>> getHijos() {
		return this.hijos;
	}

	public void agregarHijo(ArbolGeneral<T> unHijo) {

		this.getHijos().agregarFinal(unHijo);
	}

	public boolean esHoja() {

		return !this.tieneHijos();
	}
	
	public boolean tieneHijos() {
		return !this.hijos.esVacia();
	}
	
	public boolean esVacio() {

		return this.dato == null && !this.tieneHijos();
	}

	

	public void eliminarHijo(ArbolGeneral<T> hijo) {
		if (this.tieneHijos()) {
			ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
			if (hijos.incluye(hijo)) 
				hijos.eliminar(hijo);
		}
	}
	
	public ListaEnlazadaGenerica<T> preOrden() {
		return null;
	}
	
	public Integer altura() {
		// Falta implementar..
		return 0;
	}

	public Integer nivel(T dato) {
		// falta implementar
		return -1;
	}

	public Integer ancho() {
		// Falta implementar..
		return 0;
	}
	
	public Boolean esAncestro(T a, T b) {
		Boolean esAnc =  false;
		ArbolGeneral<T> subA = this.subArbol(a);
		if (!subA.esVacio()) {
			ArbolGeneral<T> subB = this.subArbol(b);
			esAnc = !subB.esVacio();
		}
		return esAnc;
	}
	
	private ArbolGeneral<T> subArbol (T dato) {
		ArbolGeneral<T> subA = new ArbolGeneral<T>();
		
		if (this.getDato().equals(dato)) {
			subA = this;
		} else {
			if (!this.esHoja()) {
				ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
				hijos.comenzar();
				boolean encontrado = false;
				while (!hijos.fin() & !encontrado) {
					ArbolGeneral<T> hijo = hijos.proximo();
					subA = hijo.subArbol(dato);
					if (!subA.esVacio()) {
						encontrado = true;
					}
				}
			}
		}
		return subA;
	}
	
	public int sumaElementosProfundidad(int p) {
		int total = 0;
	    if(p < 0) { // valor invalido
	    	total = Integer.MAX_VALUE;
	    }
	    else {
	    	int nivelActual = 0;
	        ColaGenerica <ArbolGeneral<T>> cola = new ColaGenerica<ArbolGeneral<T>>();
	        ArbolGeneral <T> arbol;
	        //cola.encolar(this.a); Comentado para que no de error
	        cola.encolar(null);
	        while(!cola.esVacia()) {
	        	arbol=cola.desencolar();    
	            if(arbol != null) {
	            	if(nivelActual == p) {
	                //total += arbol.getDato(); Comentado para que no de error
	            	} else {
		            	ListaGenerica<ArbolGeneral<T>> lHijos = arbol.getHijos();
		                lHijos.comenzar();
		                while (!lHijos.fin()) {
		                  cola.encolar(lHijos.proximo());
		                }
	            	}    
	            } else if(!cola.esVacia()){
	              nivelActual++;
	              cola.encolar(null);
	          }
	        }
	        if(p > nivelActual) {
	        	total = Integer.MIN_VALUE;
	        }
	    }
	    	return total;
	}

}