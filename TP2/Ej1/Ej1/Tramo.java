package Ej1;

import java.util.Comparator;

public class Tramo {
	
	public Integer peso;
	public Ciudad desde;
	public Ciudad hasta;
	
	public Tramo(Ciudad a, Ciudad b, Integer p){
		peso = p;
		desde = a;
		hasta = b;
	}
	
}

class TramoComparator implements Comparator<Tramo>{
	   
    public int compare(Tramo a1, Tramo a2){
       
    	Integer peso1 = a1.peso;        
    	Integer peso2 = a2.peso;   
       
        if(peso1 < peso2)
            return 1;
        else if(peso1 > peso2)
            return -1;
        else
            return 0;    
    }
   
}