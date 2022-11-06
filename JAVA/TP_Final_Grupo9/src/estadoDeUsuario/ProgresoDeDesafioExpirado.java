package estadoDeUsuario;

import java.time.LocalDateTime;

import muestra.Muestra;
import usuario.IParticipante;

public class ProgresoDeDesafioExpirado extends EstadoDeProgreso{
	
	@Override
	public void recolectarMuestra(ProgresoDeDesafio progresoDesafio, Muestra muestra, LocalDateTime fecha) throws Exception {
		throw new RuntimeException("Ya no puedes recolectar, el desafío ya ha expirado");	
	} 

	@Override
	public void registrarDesafioCompletado(IParticipante participante, ProgresoDeDesafio progresoDesafio, int sastifaccion) {
		throw new RuntimeException("Ya no puedes conceder recompensa, el desafío ya ha expirado");	
	}
	
	@Override
	public void verificarSiCompletoElDesafio(ProgresoDeDesafio progreso) {
		throw new RuntimeException("Ya no puedes verificar el progreso, el desafío ya ha expirado");	
	}
	 
}
