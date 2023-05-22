package J95;

import tp03.ejercicio1.ArbolBinario;

public class J95 {
	
	public boolean equiponderado(ArbolBinario<Integer> ab) {
		boolean aux = true;
		if (!ab.esVacio())
			if (calcular(ab) == Integer.MIN_VALUE) {
				aux = false;
			}
		return aux;
	}
	
	public int calcular(ArbolBinario<Integer> ab) {
		if (ab == null)
			return 0;
		
		int valorMin = Integer.MIN_VALUE;
		
		int pesoSubIzq = calcular(ab.getHijoIzquierdo());
		if (pesoSubIzq == valorMin)
			return valorMin;
		
		int pesoSubDer = calcular(ab.getHijoDerecho());
		if (pesoSubDer == valorMin)
			return valorMin;
		
		if (pesoSubIzq == pesoSubDer)
			return pesoSubIzq + pesoSubDer + ab.getDato();
		else
			return valorMin;
	}
	
}
