package ArbolCreciente;
import tp04.ejercicio1.*;

public class TestArbolCreciente {

	public static void main(String[] args) {
		
		ArbolGeneral<Integer> A= new ArbolGeneral<Integer>(5);//raiz 5
        ArbolGeneral<Integer> Der= new ArbolGeneral<Integer>(4);//
        ArbolGeneral<Integer> Iz= new ArbolGeneral<Integer>(3);
        A.agregarHijo(Der);
        Iz.agregarHijo(new ArbolGeneral<Integer>(2));
        Iz.agregarHijo(new ArbolGeneral<Integer>(2));
        Iz.agregarHijo(new ArbolGeneral<Integer>(2));
        A.agregarHijo(Iz);
        
        
        ArbolGeneral<Integer> a = new ArbolCreciente<Integer>(A).creciente();
        
        if (a == null) {
        	System.out.println("El arbol no es creciente");
        } else {
        	System.out.println(a.getDato());
        }
        
	}

}
