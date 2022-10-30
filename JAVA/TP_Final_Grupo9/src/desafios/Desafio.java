package desafios;

import java.time.LocalDateTime;
import java.util.List;

import caracteristicas.desafio.Area;
import caracteristicas.desafio.Caracteristica;
import caracteristicas.desafio.Dificultad;
import caracteristicas.desafio.RestriccionTemporal;
import muestra.Muestra;
import usuario.IParticipante;

public class Desafio extends ActividadLudica {
	private Area 				 area;
	private RestriccionTemporal  restriccionTemporal;
	private int 				 cantidadDeMuestrasARecolectar;
	private int 				 cantidadDeMuestrasRecolectadas; 
	private Dificultad 			 dificultad;
	private int 				 recompensa;
	private List<IParticipante>  participantes;
	private List<Caracteristica> caracteristicas;
	private IEstadoDesafio  estado;
	
	
	// Es necesario separar los conceptos de Etado y Estado del Desafio
	// Cada usuario tiene un estado para el Desafio.
	// El estado del desario para el usuario esta vinculado al desafio.
	// Mejorar UML (Faltan unir cosas y hay flechas a reves)
	
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
	public void setEstado(IEstadoDesafio desafioFinalizado) {
		this.estado = desafioFinalizado;
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
	
	public void agregarUsuarioAlDesafio(IParticipante usuario) throws Exception {
		this.getEstado().aceptarParticipante(usuario,this) ;
	}
	public void IngresoDeParticipanteADesafio(IParticipante participante) throws Exception {
		
		if (this.estaElParticipanteEnDesafio(participante)) {
			throw new RuntimeException("Ya ha sido registrado en el desafio");	
		}
		else {
			this.getParticipantes().add(participante);
		}
	}
	 
	public boolean estaElParticipanteEnDesafio(IParticipante participante) {
		return this.getParticipantes().contains(participante);
	}
	
	public void finalizarDesafio() throws Exception {
		this.getEstado().finalizarDesafio(this);
	}
	
	public boolean esElGanador(IParticipante participante) {
		return false;
	}
	
	
	public boolean estaLaMuestraDentroDelArea(Muestra muestra) {
		// TODO Auto-generated method stub
		return true;
	}
	
	public void incrementarLaCantidadTotalDeRecoleccion() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public boolean esDesafio() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
	
	
}
