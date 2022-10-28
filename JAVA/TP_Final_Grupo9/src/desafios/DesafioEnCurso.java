package desafios;

import usuario.IParticipante;

public class DesafioEnCurso implements IEstadoDesafio {
	
	public void aceptarParticipante(IParticipante participante, Desafio desafio) throws Exception {
		
		// ======= DUDA ========
		// Para santi si podria agregar participantes estando el desafio en curso
		// Para Agus quiza el desafio comienza cuando hay una x cantidad de participantes
		// y cuando esta en curso tiraria una excepcion diciendo el desafio ya esta en curso 
		// espere al siguiente
		// por el momento lo dejo como dijo santi
		
		
		desafio.IngresoDeParticipanteADesafio(participante);
		desafio.getPuntaje().put(participante,0);
		
	}

	public boolean esDesafioActivo() {
		// TODO Auto-generated method stub
		return true;
	}

	public void finalizarDesafio(Desafio desafio) {
		desafio.setEstado(new DesafioFinalizado());
	}



}
