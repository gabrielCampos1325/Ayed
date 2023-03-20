package ejercicio_5;
import java.util.Random;

public class Main {
	static int max = -1;
	static int min = 9999;
	static int sumatoria = 0;
	static int[] vectorInt = new int[30];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		
		Random random = new Random();
		
		for (int i = 0; i < vectorInt.length; i++) {
			vectorInt[i] = random.nextInt(999) + 1;
		}
		
		// A
		System.out.println(mecanismoReturn(vectorInt));	
		
		// B
		Datos d =  new Datos(vectorInt);		
		mecanismoParametro(d);
		System.out.println(d.getMax());
		System.out.println(d.getMin());
		System.out.println(d.getPromedio());
		
		// C		
		mecanismoSinParamOReturn();
		
	}
	
	public static String mecanismoReturn(int[] v) {
		int max = -1;
		int min = 9999;
		int sumatoria = 0;
		for (int i : v) {
			if (i > max) {
				max = i;
			}
			if (i < min) {
				min = i;
			}
			sumatoria = sumatoria + i;
		}
		return "El maximo es: " + max +
				", el minimo es: " + min +
				" y el promedio es: " + (double)(sumatoria / v.length);		
	}
	
	public static void mecanismoParametro(Datos d) {	
		int sumatoria = 0;
		
		for (int i : d.getVector()) {
			if (i > d.getMax()) {
				d.setMax(i);
			}
			if (i < d.getMin()) {
				d.setMin(i);
			}
			sumatoria = sumatoria + i;
		}
		d.setPromedio(sumatoria / d.getVector().length);
	}
	
	public static void mecanismoSinParamOReturn() {
		for (int i : vectorInt) {
			if (i > max) {
				max = i;
			}
			if (i < min) {
				min = i;
			}
			sumatoria = sumatoria + i;
		}
		System.out.println(max);
		System.out.println(min);
		System.out.println((double)(sumatoria / vectorInt.length));
	}
	
}
