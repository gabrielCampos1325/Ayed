package ejercicio_5;
import tp04.ejercicio1.*;
import tp02.ejercicio2.*;
import tp02.ejercicio3.*;

public class AnalizadorArbol {
	
	public int devolverMaximoPromedio (ArbolGeneral<AreaEmpresa> arbol) {
		int maxProm = 0;
		if (arbol != null & !arbol.esVacio()) {
			ColaGenerica <ArbolGeneral<AreaEmpresa>> cola = new ColaGenerica<ArbolGeneral<AreaEmpresa>>();
			ArbolGeneral<AreaEmpresa> aux;
			
			cola.encolar(arbol);
			cola.encolar(null);
			
			int totalNivel = 0;
			int promNivel;
			int cant = 0;
			while (!cola.esVacia()) {
				aux = cola.desencolar();
				if (aux != null) {
					totalNivel = totalNivel + aux.getDato().getTardanza();
					cant++;
					
					if (aux.tieneHijos()) {
						ListaGenerica<ArbolGeneral<AreaEmpresa>> lhijos = aux.getHijos();
						lhijos.comenzar();
						while (!lhijos.fin())
							cola.encolar(lhijos.proximo());
					}
					
				} else {
					promNivel = totalNivel / cant;
					maxProm = Math.max(maxProm, totalNivel);
					totalNivel = 0;
					cant = 0;
					
					if (!cola.esVacia()) {
						cola.encolar(null);
					}									
				}
			}
		} else {
			maxProm = Integer.MAX_VALUE;
		}
		return maxProm;		
	}
}
