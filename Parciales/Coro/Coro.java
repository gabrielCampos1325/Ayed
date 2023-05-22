/*package Coro;

import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class Coro {
	
	public String calcular(ArbolGeneral<Corista> ag, String s1, String s2) {
		String tenor = null;
		if (!ag.esVacio()) {
			calcular(ag, s1, s2, tenor);			
		}
		return tenor;		
	}
	
	private ArbolGeneral<Corista> calcular(ArbolGeneral<Corista> ag, String s1, String s2, String tenor) {
		
		
		if (ag.tieneHijos()) {
			ListaGenerica<ArbolGeneral<Corista>> hijos = ag.getHijos();
			hijos.comenzar();
			while (!hijos.fin() && tenor == null) {
				ArbolGeneral<Corista> c = calcular(hijos.proximo(), s1, s2, tenor);	
				
				if (c.getDato().getNombre().equals(s1)) {
					encontreS1 = true;
				}
				if (c.getDato().getNombre().equals(s2)) {
					encontreS2 = true;
				}
							
			}
		}		
		
		
	}
	
}
*/