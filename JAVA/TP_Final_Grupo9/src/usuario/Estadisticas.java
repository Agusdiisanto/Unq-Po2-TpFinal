package usuario;

public class Estadisticas {
	private int satisfaccion;
	private int recompensa;
	private int cantidadDeMuestrasRecolectadas;
	// ====================== CONSTRUCTOR =======================
	public Estadisticas(int satisfaccion, int recompensa, int cantidadDeMuestrasRecolectadas) {
		this.satisfaccion = satisfaccion;
		this.recompensa   = recompensa;
		this.cantidadDeMuestrasRecolectadas = cantidadDeMuestrasRecolectadas;
	}

	// =================== GETTERS && SETTERS ===================
	int getSatisfaccion() {
		return satisfaccion;
	}
	void setSatisfaccion(int satisfaccion) {
		this.satisfaccion = satisfaccion;
	}
	int getRecompensa() {
		return recompensa;
	}
	void setRecompensa(int recompensa) {
		this.recompensa = recompensa;
	}
	int getCantidadDeMuestrasRecolectadas() {
		return cantidadDeMuestrasRecolectadas;
	}
	void setCantidadDeMuestrasRecolectadas(int cantidadDeMuestrasRecolectadas) {
		this.cantidadDeMuestrasRecolectadas = cantidadDeMuestrasRecolectadas;
	}
}
