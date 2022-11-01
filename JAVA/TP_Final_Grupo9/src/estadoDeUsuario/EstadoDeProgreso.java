package estadoDeUsuario;

import desafios.Desafio;
import muestra.Muestra;


public class EstadoDeProgreso implements IEstadoDelProgreso {

	@Override
	public boolean esDesafioEnCurso(Desafio desafio) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void recolectarMuestra(ProgresoDesafio progresoDesafio, Muestra muestra) throws Exception {
	}

	@Override
	public void recibirRecompensaDesafio() throws Exception {
	}

	@Override
	public boolean completoElDesafio(ProgresoDesafio progresoDesafio) {
		// TODO Auto-generated method stub
		return false;
	}

	


	
}
