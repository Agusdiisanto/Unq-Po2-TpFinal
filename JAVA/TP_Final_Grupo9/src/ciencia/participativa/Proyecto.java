package ciencia.participativa;

import java.util.HashSet;
import java.util.Set;

import caracteristicas.desafio.Caracteristica;
import desafios.ActividadLudica;
import muestra.Muestra;
import usuario.IParticipante;

public class Proyecto {
	private String				 nombreDelProyecto;
	private String 				 descripcion;
	private Set<String> 		 categorias;
	private Set<ActividadLudica> actividades;
	private Set<Muestra> 		 muestrasRecolectadas;
	private Set<IParticipante>   participantes;
	private Set<Caracteristica>  caracteristicasDeInteres;
	
	// ================== METHODS ==================
	public void agregarMuestra(Muestra muestra) {
		if(this.esMuestraDeInteres(muestra)) {
			this.getMuestrasRecolectadas().add(muestra);
		}
	}
	
	public boolean esMuestraDeInteres(Muestra muestra) {
		Set<Caracteristica> caracteristicasEnComun = this.getCaracteristicasDeInteres();
		caracteristicasEnComun.retainAll(muestra.getCaracteristicas());
		return !caracteristicasEnComun.isEmpty();
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
	
	public void agregarInteres(Caracteristica caracteristica) {
		this.getCaracteristicasDeInteres().add(caracteristica);
	}
	
	public void ingresarSolicitudAProyecto(IParticipante participante) {
		this.getParticipantes().add(participante);
	}
	
	// ================== COSTRUCTOR ==================
	public Proyecto(String nombreDelProyecto, String descripcion) {
		this.nombreDelProyecto    	  = nombreDelProyecto;
		this.descripcion 	   	  	  = descripcion;
		this.caracteristicasDeInteres = new HashSet<Caracteristica>();
		this.participantes 		  	  = new HashSet<IParticipante>();
		this.muestrasRecolectadas 	  = new HashSet<Muestra>();
		this.actividades 		      = new HashSet<ActividadLudica>();
		this.categorias			  	  = new HashSet<String>(); 
	}
	
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
	public Set<ActividadLudica> getActividades() {
		return actividades;
	}
	public Set<Muestra> getMuestrasRecolectadas() {
		return muestrasRecolectadas;
	}
	public Set<IParticipante> getParticipantes() {
		return participantes;
	}
	public Set<Caracteristica> getCaracteristicasDeInteres() {
		return caracteristicasDeInteres;
	}

	
}
