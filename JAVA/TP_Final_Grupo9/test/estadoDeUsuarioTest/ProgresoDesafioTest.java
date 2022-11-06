package estadoDeUsuarioTest;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.only;
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
	public void test01_cuandoUnProgresoConoceElDesafioActual() {
		assertEquals(progreso.getDesafioActual(), desafio);
	}
	
	@Test
	public void test02_cuandoUnProgresoConoceElPuntajeDelUsuarioCuandoRecienArrancoElDesafio() {
		assertEquals(progreso.getPuntaje(), 0);
	}
	
	@Test
	public void test03_unProgresoSabeDeSuEstadoInicial() {
		assertEquals(progreso.getEstado(), progresoEnCurso);
	}
	
	@Test
	public void test04_cuandoSeIniciaElProsesoDesafioEstaEnCurso() {
		
		LocalDateTime fecha = LocalDateTime.now();
		
		when(progresoEnCurso.esDesafioEnCurso(progreso,fecha)).thenReturn(true);
		assertTrue(progreso.esDesafioActual(fecha));
		verify(progresoEnCurso,only()).esDesafioEnCurso(progreso,fecha);
	}
	
	@Test
	public void test05_cuandoSeIniciaElProsesoDesafioNoEstaEnCurso() {
		LocalDateTime fecha = LocalDateTime.now();
		when(progresoEnCurso.esDesafioEnCurso(progreso,fecha)).thenReturn(false);
		assertFalse(progreso.esDesafioActual(fecha));
		verify(progresoEnCurso,only()).esDesafioEnCurso(progreso,fecha);
	}
	
	@Test
	public void test06_unProgresoDeDesafioSabeRecolectarMuestra() throws Exception {
		
		LocalDateTime fecha = LocalDateTime.now();
		
		progreso.recolectarMuestra(participante, muestra,fecha);
		verify(progresoEnCurso,only()).recolectarMuestra(progreso, muestra,fecha);
	}
	
	@Test
	public void test07_unProgresoDeDesafioSabeSiSeCompletoElDesafio() throws Exception {
		
		when(progresoEnCurso.completoElDesafio(progreso)).thenReturn(true);
		
		assertTrue(progreso.completoElDesafio());
		verify(progresoEnCurso,only()).completoElDesafio(progreso);
	}
	
	@Test
	public void test08_unProgresoDeDesafioSabeSiSeCompletoElDesafio() throws Exception {
		
		when(progresoEnCurso.completoElDesafio(progreso)).thenReturn(false);
		
		assertFalse(progreso.completoElDesafio());
		verify(progresoEnCurso,only()).completoElDesafio(progreso);
	}
	
	@Test
	public void test09_unProgresoDeDesafioSabeIncrementarElPuntajeAlParticipante() {
		progreso.sumarPuntajeAParticipante();
		assertEquals(progreso.getPuntaje(), 1);
	}
	
	@Test
	public void test10_unProgresoDeDesafioSabeRegistrarDesafioCompletado() {
		progreso.registrarDesafioCompletado(participante, 4);
		verify(progresoEnCurso,only()).registrarDesafioCompletado(participante, progreso, 4);
	}
	
	@Test
	public void test11_unProgresoDeDesafioSabeLaRecompensaDelDesafio() {
		when(desafio.getRecompensa()).thenReturn(455);
		assertEquals(progreso.recompensaDelDesafio(), 455);
		verify(desafio,only()).getRecompensa();
	}
	
	@Test
	public void test12_unProgresoSabeSiRecolectoAlmenosUnaMuestraElParticipante() {
		progreso.sumarPuntajeAParticipante();
		assertTrue(progreso.recolectoAlmenosUnaMuestra());
	}
	
	@Test
	public void test13_unProgresoSabeSiNoRecolectoAlmenosUnaMuestraElParticipante() {
		assertFalse(progreso.recolectoAlmenosUnaMuestra());
	}
	
	@Test
	public void test14_unProgresoSabeSiEsUnaMuestraValida() {
		when(desafio.estaLaMuestraDentroDelArea(muestra)).thenReturn(true);
		when(desafio.estaLaMuestraDentroDeLaRestriccion(muestra)).thenReturn(true);
		
		assertTrue(progreso.esUnaMuestraValida(muestra));
		verify(desafio,times(1)).estaLaMuestraDentroDelArea(muestra);
		verify(desafio,times(1)).estaLaMuestraDentroDeLaRestriccion(muestra);
		
	}
	
	@Test
	public void test15_unProgresoSabeSiNoEsUnaMuestraValida() {
		
		// Esta implementado el short circuit
		
		when(desafio.estaLaMuestraDentroDelArea(muestra)).thenReturn(false);
		when(desafio.estaLaMuestraDentroDeLaRestriccion(muestra)).thenReturn(true);
		
		assertFalse(progreso.esUnaMuestraValida(muestra));
		verify(desafio,times(1)).estaLaMuestraDentroDelArea(muestra);	
	}
	
	@Test
	public void test16_unProgresoSabeSiNoEsUnaMuestraValida() {
		
		// Esta implementado el short circuit
		
		when(desafio.estaLaMuestraDentroDelArea(muestra)).thenReturn(true);
		when(desafio.estaLaMuestraDentroDeLaRestriccion(muestra)).thenReturn(false);
		
		assertFalse(progreso.esUnaMuestraValida(muestra));
		verify(desafio,times(1)).estaLaMuestraDentroDelArea(muestra);
		verify(desafio,times(1)).estaLaMuestraDentroDeLaRestriccion(muestra);
		
	} 
	
	@Test
	public void test17_unProgresoSabeSiNoEsUnaMuestraValida() {
		
		// Esta implementado el short circuit
		
		when(desafio.estaLaMuestraDentroDelArea(muestra)).thenReturn(false);
		when(desafio.estaLaMuestraDentroDeLaRestriccion(muestra)).thenReturn(false);
		
		assertFalse(progreso.esUnaMuestraValida(muestra));
		verify(desafio,times(1)).estaLaMuestraDentroDelArea(muestra);
	}
	
	
}
