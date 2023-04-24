package adicionales;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp02.ejercicio3.*;
import tp04.ejercicio1.*;

public class ElementosNoRepetidos {
	
	public ListaEnlazadaGenerica <Integer> elementosNoRepetidos(int p) {
		ListaEnlazadaGenerica <Integer> lista = new ListaEnlazadaGenerica<Integer>();
    if(p >= 0) {
      int nivelActual = 0;
      ColaGenerica <ArbolGeneral<T>> cola = new ColaGenerica<ArbolGeneral<T>>();
      ArbolGeneral <T> arbol;
      cola.encolar(this.a);
      cola.encolar(null);
      while(!cola.esVacia()) {
          arbol=cola.desencolar();    
          if(arbol != null) {
              if((nivelActual == p) && (!lista.incluye(arbol.getDato())))  lista.agregarFinal(arbol.getDato());
              else {
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
    return lista;
    }
	
	}
	
	public ListaEnlazadaGenerica<Integer> elementosNoRepetidos(ArbolGeneral<Integer> arbol, Integer n) {
	    ListaGenerica<Integer> lista = new ListaEnlazadaGenerica<Integer>();
	    if(n >= 0) {
	      int nivelActual = 0;
	      ColaGenerica <ArbolGeneral<T>> cola = new ColaGenerica<ArbolGeneral<T>>();
	      cola.encolar(arbol);
	      cola.encolar(null);
	      while(!cola.esVacia()) {
	          arbol = cola.desencolar();    
	          if(arbol != null) {
	              if((nivelActual == n) && !lista.incluye(arbol.getDato())) {
	                lista.agregarFinal(arbol.getDato());
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
	      if(n > nivelActual) { // nivel invalido
	        lista.agregarInicio(null);
	      }
	    }
	    return lista;
	  }
	
}
