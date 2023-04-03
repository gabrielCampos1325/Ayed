package ejercicio_3;
import tp02.ejercicio3.*;

public class TestColaGenerica {

	public static void main(String[] args) {

		ColaGenerica<Integer> cola = new ColaGenerica<Integer>();
		
		cola.encolar(1);
		cola.encolar(2);
		cola.encolar(3);			
		
		while(! cola.esVacia()) {
			System.out.println(cola.desencolar());
		}
	}
	

}
