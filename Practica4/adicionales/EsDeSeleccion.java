package adicionales;

import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class EsDeSeleccion {
	
	public Boolean esDeSeleccion (ArbolGeneral<Integer> ag) {		
		boolean es = true;
		
		if (!ag.esHoja() && ag.getDato().equals(hijoMin(ag.getHijos()))) {
			
			ListaGenerica<ArbolGeneral<Integer>> hijos = ag.getHijos();
			hijos.comenzar();
			while (!hijos.fin() && es) {
				es = esDeSeleccion(hijos.proximo());
			}			
		}
		
		return es;
	}
	
	private Integer hijoMin (ListaGenerica<ArbolGeneral<Integer>> hijos) {
		int min = Integer.MAX_VALUE;
		
		hijos.comenzar();
		while (!hijos.fin()) {
			min = Math.min(min, hijos.proximo().getDato());
		}
		
		return min;
	}
	
}
