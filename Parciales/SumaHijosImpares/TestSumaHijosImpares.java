package SumaHijosImpares;
import tp04.ejercicio1.*;
import tp02.ejercicio2.*;

public class TestSumaHijosImpares {

	public static void main(String[] args) {		
		
		ArbolGeneral<Integer> nodo4 = new ArbolGeneral<Integer>(4);
		nodo4.agregarHijo(new ArbolGeneral<Integer>(9));
		nodo4.agregarHijo(new ArbolGeneral<Integer>(10));
		nodo4.agregarHijo(new ArbolGeneral<Integer>(5));
		
		ArbolGeneral<Integer> nodo1 = new ArbolGeneral<Integer>(1);
		nodo1.agregarHijo(new ArbolGeneral<Integer>(5));
		nodo1.agregarHijo(nodo4);
		
		ArbolGeneral<Integer> nodo8 = new ArbolGeneral<Integer>(8);
		nodo8.agregarHijo(new ArbolGeneral<Integer>(3));
		
		ArbolGeneral<Integer> nodo7 = new ArbolGeneral<Integer>(7);
		nodo7.agregarHijo(new ArbolGeneral<Integer>(13));
		
		ArbolGeneral<Integer> nodo12 = new ArbolGeneral<Integer>(12);
		nodo12.agregarHijo(nodo8);
		nodo12.agregarHijo(new ArbolGeneral<Integer>(4));
		nodo12.agregarHijo(nodo7);
		
		ArbolGeneral<Integer> nodo2 = new ArbolGeneral<Integer>(2);
		nodo2.agregarHijo(nodo1);
		nodo2.agregarHijo(nodo12);
		nodo2.agregarHijo(new ArbolGeneral<Integer>(14));
		
		
		SumaHijosImpares parcial = new SumaHijosImpares(nodo2);
		ListaGenerica<Integer> l = parcial.resolver();
		
		l.comenzar();
		while (!l.fin()){
			System.out.println(l.proximo());
		}
	}

}
