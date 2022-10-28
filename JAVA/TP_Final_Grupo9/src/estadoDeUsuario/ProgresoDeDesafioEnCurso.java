package estadoDeUsuario;

import muestra.Muestra;

public class ProgresoDeDesafioEnCurso implements IEstadoDelProgreso {


	public boolean esDesafioEnCurso() {
		return true;
	}

	@Override
	public void recolectarMuestra(Muestra muestra) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void recibirRecompensaDesafio() {
		throw new RuntimeException("Todavia no has terminado el desafio para recibir la recompensa");
	}
	
	
	
}
