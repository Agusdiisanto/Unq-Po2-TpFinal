package usuario;

import java.util.List;

import ciencia.participativa.Desafio;
import ciencia.participativa.Muestra;
import ciencia.participativa.Proyecto;
import ciencia.participativa.Sistema;

public interface IParticipante {

	public void recolectarMuestra(Muestra muestra);
	public void solicitarSuscripcionAProyecto(Proyecto proyecto, Sistema system);
	public void recomendarParticipante(Sistema system, IParticipante x);
	public List<Desafio> getDesafiosCompleatados();
	public void inscribirseEnUnDesafio(Desafio desafio);
	public boolean estaEnDesafioActualmente(Desafio desafio);
	public void calificarProyecto(Sistema system, Proyecto proyecto);
	public Perfil getPerfil();
	
	
	
}
