package estadoDeUsuarioTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import estadoDeUsuario.EstadoDeProgreso;
import estadoDeUsuario.ProgresoDeDesafio;
import muestra.Muestra;

public class EstadoDeProgresoTest {
	
	private EstadoDeProgreso estado;
	private ProgresoDeDesafio progreso;
	private Muestra muestra;
	
	@BeforeEach
	public void setUp() {
		estado = new EstadoDeProgreso();
		progreso = mock(ProgresoDeDesafio.class);
		muestra = mock(Muestra.class);
	}
	
	@Test
	public void test01_unEstadoNuncaSeEncuentraEnCurso() {
		assertFalse(estado.esDesafioEnCurso(progreso, LocalDateTime.now()));
	}
	
	@Test
	public void test02_unEstadoNuncaSeHaCompletado() {
		assertFalse(estado.completoElDesafio(progreso));
	}
	
	@Test
	public void test04_unEstadoNoSabeRecolectar() throws Exception {
		//assertEquals(estado.recolectarMuestra(progreso, muestra, LocalDateTime.now());
		
	}
	
	@Test
	public void test05_unEstadoNoSabeVerificarSiCompletoElDesafio() {
		assertFalse(estado.esDesafioEnCurso(progreso, LocalDateTime.now()));
	}
	
	@Test
	public void test06_unEstadoNoSabeRegistrarDesafioCompletado() {
		assertFalse(estado.esDesafioEnCurso(progreso, LocalDateTime.now()));
	}
}
