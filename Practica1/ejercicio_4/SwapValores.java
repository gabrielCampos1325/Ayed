package ejercicio_4;

public class SwapValores {
	public static void swap1 (int x, int y) {
		if (x < y) {
			int tmp = x ;
			x = y ;
			y = tmp;
		}
	}
	
	public static void swap2 (Integer x, Integer y) {
		if (x < y) {
			int tmp = x ;
			x = y ;
			y = tmp;
		}
	}
	
	public static void main(String[] args) {
		int a = 1, b = 2;
		Integer c = 3, d = 4;
		swap1(a,b);
		swap2(c,d);
		
		// El pasaje de parametros es por copia por lo que los cambios realizados 
		// en el metodo no se veran reflejados en la impresion	
		System.out.println("a=" + a + " b=" + b) ;
		
		// Las clases wrapper son referencias inmutables por lo que al cambiar el valor 
		// de las mismas llevara a la creacion de otro objeto con ese nuevo valor.
		// Cuando termina la ejecucion del metodo esas nuevas referencias se pierden	
		System.out.println("c=" + c + " d=" + d) ;
	}
}

