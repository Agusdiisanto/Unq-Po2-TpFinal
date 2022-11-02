package usuario;

import ciencia.participativa.Proyecto;
import desafios.Desafio;
import muestra.Muestra;

public interface IParticipante {
	
	public void recolectarMuestra(Muestra muestra) throws Exception;
	public void solicitarSuscripcionAProyecto(Proyecto proyecto);
	public void inscribirseEnUnDesafio(Desafio desafio) throws Exception ;
	public boolean estaEnDesafioActualmente();
	public AplicacionMovil getAplicacion();
	public void recibirRecompensaDeDesafio(Desafio desafio, int recompensa);
	public void registrarDesafioCompleatado(Desafio desafio, int recompensa);

}
