package estadoDeUsuario;

import java.time.LocalDateTime;
import desafios.Desafio;
import muestra.Muestra;


public class ProgresoDeDesafioEnCurso extends EstadoDeProgreso{

	
	@Override
	public boolean esDesafioEnCurso(Desafio desafio) {
		return desafio.estaDentroDeLaRestriccion(LocalDateTime.now());
	}
	

	@Override
	public void recolectarMuestra(ProgresoDesafio progresoDesafio, Muestra muestra) throws Exception {	
		if (progresoDesafio.getDesafioActual().estaLaMuestraDentroDelArea(muestra)) {
			progresoDesafio.sumarPuntajeAParticipante();
		}	
	}
	
	@Override
	public void recibirRecompensaDesafio() throws Exception {
		
	}
	
	@Override
	public boolean completoElDesafio(ProgresoDesafio progresoDesafio) {
		return progresoDesafio.getPuntaje() == progresoDesafio.getDesafioActual().getCantidadDeMuestrasARecolectar();
	}
	
	
}
