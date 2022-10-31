package estadoDeUsuario;

import muestra.Muestra;
import usuario.IParticipante;

public class ProgresoDeDesafioPorIniciar implements IEstadoDelProgreso {

	@Override
	public boolean esDesafioEnCurso() {
		return false;
	}

	@Override
	public void recolectarMuestraPorParticipante(IParticipante participante, Muestra muestra) throws Exception {
		// No hace nada pues aún no arrancó.
	}

	@Override
	public void recibirRecompensaDesafio() throws Exception {
		// No hace nada.
	}
}
