package actividad;

/**
 * 
 * Esta clase se encarga de modelar una caracteristica con su descripción y su afinidad.
 *
 */

public class Caracteristica {
	private String descripicion;
	private double afinidad;
	
	// ====================== CONSTRUCTOR =======================
	public Caracteristica(String descripicion, double afinidad) {
		this.setDescripicion(descripicion);
		this.setAfinidad(afinidad);
	}
	
	// =================== GETTERS && SETTERS ===================
	public String getDescripicion() {
		return descripicion;
	}
	public void setDescripicion(String descripicion) {
		this.descripicion = descripicion;
	}
	public double getAfinidad() {
		return afinidad;
	}
	public void setAfinidad(double afinidad) {
		this.afinidad = afinidad;
	}
}
