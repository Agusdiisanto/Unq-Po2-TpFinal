package desafios;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import caracteristicas.desafio.Area;
import caracteristicas.desafio.Caracteristica;
import caracteristicas.desafio.Dificultad;
import caracteristicas.desafio.RestriccionTemporal;
import muestra.Muestra;
import usuario.IParticipante;

public class Desafio extends ActividadLudica {
	private Area 				area;
	private RestriccionTemporal restriccionTemporal;
	private int 				cantidadDeMuestrasARecolectar;
	private Dificultad 			dificultad;
	private int 				recompensa;
	private Set<IParticipante>  participantes;
	private Set<Caracteristica> caracteristicas;
	
	// Es necesario separar los conceptos de Etado y Estado del Desafio
	// Cada usuario tiene un estado para el Desafio.
	// El estado del desario para el usuario esta vinculado al desafio.
	// Mejorar UML (Faltan unir cosas y hay flechas a reves)

	// ================== METHODS ==================
	public Boolean esDesafioActivo() {
		return (LocalDateTime.now().isAfter(restriccionTemporal.getFechaDeInicio())
		 	 && LocalDateTime.now().isBefore(restriccionTemporal.getFechaDeCierre()));
	}
	
	public void agregarUsuarioAlDesafio(IParticipante usuario) throws Exception {
		// Un participante puede ingresar a un desafío que aún no haya arrancado
		// pero solo se contabilizan las muestras a partir del inicio del desafío.
		if (sePuedeInscribir()) {
			this.getParticipantes().add(usuario);
		}
	}
	
	public boolean estaLaMuestraDentroDelArea(Muestra muestra) {
		// Santi 
		return true;
	}
	
	public boolean estaDentroDeLaRestriccion(LocalDateTime localDateTime) {
		return this.getRestriccionTemporal().estaHabilitado(localDateTime);
	}
	
	public boolean estaLaMuestraDentroDeLaRestriccion(Muestra muestra) {
		// TODO Auto-generated method stub
		return this.getRestriccionTemporal().estaHabilitado(muestra.getFechaYHoraDeRecoleccion());
	}
	
	
	// ================ PRIVATE METHODS ================
	private boolean sePuedeInscribir() {
		return this.getRestriccionTemporal().getFechaDeCierre().isAfter(LocalDateTime.now());
	}

	
	// ================== COSTRUCTOR ==================
	public Desafio(Area 			   area,
				   RestriccionTemporal restriccionTemporal,
				   int 				   cantidadDeMuestrasARecolectar,
				   Dificultad 		   dificultad,
				   int				   recompensa) {
		this.area 							= area;
		this.restriccionTemporal 			= restriccionTemporal;
		this.cantidadDeMuestrasARecolectar  = cantidadDeMuestrasARecolectar;
		this.dificultad 					= dificultad;
		this.recompensa 					= recompensa;
		this.caracteristicas                = new HashSet<Caracteristica>();
	}

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
	public Set<IParticipante> getParticipantes() {
		return participantes;
	}
	public Set<Caracteristica> getCaracteristicas() {
		return caracteristicas;
	}

	

	
}
