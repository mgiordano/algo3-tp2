package Ej1;

import java.util.ArrayList;
import java.util.List;

public class Ciudad {
	
		public String nombre;
		public boolean estado;
		public Integer peso;
		public List<Tramo> vecinos;
		
		//Constructor
		
		public Ciudad(String n){
			nombre = n;
			estado = false;
			peso = Integer.MAX_VALUE;
			List<Tramo> vcns = new ArrayList<Tramo>();
			vecinos = vcns;
		}
		
		//Metodos
		
		public void insertarVecino(Tramo tramo){
			vecinos.add(tramo);
		}
}

