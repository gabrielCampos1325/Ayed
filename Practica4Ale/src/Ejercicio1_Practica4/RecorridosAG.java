package Ejercicio1_Practica4;

public class RecorridosAG {

	
	private ListaGenerica<Integer> ImparesPreorden(ListaGenerica<Integer> l,ArbolGeneral <Integer> a, Integer n)
	{
		if((a.getDato() > n) && (a.getDato()%2 == 1))
			l.agregarFinal(a.getDato());
	    a.getHijos().comenzar();
	    while(!a.getHijos().fin())
	    	this.ImparesPreorden(l,a.getHijos().proximo(), n);
	    return l;
	}
	public ListaGenerica<Integer> numerosImparesMayoresQuePreOrden (ArbolGeneral <Integer> a, Integer n)
	{	
		
	    ListaEnlazadaGenerica<Integer> Lista = new ListaEnlazadaGenerica<Integer>();
	    this.ImparesPreorden(Lista,a,n);
	    return Lista;
	}
	private ListaGenerica< Integer > ImparesInOrden (ListaGenerica<Integer> l ,ArbolGeneral <Integer> a, Integer n)
	{
		if(a!= null)
		{
			a.getHijos().comenzar();
			if(!a.getHijos().fin())
				this.ImparesInOrden(l, a.getHijos().proximo(), n);
			if((a.getDato() > n) && (a.getDato()%2 == 1))
		    	l.agregarFinal(a.getDato());
			while(!a.getHijos().fin())
				this.ImparesInOrden(l, a.getHijos().proximo(), n);
		}
		return l;
	}
	
	
	public ListaGenerica< Integer > numerosImparesMayoresQueInOrden (ArbolGeneral <Integer> a, Integer n)
	{
		ListaGenerica<Integer> L= new ListaEnlazadaGenerica<Integer>();
		if(!a.esVacio())
			this.ImparesInOrden(L,a,n);
		return L;
	}	
	private ListaGenerica< Integer > ImparesPostOrden  (ListaGenerica<Integer> l ,ArbolGeneral <Integer> a, Integer n)
	{
    	a.getHijos().comenzar();
    	while(!a.getHijos().fin())
    		this.ImparesPostOrden(l,a.getHijos().proximo(), n);
    	if((a.getDato() > n) && (a.getDato()%2 == 1))
        	l.agregarFinal(a.getDato());
    	return l;
	}
	public ListaGenerica< Integer > numerosImparesMayoresQuePostOrden (ArbolGeneral <Integer> a, Integer n)
	{
		ListaGenerica<Integer> L= new ListaEnlazadaGenerica<Integer>();
		this.ImparesPostOrden(L,a,n);
		return L;
	}
	private ListaGenerica< Integer > ImparesPorNivel (ListaGenerica<Integer> l ,ArbolGeneral <Integer> a, Integer n)
	{
		Cola<ArbolGeneral<Integer>> C= new Cola<ArbolGeneral<Integer>>();
		ArbolGeneral<Integer> Aux;
		C.encolar(a);
		while(!C.esVacia())
		{
			Aux=C.desencolar();
			if((Aux.getDato() > n) && (Aux.getDato()%2 == 1))
	        	l.agregarFinal(Aux.getDato());
			Aux.getHijos().comenzar();
			while(!Aux.getHijos().fin())
				C.encolar(Aux.getHijos().proximo());
		}
		return l;
	}
	public ListaGenerica< Integer > numerosImparesMayoresQuePorNiveles(ArbolGeneral <Integer> a, Integer n)
	{
		ListaGenerica<Integer> L = new ListaEnlazadaGenerica<Integer>();
		this.ImparesPorNivel(L, a, n);
		return L;
	}
	
	
}
