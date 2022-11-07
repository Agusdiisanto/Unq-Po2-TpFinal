package estadoDeUsuarioTest;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import actividad.Desafio;
import estadoDeUsuario.ProgresoDeDesafio;
import estadoDeUsuario.ProgresoDeDesafioTerminado;
import muestra.Muestra;
import usuario.IParticipante;

public class ProgresoDeDesafioTerminadoTest {
	private ProgresoDeDesafioTerminado terminado;
	private Muestra                    muestra;
	private Desafio					   desafio;
	private IParticipante			   participante;
	private ProgresoDeDesafio          progreso;
	
	@BeforeEach
	public void setUp() {
		muestra		    = mock(Muestra.class);
		participante	= mock(IParticipante.class);
		desafio			= mock(Desafio.class);
		terminado		= new ProgresoDeDesafioTerminado();
		progreso		= new ProgresoDeDesafio(desafio,terminado);
	}
	
	@Test
	public void test01_unProgresoTerminadoNoPermiteRecolectarMuestras() throws Exception {
		LocalDateTime fecha = LocalDateTime.now();
		assertThrows(
			RuntimeException.class,
			() -> {terminado.recolectarMuestra(progreso, muestra, fecha);},
			"Ya no puedes recolectar, el desafío ya ha expirado"
		);
	}
	
	@Test
	public void test02_unProgresoTerminadoNoPermiteConcederRecompensas() throws Exception {
		assertThrows(
			RuntimeException.class,
			() -> {terminado.verificarSiCompletoElDesafio(progreso);},
			"Ya no puedes verificar el progreso, el desafío ya ha terminado"
		);
	}
	
	@Test
	public void test03_unProgresoTerminadoRegistraElDesafioCompletado() throws Exception {
		when(desafio.getCantidadDeMuestrasARecolectar()).thenReturn(4);
		progreso.registrarDesafioCompletado(participante, 4);
		verify(participante,only()).registrarDesafioCompletado(desafio, 0, 4, 5);
	}
}
