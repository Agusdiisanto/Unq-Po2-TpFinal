package estadoDeUsuario;

import java.time.LocalDateTime;

import muestra.Muestra;
import usuario.IParticipante;

/**
 * 
 * Esta calse se encarga de verificar el estado de un proyecto.
 *
 */

public class EstadoDeProgreso implements IEstadoDelProgreso {

	@Override
	public boolean esDesafioEnCurso(ProgresoDeDesafio progresoDesafio, LocalDateTime fecha) {
		return false;
	} 

	@Override
	public void recolectarMuestra(ProgresoDeDesafio progresoDesafio, Muestra muestra, LocalDateTime fecha) throws Exception {}
	
	@Override
	public void registrarDesafioCompletado(IParticipante participante, ProgresoDeDesafio progresoDesafio, int sastifaccion) {}
	
	@Override
	public boolean completoElDesafio(ProgresoDeDesafio progresoDesafio) {
		return false;
	}

	@Override
	public void verificarSiCompletoElDesafio(ProgresoDeDesafio progreso) {}
}
