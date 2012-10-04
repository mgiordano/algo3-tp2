package Ej1;

import java.util.Comparator;

public class Arista {
	
	public Integer peso;
	public Ciudad desde;
	public Ciudad hasta;
	
	public Arista(Ciudad a, Ciudad b, Integer p){
		peso = p;
		desde = a;
		hasta = b;
	}
	
}

class AristaComparator implements Comparator<Arista>{
	   
    public int compare(Arista a1, Arista a2){
       
    	Integer peso1 = a1.peso;        
    	Integer peso2 = a2.peso;   
       
        if(peso1 > peso2)
            return 1;
        else if(peso1 < peso2)
            return -1;
        else
            return 0;    
    }
   
}