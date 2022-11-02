package usuario;

import java.util.HashSet;
import java.util.Set;

import caracteristicas.desafio.Caracteristica;
import estrategiaDeRecomendacion.Sistema;

public class Perfil {
	
	private Set<String>		 	gustos;
	private Set<Caracteristica> caracteristicasPreferidas;
	private Set<String>			comportamiento;
	private Sistema             recomendaciones;

	// =================== METHODS ==================== 
	public void agregarGusto(String gusto) {
		this.getGustos().add(gusto);
	}
	
	public void agregarCaracteristicaPreferida(Caracteristica caracteristica) {
		this.getPreferencias().add(caracteristica);
	}
	
	public void agregarComportamiento(String caracteristica) {
		this.getComportamiento().add(caracteristica);
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

	public Sistema getRecomendaciones() {
		return recomendaciones;
	}

	public void setRecomendaciones(Sistema recomendaciones) {
		this.recomendaciones = recomendaciones;
	}
}


