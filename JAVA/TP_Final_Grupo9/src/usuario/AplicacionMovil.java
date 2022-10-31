package usuario;

import java.util.HashSet;
import java.util.Set;

import ciencia.participativa.Proyecto;
import muestra.Muestra;

public class AplicacionMovil {
	private Set<Usuario> usuarios;
	private Set<Muestra> muestras;
	
	// ================== METHODS ==================
	public void recolectarMuestraParaProyecto(Muestra m, Proyecto p) {	
		if (this.esMuestraDeInteresParaProyecto(m, p)) {
			this.getMuestras().add(m);
		}
	}
	
	public Boolean esMuestraDeInteresParaProyecto(Muestra m, Proyecto p) {
		return p.esMuestraDeInteres(m);
	}
	
	public void recolectarMuestra(Muestra m) {
		// Analizar que haria
	}
	
	// ================== COSTRUCTOR ==================
	public AplicacionMovil() {
		this.muestras = new HashSet<Muestra>();
	}

	// ============== GETTERS & SETTERS ==============
	public Set<Muestra> getMuestras() {
		return muestras;
	}
	
	public Set<Usuario> getUsuario() {
		return usuarios;
	}
}
