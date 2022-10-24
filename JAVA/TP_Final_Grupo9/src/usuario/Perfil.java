package usuario;

import java.util.List;

import caracteristicas.desafio.Caracteristica;

public class Perfil {
	
	private List<String> gustos;
	private List<Caracteristica> preferencias;
	private List<String> comportamiento;
	
	
	public List<String> getGustos() {
		return gustos;
	}
	public void setGustos(List<String> gustos) {
		this.gustos = gustos;
	}
	public List<Caracteristica> getPreferencias() {
		return preferencias;
	}
	public void setPreferencias(List<Caracteristica> preferencias) {
		this.preferencias = preferencias;
	}
	public List<String> getComportamiento() {
		return comportamiento;
	}
	public void setComportamiento(List<String> comportamiento) {
		this.comportamiento = comportamiento;
	}
	
	
	
}
