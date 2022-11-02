package usuario;

import java.util.HashSet;
import java.util.Set;

import muestra.Muestra;
import proyectos.Proyecto;

public class AplicacionMovil {
	private Set<Usuario> usuarios;
	private Set<Muestra> muestras;
	
	// ================== METHODS ==================

	public Boolean esMuestraDeInteresParaProyecto(Muestra m, Proyecto p) {
		return p.esMuestraDeInteres(m);
	}
	
	public void recolectarMuestra(Muestra m, Usuario usuario, Proyecto p) throws Exception {
		if(estaRegistradoElUsuario(usuario)) {
			this.recolectarMuestraParaProyecto(m, p);
			usuario.recolectarMuestra(m);
		}
	}
	
	public boolean estaRegistradoElUsuario(Usuario usuario) {
		return this.getUsuario().contains(usuario);
	}
	
	public void registrarUsuarioEnAplicacion(Usuario usuario) {
		this.getUsuario().add(usuario);
	}
	
	public void recolectarMuestraParaProyecto(Muestra m, Proyecto p) {	
		if (this.esMuestraDeInteresParaProyecto(m, p)) {
			this.cargarMuestraEnAplicacion(m);
		}
	}
	
	// ======================== PRIVATES ================================
	
	private void cargarMuestraEnAplicacion(Muestra muestra) {
		this.getMuestras().add(muestra);
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
