package ejercicio_3;
import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.*;

public class TestRecorridosAG {

	public static void main(String[] args) {
		
		ArbolGeneral<Integer> raiz = new ArbolGeneral<Integer>(14);
		
		raiz.agregarHijo(new ArbolGeneral<Integer>(9));
		raiz.agregarHijo(new ArbolGeneral<Integer>(7));

		
		/* 		 				 
		        14
		     /      \
		   	9        4		
		 
		*/
				
		
		ListaGenerica<Integer> l = new RecorridosAG().numerosImparesMayoresQuePreOrden(raiz, 1);
		
		while (!l.fin()) {
			System.out.println(l.proximo());
		}
	}

}
