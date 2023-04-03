package ejercicio_2;

import tp02.ejercicio2.ListaEnlazadaGenerica;

public class TestListaEnlazadaGenerica {

	public static void main(String[] args) {
		
		Estudiante e;
		
		ListaEnlazadaGenerica<Estudiante> l = new ListaEnlazadaGenerica<Estudiante>();
		l.comenzar();
		
		for (int i = 0; i < 4; i++) {
			e = new Estudiante("nombre"+i,
							   "apellido"+i,
							   "comision"+i,
							   "email"+i,
							   "direccion"+i);
			l.agregarFinal(e);
		}
		
		while(!l.fin()){
            System.out.println(l.proximo().tusDatos());
        }		
		
	}

}
