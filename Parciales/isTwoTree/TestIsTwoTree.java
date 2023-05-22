package isTwoTree;
import tp03.ejercicio1.*;

public class TestIsTwoTree {

	public static void main(String[] args) {		
		
		ArbolBinario<Integer> aMenos3 = new ArbolBinario<Integer>(-3);
		
		ArbolBinario<Integer> a55 = new ArbolBinario<Integer>(55);
		a55.agregarHijoIzquierdo(new ArbolBinario<Integer>(9));
		a55.agregarHijoDerecho(new ArbolBinario<Integer>(16));
		
		ArbolBinario<Integer> a18 = new ArbolBinario<Integer>(18);
		a18.agregarHijoIzquierdo(new ArbolBinario<Integer>(8));
		a18.agregarHijoDerecho(new ArbolBinario<Integer>(24));
		
		ArbolBinario<Integer> a23 = new ArbolBinario<Integer>(23);
		a23.agregarHijoIzquierdo(aMenos3);
		
		ArbolBinario<Integer> a6 = new ArbolBinario<Integer>(6);
		a6.agregarHijoIzquierdo(a55);
		
		ArbolBinario<Integer> a19 = new ArbolBinario<Integer>(19);
		
		ArbolBinario<Integer> a4 = new ArbolBinario<Integer>(4);
		a4.agregarHijoDerecho(a18);
		
		ArbolBinario<Integer> a7 = new ArbolBinario<Integer>(7);
		a7.agregarHijoIzquierdo(a23);
		a7.agregarHijoDerecho(a6);
		
		ArbolBinario<Integer> aMenos5 = new ArbolBinario<Integer>(-5);
		aMenos5.agregarHijoIzquierdo(a19);
		aMenos5.agregarHijoDerecho(a4);
		
		ArbolBinario<Integer> raiz = new ArbolBinario<Integer>(2);
		raiz.agregarHijoIzquierdo(a7);
		raiz.agregarHijoDerecho(aMenos5);
		
		Parcial_6_5_2023_Correccion p = new Parcial_6_5_2023_Correccion(aMenos3);	
		System.out.println(p.isTwoTree(-3));		 
			 
	}

}
