package estadoDeUsuario;

import java.time.LocalDateTime;

import muestra.Muestra;
import usuario.IParticipante;

public class ProgresoDeDesafioExpirado extends EstadoDeProgreso{
		
	@Override
	public void recolectarMuestra(ProgresoDesafio progresoDesafio, Muestra muestra, LocalDateTime fecha) throws Exception {
		throw new RuntimeException("Ya no puedes recolectar, el desafio ya ha expirado");	
	} 

	@Override
	public void registrarDesafioCompletado(IParticipante participante, ProgresoDesafio progresoDesafio, int sastifaccion) {
		throw new RuntimeException("Ya no puedes conceder recompensa, el desafio ya ha expirado");	
	}
	
	@Override
	public void verificarSiCompletoElDesafio(ProgresoDesafio progreso) {
		throw new RuntimeException("Ya no puedes verificar el progreso del desafio porque ya ha expirado");	
	}
	 
}
