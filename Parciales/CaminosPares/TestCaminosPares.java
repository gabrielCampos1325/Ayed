package CaminosPares;

import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.*;
public class TestCaminosPares {

	public static void main(String[] args) {
		
		ArbolGeneral<Character> A= new ArbolGeneral<Character>('A');//raiz 5
	    ArbolGeneral<Character> Der= new ArbolGeneral<Character>('D');//
	    ArbolGeneral<Character> Iz= new ArbolGeneral<Character>('B');
	    ArbolGeneral<Character> Med= new ArbolGeneral<Character>('C');
	    ArbolGeneral<Character> Iz2= new ArbolGeneral<Character>('F');
	    ArbolGeneral<Character> Der2= new ArbolGeneral<Character>('H');
	    ArbolGeneral<Character> Med2= new ArbolGeneral<Character>('G');
	    Iz2.agregarHijo(new ArbolGeneral<Character>('I'));
	    Iz.agregarHijo(Iz2);
	    Der.agregarHijo(Der2);
	    Med.agregarHijo(Med2);
	    A.agregarHijo(Iz);
	    A.agregarHijo(Med);
	    A.agregarHijo(Der);
	    A.agregarHijo(new ArbolGeneral<Character>('E'));
	    /*
	          a
	      /  /  \  \
	     b  c   d  e
	     /   \    \
	    f    g    h
	     /
	    I
	     */
	    
	    CaminosPares parcial = new CaminosPares();
	    
	    ListaGenerica<ListaGenerica<Character>> listaResultado = parcial.caminosPares(A);

	}

}
