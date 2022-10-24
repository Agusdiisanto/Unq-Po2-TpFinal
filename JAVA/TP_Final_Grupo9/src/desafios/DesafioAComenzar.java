package desafios;

import usuario.IParticipante;

public class DesafioAComenzar extends EstadoDesafio {

	@Override
	public void aceptarParticipante(IParticipante participante, Desafio desafio) throws Exception {
		desafio.IngresoDeParticipanteADesafio(participante);
		desafio.getPuntaje().put(participante,0);
	}

	@Override
	public boolean esDesafioActivo() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void finalizarDesafio(Desafio desafio) {
		throw new RuntimeException("El Desafio todavia no ha sido iniciado");	
	}

	

}
