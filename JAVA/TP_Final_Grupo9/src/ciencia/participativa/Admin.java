package ciencia.participativa;

import java.util.ArrayList;
import java.util.List;

import usuario.Usuario;

public class Admin {
	private List <Usuario> usuarios;
	private List <Proyecto> proyectos;
	
	public Admin() {
		this.usuarios = new ArrayList <>();
		this.proyectos = new ArrayList <>();
	}

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
	
	public List<Desafio> getDesafios(List<ActividadLudica> actividades){
		List <Desafio> desafios = new ArrayList <>();
		for (ActividadLudica actividad : actividades) {
		desafios.addAll(actividad.getElementosUtilizados()); 
	} 
		return desafios;
	}
	
	public List <Desafio> todosLosDesafios() {
		List <Desafio> desafios = new ArrayList<>();
		for (Proyecto proyecto : getProyectos()) {
		 desafios.addAll(this.getDesafios(proyecto.getActividades()));
		}
		return desafios;
	}
	
   public List <Desafio> desafiosRecomendadosPara(Usuario usuario) {
	 //para cada desafio hacemos una cuenta.
	  //todosLosDesafios <Desafio> ;
	   for (Desafio desafio : desafios) {
		
	}
	   return null;
	   
   }
	
}


