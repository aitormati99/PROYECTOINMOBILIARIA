package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import logica.negocios.Domicilio;

public class testDomicilio {
	
	Domicilio a;
	String nombre="Villa1";
	double precio=1000000;
	boolean comprada= true;
	
	
	@Before
	public void setUp() throws Exception {
		
		
	
		a=new Domicilio(nombre, precio, comprada);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGets() {
		
		assertEquals(nombre, a.getNombre());
		assertEquals(precio, a.getPrecio(),0.0);
		assertEquals(comprada, a.isComprada());
		
	}

	@Test
	public void testSets(){
		
		a.setNombre("Casita");
		assertEquals(a.getNombre(), "Casita");
		
		a.setPrecio(1000000);
		assertEquals(a.getPrecio(),1000000,0.0);
		
		a.setComprada(true);
		assertEquals(a.isComprada(),true);
	
		
		
	}
}
