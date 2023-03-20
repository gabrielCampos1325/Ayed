package ejercicio_3;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Estudiante[] arrayE = new Estudiante[2];
		Profesor[] arrayP = new Profesor[3];
		
		for (int i = 0; i < arrayE.length; i++) {
			arrayE[i] = new Estudiante();
			arrayE[i].setNombre("Nombre " + i);
			arrayE[i].setApellido("Apellido " + i);
			arrayE[i].setComision(i);
			arrayE[i].setEmail("email " + i);
			arrayE[i].setDireccion("Direccion " + i);
		}
		
		for (int i = 0; i < arrayP.length; i++) {
			arrayP[i] = new Profesor();
			arrayP[i].setNombre("Nombre " + i);
			arrayP[i].setApellido("Apellido " + i);
			arrayP[i].setEmail("email " + i);
			arrayP[i].setCatedra("Catedra " + i);
			arrayP[i].setFacultad("Facultad " + i);
		}
		
		for (Estudiante e : arrayE) {
			System.out.println(e.tusDatos());
		}
		for (Profesor p : arrayP) {
			System.out.println(p.tusDatos());
		}
	}

}
