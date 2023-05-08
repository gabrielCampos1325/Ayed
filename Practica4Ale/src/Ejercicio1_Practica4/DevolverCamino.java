package Ejercicio1_Practica4;

public class DevolverCamino {
	
	
	private void camino (ListaGenerica<DatoParcial2016> l, ArbolGeneral<DatoParcial2016> a)
	{
		l.agregarFinal(a.getDato());
		if(a.getHijos().tamanio()>= a.getDato().getNumH())//agregar comprobacion de arbol null, cuando hago el metodo cascaron retorno vacio 
			this.camino(l, a.getHijos().elemento(a.getDato().getNumH()));
	}
	public ListaGenerica<DatoParcial2016> devolverCamino(ArbolGeneral<DatoParcial2016> a)
	{
		ListaGenerica<DatoParcial2016> l= new ListaEnlazadaGenerica<DatoParcial2016>();
		this.camino(l,a);
		return l;
	}
	
	
	
}
