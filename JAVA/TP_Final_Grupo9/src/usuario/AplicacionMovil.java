package usuario;

import java.util.HashSet;
import java.util.Set;

import muestra.Muestra;
import proyectos.Proyecto;

public class AplicacionMovil {

	private Set<Muestra> muestras;
	
	// ======================= METHODS ========================
	public void recolectarMuestra(Muestra muestra, Usuario usuario, Proyecto proyecto) throws Exception {
		if(proyecto.tieneRegistradoAlUsuario(usuario) && proyecto.esMuestraDeInteres(muestra)) {
			this.cargarMuestraEnAplicacion(muestra);
			proyecto.agregarMuestra(muestra);
			usuario.recolectarMuestraParaLosDesafios(muestra);
		}
	}

	public void cargarMuestraEnAplicacion(Muestra muestra) {
		this.getMuestras().add(muestra);
	}
	
	// ====================== COSTRUCTOR ======================
	public AplicacionMovil() {
		this.muestras = new HashSet<Muestra>();
	}

	// ================== GETTERS & SETTERS ===================
	public Set<Muestra> getMuestras() {
		return muestras;
	}
} 
