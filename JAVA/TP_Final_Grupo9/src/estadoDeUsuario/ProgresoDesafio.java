package estadoDeUsuario;

import desafios.Desafio;
import muestra.Muestra;
import usuario.IParticipante;

public class ProgresoDesafio {
	
	private Desafio desafioActual;
	private IEstadoDelProgreso estado;
	private int puntaje;

	public ProgresoDesafio(Desafio desafioActual) {
		super();
		this.desafioActual = desafioActual;
	}

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
	
	public boolean esDesafioActual() {
		// TODO Auto-generated method stub
		return this.getEstado().esDesafioEnCurso();
	}
	
	public void recolectarMuestra(IParticipante participante, Muestra muestra) throws Exception {
		
		// Ver si el mensaje incrementar lo ponemos dentro del recolectar muestra o lo dejamos ahi
		
		if (this.getDesafioActual().estaLaMuestraDentroDelArea(muestra)) {
			this.getEstado().recolectarMuestraPorParticipante(participante,muestra);
			this.getDesafioActual().incrementarLaCantidadTotalDeRecoleccion();
		}
	}
	
	public boolean esGanador(IParticipante participante) {
		
		// Este es un ESQUEMA
		// En el pdf no vi como se inidica que es ganador
		// Por el momento cuando un participante obtiene 5 puntos gana	
		return this.getPuntaje() == 5;
	}
	
	public void sumarPuntajeAParticipante(IParticipante participante) throws Exception {
		
		// Hay que implementarlo en algun otro metodo 
		this.puntaje = puntaje + 1;
		  	if (this.esGanador(participante)) {
				this.otorgarRecompensaAlParticipante(participante);
		  	}
	}
	
	public void otorgarRecompensaAlParticipante(IParticipante participante) {
		participante.recibirRecompensaDeDesafio(this,this.getDesafioActual().getRecompensa());
	}
	
}
