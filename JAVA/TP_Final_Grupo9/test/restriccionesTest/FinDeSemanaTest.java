package restriccionesTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import actividad.FinDeSemana;

public class FinDeSemanaTest {
	
	private FinDeSemana restriccion;
	
	@BeforeEach
	public void setUp() {
		restriccion = new FinDeSemana();
	}
	
	@Test
	public void test01_cumpleRestriccionCuandoCaeSabado() {
		assertTrue(restriccion.cumpleLaRestricion(LocalDateTime.of(2022, 11, 26, 10, 50)));
	}
	
	@Test
	public void test02_cumpleRestriccionCuandoCaeDomingo() {
		assertTrue(restriccion.cumpleLaRestricion(LocalDateTime.of(2022, 11, 27, 10, 50)));
	}
	
	@Test
	public void test03_NocumpleRestriccionCuandoCaeDiaDeSemana() {
		assertFalse(restriccion.cumpleLaRestricion(LocalDateTime.of(2022, 11, 25, 10, 50)));
	}
	
}
