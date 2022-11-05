package usuario;

import java.util.HashSet;
import java.util.Set;

import actividad.Caracteristica;

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
		return Math.abs(this.getCaracteristicaSegunDescripcion(caracteristica).getAfinidad() - caracteristica.getAfinidad());
	}
	
	private Caracteristica getCaracteristicaSegunDescripcion(Caracteristica caracteristica) {
		return (Caracteristica) this.getCaracteristicasPreferidas().stream().
				filter(c -> c.getDescripicion().equals(caracteristica.getDescripicion()));
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


