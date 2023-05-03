package ProcesadorDeArbolTema1;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class Datos {
	private int cantPares;
	private ListaGenerica<ArbolBinario<Integer>> lista; 
	
	public Datos() {		
		this.cantPares = 0;
		this.lista = new ListaEnlazadaGenerica<ArbolBinario<Integer>>();
	}

	public int getCantPares() {
		return cantPares;
	}

	public void incCantPares() {
		this.cantPares++;
	}

	public ListaGenerica<ArbolBinario<Integer>> getLista() {
		return lista;
	}	
	
}
