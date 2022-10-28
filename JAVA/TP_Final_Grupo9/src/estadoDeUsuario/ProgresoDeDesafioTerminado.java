package estadoDeUsuario;

import muestra.Muestra;

public class ProgresoDeDesafioTerminado implements IEstadoDelProgreso {

	@Override
	public boolean esDesafioEnCurso() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void recolectarMuestra(Muestra muestra) throws Exception {
		throw new RuntimeException("Ya no puedes recolectar mas muestras, ya terminaste el desafio");
	}

	@Override
	public void recibirRecompensaDesafio() {
		// TODO Auto-generated method stub
		
	}

}
