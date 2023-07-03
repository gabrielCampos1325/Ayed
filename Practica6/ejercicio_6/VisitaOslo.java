package ejercicio_6;

import tp02.ejercicio2.*;
import tp06.ejercicio3.*;

public class VisitaOslo {
	private static String AYUNTAMIENTO = "ayuntamiento";
	private static String MUSEO_MUNCH = "museo munch";
	
	public ListaGenerica<String> paseoEnBici(Grafo<String> lugares, String destino, int maxTiempo){
		
		//resultado
		ListaGenerica<String> result = new ListaEnlazadaGenerica<>();
		
		//busco origen y destino
		ListaGenerica<Vertice<String>> vertices = lugares.listaDeVertices();
		Vertice<String> origen = null;
		Vertice<String> dest = null;
		Vertice<String> vert = null;
		vertices.comenzar();
		while (!vertices.fin() && (origen == null || dest == null)) {
			vert = vertices.proximo();
			if (vert.dato().equals(AYUNTAMIENTO)) {
				origen = vert;
			} else if (vert.dato().equals(destino)) {
				dest = vert;
			}			
		}
		
		if (origen != null && dest != null) {
			//auxiliar para ir armando el camino
			ListaGenerica<String> listaTemp = new ListaEnlazadaGenerica<>();
			
			//auxiliar para evitar ciclos
			boolean[] visitados = new boolean[vertices.tamanio() + 1];
			for (int i = 1; i < visitados.length; i++) {
				visitados[i] = false;
			}
			
			paseoEnBici(lugares, origen, dest, maxTiempo, listaTemp, result, visitados);
		}
		
		return result;
	}

	private void paseoEnBici(Grafo<String> lugares, Vertice<String> origen, Vertice<String> destino, int maxTiempo,
			ListaGenerica<String> listaTemp, ListaGenerica<String> result, boolean[] visitados) {
		
		listaTemp.agregarFinal(origen.dato());
		visitados[origen.getPosicion()] = true;
		
		if (origen == destino) {
			if (cumpleCondicion(listaTemp)) {
				copiar(listaTemp, result);
			}
		} else {
			ListaGenerica<Arista<String>> aristasAdy = lugares.listaDeAdyacentes(origen);
			
			aristasAdy.comenzar();
			while (!aristasAdy.fin() && result.esVacia()) {
				Arista<String> aristaAdy = aristasAdy.proximo();
				Vertice<String> verticeAdy = aristaAdy.verticeDestino();
				
				if (aristaAdy.peso() <= maxTiempo && !visitados[verticeAdy.getPosicion()]) {
					paseoEnBici(lugares, verticeAdy, destino, maxTiempo - aristaAdy.peso(), listaTemp, result, visitados);
				} 
			}
		}
		
		//backtracking: hay que desmarcar para permitir pasar mas de 1 vez por cada vertice
		listaTemp.eliminarEn(listaTemp.tamanio());
		visitados[origen.getPosicion()] = false;
	}	

	private boolean cumpleCondicion(ListaGenerica<String> listaTemp) {
		boolean encontre = false;
		
		listaTemp.comenzar();
		while (!listaTemp.fin() && !encontre) {
			if (listaTemp.proximo().equals(MUSEO_MUNCH)) {
				encontre = true;
			}
		}
		
		return encontre;
	}
	
	private void copiar(ListaGenerica<String> listaOrigen, ListaGenerica<String> listaDestino) {
		
		listaOrigen.comenzar();
		while (!listaOrigen.fin()) {
			listaDestino.agregarFinal(listaOrigen.proximo());
		}
	}
}
