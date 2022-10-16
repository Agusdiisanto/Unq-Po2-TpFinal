package usuario;

import java.util.List;

import ciencia.participativa.Desafio;

public class Perfil {
	
	private List<String> gustos;
	private List<String> preferencias;
	private List<String> comportamiento;
	private List<Desafio> recomendaciones;
	
	
	public List<String> getGustos() {
		return gustos;
	}
	public void setGustos(List<String> gustos) {
		this.gustos = gustos;
	}
	public List<String> getPreferencias() {
		return preferencias;
	}
	public void setPreferencias(List<String> preferencias) {
		this.preferencias = preferencias;
	}
	public List<String> getComportamiento() {
		return comportamiento;
	}
	public void setComportamiento(List<String> comportamiento) {
		this.comportamiento = comportamiento;
	}

	
	public void agregar() {
		
	}
	
	
	
}
