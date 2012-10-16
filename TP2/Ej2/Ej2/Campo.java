package Ej2;

import java.util.Iterator;
import java.util.Map;

public class Campo {
	Map<Integer, Megavalla> horizontales;
	Map<Integer, Megavalla> verticales;
	Integer xMax;
	Integer yMax;
	
	public Parcela[][] armarParcelas(){
		Integer cantH = horizontales.keySet().size()-1;
		Integer cantV = verticales.keySet().size()-1;
		Parcela[][] parcelas = new Parcela[cantV][cantH];
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
				Parcela marcela = new Parcela();
				marcela.norte = horizontales.get(y2).entranLoBicho(x1, x2);
				marcela.sur = horizontales.get(y1).entranLoBicho(x1, x2);
				marcela.oeste = verticales.get(x1).entranLoBicho(y1, y2);
				marcela.este = verticales.get(x2).entranLoBicho(y1, y2);			
				marcela.area = (x2-x1)*(y2-y1);
				parcelas[i][j] = marcela;
				j++;
			}
			i++;
		}
		return parcelas;
	}
}
