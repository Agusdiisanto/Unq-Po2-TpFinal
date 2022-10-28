package ciencia.participativa;

import java.util.List;

import desafios.ActividadLudica;
import muestra.Muestra;
import usuario.IParticipante;

public class Proyecto {
	
	private String				  nombreDelProyecto;
	private String 				  descripcion;
	private List<String> 		  categorias;
	private List<ActividadLudica> actividades;
	private List<Muestra> 		  muestrasRecolectadas;
	private List<IParticipante>   participantes;
	private List<String> 		  intereses;
	
	// ============== GETTERS & SETTERS ==============
	public String getNombre() {
		return nombreDelProyecto;
	}
	public void setNombre(String nombre) {
		this.nombreDelProyecto = nombre;
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
	
	// ================== COSTRUCTOR ==================
	public Proyecto(String nombreDelProyecto, String descripcion) {
		super();
		this.nombreDelProyecto = nombreDelProyecto;
		this.descripcion 	   = descripcion;
	}
	
	
	// ================== METHODS ==================
	public boolean esMuestraDeInteres(Muestra muestra) {
		for (String interes : this.getIntereses()) {
			if(muestra.tieneLaCaracteristica(interes)) {
				return true;
			}
		}
		return false;
	}
	
	public void agregarMuestra(Muestra muestra) {
		
		if(this.elProyectoTieneLaMuestraDeInteres(muestra)) {
			throw new RuntimeException("La muestra ya ha sido registrada");
		}
		else {
			this.agregarMuestraSiEsDeInteres(muestra);
		}	
	}
	
	public boolean elProyectoTieneLaMuestraDeInteres(Muestra muestra) {
		return this.getMuestrasRecolectadas().contains(muestra);
	}
	
	public void agregarMuestraSiEsDeInteres(Muestra muestra) {
		if(this.esMuestraDeInteres(muestra)) {
			this.getMuestrasRecolectadas().add(muestra);
		}
	}
	
	public void agregarNuevoParticipante(IParticipante participante) {
		if(this.elProyectoTieneAlParticipante(participante)) {
			throw new RuntimeException("Ya ha sido ingresado el nuevo participante al proyecto");
		}
		else {
			this.getParticipantes().add(participante);
		}
	}
	
	public boolean elProyectoTieneAlParticipante(IParticipante participante) {
		return this.getParticipantes().contains(participante);
	}
	public Integer cantidadDeMuestras() {
		return this.getMuestrasRecolectadas().size();
	}
	

	
	
}
