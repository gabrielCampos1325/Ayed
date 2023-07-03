package Grafos_2011_tuiti;

import java.util.Collection;
import java.util.Collections;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.Arista;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.Vertice;

public class Red {	
	
	public ListaGenerica<String> calcular(Grafo<String> empresas, String destino, int maxTiempo){		
		
		ListaGenerica<String> camRes = new ListaEnlazadaGenerica<>();		
		
		if (!empresas.esVacio()) {
			ListaGenerica<Vertice<String>> vertices = empresas.listaDeVertices();
			ListaGenerica<String> camAct = new ListaEnlazadaGenerica<>();
			boolean[] visitados = new boolean[vertices.tamanio() + 1];
			for (int i = 1; i < visitados.length; i++) {
				visitados[i] = false;
			}
			
			calcular(empresas, vertices.elemento(0), camAct, camRes, visitados, 0, -1);
		}
		
		
		return camRes;
	}

	private void calcular(Grafo<String> empresas, Vertice<String> origen, ListaGenerica<String> camAct, 
			ListaGenerica<String> camRes, boolean[] visitados, int cant, int minMax) {
		
		camAct.agregarFinal(origen.dato());
		visitados[origen.getPosicion()] = true;
		
		ListaGenerica<Arista<String>> aristasAdy = empresas.listaDeAdyacentes(origen);
		
		aristasAdy.comenzar();
		while (!aristasAdy.fin()) {
			Arista<String> aristaAdy = aristasAdy.proximo();
			Vertice<String> verticeAdy = aristaAdy.verticeDestino();
			
			if (!visitados[verticeAdy.getPosicion()]) {
				calcular(empresas, verticeAdy, camAct, camRes, visitados, cant++, minMax);
			} 
		}		
		
		if (cant > minMax) {
			minMax = cant;
			camRes.agregarFinal(origen.dato());
		}
		
		//backtracking: hay que desmarcar para permitir pasar mas de 1 vez por cada vertice
		camAct.eliminarEn(camAct.tamanio());
		visitados[origen.getPosicion()] = false;
	}		

	
}
