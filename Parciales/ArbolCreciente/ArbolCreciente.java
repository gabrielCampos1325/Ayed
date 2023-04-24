package ArbolCreciente;
import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp02.ejercicio3.ColaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class ArbolCreciente<T> {
	
	private ArbolGeneral<T> ag;	
	
	public ArbolCreciente(ArbolGeneral<T> ag) {
		this.ag = ag;
	}
	
	//2013 1ra fecha
	public ArbolGeneral<T> creciente() {
		ColaGenerica <ArbolGeneral<T>> cola = new ColaGenerica<ArbolGeneral<T>>();
		ArbolGeneral <T> aux;
		ArbolGeneral <T> maxNodo = null;
		cola.encolar(this.ag);
		cola.encolar(null);
		
		int nivel = 0;
		int nodosNivel = 0;
		boolean ok = true;
		int maxHijos = -1;
		
		while(!cola.esVacia() && ok) {
			aux = cola.desencolar();			
			if(aux != null) {
				nodosNivel++;
				ListaGenerica<ArbolGeneral<T>> lHijos = aux.getHijos();
				lHijos.comenzar();
                while (!lHijos.fin()) {
                  cola.encolar(lHijos.proximo());
                }              
                if (aux.getHijos().tamanio() > maxHijos) {
                	maxHijos = aux.getHijos().tamanio();
                	maxNodo = aux;
                }
				
			} else {
				if (nodosNivel != nivel + 1) {
					ok = false;
				}
				nodosNivel = 0;
				if (!cola.esVacia()) {
					nivel++;
					cola.encolar(null);
				}
			}
		}
		return ok ? maxNodo : null;	

	}
}
