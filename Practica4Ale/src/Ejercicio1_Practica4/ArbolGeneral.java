package Ejercicio1_Practica4;

public class ArbolGeneral<T> {

	private T dato;

	private ListaGenerica<ArbolGeneral<T>> hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();

	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public void setHijos(ListaGenerica<ArbolGeneral<T>> hijos) {
		if (hijos==null)
			this.hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		else
			this.hijos = hijos;
	}

	public ArbolGeneral(T dato) {
		this.dato = dato;
	}

	public ArbolGeneral(T dato, ListaGenerica<ArbolGeneral<T>> hijos) {
		this(dato);
		if (hijos==null)
			this.hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		else
			this.hijos = hijos;
	}

	public ListaGenerica<ArbolGeneral<T>> getHijos() {
		return this.hijos;
	}

	public void agregarHijo(ArbolGeneral<T> unHijo) {

		this.getHijos().agregarFinal(unHijo);
	}

	public boolean esHoja() {

		return !this.tieneHijos();
	}
	
	public boolean tieneHijos() {
		return !this.hijos.esVacia();
	}
	
	public boolean esVacio() {

		return this.dato == null && !this.tieneHijos();
	}

	

	public void eliminarHijo(ArbolGeneral<T> hijo) {
		if (this.tieneHijos()) {
			ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
			if (hijos.incluye(hijo)) 
				hijos.eliminar(hijo);
		}
	}
	
	
	
	public Integer altura() 
	{
			Cola <ArbolGeneral<T>> C = new Cola <ArbolGeneral<T>>();// creo una cola
		    ArbolGeneral<T> Aux;// variable auxiliar para los datos a desencolar
		int cont= 0;// el resultado a retornar va a ser el nivel del árbol que equivale a la altura del árbol
		C.encolar(this);// encolo la raíz
		C.encolar(null);// encolo null como marca de fin de nivel
		while(!C.esVacia())
		{
			Aux= C.desencolar();
			if(Aux != null)// si no llegue a fin de nivel
			{
				ListaGenerica<ArbolGeneral<T>> L= Aux.getHijos();//
				L.comenzar();// me posiciono al principio de la lista de hijos del nodo
				while(!L.fin())// encolo todos sus hijos
				  C.encolar(L.proximo());
			}
			else if(!C.esVacia())	// si llegue a fin de nivel 
			{
				cont++;// aumento el valor del nivel
				C.encolar(null);// pongo en la cola una marca de fin de nivel
			}
			}
			return cont;
	}

	public Integer nivel(T dato) 
		{
			if(this.getDato() == dato)
			{
				return 0;
			}
			else
			{
				Cola <ArbolGeneral<T>> C = new Cola <ArbolGeneral<T>>();// creo una cola
				ArbolGeneral<T> Aux;// variable auxiliar para los datos a desencolar
				Integer cont=0;
				cont= 0;// el resultado a retornar va a ser el nivel del árbol que equivale a la altura del árbol
				boolean cond= false;
				C.encolar(this);// encolo la raíz
				C.encolar(null);// encolo null como marca de fin de nivel
				while((!C.esVacia()) && (!cond))
				{
					Aux= C.desencolar();
					if(Aux != null)// si no llegue a fin de nivel
					{
						if(Aux.getDato()== dato)
							cond=true;
						else
						{
						ListaGenerica<ArbolGeneral<T>> L= Aux.getHijos();//
						L.comenzar();// me posiciono al principio de la lista de hijos del nodo
						while(!L.fin())// encolo todos sus hijos
							C.encolar(L.proximo());
						}
					}
					else if((!C.esVacia()) && (!cond))	// si llegue a fin de nivel 
					{
						cont++;// aumento el valor del nivel
						C.encolar(null);// pongo en la cola una marca de fin de nivel
					}
				}
				return cond?cont:-1;
			}
	}
	public Integer ancho() {// se podría haber usado la funcion tamaño de la lista generica? 
	if(this.esVacio())
		return 0;
	else
	{
		Integer cont=0;// se inicializa el contador de nodos en uno
		Integer Max=0;// se inicializa el maximo en 1, ya que si el arbol no es vacio, tiene como minimo 1 de ancho.
		Cola<ArbolGeneral<T>> C= new Cola<ArbolGeneral<T>>();  // cola en la que se guardan los elementos del arbol
		ArbolGeneral<T> Aux;
		C.encolar(this);// se encola la raíz
		C.encolar(null);// se encola el fin del nivel 0
		while(!C.esVacia())// si la cola no es vacia
		{	
			Aux= C.desencolar();
			if(Aux!= null)// si no es fin de nivel
			{
				cont++;//se van sumando la cantidad de hijos por nivel 
				ListaGenerica<ArbolGeneral<T>> l= Aux.getHijos();//guardo la lista de subarboles
				l.comenzar();// me posiciono al principio de la lista
				while(!l.fin())// mientras no se terminen los hijos
					C.encolar(l.proximo());	// se encolan los elementos
			}
			else
			{
				if(! C.esVacia())
				C.encolar(null);// se encola el fin de nivel
				Max= Math.max(cont,Max);// se calcula el maximo entre el contador de nodos por nivel y el anterior maximo
	        	cont=0;	// se reinicia el contador
			}
		}
		return Max;
	}
	}
	public Boolean esAncestro(T a, T b)
	{
		Boolean Aux=false;// Aux controla si se confirmó que b es ancestro de A
		Boolean EncontreA=false;//Encontrea controla si se el elemento a esta en el árbol
		Cola <ArbolGeneral<T>> C= new Cola<ArbolGeneral<T>>();
		ArbolGeneral<T> Arb;
		C.encolar(this);
		while(!C.esVacia() && (!Aux))
		{
			Arb = C.desencolar();
			if(Arb!=null)
			{
				ListaGenerica<ArbolGeneral<T>> H= Arb.getHijos();
				H.comenzar();
				if(Arb.getDato() == a)
				{
					Aux=true;
					Cola <ArbolGeneral<T>> C2= new Cola<ArbolGeneral<T>>();
					ArbolGeneral<T> Arb2;
					C2.encolar(Arb);
					while(!C2.esVacia() && (!EncontreA))
					{
						Arb2= C2.desencolar();
						if(Arb2.getDato() == b)
							EncontreA=true;
						else
						{
							ListaGenerica<ArbolGeneral<T>> H2= Arb2.getHijos();
							H2.comenzar();
							while(!H2.fin())
								C2.encolar(H2.proximo());
						}		
					}
				}
				else
				{
					while(!H.fin())
						C.encolar(H.proximo());
				}
			}
		}
			return EncontreA;
		}
	/* IMPLEMENTACION CON UNA SOLA COLA
  	public Boolean esAncestro(T a, T b)
{
    Boolean Aux = false; // Aux controla si se confirmó que b es ancestro de A
    Boolean EncontreA = false; // EncontreA controla si se encontró el elemento a en el árbol
    Cola<ArbolGeneral<T>> C = new Cola<ArbolGeneral<T>>();
    C.encolar(this);

    while (!C.esVacia() && (!Aux || !EncontreA)) {
        ArbolGeneral<T> Arb = C.desencolar();
        if (Arb.getDato() == a) {
            Aux = true;
        }
        if (Arb.getDato() == b && Aux) {
            EncontreA = true;
        }
        ListaGenerica<ArbolGeneral<T>> H = Arb.getHijos();
        H.comenzar();
        while (!H.fin()) {
            C.encolar(H.proximo());
        }
    }

    return EncontreA;
}

  	*/
	
	public boolean esAncestro2(T a, T b) {
		ArbolGeneral<T> subArbol = this.buscar(a);
		return subArbol != null && subArbol.buscar(b) != null;
	}
	
	public ArbolGeneral<T> buscar(T dato){
		ArbolGeneral<T> subArbol = null;
		if (!this.esVacio()) {
			if (this.getDato().equals(dato)) {
				subArbol = this;
			}
			else {
				this.getHijos().comenzar();
				while (!this.getHijos().fin() && subArbol != null) {
					subArbol = this.getHijos().proximo().buscar(dato);
				}
			}
		}
		return subArbol;
	}
	
/*
	// camel case
	public boolean esLleno(int cant) {
		Cola <ArbolGeneral<T>> C= new Cola<ArbolGeneral<T>>();
		ArbolGeneral<T> Aux;
		//buscar formula de la cantidad de nodos que tiene que tener para que este lleno, 
	}
	*/
	
}