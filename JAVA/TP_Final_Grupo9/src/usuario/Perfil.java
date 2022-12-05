package usuario;

import java.util.HashSet;
import java.util.Set;

import actividad.Caracteristica;

/**
 * 
 * Esta clase se encarga de modelar un perfil.
 *
 */

public class Perfil {
	private Set<String>		 		  gustos;
	private Set<Caracteristica> 	  caracteristicas;
	private Set<String>				  comportamientos;
	private EstrategiaDeRecomendacion recomendacionPreferida;

	// =================== METHODS ====================
	// Ver santi, esta restando afinidad dos veces y siempre te da 0
	
	public double afinidadConCaracteristica(Caracteristica caracteristica) { 
		return !includesCaracteristicaConDescripcion(caracteristica.getDescripicion()) ? 0 : 
				Math.abs(this.getCaracteristicaSegunDescripcion(caracteristica.getDescripicion()).getAfinidad() - caracteristica.getAfinidad());
	}
	
	public boolean includesCaracteristicaConDescripcion(String descripcion) {
		return this.getCaracteristicas().stream().anyMatch(c -> c.tieneDescripcion(descripcion));
	}
	
	private Caracteristica getCaracteristicaSegunDescripcion(String descripcion) {
		Caracteristica caracteristicaEncontrada = null;
		for (Caracteristica caracteristica : this.getCaracteristicas()) {
			if (caracteristica.getDescripicion() == descripcion) {
				caracteristicaEncontrada = caracteristica;
			}
		}
		return caracteristicaEncontrada;
	}
	
	// ================= ADD METHODS ==================
	public void addGusto(String gusto){
		this.getGustos().add(gusto);
	}
	
	public void addCaracteristica(Caracteristica caracteristica) {
		this.getCaracteristicas().add(caracteristica);
	}
	
	public void addComportamiento(String comportamiento) {
		this.getComportamientos().add(comportamiento);
	}
	
	// ================== COSTRUCTOR ==================
	public Perfil() {
		this.gustos		 	 = new HashSet<String>();
		this.caracteristicas = new HashSet<Caracteristica>();
		this.comportamientos = new HashSet<String>();
	}
	
	// ============== GETTERS & SETTERS ===============
	public Set<String> getGustos() {
		return gustos;
	}
	public Set<Caracteristica> getCaracteristicas() {
		return caracteristicas;
	}
	public Set<String> getComportamientos() {
		return comportamientos;
	} 
	public EstrategiaDeRecomendacion getRecomendacionPreferida() {
		return recomendacionPreferida;
	}
	public void setRecomendacionPreferida(EstrategiaDeRecomendacion recomendacionPreferida) {
		this.recomendacionPreferida = recomendacionPreferida;
	}
}


