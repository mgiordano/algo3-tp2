package Ej1;

import java.util.ArrayList;
import java.util.List;

public class Ciudad {
	
		public String nombre;
		public boolean estado;
		public Integer peso;
		public List<Arista> vecinos;
		
		//Constructor
		
		public Ciudad(String n, boolean e, Integer p){
			nombre = n;
			estado = e;
			peso = p;
			List<Arista> vcns = new ArrayList<Arista>();
			vecinos = vcns;
		}
		
		public void insertarVecino(Arista arista){
			vecinos.add(arista);
		}
}

