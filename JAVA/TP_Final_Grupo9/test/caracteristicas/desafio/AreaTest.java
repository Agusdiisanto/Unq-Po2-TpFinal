package caracteristicas.desafio;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AreaTest {
	
	private Area area;

	@BeforeEach
	public void setUp() {
		this.area = new Area(6, 10, 4);
	}
	
	
	@Test 
	public void test01_unAreaTieneUnaLongitud() {
		
		assertEquals(10, area.getLongitud());
	}
	
	@Test 
	public void test02_unAreaTieneUnaLatitud() {
	
		assertEquals(6,area.getLatitud());
	}
	
	@Test 
	public void test03_unAreaTieneUnRadio() {
		
		assertEquals(4, area.getRadio());
	}
}
