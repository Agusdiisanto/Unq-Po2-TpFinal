package estadoDeUsuario;

import desafios.Desafio;
import muestra.Muestra;
import usuario.IParticipante;

public class ProgresoDesafio {
	
	private Desafio 		   desafioActual;
	private IEstadoDelProgreso estado;
	private int				   puntaje;
	
	// ================== COSTRUCTOR ==================
	public ProgresoDesafio(Desafio desafioActual) {
		this.desafioActual = desafioActual;
		this.estado        = new ProgresoDeDesafioEnCurso();
	}
 
	// ================== METHODS ==================
	public boolean esDesafioActual() {
		// TODO Auto-generated method stub
		return this.getEstado().esDesafioEnCurso(this);
	}
	
	// VER ESTO RARO 
	public void recolectarMuestra(IParticipante participante, Muestra muestra) throws Exception {
		this.getEstado().recolectarMuestra(this,muestra);
	}

	public boolean completoElDesafio() {
		return this.getEstado().completoElDesafio(this);
	}
	
	public void sumarPuntajeAParticipante() throws Exception {
		this.incrementarPuntajeEnUno();
	}

	public void otorgarRecompensaAlParticipante(IParticipante participante){
		this.getEstado().concederRecompensaDelDesafioA(participante, this);
	}

	public int recompensaDelDesafio() {
		return this.getDesafioActual().getRecompensa();
	}
	
	public boolean recolectoAlmenosUnaMuestra() {
		// TODO Auto-generated method stub
		return this.getPuntaje() >= 1;
	}
	
	public boolean esUnaMuestraValida(Muestra muestra) {
		// TODO Auto-generated method stub
		return estaLaMuestraDentroDelAreaDelDesafio(muestra) && estaLaMuestraDentroDeLaRestriccionDelDesafio(muestra);
	}

	
	// =============== PRIVATE METHODS ================
	private void incrementarPuntajeEnUno() {
		this.setPuntaje(this.getPuntaje()+1);
	}

	private boolean estaLaMuestraDentroDelAreaDelDesafio(Muestra muestra) {
		return this.getDesafioActual().estaLaMuestraDentroDelArea(muestra);
	}

	private boolean estaLaMuestraDentroDeLaRestriccionDelDesafio(Muestra muestra) {
		return this.getDesafioActual().estaLaMuestraDentroDeLaRestriccion(muestra);
	}
	
	// ============== GETTERS & SETTERS ==============
	public Desafio getDesafioActual() {
		return desafioActual;
	}

	public IEstadoDelProgreso getEstado() {
		return estado;
	}
	
	public void setDesafioActual(Desafio desafioActual) {
		this.desafioActual = desafioActual;
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

	
}
