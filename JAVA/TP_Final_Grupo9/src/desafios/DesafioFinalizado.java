package desafios;

import usuario.IParticipante;

public class DesafioFinalizado extends EstadoDesafio{

	@Override
	public void aceptarParticipante(IParticipante participante, Desafio desafio) throws Exception {
		throw new RuntimeException("El desafio ya ha finalizado");
	}

	@Override
	public boolean esDesafioActivo() {
		
		// Aca tendriamos que ver el tema de la restriccion 
		// Pero con el state no verificamos si esta activo? 
		// Si no lo verificamos con el state hay que tener un parametro desafio 
		// Para llamar a la restriccion
		
		return true;
	}

	@Override
	public void finalizarDesafio(Desafio desafio) throws Exception {
		throw new RuntimeException("El desafio ya ha finalizado");
	}

}
