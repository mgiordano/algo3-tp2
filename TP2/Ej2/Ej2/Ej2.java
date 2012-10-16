package Ej2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Ej2 {
	
	public static Integer buscarArea(Map<Integer,Megavalla> horizontales, Map<Integer,Megavalla> verticales){
		Integer cantH = horizontales.keySet().size()-1;
		Integer cantV = verticales.keySet().size()-1;
		System.out.println(cantH);
		System.out.println(cantV);
		return 0;
	}
	
	public static void resolverFile(String file) throws IOException{
		
		BufferedReader reader = new BufferedReader(new FileReader(file)); // Creo el buffer a llenar
		String linea; // Creo el string a utilizar (donde se van a guardar las cosas del buffer)
		BufferedWriter os = new BufferedWriter( new FileWriter( "Tp2Ej2.out" ) );
		
		int res = 1;
		
		// Creamos los treemap que se mantienen ordenados por clave
		Map<Integer, Megavalla> horizontales = new TreeMap<Integer, Megavalla>();
		Map<Integer, Megavalla> verticales = new TreeMap<Integer, Megavalla>();
		
		// Leo el archivo
		while ((linea = reader.readLine()) != null){ // mientras que hayan mas lineas que leer
		
			//la primera linea es un entero, altura de las langostas
			int saltoLangostas = Integer.parseInt(linea);
	//		Campo campo = new Campo(saltoLangostas);
			
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
				// Veo xMax
				if (orientacion.equals("|")){
					if (x > xMax){
						xMax = x;
					}
				}else{
					if (x+longitud > xMax){
						xMax = x+longitud;
					}
				}
				// Veo yMax
				if (orientacion.equals("-")){
					if (y > yMax){
						yMax = y;
					}
				}else{
					if (y+longitud > yMax){
						yMax = y+longitud;
					}
				}
				
				if (altura >= saltoLangostas){
//					Coordenada origen = new Coordenada(x,y);
//					campo.agregarValla(id, origen, orientacion, altura, longitud);
					if (orientacion.equals("|")){
						if(verticales.containsKey(x)){
							verticales.get(x).insertar(y, y+longitud);
						}else{
							Megavalla nueva = new Megavalla();
							nueva.insertar(y, y+longitud);
							verticales.put(x, nueva);
						}
					}else{
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
			
			res = buscarArea(horizontales, verticales);


			os.append(Integer.toString(res));
			os.append("\n");
		}
		reader.close();
		os.close();
	}

}
