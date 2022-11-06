package estadoDeUsuario;

import java.time.LocalDateTime;

import muestra.Muestra;
import usuario.IParticipante;


public interface IEstadoDelProgreso {
	
	public boolean esDesafioEnCurso(ProgresoDesafio progresoDesafio, LocalDateTime fecha);
	public void recolectarMuestra(ProgresoDesafio progresoDesafio , Muestra muestra, LocalDateTime fecha)throws Exception;
	public void registrarDesafioCompletado(IParticipante participante, ProgresoDesafio progresoDesafio, int sastifaccion);
	public boolean completoElDesafio(ProgresoDesafio progresoDesafio);
	public void verificarSiCompletoElDesafio(ProgresoDesafio progreso);
	
	
}
