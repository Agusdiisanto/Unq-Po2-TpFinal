package estadoDeUsuario;

import java.time.LocalDateTime;

import muestra.Muestra;
import usuario.IParticipante;

public class EstadoDeProgreso implements IEstadoDelProgreso {

	@Override
	public boolean esDesafioEnCurso(ProgresoDesafio progresoDesafio, LocalDateTime fecha) { return false;}

	@Override
	public void recolectarMuestra(ProgresoDesafio progresoDesafio, Muestra muestra, LocalDateTime fecha) throws Exception {
		
	}
	 
	@Override
	public void registrarDesafioCompletado(IParticipante participante, ProgresoDesafio progresoDesafio, int sastifaccion) {}
	
	@Override
	public boolean completoElDesafio(ProgresoDesafio progresoDesafio) {return false;}

	@Override
	public void verificarSiCompletoElDesafio(ProgresoDesafio progreso) {}
}
 