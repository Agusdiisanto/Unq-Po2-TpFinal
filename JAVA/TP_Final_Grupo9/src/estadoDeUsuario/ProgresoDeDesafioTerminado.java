package estadoDeUsuario;

import java.time.LocalDateTime;

import muestra.Muestra;
import usuario.IParticipante;

public class ProgresoDeDesafioTerminado extends EstadoDeProgreso {
	
	@Override
	public void recolectarMuestra(ProgresoDesafio progresoDesafio, Muestra muestra, LocalDateTime fecha) throws Exception {
		throw new RuntimeException("Ya no puedes recolectar, el desafio ya ha terminado");	
	} 

	@Override
	public void verificarSiCompletoElDesafio(ProgresoDesafio progreso) {
		throw new RuntimeException("Ya no puedes verificar el progreso del desafio porque ya ha terminado");	
	}
	 
	@Override
	public void registrarDesafioCompletado(IParticipante participante, ProgresoDesafio progresoDesafio, int sastifaccion) {
		participante.registrarDesafioCompletado(progresoDesafio.getDesafioActual(),progresoDesafio.recompensaDelDesafio(),progresoDesafio.getDesafioActual().getCantidadDeMuestrasARecolectar(), 5);
	}
	
}
