package estadoDeUsuario;

import java.time.LocalDateTime;
import java.util.Set;

import actividad.Desafio;
import muestra.Muestra;
import usuario.IParticipante;

/**
 * 
 * Esta clase se encarga de modelar el progreso de un desafío.
 * 
 */

public class ProgresoDeDesafio {
	private Desafio 		   desafioActual;
	private IEstadoDelProgreso estado;
	private int				   puntaje;
	private Set<Muestra>   	   muestras;
	
 
	// ================== METHODS ==================
	public boolean esDesafioActual(LocalDateTime fecha) {
		return this.getEstado().esDesafioEnCurso(this, fecha);
	}
	 
	public void recolectarMuestra(IParticipante participante, Muestra muestra , LocalDateTime fecha) throws Exception {
		this.getEstado().recolectarMuestra(this,muestra, fecha);
		this.agregarMuestra(muestra);
	}

	public boolean completoElDesafio() {
		return this.getEstado().completoElDesafio(this);
	}
	
	public void sumarPuntajeAParticipante(){
		this.incrementarPuntajeEnUno();
	}
 
	public void registrarDesafioCompletado(IParticipante participante, int sastifaccion){
		this.getEstado().registrarDesafioCompletado(participante, this, sastifaccion);
	}

	public int recompensaDelDesafio() {
		return this.getDesafioActual().getRecompensa();
	}
	
	public boolean recolectoAlmenosUnaMuestra() {
		return this.getPuntaje() >= 1;
	}
	
	public boolean esUnaMuestraValida(Muestra muestra) {
		return estaLaMuestraDentroDelAreaDelDesafio(muestra)
			&& estaLaMuestraDentroDeLaRestriccionDelDesafio(muestra);
	}
	
	
	// =============== PRIVATE METHODS ================
	private void incrementarPuntajeEnUno() {
		this.setPuntaje(this.getPuntaje()+1);
	}

	private boolean estaLaMuestraDentroDelAreaDelDesafio(Muestra muestra) {
		return this.getDesafioActual().includes(muestra);
	}

	private boolean estaLaMuestraDentroDeLaRestriccionDelDesafio(Muestra muestra) {
		return this.getDesafioActual().esMuestraValida(muestra);
	}
	
	// ================== COSTRUCTOR ==================
	public ProgresoDeDesafio(Desafio desafioActual, IEstadoDelProgreso estado) {
		this.setDesafioActual(desafioActual);
		this.setEstado(estado);
		this.setPuntaje(0);
	}
	
	// ============== GETTERS & SETTERS ==============
	public Desafio getDesafioActual() {
		return desafioActual;
	}
	void setDesafioActual(Desafio desafioActual) {
		this.desafioActual = desafioActual;
	}
	public IEstadoDelProgreso getEstado() {
		return estado;
	}
	public void setEstado(IEstadoDelProgreso estado) {
		this.estado = estado;
	}
	public int getPuntaje() {
		return puntaje;
	}
	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
	public Set<Muestra> getMuestras() {
		return muestras;
	}
	
	public void agregarMuestra(Muestra muestra) {
		this.getMuestras().add(muestra);
	}
	
	
}
