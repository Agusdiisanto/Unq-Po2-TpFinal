package desafios;

import java.util.List;
import usuario.IParticipante;


public abstract class ActividadLudica {
	
	private List<IParticipante>  participantes;

	// ============== GETTERS & SETTERS ==============
	
	public List<IParticipante> getParticipantes() {
		return participantes;
	}

	public boolean esDesafio() {
		// TODO Auto-generated method stub
		return false;
	}

	// ¿Que mas debe haber en la clase abstracta? 
}
