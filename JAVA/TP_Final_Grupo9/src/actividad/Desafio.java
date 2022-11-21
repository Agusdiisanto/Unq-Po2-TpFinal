package actividad;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import muestra.Muestra;
import usuario.IParticipante;

/**
 * 
 * Esta clase se encarga de modelar un desafío con sus correspondientes atributos.
 *
 */

public class Desafio implements ActividadLudica {
	private Circulo 			area;
	private IRetriccionTemporal restriccionTemporal;
	private int 				cantidadDeMuestrasARecolectar;
	private Dificultad 			dificultad;
	private int 				recompensa;
	private Set<IParticipante>  participantes;
	private Set<Caracteristica> caracteristicas;

	// ================== METHODS ==================
	@Override
	public boolean esDesafio() {
		return true;
	}
	
	// Verifica si un desafío es activo, según la fecha actual y la restricción temporal.      FALTA TERMINAR!
	public Boolean esDesafioActivo() {
		return this.getRestriccionTemporal().cumpleLaRestricion(LocalDateTime.now());
	}
	
	public boolean estaLaMuestraDentroDelArea(Muestra muestra) {
		return this.getArea().includes(muestra.getCoordenada());
	}
	
	public boolean estaDentroDeLaRestriccion(LocalDateTime fecha) {
		return this.getRestriccionTemporal().cumpleLaRestricion(fecha);
	}
	
	public boolean estaLaMuestraDentroDeLaRestriccion(Muestra muestra) {
		return this.getRestriccionTemporal().cumpleLaRestricion(muestra.getFechaYHoraDeRecoleccion());
	}
	
	// ================ ADD METHODS ================
	public void agregarParticipanteAlDesafio(IParticipante usuario) {
		// Un participante puede ingresar a un desafío que aún no haya arrancado
		// pero solo se contabilizan las muestras a partir del inicio del desafío.
		if (this.sePuedeInscribir()) {
			this.getParticipantes().add(usuario);
		}
	}
	
	public void agregarCaracteristica(Caracteristica caracteristica) {
		this.getCaracteristicas().add(caracteristica);
	}
	
	// ================ PRIVATE METHODS ================
	private boolean sePuedeInscribir() {
		return this.getRestriccionTemporal().cierre().isAfter(LocalDateTime.now());
	}
	
	// ================== COSTRUCTOR ==================
	public Desafio(Circulo 			   area,
				   IRetriccionTemporal restriccionTemporal,
				   int 				   cantidadDeMuestrasARecolectar,
				   Dificultad 		   dificultad,
				   int				   recompensa) {
		this.setArea(area);
		this.setRestriccionTemporal(restriccionTemporal);
		this.setCantidadDeMuestrasARecolectar(cantidadDeMuestrasARecolectar);
		this.setDificultad(dificultad);
		this.setRecompensa(recompensa);
		this.setParticipantes(new HashSet<IParticipante>());
		this.setCaracteristicas(new HashSet<Caracteristica>());
	}

	// ============== GETTERS & SETTERS ==============
	public Circulo getArea() {
		return area;
	}
	public IRetriccionTemporal getRestriccionTemporal() {
		return restriccionTemporal;
	}
	public int getCantidadDeMuestrasARecolectar() {
		return cantidadDeMuestrasARecolectar;
	}
	public Dificultad getDificultad() {
		return dificultad;
	}
	public int getRecompensa() {
		return recompensa;
	}
	public Set<IParticipante> getParticipantes() {
		return participantes;
	}
	public Set<Caracteristica> getCaracteristicas() {
		return caracteristicas;
	}
	public void setArea(Circulo circulo) {
		this.area = circulo;
	}
	public void setRestriccionTemporal(IRetriccionTemporal restriccionTemporal) {
		this.restriccionTemporal = restriccionTemporal;
	}
	public void setCantidadDeMuestrasARecolectar(int cantidadDeMuestrasARecolectar) {
		this.cantidadDeMuestrasARecolectar = cantidadDeMuestrasARecolectar;
	}
	public void setDificultad(Dificultad dificultad) {
		this.dificultad = dificultad;
	}
	public void setRecompensa(int recompensa) {
		this.recompensa = recompensa;
	}
	private void setParticipantes(Set<IParticipante> participantes) {
		this.participantes = participantes;
	}
	private void setCaracteristicas(Set<Caracteristica> caracteristicas) {
		this.caracteristicas = caracteristicas;
	}
}
