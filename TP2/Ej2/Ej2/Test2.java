package Ej2;

import java.io.IOException;
import static org.junit.Assert.*;
import org.junit.Test;

public class Test2 {
		
	@Test
	public void leerFromFile() throws IOException{
		
		Ej2.resolverFile("./Tests/Tp2Ej2.in", "Tp2Ej2.out");
		
	}
	
	@Test
	public void megavalla(){
		Megavalla megavalla = new Megavalla();
		megavalla.insertar(1,2);
		megavalla.insertar(3,4);
		megavalla.insertar(4,8);
		
		assertEquals(false, megavalla.entranLoBicho(1, 2));
		assertEquals(true, megavalla.entranLoBicho(1, 3));
		assertEquals(false, megavalla.entranLoBicho(3, 4));
		assertEquals(false, megavalla.entranLoBicho(3, 5));
		assertEquals(true, megavalla.entranLoBicho(1, 8));
	}
	
	@Test
	public void megavalla2(){
		Megavalla megavalla2 = new Megavalla();
		megavalla2.insertar(1,2);
		megavalla2.insertar(2,3);
		megavalla2.insertar(3,4);
		megavalla2.insertar(4,5);
		
		assertEquals(false, megavalla2.entranLoBicho(1, 2));
		assertEquals(false, megavalla2.entranLoBicho(1, 3));
		assertEquals(false, megavalla2.entranLoBicho(1, 4));
		assertEquals(false, megavalla2.entranLoBicho(1, 5));
		assertEquals(true, megavalla2.entranLoBicho(1, 6));
		assertEquals(false, megavalla2.entranLoBicho(3, 4));
		assertEquals(false, megavalla2.entranLoBicho(3, 5));
		assertEquals(true, megavalla2.entranLoBicho(1, 8));
	}
}
