package usuario;


/**
 * 
 * 
 * Esta clase modela una estadistica.
 *
 */
public class Estadisticas {
	private int satisfaccion;
	private int recompensa;
	private int cantidadDeMuestrasRecolectadas;
	
	// ====================== CONSTRUCTOR =======================
	public Estadisticas(int satisfaccion, int recompensa, int cantidadDeMuestrasRecolectadas) {
		this.setSatisfaccion(satisfaccion);
		this.setRecompensa(recompensa);
		this.setCantidadDeMuestrasRecolectadas(cantidadDeMuestrasRecolectadas);
	}

	// =================== GETTERS && SETTERS ===================
	public int getSatisfaccion() {
		return satisfaccion;
	}
	public void setSatisfaccion(int satisfaccion) {
		this.satisfaccion = satisfaccion;
	}
	public int getRecompensa() {
		return recompensa; 
	}
	public void setRecompensa(int recompensa) {
		this.recompensa = recompensa;
	}
	public int getCantidadDeMuestrasRecolectadas() {
		return cantidadDeMuestrasRecolectadas;
	}
	public void setCantidadDeMuestrasRecolectadas(int cantidadDeMuestrasRecolectadas) {
		this.cantidadDeMuestrasRecolectadas = cantidadDeMuestrasRecolectadas;
	}
}
