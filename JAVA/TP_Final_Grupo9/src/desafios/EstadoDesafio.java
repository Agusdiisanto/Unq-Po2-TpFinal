package desafios;

import usuario.IParticipante;

public abstract class EstadoDesafio {
	
	public abstract void aceptarParticipante(IParticipante participante, Desafio desafio) throws Exception;
	public abstract boolean esDesafioActivo();
	public abstract void finalizarDesafio(Desafio desafio) throws Exception;
	
	
	
}
