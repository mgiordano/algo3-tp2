package Ej2;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Megavalla {
	Map<Integer, Integer> vallas = new TreeMap<Integer, Integer>();
	
	public void insertar(Integer inicio, Integer fin){
		this.vallas.put(inicio, fin);
	}
	
	public boolean entranLoBicho(Integer inicio, Integer fin){
		Iterator<Integer> itClaves = this.vallas.keySet().iterator();
		boolean res = true;
		Integer pos;
		while (itClaves.hasNext()){
			if((pos = itClaves.next()) > inicio){
				break;
			}else{
				if(pos <= inicio && inicio <= this.vallas.get(pos)){
					if (fin <= this.vallas.get(pos)){
						res = false;
						break;
					}else{
						inicio = this.vallas.get(pos);
					}
				}
			}
		}
		return res;
	}
}
