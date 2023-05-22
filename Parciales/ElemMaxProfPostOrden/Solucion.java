package ElemMaxProfPostOrden;

import tp02.ejercicio2.*;
import tp02.ejercicio3.PilaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class Solucion {
	
	public int buscar(ArbolBinario<Integer> ab) {
		Resultado res = new Resultado();
		if (!ab.esVacio()) {			
			buscar(ab, res, -1);
		}			
		return res.getValor();
	}

	private void buscar(ArbolBinario<Integer> ab, Resultado res, int profAct) {
				
		profAct++;
		
		if (ab.tieneHijoIzquierdo())
			buscar(ab.getHijoIzquierdo(), res, profAct);
		
		if (ab.tieneHijoDerecho())
			buscar(ab.getHijoDerecho(), res, profAct);		
		
		if (ab.esHoja()) {
			if (profAct > res.getProfMax()) {
				res.setProfMax(profAct);
				res.setValor(ab.getDato());
			}				
		}
	}
	
	/*
	 *     
      
    private void buscar(ArbolBinario<Integer> a,ListaGenerica<ArbolBinario<Integer>> lisA, int cant, int cantMax){
   			
      	
        if(a.tieneHijoIzquierdo())
             cantMax = buscar(a.getHijoIzquierdo(),lisA,cant++);
        
        if(a.tieneHijoDerecho())
             cantMax = buscar(a.getHijoDerecho(),lisA,cant++);
        
        if(a.esHoja()){
          	if(cant > cantMax){ 
              if(lisA != null ){
                lisA.eliminarEn(lisA.tamanio());
                lisA.agregarFinal(a.getDato())
              }else{
                lisA.agregarFinal(a.getDato())
              }
              
          }
  
	 * */
	 
	
}
