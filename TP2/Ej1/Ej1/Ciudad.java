package Ej1;

import java.util.ArrayList;
import java.util.List;

public class Ciudad {
	
		public String nombre;
		public boolean estado;
		public Integer peso;
		public List<Tramo> vecinos;
		
		//Constructor
		
		public Ciudad(String n, boolean e, Integer p){
			nombre = n;
			estado = e;
			peso = p;
			List<Tramo> vcns = new ArrayList<Tramo>();
			vecinos = vcns;
		}
		
		//Metodos
		
		public void insertarVecino(Tramo tramo){
			vecinos.add(tramo);
		}
}

