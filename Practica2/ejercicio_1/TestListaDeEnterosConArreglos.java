package ejercicio_1;
import tp02.ejercicio1.*;

/*
1.2. Escriba una clase llamada TestListaDeEnterosConArreglos que reciba en su método main
una secuencia de números, los agregue a un objeto de tipo ListaDeEnterosConArreglos y luego
imprima los elementos de dicha lista.
 */

public class TestListaDeEnterosConArreglos {
	
	public static void main(String[] args) {
		
		ListaDeEnteros l = new ListaDeEnterosConArreglos();
		
		for (String st : args) {
			l.agregarFinal(Integer.valueOf(st));			
		}
		
		for (int i = 0; i < l.tamanio(); i++) {
			System.out.println(l.proximo());
		}
		
	}
}
