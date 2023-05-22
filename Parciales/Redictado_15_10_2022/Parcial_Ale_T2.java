package tema2P2022;

import caminoMasLargo.*;

public class Parcial2022Tema2 {			
	public ListaGenerica<Integer> resolver(Arbol<Integer> ab, int min)
		{
			if(!ab.esVacio())
			{
				ListaGenerica<Integer> res= new ListaEnlazadaGenerica<Integer>();
				resolver(ab,res,min,0);
				return res;
			}
			else
				return null;
		}
		private boolean esPar(int num)
		{
			return num % 2==0;
		}
		private boolean resolver(Arbol<Integer> ab,ListaGenerica<Integer> l, int min, int cont)
		{
			boolean aux=false;
			l.agregarFinal(ab.getDato());
			if(ab.esHoja())
			{
				if(cont>=min)
					return true;
				else {
					if(esPar(l.elemento(l.tamanio())))
						cont--;
					l.eliminarEn(l.tamanio());
			}
			}
			else
			{
				if(esPar(ab.getDato()))
				{
					cont++;
				}
				if((ab.tieneHijoIzquierdo())&&(!aux))
					aux= resolver(ab.GetHijoIzquierdo(),l,min,cont);
				if((ab.tieneHijoDerecho())&&(!aux))
					aux= resolver(ab.GetHijoDerecho(),l,min,cont);
				if(!aux) {
					if(esPar(l.elemento(l.tamanio())))
						cont--;
					l.eliminarEn(l.tamanio());
					}
			}	
			return aux;
			
		}
		private void resolver(Arbol<Integer> ab,ListaGenerica<Integer> l,ListaGenerica<Integer> res, int max)
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
					l.eliminarEn(l.tamanio());
			}
			
		}
	}
