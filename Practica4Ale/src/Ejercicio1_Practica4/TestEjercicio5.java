package Ejercicio1_Practica4;

public class TestEjercicio5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnalizadorArbol A= new AnalizadorArbol();
		ArbolGeneral<AreaEmpresa> Raiz= new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("M",161));
		ArbolGeneral<AreaEmpresa> Izq= new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("J",130));
		ArbolGeneral<AreaEmpresa> Med= new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("K",250));
		ArbolGeneral<AreaEmpresa> Der= new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("L",100));
		Izq.agregarHijo(new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("A",5)));
		Izq.agregarHijo(new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("B",5)));
		Izq.agregarHijo(new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("C",5)));
		Raiz.agregarHijo(Izq);
		
		Med.agregarHijo(new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("D",5)));
		Med.agregarHijo(new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("E",5)));
		Med.agregarHijo(new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("F",5)));
		Raiz.agregarHijo(Med);

	
		Der.agregarHijo(new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("G",5)));
		Der.agregarHijo(new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("H",500)));
		Der.agregarHijo(new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("I",5)));
		Raiz.agregarHijo(Der);
		
		System.out.println("Mayor Promedio = " + A.devolverMaximoPromedio(Raiz));
	}		
		

}
