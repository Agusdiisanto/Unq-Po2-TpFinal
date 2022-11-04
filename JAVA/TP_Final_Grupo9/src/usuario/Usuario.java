package usuario;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

import caracteristicas.desafio.Caracteristica;
import desafios.Desafio;
import estadoDeUsuario.ProgresoDesafio;
import muestra.Muestra;
import proyectos.Proyecto;

public class Usuario implements IParticipante{
	
	private String		          	   nombre;
	private AplicacionMovil 	  	   aplicacion;
	private Set<Proyecto> 		  	   proyectosEnCurso;
	private Perfil 				  	   perfil;   // Aca tenes las recomendaciones
	private Map<Desafio, Estadisticas> desafiosCompletados;
	private Set<ProgresoDesafio>  	   desafiosEnCurso;
	
	// ================== METHODS USUARIO ========================
	public boolean contieneCaracteristicaConDescripcion(String descripcion) {
		return this.getPerfil().contieneCaracteristicaConDescripcion(descripcion);
	}

	public double afinidadConCaracteristica(Caracteristica caracteristica) {
		return this.getPerfil().afinidadConCaracteristica(caracteristica);
	}

	public EstrategiaDeRecomendacion getEstrategia() {
		return this.getPerfil().getTipoDeRecomendacionPreferida();
	} 
 
	public double similitudConFavorito(Desafio desafio) {
		double diferenciaDeMuestras   = Math.abs(desafio.getCantidadDeMuestrasARecolectar()     - this.getDesafiosCompletados().get(this.getDesafioFavorito()).getCantidadDeMuestrasRecolectadas());
		double diferenciaDeDificultad = Math.abs(desafio.getDificultad().getNivelDeDificultad() - this.getDesafioFavorito().getDificultad().getNivelDeDificultad());
		double diferenciaDeRecompensa = Math.abs(desafio.getRecompensa()                        - this.getDesafioFavorito().getRecompensa());
		return (diferenciaDeMuestras + diferenciaDeDificultad + diferenciaDeRecompensa)/3;
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
	 
	//================== METHODS IPARTICIPANTE ====================
	@Override
	public void recolectarMuestra(Muestra muestra) throws Exception {
		this.recolectarMuestraParaLosProyectos(muestra);
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
		proyecto.agregarParticipante(this);  
	}
	
	@Override
	public void inscribirseEnUnDesafio(Desafio desafio) throws Exception {
		desafio.agregarParticipanteAlDesafio(this);
		this.agregarNuevoDesafioEnCurso(desafio);
	}
	
	@Override
	public void registrarDesafioCompletado(Desafio desafio, int recompensa, int muestrasRecolectadas) {
		Random random = new Random();
		Estadisticas estadisticas = new Estadisticas(random.nextInt(5), recompensa, muestrasRecolectadas);
		this.getDesafiosCompletados().put(desafio, estadisticas);
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
		this.desafiosCompletados 	= new HashMap<Desafio, Estadisticas>();
		this.desafiosEnCurso        = new HashSet<ProgresoDesafio>();
	}

	// ============== GETTERS & SETTERS ==============
	public String getNombre() {
		return nombre;
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
	
	public Map<Desafio, Estadisticas> getDesafiosCompletados() {
		return desafiosCompletados;
	}
	public Set<ProgresoDesafio> getDesafiosEnCurso() {
		return desafiosEnCurso;
	}
	public void agregarNuevoProyectoEnCurso(Proyecto proyecto) {
		this.getProyectoEnCurso().add(proyecto);
	}
	public Integer cantidadDeProyectosEnCurso() {
		// TODO Auto-generated method stub
		return this.getProyectoEnCurso().size();
	}
	public Integer cantidadDeDesafiosCompletados() {
		// TODO Auto-generated method stub
		return this.getDesafiosCompletados().size();
	}
	public void agregarNuevoProgresoDeDesafio(ProgresoDesafio progreso) {
		this.getDesafiosEnCurso().add(progreso);
	}
	public Integer cantidadDeDesafiosEnCurso() {
		// TODO Auto-generated method stub
		return this.getDesafiosEnCurso().size();
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
