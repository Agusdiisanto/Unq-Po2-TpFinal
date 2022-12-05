package usuario;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;

import actividad.Caracteristica;
import actividad.Desafio;

import java.util.Set;
import java.util.stream.Collectors;

import estadoDeUsuario.ProgresoDeDesafioEnCurso;
import estadoDeUsuario.ProgresoDeDesafio;
import muestra.Muestra;
import proyectos.Proyecto;

/**
 * 
 * Esta clase se encarga de modelar a un usuario.
 *
 */

public class Usuario implements IParticipante{
	private String		          	   nombre;
	private Set<Proyecto> 		  	   proyectosEnCurso;
	private Perfil 				  	   perfil;
	private Map<Desafio, Estadisticas> desafiosCompletados;
	private Set<ProgresoDeDesafio>     desafiosEnCurso; 
	
	// ================== METHODS USUARIO ========================
	public boolean contieneCaracteristicaConDescripcion(String descripcion) {
		return this.getPerfil().includesCaracteristicaConDescripcion(descripcion);
	}
	
	public double afinidadConCaracteristica(Caracteristica caracteristica) {
		return this.getPerfil().afinidadConCaracteristica(caracteristica);
	}
 
	public EstrategiaDeRecomendacion getEstrategia() {
		return this.getPerfil().getRecomendacionPreferida();
	}  
  
	public double similitudConFavorito(Desafio desafio) {
		double diferenciaDeMuestras   = Math.abs(desafio.getObjetivo()				- this.getDesafiosCompletados().get(this.getDesafioFavorito()).getCantidadDeMuestrasRecolectadas());
		double diferenciaDeDificultad = Math.abs(desafio.getDificultad().getNivel() - this.getDesafioFavorito().getDificultad().getNivel());
		double diferenciaDeRecompensa = Math.abs(desafio.getRecompensa()			- this.getDesafioFavorito().getRecompensa());
		return Math.round((diferenciaDeMuestras + diferenciaDeDificultad + diferenciaDeRecompensa)/3);
	}
	
	public Desafio getDesafioFavorito() {
        int satisfaccionMaxima = 0;
        Desafio desafioActual = null;
        for(Entry<Desafio, Estadisticas> entry : desafiosCompletados.entrySet()) {
            if(satisfaccionMaxima < entry.getValue().getSatisfaccion()) {
                satisfaccionMaxima = entry.getValue().getSatisfaccion();
                desafioActual = entry.getKey();
            } 
        };  
        return desafioActual;  
    } 
	 
	public void agregarNuevoProyectoEnCurso(Proyecto proyecto) {
		this.getProyectoEnCurso().add(proyecto);
	}
	
	public void agregarNuevoProgresoDeDesafio(ProgresoDeDesafio progreso) {
		this.getDesafiosEnCurso().add(progreso);
	}
	
	public Integer cantidadDeProyectosEnCurso() {
		return this.getProyectoEnCurso().size();
	}
	
	public Integer cantidadDeDesafiosCompletados() {
		return this.getDesafiosCompletados().size();
	}
	
	public Integer cantidadDeDesafiosEnCurso() {
		return this.getDesafiosEnCurso().size();
	}
	//================== METHODS IPARTICIPANTE ====================
	@Override
	public void recolectarMuestra(Muestra muestra) throws Exception{
		this.recolectarMuestraParaLosProyectos(muestra);
	}
	
	public void recolectarMuestraParaLosDesafios(Muestra muestra, LocalDateTime fecha) throws Exception {
		for (ProgresoDeDesafio progresoDesafio : desafiosEnCurso) {
			progresoDesafio.recolectarMuestra(this, muestra,fecha);
		}
	}
	
	public void recolectarMuestraParaLosProyectos(Muestra muestra) throws Exception {
		for (Proyecto proyecto : this.getProyectosDeInteres(muestra)) {
			proyecto.agregarMuestra(muestra);
			this.recolectarMuestraParaLosDesafios(muestra, LocalDateTime.now());
		}
	}
	
	@Override
	public boolean estaEnDesafioActualmente(LocalDateTime fecha) {
		return this.getDesafiosEnCurso().stream().anyMatch(p -> p.esDesafioActual(fecha));
	}

	@Override
	public void solicitarSuscripcionAProyecto(Proyecto proyecto) {
		proyecto.agregarParticipante(this);  
	}
	
	@Override
	public void inscribirseEnUnDesafio(Desafio desafio) throws Exception {
		desafio.addParticipante(this, LocalDateTime.now());
		this.agregarNuevoDesafioEnCurso(desafio);
	}
	
	@Override
	public void registrarDesafioCompletado(Desafio desafio, int recompensa, int muestrasRecolectadas, int satisfaccion) {
		Estadisticas estadisticas = new Estadisticas(satisfaccion, recompensa, muestrasRecolectadas);
		this.getDesafiosCompletados().put(desafio, estadisticas);
	}
	
	public Set<Proyecto> getProyectosDeInteres(Muestra muestra){
		return this.getProyectoEnCurso().stream().filter(p -> p.esMuestraDeInteres(muestra)).collect(Collectors.toSet());
	}
	 
	// ================== PRIVATE =====================
	private void agregarNuevoDesafioEnCurso(Desafio desafio) {
		ProgresoDeDesafio progreso = new ProgresoDeDesafio(desafio, new ProgresoDeDesafioEnCurso());
		this.getDesafiosEnCurso().add(progreso);
	}
	
	// ================== COSTRUCTOR ==================
	public Usuario(String nombre,Perfil perfil) {
		this.nombre				 	= nombre;
		this.perfil 			 	= perfil;
		this.proyectosEnCurso 	 	= new HashSet<Proyecto>();
		this.desafiosCompletados 	= new HashMap<Desafio, Estadisticas>();
		this.desafiosEnCurso        = new HashSet<ProgresoDeDesafio>();
	}

	// ============== GETTERS & SETTERS ==============
	public String getNombre() {
		return nombre;
	}
	public Set<Proyecto> getProyectoEnCurso() {
		return proyectosEnCurso;
	}
	public Perfil getPerfil() {
		return perfil;
	}
	public Map<Desafio, Estadisticas> getDesafiosCompletados() {
		return desafiosCompletados;
	}
	public Set<ProgresoDeDesafio> getDesafiosEnCurso() {
		return desafiosEnCurso;
	}
}
