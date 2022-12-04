package actividadTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import actividad.Caracteristica;

public class CaracteristicasTest {
	Caracteristica caracterista;
	
	@BeforeEach
	public void setUp() {
		caracterista = new Caracteristica("Oro",3);
	}
	
	@Test
	public void test01_unaCaracteristicaTieneUnaDescripcion() {
		assertEquals("Oro", caracterista.getDescripicion());
	}
	
	@Test
	public void test02_unaCaracteristicaTieneUnaAfinidad() {
		assertEquals(3, caracterista.getAfinidad());
	}
	
	@Test
	public void test03_unaCaracteristicaIncluyeLaDescripcion() {
		assertTrue(caracterista.include("Oro"));
	}
	
	@Test
	public void test04_unaCaracteristicaNoIncluyeLaDescripcion() {
		assertFalse(caracterista.include("Plata"));
	}
	
}
