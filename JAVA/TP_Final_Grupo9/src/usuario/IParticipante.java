package usuario;

import ciencia.participativa.Proyecto;
import ciencia.participativa.Sistema;
import desafios.Desafio;
import muestra.Muestra;

public interface IParticipante {
	
	// Agus : pensando si IPARTICIPANTE tendria que ser clase o interface 
	
	public void recolectarMuestra(Muestra muestra);
	public void solicitarSuscripcionAProyecto(Proyecto proyecto, Sistema system);
	public void recomendarParticipante(Sistema system, IParticipante x);
	public void inscribirseEnUnDesafio(Desafio desafio) throws Exception ;
	public boolean estaEnDesafioActualmente(Desafio desafio);
	public void calificarProyecto(Sistema system, Proyecto proyecto, int calificacion);
	public Perfil getPerfil();
}
