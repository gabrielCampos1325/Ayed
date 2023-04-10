package adicionales;
import tp02.ejercicio2.*;
import tp03.ejercicio1.ArbolBinario;

public class TestSolucion {

	public static void main(String[] args) {
		
		ArbolBinario<Integer> raiz = new ArbolBinario<Integer>(14);
		
		raiz.agregarHijoIzquierdo(new ArbolBinario<Integer>(2));
		raiz.agregarHijoDerecho(new ArbolBinario<Integer>(6));
		
		raiz.getHijoIzquierdo().agregarHijoIzquierdo(new ArbolBinario<Integer>(3));
		//raiz.getHijoIzquierdo().agregarHijoDerecho(new ArbolBinario<Integer>(1));
		
		//raiz.getHijoDerecho().agregarHijoIzquierdo(new ArbolBinario<Integer>(4));		
		raiz.getHijoDerecho().agregarHijoDerecho(new ArbolBinario<Integer>(7));		
		
		/* 		 				 
		        14
		     /      \
		   	2        6
		  /  \      /  \
		 3   1     4    7
		 
		*/			
		
		ListaGenerica<Integer> l = new ListaEnlazadaGenerica<Integer>();		
			
		l = Solucion.caminoMasLargo(raiz).clonar(); 		
		
		ListaGenerica<Integer> l2 = new ListaEnlazadaGenerica<Integer>();		
		
		l2 = Solucion.caminoMasLargoYMayorValor(raiz).clonar(); 		
		
		while (!l.fin()) {
			System.out.println(l.proximo());
		}
		
		System.out.println("-----------------");
		
		while (!l2.fin()) {
			System.out.println(l2.proximo());
		}
	}
}
