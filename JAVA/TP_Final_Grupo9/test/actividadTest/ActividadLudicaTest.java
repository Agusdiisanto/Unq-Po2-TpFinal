package actividadTest;

import static org.junit.Assert.assertFalse;


import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import actividad.ActividadLudica;
import actividad.Area;
import actividad.RestriccionTemporal;

public class ActividadLudicaTest {
	Area				area1;
	RestriccionTemporal restriccionTemporal1;
	ActividadLudica				actividad1;
	
	@BeforeEach
    public void setUp() {
		area1				 = new Area(10, 10, 5);
		restriccionTemporal1 = new RestriccionTemporal(LocalDateTime.now(), LocalDateTime.now());
		actividad1			 = new ActividadLudica();
	}
	
	// En este test se quiere comprobar que las actividades ludicas por defecto no son desafio
	// Podria ser clase abstracta la ActividadLudica pero no podriamos testear este mensaje.
	
	@Test
	public void test01_unaActividadNoEsUnDesafioPorDefecto() {
		assertFalse(actividad1.esDesafio());
	}
}
