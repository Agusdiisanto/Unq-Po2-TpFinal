package estadoDeUsuario;

import muestra.Muestra;
import usuario.IParticipante;

public class ProgresoDeDesafioTerminado implements IEstadoDelProgreso {

	@Override
	public boolean esDesafioEnCurso() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void recibirRecompensaDesafio() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void recolectarMuestraPorParticipante(IParticipante participante, Muestra muestra) throws Exception {
		throw new RuntimeException("No puedes recolectar mas muestras debido a que ya has terminado el desafio");
		
	}

}
