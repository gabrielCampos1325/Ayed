package ProcesadorDeArbolTema2;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class Datos {
	private int cantImpares;
	private ListaGenerica<ArbolBinario<Integer>> lista; 
	
	public Datos() {		
		this.cantImpares = 0;
		this.lista = new ListaEnlazadaGenerica<ArbolBinario<Integer>>();
	}

	public int getCantImpares() {
		return cantImpares;
	}

	public void incCantImpares() {
		this.cantImpares++;
	}

	public ListaGenerica<ArbolBinario<Integer>> getLista() {
		return lista;
	}	
	
}
