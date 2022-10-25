package usuario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ciencia.participativa.Proyecto;
import ciencia.participativa.Sistema;
import desafios.Desafio;
import muestra.Muestra;

public class Usuario implements IParticipante{
	
	private String			nombre;
	private AplicacionMovil aplicacion;
	private List<Proyecto> 	proyectoEnCurso;
	private Perfil 			perfil;
	private Map<Desafio, Integer>	desafiosCompletados;

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
	public Map<Desafio, Integer> getDesafiosCompletados() {
		return desafiosCompletados;
	}
	public void setDesafiosCompletados(Map<Desafio, Integer> desafiosCompletados) {
		this.desafiosCompletados = desafiosCompletados;
	}
	
	// ================== COSTRUCTOR ==================
	public Usuario(String nombre, AplicacionMovil aplicacion, Perfil perfil) {
		this.nombre				 = nombre;
		this.aplicacion			 = aplicacion;
		this.proyectoEnCurso 	 = new ArrayList<>();
		this.perfil 			 = perfil;
		this.desafiosCompletados = new HashMap<Desafio, Integer>();
	}
	
	// ================== METHODS USUARIO ========================
	
	public void registrarDesafioCompleatado(Desafio desafio, int recompensa) {
		if(this.ganoElDesafio(desafio)) {
			this.getDesafiosCompletados().put(desafio, recompensa);
		}
		else {
			this.getDesafiosCompletados().put(desafio, 0);
		}
	}
	
	private boolean ganoElDesafio(Desafio desafio) {
		return desafio.esElGanador(this);
	}
	
	// ================== METHODS IPARTICIPANTE ==================
	@Override
	public void recolectarMuestra(Muestra muestra) {
		for (Proyecto proyecto : this.getProyectoEnCurso()) {
			aplicacion.recolectarMuestra(muestra,proyecto);
		}
	}

	@Override
	public boolean estaEnDesafioActualmente(Desafio desafio) {
		return desafio.estaElParticipanteEnDesafio(this);
	}

	@Override
	public void solicitarSuscripcionAProyecto(Proyecto proyecto, Sistema system) {
		system.ingresarSolicitudAProyecto(proyecto,this);
	}
	
	@Override
	public void recomendarParticipante(Sistema system, IParticipante x) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void calificarProyecto(Sistema system, Proyecto proyecto, int calificacion) {
		system.calificarProyecto(proyecto,calificacion);
	}
	@Override
	public void inscribirseEnUnDesafio(Desafio desafio) throws Exception {
		desafio.agregarUsuarioAlDesafio(this);
	}
	@Override
	public void recibirRecompensaDeDesafio(Desafio desafio, int recompensa) {
		this.registrarDesafioCompleatado(desafio,recompensa);
	}
}
