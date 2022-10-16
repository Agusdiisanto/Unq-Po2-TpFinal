package ciencia.participativa;

import java.util.List;

import usuario.IParticipante;

public class Proyecto {
	
	private String nombre;
	private String descripcion;
	private List<String> categorias;
	private List<ActividadLudica> actividades;
	private List<Muestra> muestrasRecolectadas;
	private List<IParticipante> participantes;
	private List<String> intereses;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public List<String> getCategorias() {
		return categorias;
	}
	public void setCategorias(List<String> categorias) {
		this.categorias = categorias;
	}
	public List<ActividadLudica> getActividades() {
		return actividades;
	}
	public void setActividades(List<ActividadLudica> actividades) {
		this.actividades = actividades;
	}
	public List<Muestra> getMuestrasRecolectadas() {
		return muestrasRecolectadas;
	}
	public void setMuestrasRecolectadas(List<Muestra> muestrasRecolectadas) {
		this.muestrasRecolectadas = muestrasRecolectadas;
	}
	public List<IParticipante> getParticipantes() {
		return participantes;
	}
	public void setParticipantes(List<IParticipante> participantes) {
		this.participantes = participantes;
	}
	public List<String> getIntereses() {
		return intereses;
	}
	public void setIntereses(List<String> intereses) {
		this.intereses = intereses;
	}
	
	public boolean esDeInteres(Muestra muestra) {
		for (String interes : this.getIntereses()) {
			if(muestra.tieneLaCaracteristica(interes)) {
				return true;
			}
		}
		return false;
	}
	
	public void agregarNuevaMuestraDeInteres(Muestra muestra) {
		if(this.esDeInteres(muestra)) {
			this.getMuestrasRecolectadas().add(muestra);
		}
	}
	
	
	

	
	
}
