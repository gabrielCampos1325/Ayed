package ColorearArbol;

import tp02.ejercicio3.ColaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class ColorearArbol {
	
	public void colorear(ArbolBinario<String> ab, int maxColor) {
		
		if (!ab.esVacio()) {
			ColaGenerica<ArbolBinario<String>> cola = new ColaGenerica<ArbolBinario<String>>();
			ArbolBinario<String> aux;
			cola.encolar(ab);
			cola.encolar(null);
			boolean negro = true;
			int cantNivel = 0;
			while (!cola.esVacia()) {
				aux = cola.desencolar();
				if (aux != null) {
					if (cantNivel < maxColor) {
						cantNivel++;
						if (negro)
							aux.setDato("Negro");
						else
							aux.setDato("Rojo");
					} else {
						aux.setDato("Verde");
					}
					if (aux.tieneHijoIzquierdo())
						cola.encolar(aux.getHijoIzquierdo());
					if (aux.tieneHijoDerecho())
						cola.encolar(aux.getHijoDerecho());
				} else {
					if (!cola.esVacia()) {
						cola.encolar(null);
						negro = !negro;
						cantNivel = 0;
					}
				}
			}
		}
	}
	
}
