package usuario;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import filter.IFilter;
import muestra.Muestra;
import proyectos.Proyecto;

/**
 * 
 * Esta Clase encarga de modelar una aplicación móvil
 *
 */

public class AplicacionMovil {
	private Set<Muestra>   muestras;
	private List<Proyecto> proyectos;
	
	// ======================= METHODS ========================
	public void recolectarMuestra(Muestra muestra, Usuario usuario, Proyecto proyecto) throws Exception {
		if (proyecto.tieneRegistradoAlUsuario(usuario) && proyecto.esMuestraDeInteres(muestra)) {
			this.cargarMuestraEnAplicacion(muestra);
			proyecto.agregarMuestra(muestra);
			usuario.recolectarMuestraParaLosDesafios(muestra, LocalDateTime.now());
		}
	}

	public void cargarMuestraEnAplicacion(Muestra muestra) {
		this.getMuestras().add(muestra);
	}

	public void agregarProyecto(Proyecto proyecto) {
		this.getProyectos().add(proyecto);
	}
	
	public List <Proyecto> buscar (IFilter iFilter){
		return iFilter.filter(this.getProyectos());
	}
	
	// ====================== COSTRUCTOR ======================
	public AplicacionMovil() {
		this.muestras  = new HashSet<Muestra>();
		this.proyectos = new ArrayList<Proyecto>();
	}

	// ================== GETTERS & SETTERS ===================
	public Set<Muestra> getMuestras() {
		return muestras;
	}
	public List <Proyecto> getProyectos(){
		return proyectos;
	}
} 
