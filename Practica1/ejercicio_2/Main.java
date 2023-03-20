package ejercicio_2;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);		
		int cantidad = 0;
		
		while (cantidad != 42) {
			System.out.print("Ingrese un valor entero para N: ");
			int s = scanner.nextInt();
			cantidad++;
			int[] a = Main.getMultiplosN(s);
			for (int i = 0; i < a.length; i++) {
				System.out.println(a[i]);
			}
		}
	}
	
	public static int[] getMultiplosN(int n) {
		int[] array = new int[n];
		for (int i = 0; i < array.length; i++) {
			array[i] = n*(i + 1);
		}
		return array;
	}

}
