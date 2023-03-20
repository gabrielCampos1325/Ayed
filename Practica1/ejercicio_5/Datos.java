package ejercicio_5;

public class Datos {
	private int[] vector;
	private int max;
	private int min;
	private double promedio;
		
	
	public Datos(int[] vector) {		
		this.vector = vector;
		this.max = -1;
		this.min = 9999;
	}
	
	public int[] getVector() {
		return vector;
	}
	public void setVector(int[] vector) {
		this.vector = vector;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public double getPromedio() {
		return promedio;
	}
	public void setPromedio(double promedio) {
		this.promedio = promedio;
	}	
}
