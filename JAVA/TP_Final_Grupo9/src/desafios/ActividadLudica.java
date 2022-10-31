package desafios;

import java.util.Set;

import usuario.IParticipante;


public abstract class ActividadLudica {
	
	private Set<IParticipante>  participantes;

	// ============== GETTERS & SETTERS ==============
	
	public Set<IParticipante> getParticipantes() {
		return participantes;
	}

	public boolean esDesafio() {
		// TODO Auto-generated method stub
		return false;
	}

	// ¿Que mas debe haber en la clase abstracta? 
}
