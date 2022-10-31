package usuario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ciencia.participativa.Proyecto;
import ciencia.participativa.Sistema;
import desafios.Desafio;
import estadoDeUsuario.ProgresoDesafio;
import estrategiaDeRecomendacion.IRecomendacion;
import muestra.Muestra;

public class Usuario implements IParticipante{
	private String				  nombre;
	private AplicacionMovil 	  aplicacion;
	private List<Proyecto> 		  proyectosEnCurso;
	private Perfil 				  perfil;
	private Map<Desafio, Integer> desafiosCompletados;
	private List<ProgresoDesafio> desafiosEnCurso;
	private IRecomendacion        recomendacionPreferida;
	
	// ================== METHODS USUARIO ========================
	public void registrarDesafioCompleatado(Desafio desafio, int recompensa) {
		this.getDesafiosCompletados().put(desafio, recompensa);
	}
	
	// ================== METHODS IPARTICIPANTE ==================
	
	@Override
	public void recolectarMuestra(Muestra muestra) throws Exception {
		this.recolectarMuestraParaLosProyectos(muestra);
		this.recolectarMuestraParaLosDesafios(muestra);
	}
	
	public void recolectarMuestraParaLosDesafios(Muestra muestra) throws Exception {
		for (ProgresoDesafio desafio : this.getDesafiosEnCurso()) {
			desafio.recolectarMuestra(this,muestra);
		}
		
	}
	
	public void recolectarMuestraParaLosProyectos(Muestra muestra) {
		for (Proyecto proyecto : this.getProyectoEnCurso()) {
			aplicacion.recolectarMuestraParaProyecto(muestra,proyecto);
		}
	}

	@Override
	public boolean estaEnDesafioActualmente() {
		return this.getDesafiosEnCurso().stream().anyMatch(p -> p.esDesafioActual());
	}

	@Override
	public void solicitarSuscripcionAProyecto(Proyecto proyecto, Sistema system) {
		system.ingresarSolicitudAProyecto(proyecto,this);
	}
	
	@Override
	public void inscribirseEnUnDesafio(Desafio desafio) throws Exception {
		desafio.agregarUsuarioAlDesafio(this);
	}
	
	@Override
	public void recibirRecompensaDeDesafio(Desafio desafio, int recompensa) {
		this.registrarDesafioCompleatado(desafio,recompensa);
	}
	
	// ================== COSTRUCTOR ==================
	public Usuario(String nombre, AplicacionMovil aplicacion, Perfil perfil, IRecomendacion recomendacionPreferida) {
		this.nombre				 = nombre;
		this.aplicacion			 = aplicacion;
		this.proyectosEnCurso 	 = new ArrayList<>();
		this.perfil 			 = perfil;
		this.desafiosCompletados = new HashMap<Desafio, Integer>();
		this.recomendacionPreferida= recomendacionPreferida;
	}

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
		return proyectosEnCurso;
	}
	public void setProyectoEnCurso(List<Proyecto> proyectoEnCurso) {
		this.proyectosEnCurso = proyectoEnCurso;
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
	
	public List<ProgresoDesafio> getDesafiosEnCurso() {
		return desafiosEnCurso;
	}
	
	public void setDesafiosEnCurso(List<ProgresoDesafio> desafiosEnCurso) {
		this.desafiosEnCurso = desafiosEnCurso;
	}
	
	public IRecomendacion getRecomendacionPreferida() {
		return recomendacionPreferida;
	}
}
