package estadoDeUsuario;

import desafios.Desafio;
import usuario.IParticipante;

public class ProgresoDesafio {
	
	private Desafio desafioActual;
	private IEstadoDelProgreso estado;
	private IParticipante participante;

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
	
	public IParticipante getParticipante() {
		return participante;
	}

	public void setParticipante(IParticipante participante) {
		this.participante = participante;
	}

	
	public boolean esDesafioActual() {
		// TODO Auto-generated method stub
		return this.getEstado().esDesafioEnCurso();
	}
	
	
}
