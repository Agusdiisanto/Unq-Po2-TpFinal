package ciencia.participativa;

public class Caracteristica {
	private String descripicion;
	private int preferencia;
	public String getDescripicion() {
		return descripicion;
	}
	public void setDescripicion(String descripicion) {
		this.descripicion = descripicion;
	}
	public int getPreferencia() {
		return preferencia;
	}
	public void setPreferencia(int preferencia) {
		this.preferencia = preferencia;
	}
	
	public Caracteristica(String descripicion, int preferencia) {
		this.descripicion = descripicion;
		this.preferencia = preferencia;
	}
	
	
}
