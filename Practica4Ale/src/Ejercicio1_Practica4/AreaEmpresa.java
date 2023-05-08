package Ejercicio1_Practica4;

public class AreaEmpresa {
		private String Id;
		private int Tardanza;
		
		
		
		
		public AreaEmpresa(String id, int tardanza) {
			Id = id;
			Tardanza = tardanza;
		}
		public String getId() {
			return Id;
		}
		public void setId(String id) {
			Id = id;
		}
		public int getTardanza() {
			return Tardanza;
		}
		public void setTardanza(int tardanza) {
			Tardanza = tardanza;
		}
		
		
}
