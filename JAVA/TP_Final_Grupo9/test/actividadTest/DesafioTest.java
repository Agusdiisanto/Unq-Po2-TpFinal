package actividadTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import actividad.Circulo;
import actividad.Caracteristica;
import actividad.Desafio;
import actividad.Dificultad;
import actividad.IRetriccionTemporal;
import muestra.Coordenada;
import muestra.Muestra;
import usuario.IParticipante;

public class DesafioTest {
	private Circulo					 area;
	private IRetriccionTemporal restriccionTemporal1;
	private IRetriccionTemporal restriccionTemporal2;
	private IRetriccionTemporal restriccionTemporal3;
	private Desafio					 desafio1;
	private Desafio					 desafio2;
	private Desafio					 desafio3;
	private Coordenada				 coordenada1;
	private Coordenada				 coordenada2;
	private Muestra					 muestra1;
	private Muestra					 muestra2;
	private IParticipante			 participante1;
	private Caracteristica			 caracteristica1;
	private Caracteristica			 caracteristica2;
	private Caracteristica			 caracteristica3;
	private LocalDateTime 			 now;
	
	@BeforeEach
	public void setUp() {
		
		restriccionTemporal1 = mock(IRetriccionTemporal.class);
		restriccionTemporal2 = mock(IRetriccionTemporal.class);
		restriccionTemporal3 = mock(IRetriccionTemporal.class);
		
		caracteristica1	  	 = mock(Caracteristica.class);
		caracteristica2	  	 = mock(Caracteristica.class);
		caracteristica3	  	 = mock(Caracteristica.class);
		
		participante1		 = mock(IParticipante.class);
		muestra1             = mock(Muestra.class);
		area				 = mock(Circulo.class);
		
		desafio1			 = new Desafio(area, restriccionTemporal1, 30, Dificultad.MEDIO, 50);
		desafio2			 = new Desafio(area, restriccionTemporal2, 30, Dificultad.MEDIO, 50);
		desafio3			 = new Desafio(area, restriccionTemporal3, 30, Dificultad.MEDIO, 50);
		
		when(caracteristica1.getDescripicion()).thenReturn("Agustin es mejor");
		when(caracteristica1.getAfinidad()).thenReturn(9.9);
		when(caracteristica2.getDescripicion()).thenReturn("Tomi es mejor");
		when(caracteristica2.getAfinidad()).thenReturn(5.5);
		when(caracteristica3.getDescripicion()).thenReturn("Santi es mejor");
		when(caracteristica3.getAfinidad()).thenReturn(7.7);
		
		now = LocalDateTime.now();
	}
	
	@Test
	public void test01_unDesafioTieneUnArea() {
		assertEquals(desafio1.getArea(), area);
	}

	@Test
	public void test02_unDesafioTieneUnaRestriccionTemporal() {
		assertEquals(desafio1.getRestriccionTemporal(), restriccionTemporal1);
	}

	@Test
	public void test03_unDesafioTieneUnaCantidadDeMuestrasARecolectar() {
		assertEquals(desafio1.getObjetivo(), 30);
	}
	
	@Test
	public void test04_unDesafioTieneUnaDificultad() {
		assertEquals(desafio1.getDificultad(), Dificultad.MEDIO);
	}
	
	@Test
	public void test05_unDesafioTieneUnaRecompensa() {
		assertEquals(desafio1.getRecompensa(), 50);
	}
	
	@Test
	public void test06_unDesafioNuevoNoTieneParticipantes() {
		assertTrue(desafio1.getParticipantes().isEmpty());
	}
	
	@Test
	public void test07_unDesafioTieneParticipantes() {
		
		when(restriccionTemporal1.cumpleLaRestriccion(now)).thenReturn(true);
		
		desafio1.addParticipante(participante1, now);
		
		assertEquals(desafio1.getParticipantes().size(), 1);
		assertTrue(desafio1.getParticipantes().contains(participante1));
	}
	
	@Test
	public void test08_unDesafioNoTieneParticipantesRepetidos() {
		when(restriccionTemporal1.cumpleLaRestriccion(now)).thenReturn(true);
		desafio1.addParticipante(participante1, now);
		desafio1.addParticipante(participante1, now);
		assertEquals(desafio1.getParticipantes().size(), 1);
		assertTrue(desafio1.getParticipantes().contains(participante1));
	}
	
	@Test
	public void test09_unDesafioConcluidoNoAceptaParticipantes() {
		desafio2.addParticipante(participante1, now);
		assertTrue(desafio2.getParticipantes().isEmpty());
	}
	
	@Test
	public void test10_unDesafioNuevoNoTieneCaracteristicas() {
		assertTrue(desafio1.getCaracteristicas().isEmpty());
	}
	
	@Test
	public void test11_unDesafioTieneCaracteristicas() {
		desafio1.addCaracteristica(caracteristica1);
		assertEquals(desafio1.getCaracteristicas().size(), 1);
		assertTrue(desafio1.getCaracteristicas().contains(caracteristica1));
	}
	
	@Test
	public void test12_unDesafioNoTieneCaracteristicasRepetidas() {
		desafio1.addCaracteristica(caracteristica1);
		desafio1.addCaracteristica(caracteristica1);
		assertEquals(desafio1.getCaracteristicas().size(), 1);
		assertTrue(desafio1.getCaracteristicas().contains(caracteristica1));
	}
	
	@Test 
	public void test13_unDesafioEsUnDesafio() {
		assertTrue(desafio1.esDesafio());
	}
	
	@Test
	public void test14_unDesafioEstaActivo() {
		when(restriccionTemporal3.cumpleLaRestriccion(now)).thenReturn(true);
		assertTrue(desafio3.esActivo(now));
	}
	 
	@Test
	public void test15_unDesafioNoEstaActivo() {
		when(restriccionTemporal3.cumpleLaRestriccion(now)).thenReturn(false);
		assertFalse(desafio2.esActivo(now));
	}
	
	@Test
	public void test17_unDesafioIndicaSiIncluyeUnaMuestra() {
		coordenada1 = mock(Coordenada.class);
		muestra1	= mock(Muestra.class);
		when(muestra1.getCoordenada()).thenReturn(coordenada1);
		when(area.includes(coordenada1)).thenReturn(true);
		assertTrue(desafio1.includes(muestra1));
	}
	
	@Test
	public void test18_unDesafioIndicaSiUnaMuestraNoEstaDentroDelArea() {
		coordenada2 = mock(Coordenada.class);
		muestra2	= mock(Muestra.class);
		when(muestra2.getCoordenada()).thenReturn(coordenada2);
		when(area.includes(coordenada2)).thenReturn(false);
		assertFalse(desafio1.includes(muestra2));
	}
	
	@Test
	public void test19_unDesafioIndicaSiUnaFechaCumpleLaRestriccion() {
		when(restriccionTemporal1.cumpleLaRestriccion(now)).thenReturn(true);
		assertTrue(desafio1.esFechaValida(now));
		verify(restriccionTemporal1, times(1)).cumpleLaRestriccion(now);
	}
	
	@Test
	public void test20_unDesafioIndicaSiUnaFechaNoCumpleLaRestriccion() {
		when(restriccionTemporal1.cumpleLaRestriccion(now)).thenReturn(false);
		assertFalse(desafio1.esFechaValida(now));
		verify(restriccionTemporal1, times(1)).cumpleLaRestriccion(now);
	}
	
	@Test 
	public void test21_unDesafioIndicaSiUnaMuestraCumpleConLaRestriccion() {
		LocalDateTime fecha = LocalDateTime.of(2021, 10, 20, 10, 50);
		
		when(muestra1.getFechaYHoraDeRecoleccion()).thenReturn(fecha);
		when(restriccionTemporal1.cumpleLaRestriccion(fecha)).thenReturn(true);
		
		assertTrue(desafio1.esMuestraValida(muestra1));
		verify(restriccionTemporal1, times(1)).cumpleLaRestriccion(fecha);
		verify(muestra1, times(1)).getFechaYHoraDeRecoleccion();
	}
	
	@Test 
	public void test22_unDesafioIndicaSiUnaMuestraNoCumpleConLaRestriccion() {
		LocalDateTime fecha = LocalDateTime.of(2021, 10, 20, 10, 50);
		
		when(muestra1.getFechaYHoraDeRecoleccion()).thenReturn(fecha);
		when(restriccionTemporal1.cumpleLaRestriccion(fecha)).thenReturn(false);
		
		assertFalse(desafio1.esMuestraValida(muestra1));
		verify(restriccionTemporal1, times(1)).cumpleLaRestriccion(fecha);
		verify(muestra1, times(1)).getFechaYHoraDeRecoleccion();
	}
}
