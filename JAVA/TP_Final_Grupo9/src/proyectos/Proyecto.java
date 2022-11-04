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
	private Set<IParticipante>   participantes; // SE PUEDE TYPEAR CON USUARIO?
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
	
	// QUÉ DIFERENCIA HAY ENTRE ÉSTE...
	public boolean elProyectoTieneAlParticipante(IParticipante participante) {
		return this.getParticipantes().contains(participante);
	}

	// Y ESTE...?
	public boolean tieneRegistradoAlParticipante(Usuario usuario) {
		return this.getParticipantes().contains(usuario);
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
	
	public boolean contieneCategorias(Set<String> categorias2) {
		return this.getCategorias().containsAll(categorias2);
	}
	
	public boolean noIncluye(Set<String> categorias2) {
		// TODO Auto-generated method stub
		return !this.contieneCategorias(categorias2);
	}
	
	// ================== COSTRUCTOR ==================
	public Proyecto(String nombreDelProyecto, String descripcion) {
		this.nombreDelProyecto    	  = nombreDelProyecto;
		this.descripcion 	   	  	  = descripcion;
		this.actividades 		      = new HashSet<ActividadLudica>();
		this.categorias			  	  = new HashSet<String>(); 
		this.muestrasRecolectadas 	  = new HashSet<Muestra>();
		this.participantes 		  	  = new HashSet<IParticipante>();
		this.caracteristicasDeInteres = new HashSet<Caracteristica>();
	}
	
	// ============== GETTERS & SETTERS ==============
	public String getNombre() {
		return nombreDelProyecto;
	}
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
	public boolean tieneAlParticipante(IParticipante participante) {
		return this.getParticipantes().contains(participante);
	}
}
