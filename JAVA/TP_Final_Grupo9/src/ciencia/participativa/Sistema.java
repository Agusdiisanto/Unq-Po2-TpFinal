package ciencia.participativa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import caracteristicas.desafio.Caracteristica;
import desafios.ActividadLudica;
import desafios.Desafio;
import usuario.IParticipante;
import usuario.Usuario;

public class Sistema {
	
	private List <Usuario> usuarios;
	private List <Proyecto> proyectos;
	private Map<Proyecto, Integer> recomendacion;
	

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Proyecto> getProyectos() {
		return proyectos;
	}

	public void setProyectos(List<Proyecto> proyectos) {
		this.proyectos = proyectos;
	}
	
	public Map<Proyecto, Integer> getRecomendacion() {
		return recomendacion;
	}

	public void setRecomendacion(Map<Proyecto, Integer> recomendacion) {
		this.recomendacion = recomendacion;
	}
	
	
	//  ========= PREGUNTAR SI SE PUEDE MEJORAR EL FILTRO ===========
	


	public List<Desafio> getDesafios(List<ActividadLudica> actividades){
		
		List <Desafio> desafios = new ArrayList <>();
		for (ActividadLudica actividad : actividades) {
			if(actividad.getClass() == Desafio.class) {
				desafios.add((Desafio) actividad);
			}
		} 
		return desafios;
	}
	
	// =================================================================
	
	public List <Desafio> todosLosDesafios() {
		List <Desafio> desafios = new ArrayList<>();
		for (Proyecto proyecto : getProyectos()) {
		 desafios.addAll(this.getDesafios(proyecto.getActividades()));
		}
		return desafios;
	}
	
	public List <Desafio> desafiosRecomendadosPara(Usuario usuario) {
		List<Desafio> desafiosOrdenados = new LinkedList<Desafio>();
		desafiosOrdenados.add(this.todosLosDesafios().get(0));
		for (Desafio desafio : this.todosLosDesafios()) {
			desafiosOrdenados.add(0, desafio);
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

	public void ingresarSolicitudAProyecto(Proyecto proyecto, IParticipante usuario) {
		proyecto.agregarNuevoParticipante(usuario);
	}

	public void realizarRecomendacionAParticipante(IParticipante x) {
		// TODO Auto-generated method stub
		
	}
	
	// Lo que hace este metodo de abajo es 
	// busca el proyecto al que el usuario quiere calificar y le pone una calificacion por parametro
	
	public void calificarProyecto(Proyecto proyectoARecomendar, int calificacion) {
		for (Proyecto proyecto : this.getProyectos()) {
			if (proyecto.equals(proyectoARecomendar)) {
				this.getRecomendacion().put(proyectoARecomendar, calificacion);
			}
		}
	}
}
