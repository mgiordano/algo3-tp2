package Ej2;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Campo {
	Map<Integer, Megavalla> horizontales;
	Map<Integer, Megavalla> verticales;
	Integer xMax;
	Integer yMax;
	Integer cantH;
	Integer cantV;
	Parcela[][] parcelas;
	
	public Campo(Map<Integer, Megavalla> mvh, Map<Integer, Megavalla> mvv, Integer x, Integer y){
		horizontales = mvh;
		verticales = mvv;
		xMax = x;
		yMax = y;
	}
	
	public void ordenarVallas(){
		Set<Integer> clavesHor = horizontales.keySet();
		Iterator<Integer> it = clavesHor.iterator();
		Coordenada pedorra = new Coordenada(0,0);
		while (it.hasNext()){
			Comparator<Coordenada> comparator = pedorra.new CoordenadaComparator();
			Collections.sort(horizontales.get(it.next()).vallas, comparator);
		}
		
		Set<Integer> clavesVer = verticales.keySet();
		it = clavesVer.iterator();
		while (it.hasNext()){
			Comparator<Coordenada> comparator = pedorra.new CoordenadaComparator();
			Collections.sort(verticales.get(it.next()).vallas, comparator);
		}
	}
	
	public void armarParcelas(){
		cantH = horizontales.keySet().size()-1;
		cantV = verticales.keySet().size()-1;
		Parcela[][] cuadricula = new Parcela[cantH][cantV];
		Iterator<Integer> itHor1 = horizontales.keySet().iterator();
		Iterator<Integer> itHor2 = horizontales.keySet().iterator();
		itHor2.next();
		Integer y1, y2, x1, x2, i = 0, j = 0;
		while(itHor2.hasNext()){
			Iterator<Integer> itVer1 = verticales.keySet().iterator();
			Iterator<Integer> itVer2 = verticales.keySet().iterator();
			j = 0;
			itVer2.next();
			y1 = itHor1.next();
			y2 = itHor2.next();
			while(itVer2.hasNext()){
				x1 = itVer1.next();
				x2 = itVer2.next();
				boolean norte = horizontales.get(y2).entranLoBicho(x1, x2);
				boolean sur = horizontales.get(y1).entranLoBicho(x1, x2);
				boolean oeste = verticales.get(x1).entranLoBicho(y1, y2);
				boolean este = verticales.get(x2).entranLoBicho(y1, y2);			
				Integer area = (x2-x1)*(y2-y1);
				Coordenada pos = new Coordenada(i,j);
				Parcela marcela = new Parcela(norte,sur,este,oeste,pos,area);
				cuadricula[i][j] = marcela;
				j++;
			}
			i++;
		}
		parcelas = cuadricula;
	}
}
