package Recuperatorio_1sem_2023;

import Parcial_Agus_8.Solucion;
import tp04.ejercicio1.ArbolGeneral;

public class TestParcial {
	
	public static void main(String[] args) {
		ArbolGeneral<Integer> g = new ArbolGeneral<Integer> (2);
		
		ArbolGeneral<Integer> e = new ArbolGeneral<Integer> (5);
		ArbolGeneral<Integer> f = new ArbolGeneral<Integer> (1);
		ArbolGeneral<Integer> j = new ArbolGeneral<Integer> (2);
		
		ArbolGeneral<Integer> a = new ArbolGeneral<Integer> (7);
		ArbolGeneral<Integer> b = new ArbolGeneral<Integer> (9);
		ArbolGeneral<Integer> c = new ArbolGeneral<Integer> (3);
		
		ArbolGeneral<Integer> d = new ArbolGeneral<Integer> (10);
		
		ArbolGeneral<Integer> h = new ArbolGeneral<Integer> (6);
		ArbolGeneral<Integer> i = new ArbolGeneral<Integer> (10);
		
		g.agregarHijo(e);
		g.agregarHijo(f);
		g.agregarHijo(j);
		
		e.agregarHijo(a);
		e.agregarHijo(b);
		e.agregarHijo(c);
		
		f.agregarHijo(d);
		
		j.agregarHijo(h);
		j.agregarHijo(i);
		
		Parcial test = new Parcial(g);
		
		System.out.println(test.recorrer(2));
	}
	
}
