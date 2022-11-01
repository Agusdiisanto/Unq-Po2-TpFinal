package estadoDeUsuario;

import desafios.Desafio;
import muestra.Muestra;
import usuario.IParticipante;

public class ProgresoDesafio {
	
	private Desafio 		   desafioActual;
	private IEstadoDelProgreso estado;
	private int				   puntaje;
	
	// ================== METHODS ==================
	public boolean esDesafioActual() {
		// TODO Auto-generated method stub
		return this.getEstado().esDesafioEnCurso(this.getDesafioActual());
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

	public void otorgarRecompensaAlParticipante(IParticipante participante) {
		participante.recibirRecompensaDeDesafio(this.getDesafioActual(),this.getDesafioActual().getRecompensa());
	}
	
	
	// =============== PRIVATE METHODS ================
	private void incrementarPuntajeEnUno() {
		this.setPuntaje(this.getPuntaje()+1);
	}

	// ================== COSTRUCTOR ==================
	public ProgresoDesafio(Desafio desafioActual) {
		this.desafioActual = desafioActual;
		this.estado        = new ProgresoDeDesafioPorIniciar();
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
