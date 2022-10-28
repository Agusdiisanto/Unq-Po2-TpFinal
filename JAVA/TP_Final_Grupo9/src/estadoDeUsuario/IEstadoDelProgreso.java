package estadoDeUsuario;

import muestra.Muestra;

public interface IEstadoDelProgreso {
	
	public boolean esDesafioEnCurso();
	public void recolectarMuestra(Muestra muestra) throws Exception;
	public void recibirRecompensaDesafio() throws Exception ;
	
}
