package Ejercicio1_Practica4;

public class AnalizadorArbol {
	
	
	// utilizo el recorrido por niveles porque el ejercicio pide calcular el promedio por cada nivel, por lo que es practico usar este recorrido(?)
	public int devolverMaximoPromedio (ArbolGeneral<AreaEmpresa> arbol)
	{
		int MaxP=0,cantN=0;// variable maxP es la variable a retornar que contiene el mayor promedio. La variable cantN va contando los nodos de cada arbol para luego ser dividida por la tardanza total(variable suma)
		int Suma= 0;// en esta variable se van sumando las tardanzas de cada nivel
		Cola <ArbolGeneral<AreaEmpresa>> C=  new Cola <ArbolGeneral<AreaEmpresa>>();
		ArbolGeneral<AreaEmpresa> Aux;
		C.encolar(arbol);
		C.encolar(null);
		while(!C.esVacia())
		{
			Aux= C.desencolar();
			if(Aux!=null)
			{
				Suma+= Aux.getDato().getTardanza();
				cantN++;
				ListaGenerica <ArbolGeneral<AreaEmpresa>> L= Aux.getHijos();
				L.comenzar();
				while(!L.fin()) 
					C.encolar(L.proximo());
			}
			else
			{
				if(!C.esVacia())
				C.encolar(null);
			MaxP= Math.max(MaxP, Suma/cantN);//se calcula el maximo entre el promedio del nivel actual y el nivel anterior
			cantN=0;// se reinician los valores de las variables para el siguiente nivel del árbol
			Suma=0;
			}
			}
		return MaxP;
	}
	
	
}
