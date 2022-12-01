package restriccionesTest;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import actividad.EntreFecha;

public class EntreFechasTest {
	
	private EntreFecha restriccion;
	
	
	@BeforeEach
	public void setUp() {
		
		LocalDateTime fecha1 = LocalDateTime.of(2022, 1, 10, 23, 30);
		LocalDateTime fecha2 = LocalDateTime.of(2022, 10, 30, 10, 50);
		
		restriccion = new EntreFecha(fecha1, fecha2);
		
	}
	
	@Test
	public void test01_cuandoUnaFechaSeEncuentraDentroDelRango() {
		assertTrue(restriccion.cumpleLaRestricion(LocalDateTime.of(2022, 5, 15, 20, 45)));
	}
	
	@Test
	public void test02_cuandoUnaFechaNoSeEncuentraDentroDelRangoDeCierre() {
		assertFalse(restriccion.cumpleLaRestricion(LocalDateTime.of(2022, 12, 30, 10, 50)));
	}
	
	@Test
	public void test03_cuandoUnaFechaNoSeEncuentraDentroDelRangoDeInicio() {
		assertFalse(restriccion.cumpleLaRestricion(LocalDateTime.of(2021, 12, 30, 10, 50)));
	}
	
	
}
