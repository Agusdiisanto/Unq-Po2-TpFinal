package estadoDeUsuarioTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import actividad.Desafio;
import estadoDeUsuario.ProgresoDeDesafioEnCurso;
import estadoDeUsuario.ProgresoDesafio;
import muestra.Muestra;

public class ProgresoDeDesafioEnCursoTest {
	
	ProgresoDeDesafioEnCurso progresoCurso;
	Muestra                  muestra;
	ProgresoDesafio        progresoActual;
	Desafio                desafio;
	
	@BeforeEach
	public void setUp() {
		muestra = mock(Muestra.class);
		progresoActual = mock(ProgresoDesafio.class);
		desafio = mock(Desafio.class);
		progresoCurso = new ProgresoDeDesafioEnCurso();
	}
	
	@Test
	public void test01_unProgresoDeDesafioSabeSiElDesafioEstaEnCurso() {
		
		LocalDateTime fecha = LocalDateTime.now();
		
		when(progresoActual.getDesafioActual()).thenReturn(desafio);
		when(desafio.estaDentroDeLaRestriccion(fecha)).thenReturn(true);
		
		assertTrue(progresoCurso.esDesafioEnCurso(progresoActual,fecha));
		verify(progresoActual,times(1)).getDesafioActual();
	}
	
	@Test
	public void test02_unProgresoDeDesafioSabeSiElDesafioNoEstaEnCurso() {
		
		LocalDateTime fecha = LocalDateTime.now();
		
		when(progresoActual.getDesafioActual()).thenReturn(desafio);
		when(desafio.estaDentroDeLaRestriccion(fecha)).thenReturn(false);
		
		assertFalse(progresoCurso.esDesafioEnCurso(progresoActual,fecha));
		verify(progresoActual,times(1)).getDesafioActual();
		
	}
	
	
	
	
}
