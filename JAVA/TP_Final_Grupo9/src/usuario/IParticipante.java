package usuario;

import ciencia.participativa.Proyecto;
import ciencia.participativa.Sistema;
import desafios.Desafio;
import muestra.Muestra;

public interface IParticipante {
	
	// Agus : pensando si IPARTICIPANTE tendria que ser clase o interface s 
	
	public void recolectarMuestra(Muestra muestra);
	public void solicitarSuscripcionAProyecto(Proyecto proyecto, Sistema system);
	public void inscribirseEnUnDesafio(Desafio desafio) throws Exception ;
	public boolean estaEnDesafioActualmente();
	public void recibirRecompensaDeDesafio(Desafio desafio, int recompensa);
}
