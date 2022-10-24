package usuario;

import java.util.ArrayList;
import java.util.List;

import ciencia.participativa.Proyecto;
import ciencia.participativa.Sistema;
import desafios.Desafio;
import muestra.Muestra;

public class Usuario implements IParticipante{
	
	private String			nombre;
	private AplicacionMovil aplicacion;
	private List<Proyecto> 	proyectoEnCurso;
	private Perfil 			perfil;
	private List<Desafio> 	desafiosCompletados;

	// ============== GETTERS & SETTERS ==============
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
	public List<Desafio> getDesafiosCompletados() {
		return desafiosCompletados;
	}
	public void setDesafiosCompletados(List<Desafio> desafiosCompletados) {
		this.desafiosCompletados = desafiosCompletados;
	}
	
	// ================== COSTRUCTOR ==================
	public Usuario(String nombre, AplicacionMovil aplicacion, Perfil perfil) {
		this.nombre				 = nombre;
		this.aplicacion			 = aplicacion;
		this.proyectoEnCurso 	 = new ArrayList<>();
		this.perfil 			 = perfil;
		this.desafiosCompletados = new ArrayList<>();
	}
	
	
	// ================== METHODS ==================
	@Override
	public void recolectarMuestra(Muestra muestra) {
		for (Proyecto proyecto : this.getProyectoEnCurso()) {
			aplicacion.recolectarMuestra(muestra,proyecto);
		}
	}

	@Override
	public boolean estaEnDesafioActualmente(Desafio desafio) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void solicitarSuscripcionAProyecto(Proyecto proyecto, Sistema system) {

	}
	@Override
	public void recomendarParticipante(Sistema system, IParticipante x) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void calificarProyecto(Sistema system, Proyecto proyecto) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void inscribirseEnUnDesafio(Desafio desafio) throws Exception {
		desafio.agregarUsuarioAlDesafio(this);
	}
}
