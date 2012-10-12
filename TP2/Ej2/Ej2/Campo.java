package Ej2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Campo {

	public int saltoLangostas;
	public HashMap<String, Valla> vallas;
	public HashMap<String, Ciclo> ciclos;

	public Campo(int altura){
		
		saltoLangostas = altura;
		vallas = new HashMap<String, Valla>();
		ciclos = new HashMap<String, Ciclo>();
		
	}
	
	public void agregarValla(String id, Coordenada orig, String orient, int a, int l){
		
		Valla v1 = new Valla(id,orig,orient,a,l);
		Set<String> vallasDefinidas = vallas.keySet();
		Iterator<String> it = vallasDefinidas.iterator();
		while (it.hasNext()){
			String idValla = it.next();
			Valla v2 = vallas.get(idValla);
			if (v1.seToca(v2)){
				v1.insertarVecino(v2);
				v2.insertarVecino(v1);
			}
		}
		vallas.put(id, v1);
	}
}
