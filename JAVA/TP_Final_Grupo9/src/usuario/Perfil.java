package usuario;

import java.util.HashSet;
import java.util.Set;

import caracteristicas.desafio.Caracteristica;

public class Perfil {
	private Set<String>		 	gustos;
	private Set<Caracteristica> caracteristicasPreferidas;
	private Set<String>			comportamiento;

	// =================== METHODS ====================
	public void agregarGusto(String g) {
		this.getGustos().add(g);
	}
	
	public void agregarCaracteristicaPreferida(Caracteristica c) {
		this.getPreferencias().add(c);
	}
	
	public void agregarComportamiento(String c) {
		this.getComportamiento().add(c);
	}

	// ================== COSTRUCTOR ==================
	public Perfil() {
		this.gustos		 			   = new HashSet<String>();
		this.caracteristicasPreferidas = new HashSet<Caracteristica>();
		this.comportamiento 		   = new HashSet<String>();
	}
	
	// ============== GETTERS & SETTERS ===============
	public Set<String> getGustos() {
		return gustos;
	}
	public Set<Caracteristica> getPreferencias() {
		return caracteristicasPreferidas;
	}
	public Set<String> getComportamiento() {
		return comportamiento;
	}
}
