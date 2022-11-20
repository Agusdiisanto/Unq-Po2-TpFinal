package actividadTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import actividad.Circulo;
import muestra.Coordenada;

public class CirculoTest {
	private Coordenada coordenada1;
	private Coordenada coordenada2;
	private Coordenada coordenada3;
	private Circulo	   circulo;

	@BeforeEach
	public void setUp() {
		coordenada1 = mock(Coordenada.class);
		coordenada2 = mock(Coordenada.class);
		coordenada3 = mock(Coordenada.class);
		circulo     = new Circulo(coordenada1, 4);
		
		when(coordenada1.getCoordenadaX()).thenReturn(10.0);
		when(coordenada1.getCoordenadaY()).thenReturn(10.0);
		when(coordenada2.getCoordenadaX()).thenReturn(-2.0);
		when(coordenada2.getCoordenadaY()).thenReturn(4.0);
		when(coordenada3.getCoordenadaX()).thenReturn(9.0);
		when(coordenada3.getCoordenadaY()).thenReturn(9.0);
	}
	
	@Test
	public void test01_unCirculoTieneUnCentroConCoordenadaX() {
		assertEquals(10, circulo.getCentro().getCoordenadaX());
		verify(coordenada1, only()).getCoordenadaX();
	}
	
	@Test
	public void test02_unCirculoTieneUnCentroConCoordenadaY() {
		assertEquals(10, circulo.getCentro().getCoordenadaY());
		verify(coordenada1, only()).getCoordenadaY();
	}
	
	@Test
	public void test03_unCirculoTieneUnRadio() {
		assertEquals(4, circulo.getRadio());
	}
	
	@Test
	public void test04_unCirculoIndicaSiContieneUnaCoordenada() {
		assertTrue(circulo.includes(coordenada3));
		verify(coordenada1, times(1)).getCoordenadaX();
		verify(coordenada1, times(1)).getCoordenadaY();
		verify(coordenada3, times(1)).getCoordenadaX();
		verify(coordenada3, times(1)).getCoordenadaY();
	}
	
	@Test
	public void test05_unCirculoIndicaSiNoContieneUnaCoordenada() {
		assertFalse(circulo.includes(coordenada2));
		verify(coordenada1, times(1)).getCoordenadaX();
		verify(coordenada1, times(1)).getCoordenadaY();
		verify(coordenada2, times(1)).getCoordenadaX();
		verify(coordenada2, times(1)).getCoordenadaY();
	}
}
