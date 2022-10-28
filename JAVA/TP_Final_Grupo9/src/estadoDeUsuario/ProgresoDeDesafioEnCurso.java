package estadoDeUsuario;

import muestra.Muestra;
import usuario.IParticipante;

public class ProgresoDeDesafioEnCurso implements IEstadoDelProgreso {


	public boolean esDesafioEnCurso() {
		return true;
	}

	@Override
	public void recibirRecompensaDesafio() {
		throw new RuntimeException("Todavia no has terminado el desafio para recibir la recompensa");
	}

	@Override
	public void recolectarMuestraPorParticipante(IParticipante participante, Muestra muestra) throws Exception {
		participante.getAplicacion().recolectarMuestra(muestra);
	}
	
	
	
}
