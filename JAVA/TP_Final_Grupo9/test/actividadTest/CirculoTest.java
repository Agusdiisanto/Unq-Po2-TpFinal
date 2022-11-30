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
		
		when(coordenada1.getX()).thenReturn(10.0);
		when(coordenada1.getY()).thenReturn(10.0);
		when(coordenada2.getX()).thenReturn(-2.0);
		when(coordenada2.getY()).thenReturn(4.0);
		when(coordenada3.getX()).thenReturn(9.0);
		when(coordenada3.getY()).thenReturn(9.0);
	}
	
	@Test
	public void test01_unCirculoTieneUnCentroConCoordenadaX() {
		assertEquals(10, circulo.getCentro().getX());
		verify(coordenada1, only()).getX();
	}
	
	@Test
	public void test02_unCirculoTieneUnCentroConCoordenadaY() {
		assertEquals(10, circulo.getCentro().getY());
		verify(coordenada1, only()).getY();
	}
	
	@Test
	public void test03_unCirculoTieneUnRadio() {
		assertEquals(4, circulo.getRadio());
	}
	
	@Test
	public void test04_unCirculoIndicaSiContieneUnaCoordenada() {
		assertTrue(circulo.includes(coordenada3));
		verify(coordenada1, times(1)).getX();
		verify(coordenada1, times(1)).getY();
		verify(coordenada3, times(1)).getX();
		verify(coordenada3, times(1)).getY();
	}
	
	@Test
	public void test05_unCirculoIndicaSiNoContieneUnaCoordenada() {
		assertFalse(circulo.includes(coordenada2));
		verify(coordenada1, times(1)).getX();
		verify(coordenada1, times(1)).getY();
		verify(coordenada2, times(1)).getX();
		verify(coordenada2, times(1)).getY();
	}
}
