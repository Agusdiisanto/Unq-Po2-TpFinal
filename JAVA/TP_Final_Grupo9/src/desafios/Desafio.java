package desafios;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import caracteristicas.desafio.Area;
import caracteristicas.desafio.Caracteristica;
import caracteristicas.desafio.Dificultad;
import caracteristicas.desafio.RestriccionTemporal;
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
	private Map<IParticipante, Integer> puntaje;  // CONSULTA CON EL EQUIPO :D
	private EstadoDesafio  estado;
	
	
	// Es necesario separar los conceptos de Etado y Estado del Desafio
	// Cada usuario tiene un estado para el Desafio.
	// El estado del desario para el usuario esta vinculado al desafio.
	// Mejorar UML (Faltan unir cosas y hay flechas a reves)
	
	// ============== GETTERS & SETTERS ==============
	
	public Area getArea() {
		return area;
	}
	public Map<IParticipante, Integer> getPuntaje() {
		return puntaje;
	}
	public void setPuntaje(Map<IParticipante, Integer> puntaje) {
		this.puntaje = puntaje;
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
	
	public EstadoDesafio getEstado() {
		return estado;
	}
	public void setEstado(EstadoDesafio estado) {
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
	
	public void sumarPuntajeAParticipante(IParticipante participante) throws Exception {
		
		// Hay que implementarlo en algun otro metodo 
		
		int puntajeActual = this.getPuntaje().get(participante);
		this.getPuntaje().put(participante, puntajeActual+1);
		
		  	if (this.esGanador(participante)) {
				this.finalizarDesafio();
				this.otorgarRecompensaAlParticipante(participante);
		  	    }
	}
	
	public boolean esGanador(IParticipante participante) {
		
		// Este es un ESQUEMA
		// En el pdf no vi como se inidica que es ganador
		// Por el momento cuando un participante obtiene 5 puntos gana	
		return this.getPuntaje().get(participante) == 5;
	}
	
	public void finalizarDesafio() throws Exception {
		this.getEstado().finalizarDesafio(this);
	}
	
	public int contadorDeMuestraRestantes() {
		return this.getCantidadDeMuestrasARecolectar() - this.getCantidadDeMuestrasRecolectadas();
	}
	
	public void noHayMasMuestras() throws Exception {
		if (this.contadorDeMuestraRestantes() == 0) {
			this.finalizarDesafio();
		}
	}
	
	public boolean esElGanador(IParticipante participante) {
		return this.getPuntaje().get(participante) == 5; 
	}
	
	public void otorgarRecompensaAlParticipante(IParticipante participante) {
		participante.recibirRecompensaDeDesafio(this,this.getRecompensa());
	}
	
	
}
