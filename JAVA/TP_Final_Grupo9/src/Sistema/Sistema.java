package Sistema;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import actividad.Desafio;
import filter.IFilter;
import proyectos.Proyecto;
import usuario.Usuario;

public class Sistema {
	private Set<Proyecto> proyectos;

	// ======================== METHODS ========================
	public void agregarProyecto(Proyecto proyecto) {
		this.getProyectos().add(proyecto);
	}
	
	public ArrayList<Desafio> recomendarDesafiosAlUsuario(Usuario user) {
		return user.getEstrategia().recomendarDesafiosAlUsuario(user, this.todosLosDesafios());
	}

	// ================== PRIVATE =====================
	private ArrayList<Desafio> todosLosDesafios() {
		ArrayList<Desafio> desafios = new ArrayList<Desafio>();
		for (Proyecto proyecto : this.getProyectos()) {
			desafios.addAll(proyecto.getDesafios());
		}
		return desafios; 
	}
 
	// ====================== CONTRUCTOR ======================
	public Sistema() {
		this.proyectos = new HashSet<Proyecto>();
	}
	
	// ============== GETTERS & SETTERS ==============
	public Set<Proyecto> getProyectos() {
		return proyectos;
	}
}
