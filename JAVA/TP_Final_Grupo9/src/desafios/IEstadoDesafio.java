package desafios;

import usuario.IParticipante;

public interface IEstadoDesafio {
	
	public abstract void aceptarParticipante(IParticipante participante, Desafio desafio) throws Exception;
	public abstract boolean esDesafioActivo();
	public abstract void finalizarDesafio(Desafio desafio) throws Exception;
	
	
	
}
