package estadoDeUsuario;

import muestra.Muestra;
import usuario.IParticipante;


public interface IEstadoDelProgreso {
	
	public boolean esDesafioEnCurso(ProgresoDesafio progresoDesafio);
	public void recolectarMuestra(ProgresoDesafio progresoDesafio , Muestra muestra)throws Exception;
	public void registrarDesafioCompletado(IParticipante participante, ProgresoDesafio progresoDesafio, int sastifaccion);
	public boolean completoElDesafio(ProgresoDesafio progresoDesafio);
	public void verificarSiCompletoElDesafio(ProgresoDesafio progreso);
	
	
}
