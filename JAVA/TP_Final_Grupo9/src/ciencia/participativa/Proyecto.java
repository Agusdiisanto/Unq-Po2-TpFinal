package ciencia.participativa;

import java.util.HashSet;
import java.util.Set;

import caracteristicas.desafio.Caracteristica;
import desafios.ActividadLudica;
import muestra.Muestra;
import usuario.IParticipante;

public class Proyecto {
	
	private String				  nombreDelProyecto;
	private String 				  descripcion;
	private Set<String> 		  categorias;
	private Set<ActividadLudica> actividades;
	private Set<Muestra> 		  muestrasRecolectadas;
	private Set<IParticipante>   participantes;
	private Set<String> 		  intereses;
	
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
	public Set<String> getCategorias() {
		return categorias;
	}
	public void setCategorias(Set<String> categorias) {
		this.categorias = categorias;
	}
	public Set<ActividadLudica> getActividades() {
		return actividades;
	}
	public void setActividades(Set<ActividadLudica> actividades) {
		this.actividades = actividades;
	}
	public Set<Muestra> getMuestrasRecolectadas() {
		return muestrasRecolectadas;
	}
	public void setMuestrasRecolectadas(Set<Muestra> muestrasRecolectadas) {
		this.muestrasRecolectadas = muestrasRecolectadas;
	}
	public Set<IParticipante> getParticipantes() {
		return participantes;
	}
	public void setParticipantes(Set<IParticipante> participantes) {
		this.participantes = participantes;
	}
	public Set<String> getIntereses() {
		return intereses;
	}
	public void setIntereses(Set<String> intereses) {
		this.intereses = intereses;
	}
	
	// ================== COSTRUCTOR ==================
	public Proyecto(String nombreDelProyecto, String descripcion) {
		super();
		
		this.nombreDelProyecto = nombreDelProyecto;
		this.descripcion 	   = descripcion;
		this.intereses = new HashSet<String>();
		this.participantes = new HashSet<IParticipante>();
		this.muestrasRecolectadas = new HashSet<Muestra>();
		this.actividades = new HashSet<ActividadLudica>();
		this.categorias = new HashSet<String>(); 
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
		this.agregarMuestraSiEsDeInteres(muestra);
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
		this.getParticipantes().add(participante);
	}
	
	public boolean elProyectoTieneAlParticipante(IParticipante participante) {
		return this.getParticipantes().contains(participante);
	}
	public Integer cantidadDeMuestras() {
		return this.getMuestrasRecolectadas().size();
	}
	public void agregarInteres(Caracteristica caracteristica1) {
		this.getIntereses().add(caracteristica1.getDescripicion());
	}
	

	
	
}
