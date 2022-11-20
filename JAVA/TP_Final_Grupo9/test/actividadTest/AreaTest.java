package actividadTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import actividad.Circulo;

public class AreaTest {
	private Circulo area;

	@BeforeEach
	public void setUp() {
		area = new Circulo(10, 10, 4);
	}
	
	@Test
	public void test01_unAreaTieneUnaLongitud() {
		assertEquals(10, area.getLongitud());
	}
	
	@Test
	public void test02_unAreaTieneUnaLatitud() {
		assertEquals(10,area.getLatitud());
	}
	
	@Test
	public void test03_unAreaTieneUnRadio() {
		assertEquals(4, area.getRadio());
	}
	
	@Test
	public void test04_unAreaIndicaSiContieneUnaCoordenada() {
		assertTrue(area.estaDentroDelArea(10, 8));
	}
	
	@Test
	public void test05_unAreaIndicaSiNoContieneUnaCoordenada() {
		assertFalse(area.estaDentroDelArea(10, 5));
	}
}
