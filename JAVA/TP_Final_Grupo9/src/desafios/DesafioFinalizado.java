package desafios;

import usuario.IParticipante;

public class DesafioFinalizado extends EstadoDesafio{

	@Override
	public void aceptarParticipante(IParticipante participante, Desafio desafio) throws Exception {
		throw new RuntimeException("El desafio ya ha finalizado");
	}

	@Override
	public boolean esDesafioActivo() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void finalizarDesafio(Desafio desafio) throws Exception {
		throw new RuntimeException("El desafio ya ha finalizado");
	}

}
