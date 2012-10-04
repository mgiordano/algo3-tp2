package Ej1;

import java.util.TreeMap;

public class Mapa {

	public Ciudad origen;
	public Ciudad destino;
	private TreeMap<String, Ciudad> ciudades;
	
	public Mapa(String orig, String dest){
		
		Ciudad o = new Ciudad(orig);
		Ciudad d = new Ciudad(dest);
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
				Tramo a12 = new Tramo(c1,c2,p);
				Tramo a21 = new Tramo(c2,c1,p);
				c1.insertarVecino(a12);
				c2.insertarVecino(a21);
			}else{
				Ciudad nuevaCiudad2 = new Ciudad(ciudad2);
				Tramo a12 = new Tramo(c1,nuevaCiudad2,p);
				Tramo a21 = new Tramo(nuevaCiudad2,c1,p);
				c1.insertarVecino(a12);
				nuevaCiudad2.insertarVecino(a21);
				ciudades.put(ciudad2, nuevaCiudad2);
			}
		}else{
			if (c2 != null){
				Ciudad nuevaCiudad1 = new Ciudad(ciudad1);
				Tramo a12 = new Tramo(nuevaCiudad1,c2,p);
				Tramo a21 = new Tramo(c2,nuevaCiudad1,p);
				nuevaCiudad1.insertarVecino(a12);
				c2.insertarVecino(a21);
				ciudades.put(ciudad1, nuevaCiudad1);
			}else{
				Ciudad nuevaCiudad1 = new Ciudad(ciudad1);
				Ciudad nuevaCiudad2 = new Ciudad(ciudad2);
				Tramo a12 = new Tramo(nuevaCiudad1,nuevaCiudad2,p);
				Tramo a21 = new Tramo(nuevaCiudad2,nuevaCiudad1,p);
				nuevaCiudad1.insertarVecino(a12);
				nuevaCiudad2.insertarVecino(a21);
				ciudades.put(ciudad1, nuevaCiudad1);
				ciudades.put(ciudad2, nuevaCiudad2);
			}
			
		}
	}
}
