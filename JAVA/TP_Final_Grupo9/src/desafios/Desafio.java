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

	// ================== METHODS ==================
	@Override
	public boolean esDesafio() {
		return true;
	}
	
	public Boolean esDesafioActivo() {
		return LocalDateTime.now().isAfter(this.getRestriccionTemporal().getFechaDeInicio())
			&& LocalDateTime.now().isBefore(this.getRestriccionTemporal().getFechaDeCierre());
	} 
	
	public boolean estaLaMuestraDentroDelArea(Muestra muestra) {
		int x = muestra.getCoordenadaDeRecollecion().getCoordenadaX() - this.getArea().getLatitud();
		int y = muestra.getCoordenadaDeRecollecion().getCoordenadaY() - this.getArea().getLongitud();
		return Math.pow(x, 2) + Math.pow(y, 2) <= Math.pow(this.getArea().getRadio(), 2);
	}
	
	public boolean estaDentroDeLaRestriccion(LocalDateTime fecha) {
		return this.getRestriccionTemporal().cumpleLaRestriccion(fecha);
	}
	
	public boolean estaLaMuestraDentroDeLaRestriccion(Muestra muestra) {
		return this.getRestriccionTemporal().cumpleLaRestriccion(muestra.getFechaYHoraDeRecoleccion());
	}
	
	// ================ ADD METHODS ================
	public void agregarParticipanteAlDesafio(IParticipante usuario) {
		// Un participante puede ingresar a un desafío que aún no haya arrancado
		// pero solo se contabilizan las muestras a partir del inicio del desafío.
		if (sePuedeInscribir()) {
			this.getParticipantes().add(usuario);
		}
	}
	
	public void agregarCaracteristica(Caracteristica caracteristica) {
		this.getCaracteristicas().add(caracteristica);
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
		this.participantes					= new HashSet<IParticipante>();
		this.caracteristicas                = new HashSet<Caracteristica>();
	}

	// ============== GETTERS & SETTERS ==============
	public Area getArea() {
		return area;
	}
	public RestriccionTemporal getRestriccionTemporal() {
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
}
