package ejercicio_5;

import tp02.ejercicio2.*;
import tp06.ejercicio3.*;

public class Mapa {
	
	private Grafo<String> mapaCiudades;
	
	public Mapa (Grafo<String> mapaCiudades) {
		this.mapaCiudades = mapaCiudades;
	}
	
	public ListaGenerica<String> caminoConMenorCargaDeCombustible (String origen, String destino, int tanque) {
		ListaGenerica<String> camMinimo = new ListaEnlazadaGenerica<>();
		int cargaMin = Integer.MAX_VALUE;
		if (!this.mapaCiudades.esVacio()) {
			Vertices verts = buscarVertices(origen, destino);
			if (verts.getOrigen() != null && verts.getDestino() != null) {
				boolean[] marca = new boolean[this.mapaCiudades.listaDeVertices().tamanio() + 1];
				ListaGenerica<String> cam = new ListaEnlazadaGenerica<>();
				cargaMin = caminoConMenorCargaDeCombustible(verts.getOrigen().posicion(), verts.getDestino(), camMinimo,
						cam, marca, tanque, tanqueAct, cargaMin, 0);
			}			
		}
	}
	
	private int caminoConMenorCargaDeCombustible (int posV1, Vertice<String> v2, boolean[] marca, ListaGenerica<String> camMinimo,
			ListaGenerica<String> cam, int tanque, int tanqueAct, int cargaMin, int cargaAct) {
		
		marca[posV1] = true;
		Vertice<String> v1 = this.mapaCiudades.vetice(posV1);
		cam.agregarFinal(v1.dato());
		if (v1 == v2) {
			camMinimo.eliminarTodos();
			cargaMin = cargaAct;
			cam.comenzar();
			while (!cam.fin()) {
				camMinimo.agregarFinal(cam.proximo());
			}
		} else {
			ListaGenerica<Arista<String>> adys = this.mapaCiudades.listaDeAdyacentes(v1);
			adys.comenzar();
			while (!adys.fin() && cargaMin != 0) {
				Arista<String> a = adys.proximo();
				int j = a.verticeDestino().getPosicion();
				int peso = a.peso();
				if (!marca[j]) {
					if (peso <= tanqueAct) {
						cargaMin = caminoConMenorCargaDeCombustible(j, v2, marca, camMinimo,
								cam, tanque, tanqueAct - peso, cargaMin, cargaAct);
					} else if (peso <= tanque && cargaAct + 1 < cargaMin ) {
						cargaMin = caminoConMenorCargaDeCombustible(j, v2, marca, camMinimo,
								cam, tanque, tanqueAct - peso, cargaMin, cargaAct + 1);
					}
				}
			}
		}
		marca[posV1] = false;
		cam.eliminarEn(cam.tamanio());
		return cargaMin;
	}

	private Vertices buscarVertices(String c1, String c2) {
		ListaGenerica<Vertice<String>> vertices = this.mapaCiudades.listaDeVertices();
		Vertices verts = new Vertices();
		vertices.comenzar();
		while (!vertices.fin()) {
			Vertice<String> v = vertices.proximo();
			if (v.dato().equals(c1)) {
				verts.setOrigen(v);
			} else if (v.dato().equals(c2)) {
				verts.setDestino(v);
			}
		}
		return Vertices;
	}
	
}
