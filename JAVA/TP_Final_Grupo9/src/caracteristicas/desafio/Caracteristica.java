package caracteristicas.desafio;

public class Caracteristica {
	private String descripicion;
	private double afinidad;
	
	
	public String getDescripicion() {
		return descripicion;
	}
	public void setDescripicion(String descripicion) {
		this.descripicion = descripicion;
	}
	public double getAfinidad() {
		return afinidad;
	}
	public void setPreferencia(double preferencia) {
		this.afinidad = preferencia;
	}
	
	public Caracteristica(String descripicion, double preferencia) {
		this.setDescripicion(descripicion);
		this.setPreferencia(preferencia);
	}
	
	
} 
