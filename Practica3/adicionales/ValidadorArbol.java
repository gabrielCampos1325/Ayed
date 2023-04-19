package adicionales;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp03.ejercicio1.ArbolBinario;


public class ValidadorArbol{
    
	private ArbolBinario<Integer> arbol;
	
    
	public ValidadorArbol() {
		
	}
    
    public ValidadorArbol(ArbolBinario<Integer> unArbol) {
		
    	this.arbol = unArbol;
	}
    
    public ArbolBinario<Integer> getArbol() {
		return arbol;
	}

	public void setArbol(ArbolBinario<Integer> arbol) {
		this.arbol = arbol;
	}

	    
        
    public Integer buscarMayorEnPostOrden() {
    	// Buscar el mayor en postorden en el �rbol es:
    	// Buscar el mayor en c/u de los �rboles hijos e ir qued�ndome con el valor mayor.
    	// Comparar el mayor obtenido en el paso anterior con la ra�z del �rbol. 
    	// El entero m�s grande es el valor a retornar.
    	
    	if (!this.arbol.esVacio ()) 
    	   return this.buscarMaximoRecursivo(arbol);
    	else return Integer.MIN_VALUE;
    	}
    
    private Integer buscarMaximoRecursivo(ArbolBinario<Integer> arbol) {
    	
    	Integer mayor= Integer.MIN_VALUE;
    	
    	if (!arbol.esHoja()){
	    	if (arbol.tieneHijoIzquierdo())
	    		mayor = buscarMaximoRecursivo(arbol.getHijoIzquierdo());
	    	   	    	
	    	if (arbol.tieneHijoDerecho())
	    		mayor = Math.max(mayor, buscarMaximoRecursivo(arbol.getHijoDerecho()));
    	}	
    	return Math.max (mayor, arbol.getDato());
    }
   
  //camMasLargo = camAct.clonar(); Consultarlo
    
    public static ListaGenerica<Integer> caminoAHojaMasLejana(ArbolBinario<Integer> a){
   	 
		 ListaGenerica<Integer> camAct = new ListaEnlazadaGenerica<Integer>();
		 ListaGenerica<Integer> camMasLargo = new ListaEnlazadaGenerica<Integer>();
		 if (!a.esVacio()) caminoAHojaMasLejanaRec2 (a, camAct, camMasLargo, 0, Integer.MAX_VALUE);
		 return camMasLargo;
	}


	private static void caminoAHojaMasLejanaRec(ArbolBinario<Integer> a, ListaGenerica<Integer> camAct, 
		                                                            ListaGenerica<Integer> camMasLargo){
	    
	    camAct.agregarFinal(a.getDato());
	    
	    if (a.esHoja()){ 
	    	if (camAct.tamanio()>camMasLargo.tamanio()){
	    		camMasLargo.eliminarTodos();  
	    		camAct.comenzar(); 
	    		while(!camAct.fin())
	    			camMasLargo.agregarFinal(camAct.proximo());
	    	}
	    }    
	    else {
		   
	    	if (a.tieneHijoIzquierdo()){
	    		caminoAHojaMasLejanaRec(a.getHijoIzquierdo(), camAct, camMasLargo);
	    		camAct.eliminarEn(camAct.tamanio());
	    	} 
		    	    	   	    	
	    	if (a.tieneHijoDerecho()) {
	    		caminoAHojaMasLejanaRec(a.getHijoDerecho(), camAct, camMasLargo);
	    		camAct.eliminarEn(camAct.tamanio());
		    }
	    }
	}

	private static void caminoAHojaMasLejanaRec1(ArbolBinario<Integer> a, ListaGenerica<Integer> camAct, 
			ListaGenerica<Integer> camMasLargo){

		camAct.agregarFinal(a.getDato());

		if (a.esHoja()) {
			if (camAct.tamanio() > camMasLargo.tamanio()) {
				camMasLargo.eliminarTodos();
				camAct.comenzar();
				while (!camAct.fin())
					camMasLargo.agregarFinal(camAct.proximo());
			}
		} else {

			if (a.tieneHijoIzquierdo()) caminoAHojaMasLejanaRec1(a.getHijoIzquierdo(), camAct, camMasLargo);
				
			if (a.tieneHijoDerecho()) caminoAHojaMasLejanaRec1(a.getHijoDerecho(), camAct, camMasLargo);
		}
		
		camAct.eliminarEn(camAct.tamanio()); // eliminamos cuando el �rbol es hoja y al volver de la recursi�n luego de tratar a los sub�rboles o al sub�rbol que tenga.
	}
//Ante igual longitud, devuelve el de mayor peso.
	private static int caminoAHojaMasLejanaRec2(ArbolBinario<Integer> a, ListaGenerica<Integer> camAct, 
			ListaGenerica<Integer> camMasLargo, int sumaAct, int sumaMax){
        		
        camAct.agregarFinal(a.getDato());
        sumaAct += a.getDato();
		
        if (a.esHoja()) {
			if ((camAct.tamanio() > camMasLargo.tamanio()) || ((camAct.tamanio() == camMasLargo.tamanio()) && (sumaAct > sumaMax))) {
				camMasLargo.eliminarTodos();
				sumaMax = sumaAct;
				camAct.comenzar();
				while (!camAct.fin())
					camMasLargo.agregarFinal(camAct.proximo());
			}
		} else {

			if (a.tieneHijoIzquierdo()) sumaMax = caminoAHojaMasLejanaRec2(a.getHijoIzquierdo(), camAct, camMasLargo, sumaAct, sumaMax);
				
			if (a.tieneHijoDerecho()) sumaMax = caminoAHojaMasLejanaRec2(a.getHijoDerecho(), camAct, camMasLargo, sumaAct, sumaMax);
		}
		
		camAct.eliminarEn(camAct.tamanio()); // eliminamos cuando el �rbol es hoja y al volver de la recursi�n luego de tratar a los sub�rboles o al sub�rbol que tenga.
		return sumaMax;
	}

    
	public static ListaGenerica<ListaGenerica<Integer>> todosCaminosAHojaMasLejana(ArbolBinario<Integer> a){
	   	 int max = 0;
		 ListaGenerica<Integer> camAct = new ListaEnlazadaGenerica<Integer>();
		 ListaGenerica<ListaGenerica<Integer>> todosCaminos = new ListaEnlazadaGenerica<ListaGenerica<Integer>>();
		 if (!a.esVacio()) todosCaminosAHojaMasLejRec2(a, camAct, todosCaminos);
		 return todosCaminos;
	}
	
	private static int todosCaminosAHojaMasLejRec(ArbolBinario<Integer> a, ListaGenerica<Integer> camAct, 
			ListaGenerica<ListaGenerica<Integer>> todosCaminos, int max){
		
		
		camAct.agregarFinal(a.getDato());

		if (a.esHoja()){
			
			if (todosCaminos.esVacia()){
				todosCaminos.agregarFinal(camAct.clonar());
				max = camAct.tamanio();
			}
			else //ya hay alg�n camino guardado
				if (camAct.tamanio() == max) todosCaminos.agregarFinal(camAct.clonar());
				else
					if (camAct.tamanio() > max){
						todosCaminos.eliminarTodos();
						todosCaminos.agregarFinal(camAct.clonar());
						max = camAct.tamanio();
					}
		}else {

			if (a.tieneHijoIzquierdo()) max = todosCaminosAHojaMasLejRec(a.getHijoIzquierdo(), camAct, todosCaminos, max);
				
			if (a.tieneHijoDerecho()) max = todosCaminosAHojaMasLejRec(a.getHijoDerecho(), camAct, todosCaminos, max);
		}
		
		camAct.eliminarEn(camAct.tamanio()); // eliminamos cuando el �rbol es hoja y al volver de la recursi�n luego de tratar a los sub�rboles o al sub�rbol que tenga.
		return max;
	}
	
	private static int todosCaminosAHojaMasLejRec1(ArbolBinario<Integer> a, ListaGenerica<Integer> camAct, 
			ListaGenerica<ListaGenerica<Integer>> todosCaminos, int max){
		
		
		camAct.agregarFinal(a.getDato());

		if (a.esHoja()){
			
			if (todosCaminos.esVacia() || (camAct.tamanio() > max)){
				todosCaminos.eliminarTodos();
				todosCaminos.agregarFinal(camAct.clonar());
				max = camAct.tamanio();
			}
			else //ya hay alg�n camino guardado
				if (camAct.tamanio() == max) todosCaminos.agregarFinal(camAct.clonar());
		}else {

			if (a.tieneHijoIzquierdo()) max = todosCaminosAHojaMasLejRec1(a.getHijoIzquierdo(), camAct, todosCaminos, max);
				
			if (a.tieneHijoDerecho()) max = todosCaminosAHojaMasLejRec1(a.getHijoDerecho(), camAct, todosCaminos, max);
		}
		
		camAct.eliminarEn(camAct.tamanio()); // eliminamos cuando el �rbol es hoja y al volver de la recursi�n luego de tratar a los sub�rboles o al sub�rbol que tenga.
		return max;
	}

	private static void todosCaminosAHojaMasLejRec2(ArbolBinario<Integer> a, ListaGenerica<Integer> camAct, 
			ListaGenerica<ListaGenerica<Integer>> todosCaminos){
		
		
		camAct.agregarFinal(a.getDato());

		if (a.esHoja()){
			
			if (todosCaminos.esVacia() || (camAct.tamanio() > todosCaminos.elemento(1).tamanio())){
				todosCaminos.eliminarTodos();
				todosCaminos.agregarFinal(camAct.clonar());
			}
			else //ya hay alg�n camino guardado
				if (camAct.tamanio() == todosCaminos.elemento(1).tamanio()) todosCaminos.agregarFinal(camAct.clonar());
		}else {

			if (a.tieneHijoIzquierdo()) todosCaminosAHojaMasLejRec2(a.getHijoIzquierdo(), camAct, todosCaminos);
				
			if (a.tieneHijoDerecho())  todosCaminosAHojaMasLejRec2(a.getHijoDerecho(), camAct, todosCaminos);
		}
		
		camAct.eliminarEn(camAct.tamanio()); // eliminamos cuando el �rbol es hoja y al volver de la recursi�n luego de tratar a los sub�rboles o al sub�rbol que tenga.
	}

	
    public static void main (String[] args) {
		
      
        // Se instancia el siguiente ejemplo:
		//
		// 		  22
		// 		/   \
		// 	  1      7
		// 	/  \      \
		// 5    4     111
		// 	   / \     / \
		// 	  1   12  3  33
    	//			 / \
    	//          99 999
    	//             	 \
    	//               9999

		ArbolBinario <Integer> ab = new ArbolBinario<Integer>(22);
		ab.agregarHijoIzquierdo(new ArbolBinario<Integer>(1));
		ab.agregarHijoDerecho(new ArbolBinario<Integer>(7));
		ab.getHijoIzquierdo().agregarHijoIzquierdo(new ArbolBinario<Integer>(5));
		ab.getHijoIzquierdo().agregarHijoDerecho(new ArbolBinario<Integer>(4));
		ab.getHijoDerecho().agregarHijoDerecho(new ArbolBinario<Integer>(111));
		ArbolBinario <Integer> aux=ab.getHijoIzquierdo().getHijoDerecho();
		aux.agregarHijoIzquierdo(new ArbolBinario<Integer>(1));
		aux.agregarHijoDerecho(new ArbolBinario<Integer>(12));
		aux=ab.getHijoDerecho().getHijoDerecho();
		aux.agregarHijoIzquierdo(new ArbolBinario<Integer>(3));
		aux.agregarHijoDerecho(new ArbolBinario<Integer>(33));
		aux.getHijoIzquierdo().agregarHijoIzquierdo(new ArbolBinario<Integer>(99));
		aux.getHijoIzquierdo().agregarHijoDerecho(new ArbolBinario<Integer>(999));
//		aux.getHijoIzquierdo().getHijoDerecho().agregarHijoDerecho(new ArbolBinario<Integer>(9999));
		
//		Parcial p = new Parcial();
//				
//		ListaGenerica<Integer> l = p.resolver1(ab, 0, 200);
//		
//		if (!l.esVacia()) {
//			System.out.print(l.toString());
//			l.comenzar();
//			while (!l.fin())
//				System.out.print(l.proximo()+ " ");
//		}else 
//			System.out.println("No hay ning�n elemento del �rbol que cumplan las condiciones!!! " );
		
		
		
		System.out.println("------ Test IMPRESI�N POR NIVELES ------");
		ab.recorridoPorNiveles();
		System.out.print("\n\n");
		
		System.out.println("El camino a la hoja m�s lejana es: " + caminoAHojaMasLejana(ab)+"\n\n");
		System.out.println("Todos los caminos a la hoja m�s lejana son: ");
		ListaGenerica<ListaGenerica<Integer>> caminos = todosCaminosAHojaMasLejana(ab);
		if (!caminos.esVacia()){
			caminos.comenzar();
			while (!caminos.fin())
				System.out.print(caminos.proximo()+ "\n");
		}
		
		// Se instancia el siguiente ejemplo:
		//
		// 		   gris
		// 		 /     \
		// 	  gris       verde
		// 	 /    \      /    \
		// gris   gris   gris  gris
		// 	      /     /      /    \
		// 	     gris   gris   gris gris
		//			           

		ArbolBinario <String> abSt = new ArbolBinario<String>("gris");
		ArbolBinario <String> abSt1 = new ArbolBinario<String>("gris");
		ArbolBinario <String> abSt2 = new ArbolBinario<String>("verde");
		ArbolBinario <String> abSt3 = new ArbolBinario<String>("gris");
		ArbolBinario <String> abSt4 = new ArbolBinario<String>("gris");
		ArbolBinario <String> abSt5 = new ArbolBinario<String>("gris");
		ArbolBinario <String> abSt6 = new ArbolBinario<String>("gris");
		ArbolBinario <String> abSt7 = new ArbolBinario<String>("gris");
		ArbolBinario <String> abSt8 = new ArbolBinario<String>("gris");
		ArbolBinario <String> abSt9 = new ArbolBinario<String>("gris");
		ArbolBinario <String> abSt10 = new ArbolBinario<String>("gris");
		
		abSt.agregarHijoIzquierdo(abSt1);
		abSt.agregarHijoDerecho(abSt2);
		
		abSt1.agregarHijoIzquierdo(abSt3);
		abSt1.agregarHijoDerecho(abSt4);
		
		abSt2.agregarHijoIzquierdo(abSt5);
		abSt2.agregarHijoDerecho(abSt6);
		
		abSt4.agregarHijoIzquierdo(abSt7);
		
		abSt5.agregarHijoIzquierdo(abSt8);
		
		abSt6.agregarHijoIzquierdo(abSt9);
		abSt6.agregarHijoDerecho(abSt10);
		
			 	
		
//		ValidadorArbol v = new ValidadorArbol(ab);
//				
//		System.out.println("El mayor valor del �rbol es: "+ v.buscarMayorEnPostOrden());
//		
//		System.out.println("El camino a la hoja m�s lejana es: "+ caminoAHojaMasLejana(ab));
//		Parcial p = new Parcial();
//		System.out.println("El �rbol es creciente: " + p.resolver(ab));
//		
//		ListaGenerica<Integer> l = p.resolver(ab, 19, 22);
//		if (!l.esVacia()) {
//			l.comenzar();
//			while (!l.fin())
//				System.out.print(l.proximo()+ " ");
//		}else 
//			System.out.println("No hay ning�n elemento del �rbol que cumplan las condiciones!!! " );
//    
//    
    	    
		    
//    ListaGenerica <Integer> l = new ListaEnlazadaGenerica<Integer>();
//    l.agregarFinal(22);
//    l.agregarFinal(1);
//    l.agregarFinal(5);
//    l.agregarFinal(3);
    
//    System.out.println( "La lista coincide con al menos un camino en el �rbol: " + p.resolver(ab,l));
		
		
//		abSt.recorridoPorNiveles();
//		System.out.print("\n\n");
//		p.colorearArbol(abSt);
//		abSt.recorridoPorNiveles();
		
		
// Se instancia el siguiente ejemplo:
//
// 		  22
// 	     /   
// 	    1      
// 	    \      
//       5    
// 	     / 
// 	    3   
//		 \
//        99
//		   \
//         101		

	  ArbolBinario <Integer> a = new ArbolBinario<Integer>(22);
	  a.agregarHijoIzquierdo(new ArbolBinario<Integer>(1));
	  a.getHijoIzquierdo().agregarHijoDerecho(new ArbolBinario<Integer>(5));
	  ArbolBinario <Integer> temp5 = a.getHijoIzquierdo().getHijoDerecho();
	  temp5.agregarHijoIzquierdo(new ArbolBinario<Integer>(3));
	  ArbolBinario <Integer> temp3=temp5.getHijoIzquierdo();
	  temp3.agregarHijoDerecho(new ArbolBinario<Integer>(99));
//	  temp3.agregarHijoIzquierdo(new ArbolBinario<Integer>(100));
	  temp3.getHijoDerecho().agregarHijoDerecho(new ArbolBinario<Integer>(101));
//			
	  System.out.println("------ Test IMPRESI�N POR NIVELES ------");
	  a.recorridoPorNiveles();
	  System.out.println("\n\n" + "El camino a la hoja m�s lejana es: " + caminoAHojaMasLejana(a)+ "\n");
	  System.out.println("Todos los caminos a la hoja m�s lejana son: ");
	  ListaGenerica<ListaGenerica<Integer>> caminos1 = todosCaminosAHojaMasLejana(a);
		if (!caminos1.esVacia()){
			caminos1.comenzar();
			while (!caminos1.fin())
				System.out.print(caminos1.proximo()+ "\n");
		}
	  
//	  Parcial p = new Parcial();
//	  System.out.println( "El �rbol es zig zag: " + p.zigZag(a));
		
	// Se instancia el siguiente ejemplo:
	  //
//	   		  22
//	   	     /  \  
//	   	    100  22  
//	   	    /  \      
//	       200  100    
//	   	   /     /
//	   	  200   100
//	  		
//	          
//	  		   
//	           	
//
//	  	  ArbolBinario <Integer> a1 = new ArbolBinario<Integer>(22);
//	  	  a1.agregarHijoIzquierdo(new ArbolBinario<Integer>(100));
//	  	  a1.agregarHijoDerecho(new ArbolBinario<Integer>(22));
//	  	  a1.getHijoIzquierdo().agregarHijoDerecho(new ArbolBinario<Integer>(100));
//	  	  a1.getHijoIzquierdo().agregarHijoIzquierdo(new ArbolBinario<Integer>(200));
//	  	  ArbolBinario <Integer> temp100 = a1.getHijoIzquierdo().getHijoDerecho();
//	  	  temp100.agregarHijoIzquierdo(new ArbolBinario<Integer>(100));
//	  	  ArbolBinario <Integer> temp200=a1.getHijoIzquierdo().getHijoIzquierdo();
//	  	  temp200.agregarHijoDerecho(new ArbolBinario<Integer>(200));
//	  	  
//	  	  System.out.println("------ Test IMPRESI�N POR NIVELES ------");
//		  a1.recorridoPorNiveles();
//		  System.out.print("\n\n");
//			
//		  Parcial p1 = new Parcial();
//		  System.out.println( "El �rbol es de selecci�n: " + p1.esSeleccion(a1));
	  	  
	  	  
	  	  
}
    
}
