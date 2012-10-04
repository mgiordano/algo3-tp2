package Ej1;

import java.util.TreeMap;

public class Mapa {

	public Ciudad origen;
	public Ciudad destino;
	private TreeMap<String, Ciudad> ciudades;
	
	public Mapa(String orig, String dest){
		
		Ciudad o = new Ciudad(orig, false, Integer.MAX_VALUE);
		Ciudad d = new Ciudad(dest, false, Integer.MAX_VALUE);
		origen = o;
		destino = d;
		TreeMap<String, Ciudad> c = new TreeMap<String, Ciudad>();
		c.put(orig, o);
		c.put(dest,d);
		ciudades = c;
	}
	
	public void agregar(String ciudad1, String ciudad2, Integer p){
		Ciudad c1 = ciudades.get(ciudad1);
		Ciudad c2 = ciudades.get(ciudad2);
		if (c1 != null ){
			if (c2 != null){
				Arista a12 = new Arista(c1,c2,p);
				Arista a21 = new Arista(c2,c1,p);
				c1.insertarVecino(a12);
				c2.insertarVecino(a21);
			}else{
				Ciudad nuevaCiudad2 = new Ciudad(ciudad2, false, Integer.MAX_VALUE);
				Arista a12 = new Arista(c1,nuevaCiudad2,p);
				Arista a21 = new Arista(nuevaCiudad2,c1,p);
				c1.insertarVecino(a12);
				nuevaCiudad2.insertarVecino(a21);
				ciudades.put(ciudad2, nuevaCiudad2);
			}
		}else{
			if (c2 != null){
				Ciudad nuevaCiudad1 = new Ciudad(ciudad1, false, Integer.MAX_VALUE);
				Arista a12 = new Arista(nuevaCiudad1,c2,p);
				Arista a21 = new Arista(c2,nuevaCiudad1,p);
				nuevaCiudad1.insertarVecino(a12);
				c2.insertarVecino(a21);
				ciudades.put(ciudad1, nuevaCiudad1);
			}else{
				Ciudad nuevaCiudad1 = new Ciudad(ciudad1, false, Integer.MAX_VALUE);
				Ciudad nuevaCiudad2 = new Ciudad(ciudad2, false, Integer.MAX_VALUE);
				Arista a12 = new Arista(nuevaCiudad1,nuevaCiudad2,p);
				Arista a21 = new Arista(nuevaCiudad2,nuevaCiudad1,p);
				nuevaCiudad1.insertarVecino(a12);
				nuevaCiudad2.insertarVecino(a21);
				ciudades.put(ciudad1, nuevaCiudad1);
				ciudades.put(ciudad2, nuevaCiudad2);
			}
			
		}
	}
}
