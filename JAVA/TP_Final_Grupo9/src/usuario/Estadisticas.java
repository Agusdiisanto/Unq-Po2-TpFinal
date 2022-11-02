package usuario;

public class Estadisticas {
	private int satisfaccion;
	private int cantidadDeMuestrasRecolectadas;
	private int recompensa;
	private int dificultad;

	// ====================== CONSTRUCTOR =======================
	public Estadisticas(int satisfaccion, int cantidadDeMuestrasRecolectadas, int recompensa, int dificultad) {
		this.satisfaccion					= satisfaccion;
		this.cantidadDeMuestrasRecolectadas = cantidadDeMuestrasRecolectadas;
		this.recompensa						= recompensa;
		this.dificultad 					= dificultad;
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
	int getDificultad() {
		return dificultad;
	}
	void setDificultad(int dificultad) {
		this.dificultad = dificultad;
	}
}
