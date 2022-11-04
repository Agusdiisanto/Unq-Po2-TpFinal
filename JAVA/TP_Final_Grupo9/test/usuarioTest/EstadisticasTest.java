package usuarioTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import usuario.Estadisticas;

public class EstadisticasTest {
	private Estadisticas estadisticas1;
	
	@BeforeEach
    public void setUp() {
		estadisticas1 = new Estadisticas(10, 50, 10);
	}
	
	@Test
	public void test01_unasEstadisticasTienenSatisfaccion() {
		assertEquals(estadisticas1.getSatisfaccion(), 10);
	}
	
	@Test
	public void test02_unasEstadisticasTienenRecompensa() {
		assertEquals(estadisticas1.getRecompensa(), 50);
	}
	
	@Test
	public void test03_unasEstadisticasTienenUnaCantidadDeRecolecciones() {
		assertEquals(estadisticas1.getCantidadDeMuestrasRecolectadas(), 10);
	}
}
