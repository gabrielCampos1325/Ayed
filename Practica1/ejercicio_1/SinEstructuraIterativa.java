package ejercicio_1;

public class SinEstructuraIterativa {
	
	public static void imprimirEntreNumeros(int a, int b) {
		if (a <= b) {
			System.out.println(a);
			a++;
			imprimirEntreNumeros(a, b);
		}
	}
}
