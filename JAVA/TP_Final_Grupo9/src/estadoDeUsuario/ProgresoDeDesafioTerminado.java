package estadoDeUsuario;

import muestra.Muestra;
import usuario.IParticipante;

public class ProgresoDeDesafioTerminado extends EstadoDeProgreso {
	
	@Override
	public void recolectarMuestra(ProgresoDesafio progresoDesafio, Muestra muestra) throws Exception {
		throw new RuntimeException("Ya no puedes recolectar, el desafio ya ha terminado");	
	} 

	@Override
	public void verificarSiCompletoElDesafio(ProgresoDesafio progreso) {
		throw new RuntimeException("Ya no puedes verificar el progreso del desafio porque ya ha terminado");	
	}
	
	@Override
	public void concederRecompensaDelDesafioA(IParticipante participante, ProgresoDesafio progresoDesafio) {
		participante.registrarDesafioCompleatado(progresoDesafio.getDesafioActual(),progresoDesafio.recompensaDelDesafio());
	}
	
}
