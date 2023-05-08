package Ejercicio1_Practica4;

public class testArbolGeneral {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArbolGeneral<Integer> A= new ArbolGeneral<Integer>(5);//raiz 5
		ArbolGeneral<Integer> Der= new ArbolGeneral<Integer>(4);//  
		ArbolGeneral<Integer> Iz= new ArbolGeneral<Integer>(3);
		ArbolGeneral<Integer> Med= new ArbolGeneral<Integer>(21);
		ArbolGeneral<Integer> Iz2= new ArbolGeneral<Integer>(9);
		ArbolGeneral<Integer> Der2= new ArbolGeneral<Integer>(7);
		ArbolGeneral<Integer> Med2= new ArbolGeneral<Integer>(6);
		Iz2.agregarHijo(new ArbolGeneral<Integer>(99));
		Iz.agregarHijo(Iz2);
		Der.agregarHijo(Der2);
		Med.agregarHijo(Med2);
		A.agregarHijo(Iz);
		A.agregarHijo(Med);
		A.agregarHijo(Der);	
		A.agregarHijo(new ArbolGeneral<Integer>(13));
		/*
		   	 5
		  /  /  \ \
		 3  21   4 13
		 /   \    \
		 9   6     7
	     /
		99
		 */
		System.out.println(A.altura());
		System.out.println(A.nivel(2));
		RecorridosAG L= new RecorridosAG();
		ListaGenerica<Integer> Lista= L.numerosImparesMayoresQuePreOrden(A, 3);
		Lista.comenzar();
		System.out.println("PreOrden");
		while(!Lista.fin())
		{
			System.out.println(Lista.proximo());
		}
		
		System.out.println("InOrden");
		Lista = L.numerosImparesMayoresQueInOrden(A, 3);
		while(!Lista.fin())
		{
			System.out.println(Lista.proximo());
		}
		System.out.println("PostOrden");
		Lista = L.numerosImparesMayoresQuePostOrden(A, 3);
		while(!Lista.fin())
		{
			System.out.println(Lista.proximo());
		}
		System.out.println("PorNivel");
		Lista = L.numerosImparesMayoresQuePorNiveles(A, 3);
		while(!Lista.fin())
		{
			System.out.println(Lista.proximo());
		}
		System.out.println("Ancho del Arbol: " + A.ancho());
		
		
		System.out.println(A.esAncestro(9, 999));
		
		
		
		
		}
		

}