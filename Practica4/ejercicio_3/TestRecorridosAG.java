package ejercicio_3;
import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.*;

public class TestRecorridosAG {

	public static void main(String[] args) {
		
		ArbolGeneral<Integer> raiz = new ArbolGeneral<Integer>(14);
		ArbolGeneral<Integer> h = new ArbolGeneral<Integer>(9);
		
		h.agregarHijo(new ArbolGeneral<Integer>(11));
		raiz.agregarHijo(new ArbolGeneral<Integer>(7));
		raiz.agregarHijo(h);
		
		/* 		 				 
		        14
		     /      \
		   	7        9		
					  \ 
					  11
		  
		*/
		
		System.out.println(raiz.altura());
		ListaGenerica<Integer> l;
		
		l = new RecorridosAG().numerosImparesMayoresQuePreOrden(raiz, 1);
		System.out.println("PreOrden");
		while (!l.fin()) {
			System.out.println(l.proximo());
		}		
		
		l = new RecorridosAG().numerosImparesMayoresQueInOrden(raiz, 1);
		System.out.println("InOrden");
		while (!l.fin()) {
			System.out.println(l.proximo());
		}
		
		l = new RecorridosAG().numerosImparesMayoresQuePostOrden(raiz, 1);
		System.out.println("PostOrden");
		while (!l.fin()) {
			System.out.println(l.proximo());
		}
	}

}
