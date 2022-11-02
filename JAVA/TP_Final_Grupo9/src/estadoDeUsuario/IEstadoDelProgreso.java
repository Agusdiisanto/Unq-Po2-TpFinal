package estadoDeUsuario;

import muestra.Muestra;
import usuario.IParticipante;


public interface IEstadoDelProgreso {
	
	public boolean esDesafioEnCurso(ProgresoDesafio progresoDesafio);
	public void recolectarMuestra(ProgresoDesafio progresoDesafio , Muestra muestra)throws Exception;
	public void concederRecompensaDelDesafioA(IParticipante participante, ProgresoDesafio progresoDesafio);
	public boolean completoElDesafio(ProgresoDesafio progresoDesafio);
	public void verificarSiCompletoElDesafio(ProgresoDesafio progreso);
	
	
}
