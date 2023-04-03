package ejercicio_1;
import tp02.ejercicio1.*;

/*
 1.3. Escriba una clase llamada TestListaDeEnterosEnlazada que reciba en su método main una
secuencia de números, los agregue a un objeto de tipo ListaDeEnterosEnlazada y luego imprima los
elementos de dicha lista.
 */

public class TestListaDeEnterosEnlazada {

	public static void main(String[] args) {
		
		ListaDeEnteros l = new ListaDeEnterosEnlazada();
		
		for (String st : args) {
			l.agregarFinal(Integer.valueOf(st));			
		}
		
		for (int i = 0; i < l.tamanio(); i++) {
			System.out.println(l.proximo());
		}
		
	}

}
