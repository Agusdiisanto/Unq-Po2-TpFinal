package estadoDeUsuario;

import java.time.LocalDateTime; 
import muestra.Muestra;
 
public class ProgresoDeDesafioEnCurso extends EstadoDeProgreso{

	@Override
	public boolean esDesafioEnCurso(ProgresoDesafio progresoDesafio, LocalDateTime fecha) {
		return progresoDesafio.getDesafioActual().estaDentroDeLaRestriccion(fecha); 
	} 
	  
	@Override
	public void recolectarMuestra(ProgresoDesafio progresoDesafio, Muestra muestra, LocalDateTime fecha) throws Exception {	
		
		if(this.esDesafioEnCurso(progresoDesafio,fecha) == false) {
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
