package ejercicio_3;
import tp02.ejercicio3.*;

public class TestPilaGenerica {

	public static void main(String[] args) {
		PilaGenerica<String> pila = new PilaGenerica<String>();
		
		pila.apilar("Tina Turner");
		pila.apilar("Madonna");
		pila.apilar("Elton John");
		
		while (! pila.esVacia()) {
			System.out.println(pila.desapilar());
		}

	}

}
