package estadoDeUsuario;

import java.time.LocalDateTime; 
import muestra.Muestra;
import usuario.IParticipante;
 
/**
 * 
 * Esta clase se encarga ver si un desafío está en curso.
 *
 */

public class ProgresoDeDesafioEnCurso implements IEstadoDelProgreso{

	@Override
	public boolean esDesafioEnCurso(ProgresoDeDesafio progreso, LocalDateTime fecha) {
		return progreso.getDesafioActual().esFechaValida(fecha); 
	}
	
	@Override 
	public void recolectarMuestra(ProgresoDeDesafio progreso, Muestra muestra, LocalDateTime fecha) throws Exception {
		if (this.esDesafioEnCurso(progreso, fecha)) {
			this.recolectarMuestraSiAunNoHaExpirado(progreso, muestra);	
		}
		else {
			progreso.setEstado(new ProgresoDeDesafioExpirado());
		}
	}
	
	@Override
	public boolean completoElDesafio(ProgresoDeDesafio progreso) {
		return progreso.getPuntaje() == progreso.getDesafioActual().getObjetivo();
	}
	
	@Override
	public void verificarSiCompletoElDesafio(ProgresoDeDesafio progreso) {
		if (this.completoElDesafio(progreso)) {
			progreso.setEstado(new ProgresoDeDesafioTerminado());
		}
	}
	
	// ============================ PRIVATE METHODS ============================
	private void recolectarMuestraSiAunNoHaExpirado(ProgresoDeDesafio progreso, Muestra muestra) throws Exception {
		if (progreso.esUnaMuestraValida(muestra)) {
			progreso.sumarPuntajeAParticipante();
			this.verificarSiCompletoElDesafio(progreso);
		}
	}
	
	@Override 
	public void registrarDesafioCompletado(IParticipante participante, ProgresoDeDesafio progresoDesafio,
			int sastifaccion) throws Exception {
		throw new RuntimeException("No se puede registrar, el desafio sigue en curso"); 
	}
}
