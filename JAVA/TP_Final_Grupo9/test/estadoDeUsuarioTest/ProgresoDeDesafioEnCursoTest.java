package estadoDeUsuarioTest;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import actividad.Desafio;
import estadoDeUsuario.ProgresoDeDesafioEnCurso;
import estadoDeUsuario.ProgresoDeDesafioTerminado;
import estadoDeUsuario.ProgresoDeDesafio;
import muestra.Muestra;

public class ProgresoDeDesafioEnCursoTest {
	ProgresoDeDesafioEnCurso progresoEnCurso;
	Muestra                  muestra;
	ProgresoDeDesafio        progresoActual;
	Desafio                  desafio;
	
	@BeforeEach
	public void setUp() {
		muestra		    = mock(Muestra.class);
		progresoActual  = mock(ProgresoDeDesafio.class);
		desafio		    = mock(Desafio.class);
		progresoEnCurso = new ProgresoDeDesafioEnCurso();
	}
	
	@Test
	public void test01_unProgresoIndicaSiElDesafioEstaEnCurso() {
		LocalDateTime fecha = LocalDateTime.now();
		
		when(progresoActual.getDesafioActual()).thenReturn(desafio);
		when(desafio.estaDentroDeLaRestriccion(fecha)).thenReturn(true);
		
		assertTrue(progresoEnCurso.esDesafioEnCurso(progresoActual,fecha));
		verify(progresoActual,times(1)).getDesafioActual();
	}
	
	@Test
	public void test02_unProgresoIndicaSiElDesafioNoEstaEnCurso() {
		LocalDateTime fecha = LocalDateTime.now();
		
		when(progresoActual.getDesafioActual()).thenReturn(desafio);
		when(desafio.estaDentroDeLaRestriccion(fecha)).thenReturn(false);
		
		assertFalse(progresoEnCurso.esDesafioEnCurso(progresoActual,fecha));
		verify(progresoActual,times(1)).getDesafioActual();	
	}
	
	// REVISAR
	@Test
	public void test03_unProgresoRecolectaUnaMuestra() throws Exception {
		LocalDateTime fecha = LocalDateTime.now();
		
		when(progresoActual.getDesafioActual()).thenReturn(desafio);
		when(desafio.estaDentroDeLaRestriccion(fecha)).thenReturn(true);
		when(progresoActual.esUnaMuestraValida(muestra)).thenReturn(true);
		
		assertTrue(progresoEnCurso.esDesafioEnCurso(progresoActual,fecha));
		progresoEnCurso.recolectarMuestra(progresoActual, muestra, fecha);
		assertEquals(progresoActual.getPuntaje(), 0);
		verify(progresoActual,times(3)).getDesafioActual();
		verify(progresoActual,times(1)).esUnaMuestraValida(muestra);
	}
	
	@Test
	public void test04_unProgresoNoRecolectaUnaMuestraInvalida() throws Exception {
		LocalDateTime fecha = LocalDateTime.of(2023, 01, 01, 00, 00);
		
		when(progresoActual.getDesafioActual()).thenReturn(desafio);
		when(desafio.estaDentroDeLaRestriccion(fecha)).thenReturn(false);
		
		assertFalse(progresoEnCurso.esDesafioEnCurso(progresoActual,fecha));
		progresoEnCurso.recolectarMuestra(progresoActual, muestra, fecha);
		assertEquals(progresoActual.getPuntaje(), 0);
		verify(progresoActual,times(2)).getDesafioActual();
	}
	
	@Test
	public void test05_unProgresoNoRecolectaUnaMuestraInvalida() throws Exception {
		LocalDateTime fecha = LocalDateTime.of(2023, 01, 01, 00, 00);
		
		when(progresoActual.getDesafioActual()).thenReturn(desafio);
		when(progresoActual.esUnaMuestraValida(muestra)).thenReturn(false);
		when(desafio.estaDentroDeLaRestriccion(fecha)).thenReturn(true);
		
		assertTrue(progresoEnCurso.esDesafioEnCurso(progresoActual,fecha));
		progresoEnCurso.recolectarMuestra(progresoActual, muestra, fecha);
		assertEquals(progresoActual.getPuntaje(), 0);
		verify(progresoActual,times(2)).getDesafioActual();
		verify(progresoActual,times(1)).esUnaMuestraValida(muestra);
		verify(desafio,times(2)).estaDentroDeLaRestriccion(fecha);
	}
	
	@Test
	public void test06_unProgresoIndicaSiCompletoElDesafio() throws Exception {
		when(progresoActual.getDesafioActual()).thenReturn(desafio);
		when(progresoActual.getPuntaje()).thenReturn(5);
		when(desafio.getCantidadDeMuestrasARecolectar()).thenReturn(5);
		
		assertTrue(progresoEnCurso.completoElDesafio(progresoActual));
		verify(progresoActual,times(1)).getDesafioActual();
		verify(progresoActual,times(1)).getPuntaje();
		verify(desafio,times(1)).getCantidadDeMuestrasARecolectar();
	}
	
	@Test
	public void test07_unProgresoIndicaSiNoCompletoElDesafio() throws Exception {
		when(progresoActual.getDesafioActual()).thenReturn(desafio);
		when(progresoActual.getPuntaje()).thenReturn(2);
		when(desafio.getCantidadDeMuestrasARecolectar()).thenReturn(5);
		
		assertFalse(progresoEnCurso.completoElDesafio(progresoActual));
		verify(progresoActual,times(1)).getDesafioActual();
		verify(progresoActual,times(1)).getPuntaje();
		verify(desafio,times(1)).getCantidadDeMuestrasARecolectar();
	}

	// REVISAR
	@Test
	public void test08_unProgresoVerificaSiCompletoElDesafio() throws Exception {
		ProgresoDeDesafioTerminado progresoTerminado = new ProgresoDeDesafioTerminado();
		when(progresoActual.getDesafioActual()).thenReturn(desafio);
		when(progresoActual.getPuntaje()).thenReturn(5);
		when(progresoActual.getEstado()).thenReturn(progresoTerminado);
		when(desafio.getCantidadDeMuestrasARecolectar()).thenReturn(5);
		
		assertTrue(progresoEnCurso.completoElDesafio(progresoActual));
		progresoEnCurso.verificarSiCompletoElDesafio(progresoActual);
		assertEquals(progresoActual.getEstado(), progresoTerminado);
		verify(progresoActual,times(2)).getDesafioActual();
		verify(progresoActual,times(2)).getPuntaje();
		verify(desafio,times(2)).getCantidadDeMuestrasARecolectar();
	}

	// REVISAR
	@Test
	public void test09_unProgresoVerificaSiNoCompletoElDesafio() throws Exception {
		ProgresoDeDesafioEnCurso progresoEnCurso = new ProgresoDeDesafioEnCurso();
		when(progresoActual.getDesafioActual()).thenReturn(desafio);
		when(progresoActual.getPuntaje()).thenReturn(2);
		when(progresoActual.getEstado()).thenReturn(progresoEnCurso);
		when(desafio.getCantidadDeMuestrasARecolectar()).thenReturn(5);
		
		assertFalse(progresoEnCurso.completoElDesafio(progresoActual));
		progresoEnCurso.verificarSiCompletoElDesafio(progresoActual);
		assertEquals(progresoActual.getEstado(), progresoEnCurso);
		verify(progresoActual,times(2)).getDesafioActual();
		verify(progresoActual,times(2)).getPuntaje();
		verify(desafio,times(2)).getCantidadDeMuestrasARecolectar();
	}
}
