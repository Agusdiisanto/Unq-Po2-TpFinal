package desafiostTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import caracteristicas.desafio.Area;
import caracteristicas.desafio.Caracteristica;
import caracteristicas.desafio.Dificultad;
import caracteristicas.desafio.RestriccionTemporal;
import desafios.Desafio;
import muestra.Coordenada;
import muestra.Muestra;
import usuario.IParticipante;


public class DesafioTest {
	private Area				area;
	private RestriccionTemporal restriccionTemporal1;
	private RestriccionTemporal restriccionTemporal2;
	private RestriccionTemporal restriccionTemporal3;
	private Desafio				desafio1;
	private Desafio				desafio2;
	private Desafio				desafio3;
	private Coordenada			coordenada1;
	private Coordenada			coordenada2;
	private Muestra				muestra1;
	private Muestra				muestra2;
	private IParticipante		participante1;
	private Caracteristica		caracteristica1;
	private Caracteristica		caracteristica2;
	private Caracteristica		caracteristica3;
		
	@BeforeEach
	public void setUp() {
	 area				  = mock(Area.class);
	 coordenada1		  = mock(Coordenada.class);
	 coordenada2		  = mock(Coordenada.class);
	 restriccionTemporal1 = mock(RestriccionTemporal.class);
	 restriccionTemporal2 = mock(RestriccionTemporal.class);
	 restriccionTemporal3 = mock(RestriccionTemporal.class);
	 caracteristica1	  = mock(Caracteristica.class);
	 caracteristica2	  = mock(Caracteristica.class);
	 caracteristica3	  = mock(Caracteristica.class);
	 participante1		  = mock(IParticipante.class);
	 muestra1			  = new Muestra(null, null, coordenada1);
	 muestra2			  = new Muestra(null, null, coordenada2);
	 desafio1			  = new Desafio(area, restriccionTemporal1, 30, Dificultad.MEDIO, 50);
	 desafio2			  = new Desafio(area, restriccionTemporal2, 30, Dificultad.MEDIO, 50);
	 desafio3			  = new Desafio(area, restriccionTemporal3, 30, Dificultad.MEDIO, 50);
	 
	 when(area.getLatitud()).thenReturn(10);
	 when(area.getLongitud()).thenReturn(10);
	 when(area.getRadio()).thenReturn(10);
	 when(coordenada1.getCoordenadaX()).thenReturn(5);
	 when(coordenada1.getCoordenadaY()).thenReturn(5);
	 when(coordenada2.getCoordenadaX()).thenReturn(1);
	 when(coordenada2.getCoordenadaY()).thenReturn(1);
	 when(restriccionTemporal1.getFechaDeInicio()).thenReturn(LocalDateTime.of(2021, 10, 30,5,56));
	 when(restriccionTemporal1.getFechaDeCierre()).thenReturn(LocalDateTime.of(2023, 10, 30,5,56));
	 when(restriccionTemporal2.getFechaDeInicio()).thenReturn(LocalDateTime.of(2020, 10, 30,5,56));
	 when(restriccionTemporal2.getFechaDeCierre()).thenReturn(LocalDateTime.of(2021, 10, 30,5,56));
	 when(restriccionTemporal3.getFechaDeInicio()).thenReturn(LocalDateTime.of(2023, 10, 30,5,56));
	 when(restriccionTemporal3.getFechaDeCierre()).thenReturn(LocalDateTime.of(2024, 10, 30,5,56));
	 when(caracteristica1.getDescripicion()).thenReturn("Agustin es mejor");
	 when(caracteristica1.getAfinidad()).thenReturn(9.9);
	 when(caracteristica2.getDescripicion()).thenReturn("Tomi es mejor");
	 when(caracteristica2.getAfinidad()).thenReturn(5.5);
	 when(caracteristica3.getDescripicion()).thenReturn("Santi es mejor");
	 when(caracteristica3.getAfinidad()).thenReturn(7.7);
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
		assertEquals(desafio1.getCantidadDeMuestrasARecolectar(), 30);
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
		desafio1.agregarParticipanteAlDesafio(participante1);
		assertEquals(desafio1.getParticipantes().size(), 1);
		assertTrue(desafio1.getParticipantes().contains(participante1));
	}
	
	@Test
	public void test08_unDesafioNoTieneParticipantesRepetidos() {
		desafio1.agregarParticipanteAlDesafio(participante1);
		desafio1.agregarParticipanteAlDesafio(participante1);
		assertEquals(desafio1.getParticipantes().size(), 1);
		assertTrue(desafio1.getParticipantes().contains(participante1));
	}
	
	@Test
	public void test09_unDesafioConcluidoNoAceptaParticipantes() {
		desafio2.agregarParticipanteAlDesafio(participante1);
		assertTrue(desafio2.getParticipantes().isEmpty());
	}
	
	@Test
	public void test10_unDesafioNuevoNoTieneCaracteristicas() {
		assertTrue(desafio1.getCaracteristicas().isEmpty());
	}
	
	@Test
	public void test11_unDesafioTieneCaracteristicas() {
		desafio1.agregarCaracteristica(caracteristica1);
		assertEquals(desafio1.getCaracteristicas().size(), 1);
		assertTrue(desafio1.getCaracteristicas().contains(caracteristica1));
	}
	
	@Test
	public void test12_unDesafioNoTieneCaracteristicasRepetidas() {
		desafio1.agregarCaracteristica(caracteristica1);
		desafio1.agregarCaracteristica(caracteristica1);
		assertEquals(desafio1.getCaracteristicas().size(), 1);
		assertTrue(desafio1.getCaracteristicas().contains(caracteristica1));
	}
	
	@Test
	public void test13_unDesafioEsUnDesafio() {
		assertTrue(desafio1.esDesafio());
	}
	
	@Test
	public void test14_unDesafioEstaActivo() {
		assertTrue(desafio1.esDesafioActivo());
	}
	
	@Test
	public void test15_unDesafioNoEstaActivoPorqueEstaConcluido() {
		assertFalse(desafio2.esDesafioActivo());
	}
	
	@Test
	public void test16_unDesafioNoEstaActivoPorqueEstaPorIniciar() {
		assertFalse(desafio3.esDesafioActivo());
	}
	
	@Test
	public void test17_unDesafioIndicaSiUnaMuestraEstaDentroDelArea() {
		assertTrue(desafio1.estaLaMuestraDentroDelArea(muestra1));
	}
	
	@Test
	public void test18_unDesafioIndicaSiUnaMuestraNoEstaDentroDelArea() {
		assertFalse(desafio1.estaLaMuestraDentroDelArea(muestra2));
	}
	
	@Test
	public void test19_unDesafioIndicaSiUnaMuestraNoEstaDentroDelArea() {
		assertFalse(desafio1.estaLaMuestraDentroDelArea(muestra2));
	}
}
