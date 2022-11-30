package muestra;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import actividad.Caracteristica;
import usuario.Usuario;

/**
 * 
 * Esta clase se encarga de modelar una muestra. 
 *
 */

public class Muestra {
	private Set<Caracteristica> caracteristicas;
	private Usuario 			usuarioRecolector;
	private LocalDateTime 		fechaYHoraDeRecoleccion;
	private Coordenada 			coordenada;

	// ================== METHODS ==================
	public boolean includes(Caracteristica caracteristica) {
		return this.getCaracteristicas().contains(caracteristica);
	}
	
	public void addCaracteristica(Caracteristica caracteristica) {
		this.getCaracteristicas().add(caracteristica);
	}
	
	public int cantidadDeCaracteristicas() {
		return this.getCaracteristicas().size();
	}
	
	// ================== COSTRUCTOR ==================
	public Muestra(Usuario		 usuarioQueLaRecolecto, 
			       LocalDateTime fechaYHoraDeRecoleccion,
			       Coordenada	 coordenada) {
		this.setCaracteristicas(new HashSet<Caracteristica>());
		this.setUsuarioQueLaRecolecto(usuarioQueLaRecolecto);
		this.setFechaYHoraDeRecoleccion(fechaYHoraDeRecoleccion);
		this.setCoordenada(coordenada);
	}

	// ============== GETTERS & SETTERS ==============
	public Set<Caracteristica> getCaracteristicas() {
		return caracteristicas;
	}
	public Usuario getUsuarioQueLaRecolecto() {
		return usuarioRecolector;
	}
	private void setCaracteristicas(Set<Caracteristica> caracteristicas) {
		this.caracteristicas = caracteristicas;
	}
	public void setUsuarioQueLaRecolecto(Usuario usuarioQueLaRecolecto) {
		this.usuarioRecolector = usuarioQueLaRecolecto;
	}
	public LocalDateTime getFechaYHoraDeRecoleccion() {
		return fechaYHoraDeRecoleccion;
	}
	public void setFechaYHoraDeRecoleccion(LocalDateTime fechaYHoraDeRecoleccion) {
		this.fechaYHoraDeRecoleccion = fechaYHoraDeRecoleccion;
	}
	public Coordenada getCoordenada() {
		return coordenada;
	}
	public void setCoordenada(Coordenada coordenada) {
		this.coordenada = coordenada;
	}
}
