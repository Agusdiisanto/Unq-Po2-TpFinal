package caracteristicas.desafio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DificultadTest {
	
	Dificultad dificultad;
	
	@BeforeEach
	public void setUp() {
		dificultad = Dificultad.MUY_DIFICIL;
	}
	
	@Test
	public void test01_UnaDificultadTieneAsociadoUnNivel() {
		assertEquals(5, dificultad.getNivelDeDificultad());
	}
}
