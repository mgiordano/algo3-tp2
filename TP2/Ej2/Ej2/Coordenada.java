package Ej2;

public class Coordenada {
	
	public int x;
	public int y;
	
	public Coordenada(int cx, int cy){
		
		x = cx;
		y = cy;
		
	}

	public boolean alignHor(Coordenada a, int distancia){
		boolean res = false;
		if (y <= a.y){
			if (a.y <= (y + distancia)){
				res = true;
			}
		}
		return res;
	}
	
	public boolean alignVer(Coordenada a, int distancia){
		boolean res = false;
		if (x <= a.x){
			if (a.x <= (x + distancia)){
				res = true;
			}
		}
		return res;
	}
	
}
