package estadoDeUsuario;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import actividad.Desafio;
import muestra.Muestra;
import usuario.IParticipante;

public class ProgresoDesafioTest {
	
	Desafio desafio;
	Muestra muestra;
	IParticipante participante;
	ProgresoDesafio progreso;
	ProgresoDeDesafioEnCurso progresoEnCurso;

	@BeforeEach
	public void setUp() {
		
		desafio = mock(Desafio.class); 
		muestra = mock(Muestra.class);
		participante = mock(IParticipante.class);
		progresoEnCurso = mock(ProgresoDeDesafioEnCurso.class);
		
		progreso = new ProgresoDesafio(desafio,progresoEnCurso);
		
		
	}
	
	@Test
	public void test01_cuandoSeIniciaElProsesoDesafioArrancaEnCurso() {
		when(progresoEnCurso.esDesafioEnCurso(progreso)).thenReturn(true);
		assertTrue(progreso.esDesafioActual());
	}
	
	@Test
	public void test02_cuandoUnProgresoConoceElDesafioActual() {
		assertEquals(progreso.getDesafioActual(), desafio);
	}
	
	@Test
	public void test03_cuandoUnProgresoConoceElPuntajeDelUsuarioCuandoRecienArrancoElDesafio() {
		assertEquals(progreso.getPuntaje(), 0);
	}
	
	
	
	
}
