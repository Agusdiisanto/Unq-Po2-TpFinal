package caracteristicas.desafio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CaracteristicasTest {
	
	
	Caracteristica caracterista;
	
	@BeforeEach
	public void setUp() {
		caracterista = new Caracteristica("Oro",3);
	}
	
	@Test
	public void test01_unaCaracteristicaTieneUnaDescripcion() {
		assertEquals("Oro", caracterista.getDescripicion());
	}
	
	@Test
	public void test02_unaCaracteristicaTieneUnaAfinidad() {
		assertEquals(3, caracterista.getAfinidad());
	}
	
	
	
}
