package ColorearEntreNiveles;

import tp02.ejercicio3.ColaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class ColorearEntreNiveles {
	
	public void colorear(ArbolBinario<String> ab, int nivelMin, int nivelMax) {
		if (nivelMin < 0) { // Valor invalido
			return;
		} else {
			ColaGenerica<ArbolBinario<String>> cola = new ColaGenerica<ArbolBinario<String>>();
			ArbolBinario<String> aux;
			
			cola.encolar(ab);
			cola.encolar(null);
			
			int nivelActual = 0;
			
			while(!cola.esVacia()) {
				aux = cola.desencolar();
				if (aux != null) {
					if (nivelActual >= nivelMin && nivelActual <=nivelMax) {
						aux.setDato("Rojo");						
					} else {
						aux.setDato("Negro");						
					}
					if (aux.tieneHijoIzquierdo())
						cola.encolar(aux.getHijoIzquierdo());
					if (aux.tieneHijoDerecho())
						cola.encolar(aux.getHijoDerecho());
				} else {
					if (!cola.esVacia()) {
						cola.encolar(null);
						nivelActual++;
					}
				}
			}
			if (nivelActual < nivelMin) { //Valor inalcanzable
				return;
			}
		}
		
	}
	
}
