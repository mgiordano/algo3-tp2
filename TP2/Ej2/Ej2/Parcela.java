package Ej2;

public class Parcela {
	// Estos 4 booleanos delimitan cada porci�n infestable
	boolean infestable;
	boolean norte;
	boolean sur;
	boolean este;
	boolean oeste;
	Coordenada pos;
	Integer area;
	
	public Parcela(boolean n, boolean s, boolean e, boolean o, Coordenada p, Integer a){
		
		infestable = false;
		norte = n;
		sur = s;
		este = e;
		oeste = o;
		pos = p;
		area = a;
		
	}
	
	
}
