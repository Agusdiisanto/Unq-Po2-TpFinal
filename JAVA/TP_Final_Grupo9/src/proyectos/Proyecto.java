package proyectos;

import java.util.HashSet;
import java.util.Set;

import caracteristicas.desafio.Caracteristica;
import desafios.ActividadLudica;
import desafios.Desafio;
import muestra.Muestra;
import usuario.IParticipante;
import usuario.Usuario;

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
		this.getMuestrasRecolectadas().add(muestra);
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
	
	public Set<Desafio> getDesafios(){
		Set<Desafio> desafios = new HashSet<Desafio>();
		for (ActividadLudica actividad : this.getActividades()) {
			if(actividad.esDesafio()) {
				desafios.add((Desafio) actividad);
			}
		}
		return desafios;
	}
	
	public int cantidadDeCaracteristicas() {
		return this.getCaracteristicasDeInteres().size();
	}
	
	public boolean tieneRegistradoAlParticipante(Usuario usuario) {
		// TODO Auto-generated method stub
		return this.getParticipantes().contains(usuario);
	}
	
	public int cantidadDeParticipantes() {
		return this.getParticipantes().size();
	}
	
	public Integer cantidadDeActividades() {
		// TODO Auto-generated method stub
		return this.getActividades().size();
	}
	
	public void agregarActividadLudica(ActividadLudica actividad) {
		this.getActividades().add(actividad);
	}
	
	public void agregarCategorias(String categoria) {
		this.getCategorias().add(categoria);
	}
	
	public Integer cantidadDeCategorias() {
		// TODO Auto-generated method stub
		return this.getCategorias().size();
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
