package restriccionesTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import actividad.DiaDeSemana;


public class DiaDeSemanaTest {
	
	private DiaDeSemana restriccion;
	
	@BeforeEach
	public void setUp() {
		restriccion = new DiaDeSemana();
	}
	
	@Test
	public void test01_cumpleRestriccionCuandoDiaDeSemana() {
		assertTrue(restriccion.cumpleLaRestricion(LocalDateTime.of(2022, 11, 25, 10, 50)));
	}
	
	@Test
	public void test02_NocumpleRestriccionCuandoCaeDomingo() {
		assertFalse(restriccion.cumpleLaRestricion(LocalDateTime.of(2022, 11, 27, 10, 50)));
	}
	
	@Test
	public void test03_NocumpleRestriccionCuandoCaeDiaDeSemana() {
		assertFalse(restriccion.cumpleLaRestricion(LocalDateTime.of(2022, 11, 26, 10, 50)));
	}
	
}
