package muestra;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import caracteristicas.desafio.Caracteristica;
import usuario.Usuario;

public class Muestra {
	private Set<Caracteristica> caracteristicas;
	private Usuario 			usuarioQueLaRecolecto;
	private LocalDateTime 		fechaYHoraDeRecoleccion;
	private Coordenada 			coordenadaDeRecoleccion;

	// ================== METHODS ==================
	public boolean tieneLaCaracteristica(Caracteristica c) {
		return this.getCaracteristicas().contains(c);
	}
	
	public void agregarCaracteristicaAMuestra(Caracteristica c) {
		this.getCaracteristicas().add(c);
	}
	
	// ================== COSTRUCTOR ==================
	public Muestra(Usuario		 usuarioQueLaRecolecto, 
			       LocalDateTime fechaYHoraDeRecoleccion,
			       Coordenada	 coordenadaDeRecollecion) {
		this.caracteristicas		 = new HashSet<Caracteristica>();
		this.usuarioQueLaRecolecto	 = usuarioQueLaRecolecto;
		this.fechaYHoraDeRecoleccion = fechaYHoraDeRecoleccion;
		this.coordenadaDeRecoleccion = coordenadaDeRecollecion;
	}

	// ============== GETTERS & SETTERS ==============
	public Set<Caracteristica> getCaracteristicas() {
		return caracteristicas;
	}

	public Usuario getUsuarioQueLaRecolecto() {
		return usuarioQueLaRecolecto;
	}

	public void setUsuarioQueLaRecolecto(Usuario usuarioQueLaRecolecto) {
		this.usuarioQueLaRecolecto = usuarioQueLaRecolecto;
	}

	public LocalDateTime getFechaYHoraDeRecoleccion() {
		return fechaYHoraDeRecoleccion;
	}

	public void setFechaYHoraDeRecoleccion(LocalDateTime fechaYHoraDeRecoleccion) {
		this.fechaYHoraDeRecoleccion = fechaYHoraDeRecoleccion;
	}

	public Coordenada getCoordenadaDeRecollecion() {
		return coordenadaDeRecoleccion;
	}

	public void setCoordenadaDeRecollecion(Coordenada coordenadaDeRecollecion) {
		this.coordenadaDeRecoleccion = coordenadaDeRecollecion;
	}
}
