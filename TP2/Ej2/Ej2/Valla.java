package Ej2;

import java.util.HashMap;

public class Valla {

	public int altura;
	public String orientacion;
	public String id;
	public Coordenada origen;
	public int longitud;
	private HashMap<String, Valla> vecinos;
	
	public Valla(String s, Coordenada orig, String or, int a, int l) {
		id = s;
		orientacion = or;
		altura = a;
		origen = orig;
		longitud = l;
		vecinos = new HashMap<String, Valla>();
		
	}
	
	public void insertarVecino(Valla v){
		
		vecinos.put(v.id, v);
		
	}
	
	public boolean seToca(Valla v){
		boolean res = false;
		boolean ah = false;
		boolean av = false;
		if (orientacion != v.orientacion){
			if (orientacion == "|"){
				ah = origen.alignHor(v.origen, longitud);
				av = v.origen.alignVer(origen, v.longitud);
			}else{
				ah = v.origen.alignHor(origen, v.longitud);
				av = origen.alignVer(v.origen, longitud);
			}
			res = ah && av;
		}
		return res;
	}
}
