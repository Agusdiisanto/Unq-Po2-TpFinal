package desafios;

import usuario.IParticipante;

public class DesafioFinalizado implements IEstadoDesafio{

	public void aceptarParticipante(IParticipante participante, Desafio desafio) throws Exception {
		throw new RuntimeException("El desafio ya ha finalizado");
	}

	public boolean esDesafioActivo() {
		return false;
	}

	public void finalizarDesafio(Desafio desafio) throws Exception {
		throw new RuntimeException("El desafio ya ha finalizado");
	}

}
