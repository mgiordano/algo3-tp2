package Ej2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Ej2 {
	
	public static Integer buscarArea(Campo campo){
		Queue<Parcela> cola = new LinkedList<Parcela>();
		campo.parcelas[0][0].infestable = true;
		cola.add(campo.parcelas[0][0]);
		Parcela parcela;
		Integer areaInfestada = 0;
		while (!(cola.isEmpty())){
			parcela = cola.poll();
			areaInfestada += parcela.area;
			infestarParcelasContiguas(parcela,campo,cola);
		}
		return (campo.xMax)*(campo.yMax)-areaInfestada;
	}
	
	public static void infestarParcelasContiguas(Parcela parcela, Campo campo, Queue<Parcela> cola){
		Integer i = parcela.pos.x;
		Integer j = parcela.pos.y;
		if (j+1 < campo.cantV){
			if(!(campo.parcelas[i][j+1].infestable) && parcela.este){
				campo.parcelas[i][j+1].infestable = true;
				cola.add(campo.parcelas[i][j+1]);
			}
		}
		if (j-1 > 0){
			if (!(campo.parcelas[i][j-1].infestable) && parcela.oeste){
				campo.parcelas[i][j-1].infestable = true;
				cola.add(campo.parcelas[i][j-1]);
			}
		}
		if (i+1 < campo.cantH){
			if (!(campo.parcelas[i+1][j].infestable) && parcela.norte){
				campo.parcelas[i+1][j].infestable = true;
				cola.add(campo.parcelas[i+1][j]);
			}
		}
		if (i-1 > 0){
			if (!(campo.parcelas[i-1][j].infestable) && parcela.sur){
				campo.parcelas[i-1][j].infestable = true;
				cola.add(campo.parcelas[i-1][j]);
			}
		}
	}
		
	public static void resolverFile(String fileIn, String fileOut) throws IOException{
		
		BufferedReader reader = new BufferedReader(new FileReader(fileIn)); // Creo el buffer a llenar
		String linea; // Creo el string a utilizar (donde se van a guardar las cosas del buffer)
		BufferedWriter os = new BufferedWriter( new FileWriter(fileOut) );
		
		int res = 1;
		
		// Leo el archivo
		while ((linea = reader.readLine()) != null){ // mientras que hayan mas lineas que leer

			Map<Integer, Megavalla> horizontales = new TreeMap<Integer, Megavalla>();
			Map<Integer, Megavalla> verticales = new TreeMap<Integer, Megavalla>();
		
			//la primera linea es un entero, altura de las langostas
			int saltoLangostas = Integer.parseInt(linea);
			
			//la segunda linea contiene el resto de la informacion
			linea = reader.readLine();
			//Separamos primero en funcion de ";", individualizando tokens con la info de la valla
			StringTokenizer tokenVallas = new StringTokenizer(linea,";");
			int x, y, longitud, altura, xMax = 0, yMax = 0;
			while (tokenVallas.hasMoreTokens()){
				StringTokenizer tokenData = new StringTokenizer(tokenVallas.nextToken(), " ");
				x = Integer.parseInt(tokenData.nextToken());
				y = Integer.parseInt(tokenData.nextToken());
				String orientacion = tokenData.nextToken();
				longitud = Integer.parseInt(tokenData.nextToken());
				altura = Integer.parseInt(tokenData.nextToken());
				if (altura >= saltoLangostas){
					if (orientacion.equals("|")){
						// Veo xMax
						if (x > xMax){
							xMax = x;
						}
						// Veo yMax
						if (y+longitud > yMax){
							yMax = y+longitud;
						}
						//Definimos la valla
						if(verticales.containsKey(x)){
							verticales.get(x).insertar(y, y+longitud);
						}else{
							Megavalla nueva = new Megavalla();
							nueva.insertar(y, y+longitud);
							verticales.put(x, nueva);
						}
					}
					if (orientacion.equals("-")){
						// Veo yMax
						if (y > yMax){
							yMax = y;
						}
						// Veo xMax
						if (x+longitud > xMax){
							xMax = x+longitud;
						}
						if(horizontales.containsKey(y)){
							horizontales.get(y).insertar(x, x+longitud);
						}else{
							Megavalla nueva = new Megavalla();
							nueva.insertar(x, x+longitud);
							horizontales.put(y, nueva);
						}
					}
				}
			}
			
			Megavalla bordeX0 = new Megavalla();
			bordeX0.insertar(0, xMax+1);
			horizontales.put(0, bordeX0);

			Megavalla bordeXMax = new Megavalla();
			bordeXMax.insertar(0, xMax+1);
			horizontales.put(yMax+1, bordeXMax);
			
			Megavalla bordeY0 = new Megavalla();
			bordeY0.insertar(0, yMax+1);
			verticales.put(0, bordeY0);
			
			Megavalla bordeYMax = new Megavalla();
			bordeYMax.insertar(0, yMax+1);
			verticales.put(xMax+1, bordeY0);
			
			Campo campo = new Campo(horizontales,verticales,xMax+1,yMax+1);
			campo.ordenarVallas();
			campo.armarParcelas(); 
			res = buscarArea(campo);

			os.append(Integer.toString(res));
			os.append("\n");
		}
		reader.close();
		os.close();
	}

}
