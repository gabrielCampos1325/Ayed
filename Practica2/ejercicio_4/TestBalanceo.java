package ejercicio_4;

public class TestBalanceo {

	public static void main(String[] args) {
		
		Dato[] liValores = new Dato[3];		
		
		for (int i = 0; i < liValores.length; i++) {
			liValores[i] = new Dato();
		}
		
		liValores[0].setElem("()");
		liValores[1].setElem("[]");
		liValores[2].setElem("{}");
		
		String st = "({[](}))";
		String c;
		
		for (int i = 0; i < st.length(); i++) {
			c = Character.toString(st.charAt(i));
			for (int j = 0; j < liValores.length; j++) {
				if (liValores[j].getElem().contains(c)) {
					liValores[j].incCant();
				}
			}
		}
		
		boolean ok = true;
		int i = 0;
		while ((i < 3) && (ok)){			
			if (liValores[i].getCant() % 2 == 0) {
				i++;
			} else {
				ok = false;
			}
		}
		
		if (ok) {
			System.out.println("Esta balanceado");
		} else {
			System.out.println("Esta DESBALANCEADO");
		}
		
		/*ColaGenerica<Character> cola = new ColaGenerica<Character>();
		
		PilaGenerica<Character> pila = new PilaGenerica<Character>();		
		
		ListaGenerica<Character> liEntrada = new ListaEnlazadaGenerica<Character>();
		
		ListaGenerica<Character> liSalida = new ListaEnlazadaGenerica<Character>();
		
		liEntrada.agregarFinal('(');
		liEntrada.agregarFinal('[');
		liEntrada.agregarFinal('{');
		
		liSalida.agregarFinal(')');
		liSalida.agregarFinal(']');
		liSalida.agregarFinal('}');
		
		String st = "([])";
		
		for (int i = 0; i < st.length(); i++) {
			System.out.println(st.charAt(i));
			cola.encolar(st.charAt(i)); 
		}		
		
		Character elem;
		
		for (int i = 0; i < st.length(); i++) {
			elem = cola.desencolar();
			if () {
				
			}
			
			if (elem == pila.tope()) {
				elem = pila.desapilar();
			} else {
				pila.apilar(elem);
			}
		}
		if (pila.esVacia()) {
			System.out.println("La pila quedo vacia");
		} else {
			System.out.println("La pila quedo LLENA");
		}*/
	}
	

	
}
