package adicionales;
import tp02.ejercicio2.*;
import tp03.ejercicio1.ArbolBinario;

public class Solucion {
	

	// A
	public static ListaGenerica<Integer> caminoMasLargo(ArbolBinario<Integer> arbol) {
		if (arbol == null) {
			ListaGenerica<Integer> array = new ListaEnlazadaGenerica<Integer>();
			return array;
		}
		
		ListaGenerica<Integer> izquierdo = caminoMasLargo(arbol.getHijoIzquierdo());
		ListaGenerica<Integer> derecho = caminoMasLargo(arbol.getHijoDerecho());
		
		if (derecho.tamanio() >izquierdo.tamanio()) {
			derecho.agregarInicio(arbol.getDato());
		} else {
			izquierdo.agregarInicio(arbol.getDato());
		}
		
		return (izquierdo.tamanio() > derecho.tamanio() ? izquierdo : derecho);		
	}

	
	// B

	
	
	// C
	public static ListaGenerica<Integer> caminoMasLargoYMayorValor(ArbolBinario<Integer> arbol) {
		if (arbol == null) {
			ListaGenerica<Integer> array = new ListaEnlazadaGenerica<Integer>();
			return array;
		}
		
		ListaGenerica<Integer> izquierdo = caminoMasLargoYMayorValor(arbol.getHijoIzquierdo());
		ListaGenerica<Integer> derecho = caminoMasLargoYMayorValor(arbol.getHijoDerecho());
		
		if (derecho.tamanio() == izquierdo.tamanio()){			
			int maxD = 0;
			int maxI = 0;
			for (int i = 1; i <= derecho.tamanio(); i++) {
				maxD += derecho.elemento(i);
				maxI += izquierdo.elemento(i);
			}			
			if (maxD > maxI) {
				derecho.agregarInicio(arbol.getDato());
			} else {
				izquierdo.agregarInicio(arbol.getDato());
			}				
		} else {
			if (derecho.tamanio() > izquierdo.tamanio()) {
				derecho.agregarInicio(arbol.getDato());
			} else {
				izquierdo.agregarInicio(arbol.getDato());
			}
		}		
		
		return (izquierdo.tamanio() > derecho.tamanio() ? izquierdo : derecho);		
	}

	
	public static class Resultado {
		ListaGenerica<Integer> datos;
		int total;
		public Resultado() {
			datos = new ListaEnlazadaGenerica<>();
			total = 0;
		}
		public void agregar(Integer valor) {
			total += valor;
			datos.agregarAlInicio(valor);
		}
		public int compareTo(Resultado otro) {
			if (this.datos.tamanio() < otro.datos.tamanio()) {
				return -1;  // el objeto resultado que recibe el mensaje es mas chico
			}
			if (this.datos.tamanio() > otro.datos.tamanio()) {
				return 1;  // el objeto resultado que recibe el mensaje es mas grande
			}
			return this.total - otro.total;  // tiene la misma cantidad de elemntos, decido por su total
		}
	}
	

	public static ListaGenerica<Integer> caminoMasLargoYMayorValor2(ArbolBinario<Integer> arbol) {
		if (arbol == null) {
			return new Resultado();
		}
		Resultado r1 = caminoMasLargoYMayorValor2(arbol.getHijoIzquierdo());
		Resultado r1 = caminoMasLargoYMayorValor2(arbol.getHijoDerecho());
		Resultado total;
		
		if (r1.compareTo(r2) < 0) {
			total = r2
		}
		else {
			total = r1;
		}
		total.agregar(arbol.getDato());
		return total;
	}

}
