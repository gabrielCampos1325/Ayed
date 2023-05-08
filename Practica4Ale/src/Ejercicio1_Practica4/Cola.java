package Ejercicio1_Practica4;

public class Cola<T>{
	private ListaGenerica<T> l;
	
	public Cola() {
		l= new ListaEnlazadaGenerica<T>();
	}
	public void encolar(T elem)
	{
		l.agregarFinal(elem);
	}
	public T tope()
	{
		return l.elemento(1);
	}
	public T desencolar ( )
	{
		 T aux= this.tope();
		 l.eliminarEn(1);
		 return aux;
	}
	public boolean esVacia()
	{
		 
		return(l.tamanio()==0);
	}
}
