package Ej2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Ej2 {
	
	public static void resolverFile(String file) throws IOException{
		
		BufferedReader reader = new BufferedReader(new FileReader(file)); // Creo el buffer a llenar
		String linea; // Creo el string a utilizar (donde se van a guardar las cosas del buffer)
		BufferedWriter os = new BufferedWriter( new FileWriter( "Tp2Ej2.out" ) );
		
		int res = 1;
		
		// Leo el archivo
		while ((linea = reader.readLine()) != null){ // mientras que hayan mas lineas que leer
		
			//la primera linea es un entero, altura de las langostas
			int saltoLangostas = Integer.parseInt(linea);
			Campo campo = new Campo(saltoLangostas);
			
			//la segunda linea contiene el resto de la informacion
			linea = reader.readLine();
			//Separamos primero en funcion de ";", individualizando tokens con la info de la valla
			StringTokenizer tokenVallas = new StringTokenizer(linea,";");
			int i = 0;
			while (tokenVallas.hasMoreTokens()){
				StringTokenizer tokenData = new StringTokenizer(tokenVallas.nextToken(), " ");
				int x = Integer.parseInt(tokenData.nextToken());
				int y = Integer.parseInt(tokenData.nextToken());
				String orientacion = tokenData.nextToken();
				int longitud = Integer.parseInt(tokenData.nextToken());
				int altura = Integer.parseInt(tokenData.nextToken());
				String id = Integer.toString(i);
				
				if (altura >= saltoLangostas){
					Coordenada origen = new Coordenada(x,y);
					campo.agregarValla(id, origen, orientacion, altura, longitud);
				}
				i++;
			}
			
			//res = buscarArea(campo);
			os.append(Integer.toString(res));
			os.append("\n");
		}
		reader.close();
		os.close();
	}

}
