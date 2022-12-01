package proyectos;

import java.util.HashSet;
import java.util.Set;

import actividad.ActividadLudica;
import actividad.Caracteristica;
import actividad.Desafio;
import muestra.Muestra;
import usuario.IParticipante;

/**
 * 
 * Esta calse se encarga de modelar un proyecto.
 *
 */

public class Proyecto {
	private String				 nombre;
	private String 				 descripcion;
	private Set<String> 		 categorias;
	private Set<ActividadLudica> actividades;
	private Set<Muestra> 		 muestrasRecolectadas;
	private Set<IParticipante>   participantes;
	private Set<Caracteristica>  caracteristicasDeInteres;
	
	// ================== METHODS ==================
	public boolean esMuestraDeInteres(Muestra muestra) {
		Set<Caracteristica> caracteristicasEnComun = this.getCaracteristicasDeInteres();
		caracteristicasEnComun.retainAll(muestra.getCaracteristicas());
		return !caracteristicasEnComun.isEmpty();
	} 
	
	public Set<Desafio> getDesafios(){
		Set<Desafio> desafios = new HashSet<Desafio>();
		for (ActividadLudica actividad : this.getActividades()) {
			if(actividad.esDesafio()) {
				desafios.add((Desafio) actividad);
			}
		}
		return desafios;
	}

	public boolean tieneRegistradoAlUsuario(IParticipante participante) {
		return this.getParticipantes().contains(participante);
	}
	
	public boolean contieneCategorias(Set<String> categorias) {
		return this.getCategorias().containsAll(categorias);
	}
	
	public boolean includes(String categoria) {
		return this.getCategorias().contains(categoria);
	}
	
	public boolean noContieneCategorias(Set<String> categorias) {
		return !this.contieneCategorias(categorias);
	}

	// ================ ADD METHODS =================
	public void agregarActividad(ActividadLudica actividad) {
		this.getActividades().add(actividad);
	}
	
	public void agregarCategoria(String categoria) {
		this.getCategorias().add(categoria);
	}
	
	public void agregarMuestra(Muestra muestra) {
		this.getMuestrasRecolectadas().add(muestra);
	}
	
	public void agregarParticipante(IParticipante participante) {
		this.getParticipantes().add(participante);
	}
	
	public void agregarCaracteristicaDeInteres(Caracteristica caracteristica) {
		this.getCaracteristicasDeInteres().add(caracteristica);
	}
	
	// ================ SIZE METHODS ================
	public int cantidadDeActividades() {
		return this.getActividades().size();
	}
	
	public int cantidadDeCategorias() {
		return this.getCategorias().size();
	}
	
	public int cantidadDeMuestrasRecolectadas() {
		return this.getMuestrasRecolectadas().size();
	}
	
	public int cantidadDeParticipantes() {
		return this.getParticipantes().size();
	}

	public int cantidadDeCaracteristicasDeInteres() {
		return this.getCaracteristicasDeInteres().size();
	}
	
	// ================== COSTRUCTOR ==================
	public Proyecto(String nombreDelProyecto, String descripcion) {
		this.setNombre(nombreDelProyecto);
		this.setDescripcion(descripcion);
		this.actividades 		      = new HashSet<ActividadLudica>();
		this.categorias			  	  = new HashSet<String>(); 
		this.muestrasRecolectadas 	  = new HashSet<Muestra>();
		this.participantes 		  	  = new HashSet<IParticipante>();
		this.caracteristicasDeInteres = new HashSet<Caracteristica>();
	}
	
	// ============== GETTERS & SETTERS ==============
	
	public String getDescripcion() {
		return descripcion;
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

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public boolean tieneElTitulo(String titulo) {
		return this.getNombre().equals(titulo);
	}
}
