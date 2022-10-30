package ciencia.participativa;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import caracteristicas.desafio.Caracteristica;
import desafios.ActividadLudica;
import desafios.Desafio;
import usuario.IParticipante;
import usuario.Usuario;

public class Sistema {
	
	private Set<Proyecto> proyectos;

	public Set<Proyecto> getProyectos() {
		return proyectos;
	}
	
	public void setProyectos(Set<Proyecto> proyectos) {
		this.proyectos = proyectos;
	}
	
	
	// ========================= CONTRUCTOR ==============================
	
	public Sistema() {
		this.proyectos = new HashSet<Proyecto>();
	}
	
	public Set<Desafio> getDesafios(Set<ActividadLudica> set){
		
		Set<Desafio> desafios = new HashSet<Desafio>();
		for (ActividadLudica actividad : set) {
			if(actividad.esDesafio()) {
				desafios.add((Desafio) actividad);
			}
		} 
		return desafios;
		
	}
	
	// =================================================================
	
	public Set <Desafio> todosLosDesafios() {
		Set <Desafio> desafios = new HashSet<Desafio>();
		for (Proyecto proyecto : getProyectos()) {
		 desafios.addAll(this.getDesafios(proyecto.getActividades()));
		}
		return desafios;
	}
	
	/*
	public List <Desafio> desafiosRecomendadosPara(Usuario usuario) {
		List<Desafio> desafiosOrdenados = new LinkedList<Desafio>();
		desafiosOrdenados.add(this.todosLosDesafios().get(0));
		for (Desafio desafio : this.todosLosDesafios()) {
			desafiosOrdenados.add(0, desafio);
		}
		return null;
	}
	*/
	
	public Set<Desafio> desafiosRecomendadosPara(Usuario usuario) {
		Set<Desafio> desafiosOrdenados = new HashSet<Desafio>();
		desafiosOrdenados.addAll(this.todosLosDesafios());
		for (Desafio desafio : this.todosLosDesafios()) {
			desafiosOrdenados.add(desafio);
		}
		return null;
	}
	
	public Desafio desafioConMayorCoincidenciaEntre(Desafio d1 ,Desafio d2, Usuario user) {
		if (coincidenciaConUsuario(d1,user) < coincidenciaConUsuario(d2,user)) {
			return d1;
		}
		else {
			return d2;
		}
	}

	private double coincidenciaConUsuario(Desafio d1, Usuario user) {
		double indiceDeCoincidencia = 0;
		for (Caracteristica caracteristica : d1.getCaracteristicas()) {
			if (contieneCaracteristica(caracteristica, user.getPerfil().getPreferencias())) {
				double afinidad = caracteristicaConDescripcion(caracteristica.getDescripicion(), user.getPerfil().getPreferencias()).getAfinidad();
				indiceDeCoincidencia = Math.abs(caracteristica.getAfinidad() - afinidad);
			}
		}
		return indiceDeCoincidencia;
	}

	private Caracteristica caracteristicaConDescripcion(String descripicion, List<Caracteristica> preferencias) {
		while(preferencias.get(0).getDescripicion() != descripicion) {
			preferencias.remove(0);
		}
		return preferencias.get(0);
	}

	private boolean contieneCaracteristica(Caracteristica caracteristica, List<Caracteristica> preferencias) {
		while(preferencias.get(0).getDescripicion() != caracteristica.getDescripicion()) {
			preferencias.remove(0);
		}
		return preferencias.get(0).getDescripicion() == caracteristica.getDescripicion();
	}
	
	
	// Esto se va

	public void ingresarSolicitudAProyecto(Proyecto proyecto, IParticipante usuario) {
		proyecto.agregarNuevoParticipante(usuario);
	}


}
