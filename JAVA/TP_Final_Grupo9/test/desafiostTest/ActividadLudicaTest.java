package desafiostTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import caracteristicas.desafio.Area;
import caracteristicas.desafio.Dificultad;
import caracteristicas.desafio.RestriccionTemporal;
import desafios.Desafio;

public class ActividadLudicaTest {
	Area				area1;
	RestriccionTemporal restriccionTemporal1;
	Desafio				actividad1;
	
	@BeforeEach
    public void setUp() {
		area1				 = new Area(10, 10, 5);
		restriccionTemporal1 = new RestriccionTemporal(LocalDateTime.now(), LocalDateTime.now());
		actividad1			 = new Desafio(area1, restriccionTemporal1, 5, Dificultad.FACIL, 10);
	}
	
	@Test
	public void test01_unaActividadNoEsUnDesafio() {
		assertTrue(actividad1.esDesafio());
	}
}
