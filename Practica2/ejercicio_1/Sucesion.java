package ejercicio_1;
import tp02.ejercicio1.*;

public class Sucesion {	
	
	public static void calcularSucesionSinListar(int n) {		
		System.out.print(n + " ");
		if (n != 1) {			
			if (n % 2 == 0) {
				calcularSucesionSinListar(n/2);
			} else {
				calcularSucesionSinListar(3*n + 1);
			}			
		}				
	}
	
	public ListaDeEnterosEnlazada calcularSucesionConLista(int n) {
		ListaDeEnterosEnlazada lista;
		
		if (n != 1) {			
			if (n % 2 == 0) {
				lista = calcularSucesionConLista(n/2);
			} else {
				lista = calcularSucesionConLista(3*n + 1);
			}				
		} else {
			lista = new ListaDeEnterosEnlazada();
		}
		
		lista.agregarInicio(n);
		
		return lista;
	}
	
	public static void main(String[] args) {
		
		calcularSucesionSinListar(6);
		// 6, 3, 10, 5, 16, 8, 4, 2, 1
		
		System.out.println("");
		
		Sucesion f = new Sucesion();
		ListaDeEnterosEnlazada l = f.calcularSucesionConLista(6);
		
		l.comenzar();
		while (! l.fin()) {
			System.out.print(l.proximo() + " ");
		}
	}	

}
