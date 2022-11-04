package actividad;

public class Area {
	private double latitud;
	private double longitud;
	private double radio;
	
	public boolean estaDentroDelArea(double coordenadaX, double coordenadaY) {
		double x = coordenadaX - this.getLatitud();
		double y = coordenadaY - this.getLongitud();
		return Math.pow(x, 2) + Math.pow(y, 2) <= Math.pow(this.getRadio(), 2);
	}

	// ================== COSTRUCTOR ==================
	public Area(double latitud, double longitud, double radio) {
		this.latitud  = latitud;
		this.longitud = longitud;
		this.radio    = radio;
	}
	
	// ============== GETTERS & SETTERS ==============
	public double getLatitud() {
		return latitud;
	}
	public double getLongitud() {
		return longitud;
	}
	public double getRadio() {
		return radio;
	}
}
