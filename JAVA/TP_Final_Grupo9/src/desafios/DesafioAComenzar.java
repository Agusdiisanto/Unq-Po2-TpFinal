package desafios;

import usuario.IParticipante;

public class DesafioAComenzar implements IEstadoDesafio {

	public void aceptarParticipante(IParticipante participante, Desafio desafio) throws Exception {
		desafio.IngresoDeParticipanteADesafio(participante);
		desafio.getPuntaje().put(participante,0);
	}

	public boolean esDesafioActivo() {
		// TODO Auto-generated method stub
		return true;
	}

	public void finalizarDesafio(Desafio desafio) {
		throw new RuntimeException("El Desafio todavia no ha sido iniciado");	
	}

	

}
