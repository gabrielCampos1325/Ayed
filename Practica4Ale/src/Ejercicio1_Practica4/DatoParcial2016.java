package Ejercicio1_Practica4;

public class DatoParcial2016 {
	private int numH;
	private char letra;
	public int getNumH() {
		return numH;
	}
	public void setNumH(int numH) {
		this.numH = numH;
	}
	public char getLetra() {
		return letra;
	}
	public void setLetra(char letra) {
		this.letra = letra;
	}
	public DatoParcial2016(int numH, char letra) {
		this.numH = numH;
		this.letra = letra;
	}
	
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		if (o == this) {
			return true;
		}
		if (o instanceof DatoParcial2016) {
			DatoParcial2016 otro = (DatoParcial2016) o;
			return otro.letra == this.letra && otro.numH == this.numH;
		}
		return false;
	}
}
