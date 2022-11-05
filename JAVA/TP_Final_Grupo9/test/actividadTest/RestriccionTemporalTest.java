package actividadTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import actividad.RestriccionTemporal;

public class RestriccionTemporalTest {
	
	RestriccionTemporal restriccion;
	
	@BeforeEach
	public void setUp() {
		restriccion = new RestriccionTemporal(LocalDateTime.of(2022, 5, 10, 21, 30), LocalDateTime.of(2022, 6, 10, 23, 59));
	}
	
	@Test
	public void test01_unaRestriccionConoceLaFechaDeInicio() {
		assertEquals(LocalDateTime.of(2022, 5, 10, 21, 30), restriccion.getFechaDeInicio());
	}
	 
	@Test
	public void test02_unaRestriccionConoceLaFechaDeFin() {
		assertEquals(LocalDateTime.of(2022, 6, 10, 23, 59), restriccion.getFechaDeCierre());
	}
	
	@Test
	public void test03_unaRestriccionSabeSiEstaHabilitadaUnaFecha() {
		assertTrue(restriccion.cumpleLaRestriccion(LocalDateTime.of(2022, 5, 25, 12, 55)));
	}
	
	@Test
	public void test04_unaRestriccionSabeSiNoEstaHabilitadaUnaFecha() {
		assertFalse(restriccion.cumpleLaRestriccion(LocalDateTime.of(2022, 8, 31, 1, 55)));
	}
	
}
