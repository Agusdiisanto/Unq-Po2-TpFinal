package estadoDeUsuario;

import desafios.Desafio;
import muestra.Muestra;


public interface IEstadoDelProgreso {
	
	public boolean esDesafioEnCurso(Desafio desafio);
	public void recolectarMuestra(ProgresoDesafio progresoDesafio , Muestra muestra)throws Exception;
	public void recibirRecompensaDesafio() throws Exception;
	public boolean completoElDesafio(ProgresoDesafio progresoDesafio);
}
