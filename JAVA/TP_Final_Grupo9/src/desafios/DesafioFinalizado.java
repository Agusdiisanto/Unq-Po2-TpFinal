package desafios;

import usuario.IParticipante;

public class DesafioFinalizado implements IEstadoDesafio{

	public void aceptarParticipante(IParticipante participante, Desafio desafio) throws Exception {
		throw new RuntimeException("El desafio ya ha finalizado");
	}

	public boolean esDesafioActivo() {
		
		// Aca tendriamos que ver el tema de la restriccion 
		// Pero con el state no verificamos si esta activo? 
		// Si no lo verificamos con el state hay que tener un parametro desafio 
		// Para llamar a la restriccion
		
		return true;
	}

	public void finalizarDesafio(Desafio desafio) throws Exception {
		throw new RuntimeException("El desafio ya ha finalizado");
	}

}
