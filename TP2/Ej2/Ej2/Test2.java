package Ej2;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.io.IOException;

public class Test2 {
	
	@Test
	public void testValla(){
		
		Coordenada c = new Coordenada(2,2);
		Valla v1 = new Valla("1",c,"|",10,4);
		
		c = new Coordenada(2,4);
		Valla v2 = new Valla("2",c,"-",10,2);
		
		c = new Coordenada(4,2);
		Valla v3 = new Valla("3",c,"|",10,4);
		
		c = new Coordenada(5,2);
		Valla v4 = new Valla("4",c,"|",10,4);
		
		c = new Coordenada(5,6);
		Valla v5 = new Valla("5",c,"-",10,2);
		
		c = new Coordenada(7,2);
		Valla v6 = new Valla("6",c,"|",10,4);
		
		c = new Coordenada(5,2);
		Valla v7 = new Valla("7",c,"-",10,2);
		
		assertEquals("1",v1.id);
		assertEquals(2, v2.origen.x);
		assertEquals("|", v3.orientacion);
		assertEquals(10, v4.altura);
		assertEquals(2, v5.longitud);
		assertEquals("6", v6.id);
		assertEquals(2, v7.origen.y);
		
		assertEquals(true,v1.seToca(v2));
		assertEquals(false,v1.seToca(v3));
		assertEquals(false,v1.seToca(v4));
		assertEquals(false,v1.seToca(v5));
		assertEquals(false,v1.seToca(v6));
		assertEquals(false,v1.seToca(v7));
		
		assertEquals(true,v2.seToca(v1));
		assertEquals(true,v2.seToca(v3));
		assertEquals(false,v2.seToca(v4));
		assertEquals(false,v2.seToca(v5));
		assertEquals(false,v2.seToca(v6));
		assertEquals(false,v2.seToca(v7));
		
		assertEquals(true,v3.seToca(v2));
		assertEquals(false,v3.seToca(v1));
		assertEquals(false,v3.seToca(v4));
		assertEquals(false,v3.seToca(v5));
		assertEquals(false,v3.seToca(v6));
		assertEquals(false,v3.seToca(v7));
		
		assertEquals(true,v4.seToca(v5));
		assertEquals(true,v4.seToca(v7));
		assertEquals(false,v4.seToca(v1));
		assertEquals(false,v4.seToca(v2));
		assertEquals(false,v4.seToca(v3));
		assertEquals(false,v1.seToca(v6));
		
		
	}
	
	@Test
	public void leerFromFile() throws IOException{
		
		Ej2.resolverFile("./Tests/Tp2Ej2.in");	
		
		
	}

}
