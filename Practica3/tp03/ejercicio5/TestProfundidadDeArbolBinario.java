package tp03.ejercicio5;

import tp03.ejercicio1.*;

public class TestProfundidadDeArbolBinario {

	public static void main(String[] args) {
		
		ArbolBinario<Integer> raiz = new ArbolBinario<Integer>(14);
		
		raiz.agregarHijoIzquierdo(new ArbolBinario<Integer>(2));
		raiz.agregarHijoDerecho(new ArbolBinario<Integer>(6));
		
		raiz.getHijoIzquierdo().agregarHijoIzquierdo(new ArbolBinario<Integer>(3));
		raiz.getHijoIzquierdo().agregarHijoDerecho(new ArbolBinario<Integer>(1));
		
		raiz.getHijoDerecho().agregarHijoIzquierdo(new ArbolBinario<Integer>(4));		
		raiz.getHijoDerecho().agregarHijoDerecho(new ArbolBinario<Integer>(7));		
		
		/* 		 				 
		        14
		     /      \
		   	2        6
		  /  \      /  \
		 3   1     4    7
		 
		*/
		
		
		ProfundidadDeArbolBinario ab = new ProfundidadDeArbolBinario(raiz);
		
		// OPCION 1
		System.out.println(ab.sumaElementosProfundidad(3)); 
		
		// OPCION 2	
		System.out.println(ab.sumaRecursiva(3));		
		
	}

}
