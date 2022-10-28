package estadoDeUsuario;

import desafios.Desafio;
import muestra.Muestra;
import usuario.IParticipante;

public class ProgresoDesafio {
	
	private Desafio desafioActual;
	private IEstadoDelProgreso estado;

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
	
	public boolean esDesafioActual() {
		// TODO Auto-generated method stub
		return this.getEstado().esDesafioEnCurso();
	}
	
	public void recolectarMuestra(IParticipante participante, Muestra muestra) throws Exception {
		
		// Ver si el mensaje incrementar lo ponemos dentro del recolectar muestra o lo dejamos ahi
		
		if (this.getDesafioActual().estaLaMuestraDentroDelArea(muestra)) {
			this.getEstado().recolectarMuestraPorParticipante(participante,muestra);
			this.getDesafioActual().sumarPuntajeAParticipante(participante);
			this.getDesafioActual().incrementarLaCantidadTotalDeRecoleccion();
		}
	}
	
	
}
