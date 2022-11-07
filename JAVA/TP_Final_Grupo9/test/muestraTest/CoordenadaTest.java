package muestraTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import muestra.Coordenada;

public class CoordenadaTest {
	Coordenada coordenada;
	
	@BeforeEach
	public void setUp() {
		coordenada = new Coordenada(15,3);
	}
	
	@Test
	public void test01_UnaCoordenadaSabeSuEjeX() {
		assertEquals(15, coordenada.getCoordenadaX());
	}
	
	@Test
	public void test02_UnaCoordenadaSabeSuEjeY() {
		assertEquals(3, coordenada.getCoordenadaY());
	}
}
