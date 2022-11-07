package usuario;

import java.time.LocalDateTime;

import actividad.Desafio;
import muestra.Muestra;
import proyectos.Proyecto;

/**
 * 
 * Esta interfaz se encarga modelar los metodos de un participante.
 *
 */

public interface IParticipante {
	
	public void recolectarMuestra(Muestra muestra) throws Exception;
	public void solicitarSuscripcionAProyecto(Proyecto proyecto);
	public void inscribirseEnUnDesafio(Desafio desafio) throws Exception ;
	public boolean estaEnDesafioActualmente(LocalDateTime fecha);
	public AplicacionMovil getAplicacion();
	public void registrarDesafioCompletado(Desafio desafio, int recompensa, int muestrasRecolectadas, int satisfaccion);
}
