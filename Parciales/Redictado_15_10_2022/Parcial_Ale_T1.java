package Redictado_15_10_2022;

import caminoMasLargo.*;
import tp02.ejercicio2.ListaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class Parcial_Ale_T1 {
	
	
	
	
	
	public ListaGenerica<Integer> resolver(ArbolBinario<Integer> ab, int max)
	{
		if(!ab.esVacio())
		{
			//ListaGenerica<Integer> l= new ListaEnlazadaGenerica<Integer>();
			ListaGenerica<Integer> res= new ListaEnlazadaGenerica<Integer>();
			resolver(ab,res,max);
			return res;
		}
		else
			return null;
	}
	private int resolver(ArbolBinario<Integer> ab,ListaGenerica<Integer> l, int max)
	{
		l.agregarFinal(ab.getDato());
		if(ab.esHoja())
		{
			if(ab.getDato()<= max)
				return -1;
			else
				l.eliminarEn(l.tamanio());
		}
		else
		{
			if((ab.tieneHijoIzquierdo())&&(max!=-1))
				max= resolver(ab.GetHijoIzquierdo(),l,max);
			if(max!= -1)
			{if((ab.tieneHijoDerecho()))
				max= resolver(ab.GetHijoDerecho(),l,max);
			if(max!= -1)
				l.eliminarEn(l.tamanio());
			}
		}	
		return max;
		
	}
	private void resolver(ArbolBinario<Integer> ab,ListaGenerica<Integer> l,ListaGenerica<Integer> res, int max)
	{
		l.agregarFinal(ab.getDato());
		if(ab.esHoja())
		{
			if(ab.getDato()<= max) {
				l.comenzar();
				while(!l.fin())
					res.agregarFinal(l.proximo());
			}
			else
				l.eliminarEn(l.tamanio());
		}
		else
		{
			if((ab.tieneHijoIzquierdo())&&(res.esVacia()))
				resolver(ab.GetHijoIzquierdo(),l,res,max);
			if((ab.tieneHijoDerecho())&&(res.esVacia()))
				resolver(ab.GetHijoDerecho(),l,res,max);
			
		}
		l.eliminarEn(l.tamanio());
		
	}
}
