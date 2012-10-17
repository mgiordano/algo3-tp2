package Ej2;

import java.util.Comparator;

public class Coordenada {
	
	public int x;
	public int y;
	
	public Coordenada(int cx, int cy){
		
		x = cx;
		y = cy;
		
	}

	class CoordenadaComparator implements Comparator<Coordenada>{
		   
	    public int compare(Coordenada c1, Coordenada c2){
	       
	    	Integer desde1 = c1.x;        
	    	Integer desde2 = c2.x;   
	       
	        if(desde1 > desde2)
	            return 1;
	        else if(desde1 < desde2)
	            return -1;
	        else
	            return 0;
	        }
	    }
	
}
