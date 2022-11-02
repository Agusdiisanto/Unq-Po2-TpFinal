package usuario;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import ciencia.participativa.Proyecto;
import desafios.Desafio;
import estadoDeUsuario.ProgresoDesafio;
import muestra.Muestra;

public class Usuario implements IParticipante{
	
	private String		          nombre;
	private AplicacionMovil 	  aplicacion;
	private Set<Proyecto> 		  proyectosEnCurso;
	private Perfil 				  perfil;   // Aca tenes las recomendaciones
	private Map<Desafio, Integer> desafiosCompletados;
	private Set<ProgresoDesafio>  desafiosEnCurso;
	
	  
	
	// ================== METHODS USUARIO ========================
	public void registrarDesafioCompleatado(Desafio desafio, int recompensa) {
		this.getDesafiosCompletados().put(desafio, recompensa);
	}
	
	//================== METHODS IPARTICIPANTE ====================
	
	@Override
	public void recolectarMuestra(Muestra m) throws Exception {
		this.recolectarMuestraParaLosDesafios(m);
		this.recolectarMuestraParaLosProyectos(m);
	}
	
	public void recolectarMuestraParaLosDesafios(Muestra muestra) throws Exception {
		for (ProgresoDesafio progresoDesafio : desafiosEnCurso) {
			progresoDesafio.recolectarMuestra(this, muestra);
		}
	}
	
	public void recolectarMuestraParaLosProyectos(Muestra muestra) throws Exception {
		for (Proyecto proyecto : this.getProyectoEnCurso()) {
			aplicacion.recolectarMuestra(muestra, this, proyecto);
		}
	}

	@Override
	public boolean estaEnDesafioActualmente() {
		return this.getDesafiosEnCurso().stream().anyMatch(p -> p.esDesafioActual());
	}

	@Override
	public void solicitarSuscripcionAProyecto(Proyecto proyecto) {
		proyecto.ingresarSolicitudAProyecto(this);  
	}
	
	@Override
	public void inscribirseEnUnDesafio(Desafio desafio) throws Exception {
		desafio.agregarUsuarioAlDesafio(this);
		this.agregarNuevoDesafioEnCurso(desafio);
	}
	
	@Override
	public void recibirRecompensaDeDesafio(Desafio desafio, int recompensa) {
		this.registrarDesafioCompleatado(desafio,recompensa);
	}
	
	// ================== PRIVATE =====================
	
	private void agregarNuevoDesafioEnCurso(Desafio desafio) {
		ProgresoDesafio progreso = new ProgresoDesafio(desafio);
		this.getDesafiosEnCurso().add(progreso);
	}
	
	// ================== COSTRUCTOR ==================
	public Usuario(String nombre, AplicacionMovil aplicacion, Perfil perfil) {
		this.nombre				 	= nombre;
		this.aplicacion			 	= aplicacion;
		this.perfil 			 	= perfil;
		this.proyectosEnCurso 	 	= new HashSet<Proyecto>();
		this.desafiosCompletados 	= new HashMap<Desafio, Integer>();
		this.desafiosEnCurso        = new HashSet<ProgresoDesafio>();
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
	public Set<Proyecto> getProyectoEnCurso() {
		return proyectosEnCurso;
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
	public Set<ProgresoDesafio> getDesafiosEnCurso() {
		return desafiosEnCurso;
	}
	

	
}
