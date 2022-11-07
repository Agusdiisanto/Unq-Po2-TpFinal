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
	private Set<Caracteristica> 	  caracteristicasPreferidas;
	private Set<String>				  comportamientos;
	private EstrategiaDeRecomendacion tipoDeRecomendacionPreferido;

	// =================== METHODS ====================
	public boolean contieneCaracteristicaConDescripcion(String s) {
		return this.getCaracteristicasPreferidas().stream().anyMatch(c -> c.getDescripicion().equals(s));
	}

	public double afinidadConCaracteristica(Caracteristica caracteristica) {
		return !contieneCaracteristicaConDescripcion(caracteristica.getDescripicion()) ? 0 :
				Math.abs(this.getCaracteristicaSegunDescripcion(caracteristica.getDescripicion()).getAfinidad() - caracteristica.getAfinidad());
	}

	private Caracteristica getCaracteristicaSegunDescripcion(String descipcion) {
		Caracteristica caracteristicaEncontrada = null;
		for (Caracteristica caracteristica : this.getCaracteristicasPreferidas()) {
			if (caracteristica.getDescripicion() == descipcion) {
				caracteristicaEncontrada = caracteristica;
			}
		}
		return caracteristicaEncontrada;
	}
	
	// ================= ADD METHODS ==================
	public void agregarGusto(String gusto){
		this.getGustos().add(gusto);
	}
	
	public void agregarCaracteristicaPreferida(Caracteristica caracteristica) {
		this.getCaracteristicasPreferidas().add(caracteristica);
	}
	
	public void agregarComportamiento(String comportamiento) {
		this.getComportamientos().add(comportamiento);
	}
	
	// ================== COSTRUCTOR ==================
	public Perfil() {
		this.gustos		 			   = new HashSet<String>();
		this.caracteristicasPreferidas = new HashSet<Caracteristica>();
		this.comportamientos 		   = new HashSet<String>();
	}
	
	// ============== GETTERS & SETTERS ===============
	public Set<String> getGustos() {
		return gustos;
	}
	public Set<Caracteristica> getCaracteristicasPreferidas() {
		return caracteristicasPreferidas;
	}
	public Set<String> getComportamientos() {
		return comportamientos;
	} 
	public EstrategiaDeRecomendacion getTipoDeRecomendacionPreferida() {
		return tipoDeRecomendacionPreferido;
	}
	public void setTipoDeRecomendacionPreferido(EstrategiaDeRecomendacion tipoDeRecomendacion) {
		this.tipoDeRecomendacionPreferido = tipoDeRecomendacion;
	}
}


