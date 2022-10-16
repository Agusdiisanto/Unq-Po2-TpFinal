package usuario;

import java.util.List;

import ciencia.participativa.AplicacionMovil;
import ciencia.participativa.Desafio;
import ciencia.participativa.Desafios;
import ciencia.participativa.Muestra;
import ciencia.participativa.Proyecto;
import ciencia.participativa.Sistema;

public class Usuario implements IParticipante{
	
	private String nombre;
	private AplicacionMovil aplicacion;
	private List<Proyecto> proyectoEnCurso;
	private Perfil perfil;
	private List<Desafios> desafiosCompletados;
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public AplicacionMovil getAplicacion() {
		return aplicacion;
	}

	public void setAplicacion(AplicacionMovil aplicacion) {
		this.aplicacion = aplicacion;
	}

	public List<Proyecto> getProyectoEnCurso() {
		return proyectoEnCurso;
	}

	public void setProyectoEnCurso(List<Proyecto> proyectoEnCurso) {
		this.proyectoEnCurso = proyectoEnCurso;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public List<Desafios> getDesafiosCompletados() {
		return desafiosCompletados;
	}

	public void setDesafiosCompletados(List<Desafios> desafiosCompletados) {
		this.desafiosCompletados = desafiosCompletados;
	}

	
	
	@Override
	public void recolectarMuestra(Muestra muestra) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void solicitarSuscripcionAProyecto(Proyecto proyecto, Sistema system) {
		system.ingresarSolicitudAProyecto(proyecto);
	}

	@Override
	public void recomendarParticipante(Sistema system, IParticipante x) {
		system.realizarRecomendacionAParticipante(x);
	}

	@Override
	public List<Desafio> getDesafiosCompleatados() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void inscribirseEnUnDesafio(Desafio desafio) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean estaEnDesafioActualmente(Desafio desafio) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void calificarProyecto(Sistema system, Proyecto proyecto) {
		system.puntuarProyecto(proyecto);
	}



	

}
