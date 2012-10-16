package Ej2;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Megavalla {
	List<Coordenada> vallas = new ArrayList<Coordenada>();
	
	public void insertar(Integer inicio, Integer fin){
		Coordenada extremos = new Coordenada(inicio,fin);
		vallas.add(extremos);
	}
	
	public boolean entranLoBicho(Integer inicio, Integer fin){
		ListIterator<Coordenada> itVallas = vallas.listIterator();
		boolean res = true;
		Coordenada extremos;
		while (itVallas.hasNext()){
			extremos = itVallas.next();
			if(extremos.x > inicio){
				break;
			}else{
				if(extremos.x <= inicio && inicio <= extremos.y){
					if (fin <= extremos.y){
						res = false;
						break;
					}else{
						inicio = extremos.y;
					}
				}
			}
		}
		return res;
	}
}
