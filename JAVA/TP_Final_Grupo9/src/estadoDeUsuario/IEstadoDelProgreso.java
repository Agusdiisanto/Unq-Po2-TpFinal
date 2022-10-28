package estadoDeUsuario;

import muestra.Muestra;
import usuario.IParticipante;

public interface IEstadoDelProgreso {
	
	public boolean esDesafioEnCurso();
	public void recolectarMuestraPorParticipante(IParticipante participante,Muestra muestra) throws Exception;
	public void recibirRecompensaDesafio() throws Exception ;
	
}
