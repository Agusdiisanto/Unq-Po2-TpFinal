package usuario;

import ciencia.participativa.Proyecto;
import ciencia.participativa.Sistema;
import desafios.Desafio;
import estadoDeUsuario.ProgresoDesafio;
import muestra.Muestra;

public interface IParticipante {
	
	// Agus : pensando si IPARTICIPANTE tendria que ser clase o interface s 
	
	public void recolectarMuestra(Muestra muestra) throws Exception;
	public void solicitarSuscripcionAProyecto(Proyecto proyecto, Sistema system);
	public void inscribirseEnUnDesafio(Desafio desafio) throws Exception ;
	public boolean estaEnDesafioActualmente();
	public void recibirRecompensaDeDesafio(ProgresoDesafio progresoDesafio, int recompensa);
	public AplicacionMovil getAplicacion();
	void recibirRecompensaDeDesafio(Desafio desafio, int recompensa);
	
}
