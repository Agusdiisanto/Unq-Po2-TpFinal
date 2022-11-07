package estadoDeUsuario;

import java.time.LocalDateTime;

import muestra.Muestra;
import usuario.IParticipante;

/**
 * 
 * 
 * Esta interfaz se encarga de verificar el estado del progreso de un desafío.
 *
 */

public interface IEstadoDelProgreso {
	public boolean esDesafioEnCurso(ProgresoDeDesafio progresoDesafio, LocalDateTime fecha);
	public void recolectarMuestra(ProgresoDeDesafio progresoDesafio , Muestra muestra, LocalDateTime fecha)throws Exception;
	public void registrarDesafioCompletado(IParticipante participante, ProgresoDeDesafio progresoDesafio, int sastifaccion);
	public boolean completoElDesafio(ProgresoDeDesafio progresoDesafio);
	public void verificarSiCompletoElDesafio(ProgresoDeDesafio progreso);
}
