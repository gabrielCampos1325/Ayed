package Grafos_2012_tuiti;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.Arista;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.Vertice;

public class Mafias {
	private static String RESIDENCIA = "Casa del Intendente";
	private static String MUNICIPALIDAD = "Municipalidad";
	
	public ListaGenerica<String> calcular(Grafo<String> ciudad){
		
		//camRes
		ListaGenerica<String> camRes = new ListaEnlazadaGenerica<>();
		
		//busco origen y destino
		ListaGenerica<Vertice<String>> vertices = ciudad.listaDeVertices();
		Vertice<String> origen = null;
		Vertice<String> dest = null;
		Vertice<String> vert = null;
		vertices.comenzar();
		while (!vertices.fin() && (origen == null || dest == null)) {
			vert = vertices.proximo();
			if (vert.dato().equals(RESIDENCIA)) {
				origen = vert;
			} else if (vert.dato().equals(MUNICIPALIDAD)) {
				dest = vert;
			}			
		}
		
		if (origen != null && dest != null) {
			//auxiliar para ir armando el camino
			ListaGenerica<String> camAct = new ListaEnlazadaGenerica<>();
			
			//auxiliar para evitar ciclos
			boolean[] visitados = new boolean[vertices.tamanio() + 1];
			for (int i = 1; i < visitados.length; i++) {
				visitados[i] = false;
			}
			
			calcular(ciudad, origen, dest, camAct, camRes, visitados, 0, -1);
		}
		
		return camRes;
	}

	private void calcular(Grafo<String> ciudad, Vertice<String> origen, Vertice<String> destino,
						  ListaGenerica<String> camAct, ListaGenerica<String> camRes, boolean[] visitados,
						  int controlado, int MinControlado) {
		
		camAct.agregarFinal(origen.dato());
		visitados[origen.getPosicion()] = true;
		
		if (origen == destino && controlado < MinControlado) {
			copiar(camAct, camRes);	
				
		} else {
			ListaGenerica<Arista<String>> aristasAdy = ciudad.listaDeAdyacentes(origen);
			
			aristasAdy.comenzar();
			while (!aristasAdy.fin() && camRes.esVacia()) { //controladoMin != 0
				Arista<String> aristaAdy = aristasAdy.proximo();
				Vertice<String> verticeAdy = aristaAdy.verticeDestino();
				
				if (!visitados[verticeAdy.getPosicion()]) {
					calcular(ciudad, verticeAdy, destino, camAct, camRes, visitados, controlado);
				} 
			}
		}
		
		//backtracking: hay que desmarcar para permitir pasar mas de 1 vez por cada vertice
		camAct.eliminarEn(camAct.tamanio());
		visitados[origen.getPosicion()] = false;
	}	
	
	
	private void copiar(ListaGenerica<String> listaOrigen, ListaGenerica<String> listaDestino) {
		
		listaOrigen.comenzar();
		while (!listaOrigen.fin()) {
			listaDestino.agregarFinal(listaOrigen.proximo());
		}
	}
}
