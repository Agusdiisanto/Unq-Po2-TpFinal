package estadoDeUsuario;

import java.time.LocalDateTime;
import muestra.Muestra;
 
public class ProgresoDeDesafioEnCurso extends EstadoDeProgreso{

	@Override
	public boolean esDesafioEnCurso(ProgresoDesafio progresoDesafio) {
		return progresoDesafio.getDesafioActual().estaDentroDeLaRestriccion(LocalDateTime.now());
	}
	 
	@Override
	public void recolectarMuestra(ProgresoDesafio progresoDesafio, Muestra muestra) throws Exception {	
		
		if(this.esDesafioEnCurso(progresoDesafio) == false) {
			progresoDesafio.setEstado(new ProgresoDeDesafioExpirado());
		}
		else {
			recolectarMuestraSiAunNoHaExpirado(progresoDesafio, muestra);	
		}
	}
	
	@Override
	public boolean completoElDesafio(ProgresoDesafio progresoDesafio) {
		return progresoDesafio.getPuntaje() == progresoDesafio.getDesafioActual().getCantidadDeMuestrasARecolectar();
	}
	
	@Override
	public void verificarSiCompletoElDesafio(ProgresoDesafio progreso) {
		if(this.completoElDesafio(progreso)) {
			progreso.setEstado(new ProgresoDeDesafioTerminado());
		}
	}
	
	
	// ============================ PRIVATE METHODS ================================================
	
	private void recolectarMuestraSiAunNoHaExpirado(ProgresoDesafio progresoDesafio, Muestra muestra) throws Exception {
		if (progresoDesafio.esUnaMuestraValida(muestra)) {
			progresoDesafio.sumarPuntajeAParticipante();
			this.verificarSiCompletoElDesafio(progresoDesafio);
		}
	}
	
	// ============================================================================================
	
	
	
	
	
	
	
}
