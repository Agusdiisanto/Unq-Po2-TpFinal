package usuario;

import actividad.Desafio;
import muestra.Muestra;
import proyectos.Proyecto;

public interface IParticipante {
	
	public void recolectarMuestra(Muestra muestra) throws Exception;
	public void solicitarSuscripcionAProyecto(Proyecto proyecto);
	public void inscribirseEnUnDesafio(Desafio desafio) throws Exception ;
	public boolean estaEnDesafioActualmente();
	public AplicacionMovil getAplicacion();
	public void registrarDesafioCompletado(Desafio desafio, int recompensa, int muestrasRecolectadas, int satisfaccion);
}
