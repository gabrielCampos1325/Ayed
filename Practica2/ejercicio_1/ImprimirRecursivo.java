package ejercicio_1;
import tp02.ejercicio1.*;

/*
1.5. Escriba un método recursivo que imprima los elementos de una lista en sentido inverso. La lista
la recibe por parámetro.
*/

public class ImprimirRecursivo {
	
	public static void imprimir(ListaDeEnteros l) {
		if(! l.fin()) {
			int dato = l.proximo();
			imprimir(l);
			System.out.println(dato);
		}
	}
	
	//Otra opcion podria ser recibir una lista y un puntero que movemos en cada llamada
	
	
	public static void main(String[] args) {
		
		ListaDeEnteros listaArray = new ListaDeEnterosConArreglos();
		
		ListaDeEnteros listaEnlazada = new ListaDeEnterosEnlazada();
		
		for (int i = 0; i < 10; i++) {
			listaArray.agregarFinal(i);
			listaEnlazada.agregarFinal(i);
		}
		
		System.out.println("Imprimiendo la lista de array");
		listaArray.comenzar();
		imprimir(listaArray);
		
		System.out.println("Imprimiendo la lista enlazada");
		listaEnlazada.comenzar();
		imprimir(listaEnlazada);
		
	}
	
}
