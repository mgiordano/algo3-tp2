package Ej1;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import org.junit.Test;

public class Test1 {
	
	//Tests de Correctitud
	
	@Test
	public void testCiudad(){
		
		Ciudad BA = new Ciudad("Buenos Aires", false, 10);
		Ciudad NY = new Ciudad("Nueva York", true, 2);
		
		assertEquals(BA.nombre, "Buenos Aires");
		assertEquals(BA.estado, false);
		assertEquals(BA.peso, (Integer) 10);
		assertEquals(BA.vecinos.size(), 0);
		
		assertEquals(NY.nombre, "Nueva York");
		assertEquals(NY.estado, true);
		assertEquals(NY.peso, (Integer) 2);
		assertEquals(NY.vecinos.size(), 0);
		
	}
	
	@Test
	public void testTramo(){
		Ciudad SC = new Ciudad("Sin City", true, 100);
		Ciudad M = new Ciudad("Metropolis", true, 29);
		
		Tramo aSCM = new Tramo(SC,M,50);
		Tramo aMSC = new Tramo(M,SC,10);
		
		assertEquals(aSCM.desde, SC);
		assertEquals(aSCM.hasta, M);
		assertEquals(aSCM.peso, (Integer) 50);
		assertEquals(aMSC.desde, M);
		assertEquals(aMSC.hasta, SC);
		assertEquals(aMSC.peso, (Integer) 10);
		
		SC.estado = false;
		M.nombre = "Madagascar";
		
		assertEquals(aSCM.desde.estado, false);
		assertEquals(aMSC.desde.nombre, "Madagascar");
		
		aMSC.peso = 12;
		Ciudad W = new Ciudad("Washington", false, 9);
		aSCM.desde = W;
		
		assertEquals(aMSC.peso, (Integer) 12);
		assertEquals(aSCM.desde, W);
		
	}
	
	@Test
	public void testComparator(){
		Ciudad Q = new Ciudad("Quequen", true, 100);
		Ciudad N = new Ciudad("Necochea", true, 29);
		Tramo aQN = new Tramo(Q,N,10);
		
		Ciudad P = new Ciudad("Pinamar", true, 0);
		Ciudad MP = new Ciudad("Mar del Plata", true, 0);
		Tramo aPMP = new Tramo(P,MP,200);
		
		Comparator<Tramo> comp = new TramoComparator();
		assertEquals(comp.compare(aQN,aPMP), 1);
		aPMP.peso = 1;
		assertEquals(comp.compare(aQN,aPMP), -1);
		assertEquals(comp.compare(aPMP,aPMP), 0);
		assertEquals(comp.compare(aPMP,aQN), 1);
		
		PriorityQueue<Tramo> heap = new PriorityQueue<Tramo>(11, comp);
		heap.add(aPMP);
		heap.add(aQN);
		assertEquals(heap.poll().peso, (Integer) 10);
	}
	
	@Test
	public void testTramoCiudad(){
		
		Ciudad L = new Ciudad("Liverpool", false, -12);
		Ciudad T = new Ciudad("Tokyo", true, 128341);
		Ciudad A = new Ciudad("Amsterdam", true, 0);
		Ciudad E = new Ciudad("Edimburgo", true, 69);
		Ciudad B = new Ciudad("Bath", false, 12);
		
		Tramo aLT = new Tramo(L,T,4);
		Tramo aLA = new Tramo(L,A,12);
		Tramo aLB = new Tramo(L,B,4);
		Tramo aTL = new Tramo(T,L,4);
		Tramo aTE = new Tramo(T,E,10);
		Tramo aBA = new Tramo(B,A,121);
		
		List<Tramo> lista1 = new ArrayList<Tramo>();
		lista1.add(aLT);
		lista1.add(aLA);
		lista1.add(aLB);
		
		List<Tramo> lista2 = new ArrayList<Tramo>();
		lista2.add(aTL);
		lista2.add(aTE);
		
		List<Tramo> lista3 = new ArrayList<Tramo>();
		lista3.add(aBA);
		
		L.vecinos = lista1;
		T.vecinos = lista2;
		B.vecinos = lista3;
		A.vecinos = lista1;
		
		assertEquals(L.vecinos.get(0).peso, (Integer) 4);
		assertEquals(L.vecinos.get(0).desde.nombre, "Liverpool" );
		assertEquals(B.vecinos.size(),1);
		assertEquals(L.vecinos,A.vecinos);
		
		B.insertarVecino(aLB);
		
		assertEquals(B.vecinos.size(), 2);
		assertEquals(B.vecinos.get(1).hasta.nombre, "Bath");
		
	}
	
	@Test
	public void testMapa(){
		
		String orig = "Tierra del Fuego";
		String dest = "Tilcara";
		
		Mapa teg = new Mapa(orig,dest);
		
		assertEquals(teg.origen.nombre, "Tierra del Fuego");
		assertEquals(teg.destino.nombre, "Tilcara");
		
		teg.agregar("Tierra del Fuego", "Rawson", 12);
		teg.agregar("Tierra del Fuego", "Rivadavia", 20);
		teg.agregar("Carmen de Patagones", "Rawson", 15);
		teg.agregar("Rivadavia", "Bariloche", 35);
		teg.agregar("Bariloche", "Rawson", 7);
		
		assertEquals(teg.origen.estado, false);
		assertEquals(teg.destino.peso, (Integer) Integer.MAX_VALUE);
		
		//Esto se utilizo para verificar la correcta construccion del Mapa
		//Para probarlo se debe cambiar la accesibilidad del TreeMap ciudades
		//a modo 'Public'
		/*
		teg.origen.estado = true;
		assertEquals(teg.ciudades.get(teg.origen.nombre).estado, true);
		assertEquals(teg.ciudades.size(), 6);
		assertEquals(teg.ciudades.containsKey("Tilcara"), true);
		assertEquals(teg.ciudades.containsKey("Tilcar"), false);
		assertEquals(teg.ciudades.containsKey("Tangamandapio"), false);
		assertEquals(teg.ciudades.get("Rawson").nombre, "Rawson");
		assertEquals(teg.ciudades.get("Carmen de Patagones").vecinos.get(0).hasta.nombre, "Rawson");
		assertEquals(teg.ciudades.get("Bariloche").vecinos.get(0).peso, (Integer) 35);
		
		teg.agregar("Mendoza", "Rivadavia", 25);
		
		assertEquals(teg.ciudades.get("Rivadavia").vecinos.get(2).hasta.nombre, "Mendoza");
		assertEquals(teg.ciudades.get("Mendoza").nombre, "Mendoza");
		assertEquals(teg.ciudades.get("Mendoza").vecinos.get(0).hasta.nombre, "Rivadavia");
		teg.agregar("Rawson","Mendoza", 5);
		
		assertEquals(teg.ciudades.get("Rawson").vecinos.get(3).hasta.nombre, teg.ciudades.get("Mendoza").vecinos.get(1).desde.nombre);
	*/
	}
	
	@Test
	public void leerFromFile() throws IOException{
		Ej1.resolverFile("./Tests/Tp2Ej1.in");	
		
	}
}

