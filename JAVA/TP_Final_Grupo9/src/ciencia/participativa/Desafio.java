package ciencia.participativa;

import java.time.LocalDateTime;
import java.util.List;

import usuario.IParticipante;

public class Desafio {
	private Area 				 area;
	private RestriccionTemporal  restriccionTemporal;
	private int 				 cantidadDeMuestrasARecolectar;
	private int 				 cantidadDeMuestrasRecolectadas;
	private Dificultad 			 dificultad;
	private int 				 recompensa;
	private List<IParticipante>  participantes;
	private List<Caracteristica> caracteristicas;
	private IEstadoDesafio  estado;
	
	// ============== GETTERS & SETTERS ==============
	public Area getArea() {
		return area;
	}
	public void setArea(Area area) {
		this.area = area;
	}
	public RestriccionTemporal getRestriccionTemporal() {
		return restriccionTemporal;
	}
	public void setRestriccionTemporal(RestriccionTemporal restriccionTemporal) {
		this.restriccionTemporal = restriccionTemporal;
	}
	public int getCantidadDeMuestrasARecolectar() {
		return cantidadDeMuestrasARecolectar;
	}
	public void setCantidadDeMuestrasARecolectar(int cantidadDeMuestrasARecolectar) {
		this.cantidadDeMuestrasARecolectar = cantidadDeMuestrasARecolectar;
	}
	public int getCantidadDeMuestrasRecolectadas() {
		return cantidadDeMuestrasRecolectadas;
	}
	public void setCantidadDeMuestrasRecolectadas(int cantidadDeMuestrasRecolectadas) {
		this.cantidadDeMuestrasRecolectadas = cantidadDeMuestrasRecolectadas;
	}
	public Dificultad getDificultad() {
		return dificultad;
	}
	public void setDificultad(Dificultad dificultad) {
		this.dificultad = dificultad;
	}
	public int getRecompensa() {
		return recompensa;
	}
	public void setRecompensa(int recompensa) {
		this.recompensa = recompensa;
	}
	public List<IParticipante> getParticipantes() {
		return participantes;
	}
	public void setParticipantes(List<IParticipante> participantes) {
		this.participantes = participantes;
	}
	
	public List<Caracteristica> getCaracteristicas() {
		return caracteristicas;
	}
	public void setCaracteristicas(List<Caracteristica> caracteristicas) {
		this.caracteristicas = caracteristicas;
	}
	
	public IEstadoDesafio getEstado() {
		return estado;
	}
	public void setEstado(IEstadoDesafio estado) {
		this.estado = estado;
	}
	
	// ================== COSTRUCTOR ==================
	public Desafio(Area area, RestriccionTemporal restriccionTemporal,
			int cantidadDeMuestrasARecolectar,
			Dificultad dificultad, int recompensa, List <Caracteristica> caracteristicas) {
		this.area 							= area;
		this.restriccionTemporal 			= restriccionTemporal;
		this.cantidadDeMuestrasARecolectar  = cantidadDeMuestrasARecolectar;
		this.cantidadDeMuestrasRecolectadas = 0;
		this.dificultad 					= dificultad;
		this.recompensa 					= recompensa;
		this.caracteristicas                = caracteristicas;
	}

	
	// ================== METHODS ==================
	public Boolean esDesafioActivo() {
		return (LocalDateTime.now().isAfter(restriccionTemporal.getFechaDeInicio())
		 	 && LocalDateTime.now().isBefore(restriccionTemporal.getFechaDeCierre()));
	}
	
	public void agregarUsuarioAlDesafio(IParticipante usuario) {
		this.getParticipantes().add(usuario);
	}
}
