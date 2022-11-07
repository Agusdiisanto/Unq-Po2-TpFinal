package estadoDeUsuarioTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import estadoDeUsuario.ProgresoDeDesafio;
import estadoDeUsuario.ProgresoDeDesafioExpirado;
import muestra.Muestra;
import usuario.IParticipante;

public class ProgresoDeDesafioExpiradoTest {
	private ProgresoDeDesafioExpirado expirado;
	private Muestra                   muestra;
	private ProgresoDeDesafio         progresoActual;
	private IParticipante			  participante;
	
	@BeforeEach
	public void setUp() {
		muestra		    = mock(Muestra.class);
		progresoActual  = mock(ProgresoDeDesafio.class);
		participante	= mock(IParticipante.class);
		expirado		= new ProgresoDeDesafioExpirado();
	}
	
	@Test
	public void test01_unProgresoExpiradoNoPermiteRecolectarMuestras() throws Exception {
		LocalDateTime fecha = LocalDateTime.now();
	    assertThrows(
	    	RuntimeException.class,
	    	() -> {expirado.recolectarMuestra(progresoActual, muestra, fecha);},
	    	"Ya no puedes recolectar, el desafío ya ha expirado"
	    );
	}
	
	@Test
	public void test02_unProgresoExpiradoNoPermiteConcederRecompensas() throws Exception {
		assertThrows(
			RuntimeException.class,
			() -> {expirado.registrarDesafioCompletado(participante, progresoActual, 10);},
			"Ya no puedes conceder recompensa, el desafío ya ha expirado"
		);
	}
	
	@Test
	public void test03_unProgresoExpiradoNoPermiteVerificarSiCompletoElDesafio() throws Exception {
		assertThrows(
			RuntimeException.class,
			() -> {expirado.verificarSiCompletoElDesafio(progresoActual);},
			"Ya no puedes verificar el progreso, el desafío ya ha expirado"
		);
	}
	
	@Test
	public void test04_unProgresoExpiradoIndicaSiElDesafioEstaEnCurso() {
		LocalDateTime fecha = LocalDateTime.now();
		assertFalse(expirado.esDesafioEnCurso(progresoActual,fecha));
	}
	
	@Test
	public void test05_unProgresoExpiradoIndicaSiElDesafioEstaEnCurso() {
		assertFalse(expirado.completoElDesafio(progresoActual));
	}
}
