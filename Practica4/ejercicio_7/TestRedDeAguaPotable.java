package ejercicio_7;
import tp04.ejercicio1.*;

public class TestRedDeAguaPotable {

	public static void main(String[] args) {
		
		ArbolGeneral<Double> ArbolDeRed= new ArbolGeneral<Double>(100.0);
        ArbolGeneral<Double> Der= new ArbolGeneral<Double>(0.0);//
        ArbolGeneral<Double> Iz= new ArbolGeneral<Double>(0.0);
        ArbolGeneral<Double> Med= new ArbolGeneral<Double>(0.0);
        ArbolGeneral<Double> Iz2= new ArbolGeneral<Double>(0.0);
        ArbolGeneral<Double> Der2= new ArbolGeneral<Double>(0.0);
        ArbolGeneral<Double> Med2= new ArbolGeneral<Double>(0.0);

        Iz2.agregarHijo(new ArbolGeneral<Double>(0.0));
        Iz.agregarHijo(Iz2);
        Iz.agregarHijo(new ArbolGeneral<Double>(0.0));
        Der.agregarHijo(Der2);
        Med.agregarHijo(Med2);
        ArbolDeRed.agregarHijo(Iz);
        ArbolDeRed.agregarHijo(Med);
        ArbolDeRed.agregarHijo(Der);
        ArbolDeRed.agregarHijo(new ArbolGeneral<Double>(0.0));
        
        
        RedDeAguaPotable Red= new RedDeAguaPotable(ArbolDeRed);
        System.out.println(Red.minimoCaudal(100.0));

	}

}
