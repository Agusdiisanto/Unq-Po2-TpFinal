package muestra;

import java.time.LocalDateTime;
import java.util.List;

import ciencia.participativa.Proyecto;
import usuario.IParticipante;
import usuario.Usuario;

public class Muestra {
	
	private List<String> caracteristicas;
	private Usuario usuarioQueLaRecolecto;
	private LocalDateTime fechaYHoraDeRecoleccion;
	private Coordenada coordenadaDeRecollecion;
	

	public Muestra(List<String> caracteristicas, Usuario usuarioQueLaRecolecto, 
			       LocalDateTime fechaYHoraDeRecoleccion,
			       Coordenada coordenadaDeRecollecion) {
		this.caracteristicas = caracteristicas;
		this.usuarioQueLaRecolecto = usuarioQueLaRecolecto;
		this.fechaYHoraDeRecoleccion = fechaYHoraDeRecoleccion;
		this.coordenadaDeRecollecion = coordenadaDeRecollecion;
	}

	public List<String> getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(List<String> caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	public Usuario getUsuarioQueLaRecolecto() {
		return usuarioQueLaRecolecto;
	}

	public void setUsuarioQueLaRecolecto(Usuario usuarioQueLaRecolecto) {
		this.usuarioQueLaRecolecto = usuarioQueLaRecolecto;
	}

	public LocalDateTime getFechaYHoraDeRecoleccion() {
		return fechaYHoraDeRecoleccion;
	}

	public void setFechaYHoraDeRecoleccion(LocalDateTime fechaYHoraDeRecoleccion) {
		this.fechaYHoraDeRecoleccion = fechaYHoraDeRecoleccion;
	}

	public Coordenada getCoordenadaDeRecollecion() {
		return coordenadaDeRecollecion;
	}

	public void setCoordenadaDeRecollecion(Coordenada coordenadaDeRecollecion) {
		this.coordenadaDeRecollecion = coordenadaDeRecollecion;
	}

	public boolean tieneLaCaracteristica(String interes) {
		return caracteristicas.contains(interes);
	}
	
	//Ver
	public void registrarMuestraEnProyectoPorUsario(Proyecto proyecto, IParticipante participante) throws Exception {
		this.notificar(proyecto);
		participante.recolectarMuestra(this);
	}
	
	
	//Sacar??
	public void notificar(Proyecto proyecto) {
		proyecto.esMuestraDeInteres(this);
	}
}
