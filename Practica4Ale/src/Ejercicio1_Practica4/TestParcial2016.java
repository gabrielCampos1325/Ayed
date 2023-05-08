package Ejercicio1_Practica4;

public class TestParcial2016 {
	
	
	ArbolGeneral<DatoParcial2016> A= new ArbolGeneral<DatoParcial2016>(new DatoParcial2016(5,'G'));//raiz 5
	ArbolGeneral<DatoParcial2016> Der= new ArbolGeneral<DatoParcial2016>(new DatoParcial2016(4,'R'));//  
	ArbolGeneral<DatoParcial2016> Iz= new ArbolGeneral<DatoParcial2016>(new DatoParcial2016(3,'F'));
	ArbolGeneral<DatoParcial2016> Med= new ArbolGeneral<DatoParcial2016>(new DatoParcial2016(21,'G'));
	ArbolGeneral<DatoParcial2016> Iz2= new ArbolGeneral<DatoParcial2016>(new DatoParcial2016(9,'#'));
	ArbolGeneral<DatoParcial2016> Der2= new ArbolGeneral<DatoParcial2016>(new DatoParcial2016(7,'F'));
	ArbolGeneral<DatoParcial2016> Med2= new ArbolGeneral<DatoParcial2016>(new DatoParcial2016(6,'O'));
	//Iz2.agregarHijo(new ArbolGeneral<DatoParcial2016>(new DatoParcial2016(99,'F'));
	Iz.agregarHijo(Iz2);
	Der.agregarHijo(Der2);
	Med.agregarHijo(Med2);
	A.agregarHijo(Iz);
	A.agregarHijo(Med);
	A.agregarHijo(Der);	
	A.agregarHijo(new ArbolGeneral<DatoParcial2016>(13,'A'));
	DevolverCamino d= new DevolverCamino(A);
	
}
	/*
	   	 5
	  /  /  \ \
	 3  21   4 13
	 /   \    \
	 9   6     7
     /
	99
	DevolverCamino d= new DevolverCamino();
	
}
