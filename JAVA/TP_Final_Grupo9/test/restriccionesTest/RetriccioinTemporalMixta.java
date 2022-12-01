package restriccionesTest;

import static org.junit.Assert.assertTrue;
import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import actividad.DiaDeSemana;
import actividad.EntreFecha;
import actividad.RestriccionTemporalMixta;

public class RetriccioinTemporalMixta {
	
	private EntreFecha restriccion1;
	private DiaDeSemana restriccion2;
	private RestriccionTemporalMixta restriccionMixta;
	
	@BeforeEach
	public void setUp() {
		
		LocalDateTime fecha1 = LocalDateTime.of(2022, 1, 10, 23, 30);
		LocalDateTime fecha2 = LocalDateTime.of(2022, 11, 30, 10, 50);
		
		restriccion1 = new EntreFecha(fecha1, fecha2);
		restriccion2 = new DiaDeSemana();
		restriccionMixta = new RestriccionTemporalMixta();
	}
	 
	@Test
	public void test01_unaRestriccionMixtaPuedeAgregarNuevasRestricciones() {
		restriccionMixta.addRetriccionTemporal(restriccion1);
		assertTrue(restriccionMixta.getRetricciones().contains(restriccion1));
	}	
	
	@Test
	public void test02_unaRestriccionMixtaEvaluaSiTodasLasRestriccionesCumplen() {
		restriccionMixta.addRetriccionTemporal(restriccion1);
		restriccionMixta.addRetriccionTemporal(restriccion2);
		assertTrue(restriccionMixta.cumpleLaRestricion(LocalDateTime.of(2022, 11, 25, 10, 50)));
	}
	
	
}
