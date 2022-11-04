package caracteristicas.desafio;

public class Area {
	private int latitud;
	private int longitud;
	private int radio;

	// ================== COSTRUCTOR ==================
	public Area(int latitud, int longitud, int radio) {
		this.latitud  = latitud;
		this.longitud = longitud;
		this.radio    = radio;
	}
	
	// ============== GETTERS & SETTERS ==============
	public int getLatitud() {
		return latitud;
	}
	public int getLongitud() {
		return longitud;
	}
	public int getRadio() {
		return radio;
	}
}
