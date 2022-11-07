package estadoDeUsuario;

import java.time.LocalDateTime;

import muestra.Muestra;
import usuario.IParticipante;

/**
 * 
 * Esta clase se encarga de ver si un desafío está terminado.
 *
 */

public class ProgresoDeDesafioTerminado extends EstadoDeProgreso {
	
	@Override
	public void recolectarMuestra(ProgresoDeDesafio progresoDesafio, Muestra muestra, LocalDateTime fecha) throws Exception {
		throw new RuntimeException("Ya no puedes recolectar, el desafío ya ha terminado");	
	}

	@Override
	public void verificarSiCompletoElDesafio(ProgresoDeDesafio progreso) {
		throw new RuntimeException("Ya no puedes verificar el progreso, el desafío ya ha terminado");	
	}
	 
	@Override
	public void registrarDesafioCompletado(IParticipante participante, ProgresoDeDesafio progreso, int sastifaccion) {
		participante.registrarDesafioCompletado(progreso.getDesafioActual(),
												progreso.recompensaDelDesafio(),
												progreso.getDesafioActual().getCantidadDeMuestrasARecolectar(),
												5);
	}
}
