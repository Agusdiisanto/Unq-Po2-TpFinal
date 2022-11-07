package estadoDeUsuario;

import java.time.LocalDateTime; 
import muestra.Muestra;
 
/**
 * 
 * 
 * Esta clase se encarga ver si un desafío está en curso.
 *
 */

public class ProgresoDeDesafioEnCurso extends EstadoDeProgreso{

	@Override
	public boolean esDesafioEnCurso(ProgresoDeDesafio progreso, LocalDateTime fecha) {
		return progreso.getDesafioActual().estaDentroDeLaRestriccion(fecha); 
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
		return progreso.getPuntaje() == progreso.getDesafioActual().getCantidadDeMuestrasARecolectar();
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
}
