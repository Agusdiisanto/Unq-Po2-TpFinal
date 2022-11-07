package muestra;

/**
 * 
 * 
 * Esta clase se encarga de modelar una coordenada.
 *
 */

public class Coordenada {
	private double coordenadaX;
	private double coordenadaY;

	
	// ============ CONSTRUCTOR ===================
	public Coordenada(double coordenadaX, double coordenadaY) {
		this.setCoordenadaX(coordenadaX);
		this.setCoordenadaY(coordenadaY);
	}
	
	// ============= METHODS =======================
	public double getCoordenadaX() {
		return coordenadaX;
	}
	public void setCoordenadaX(double coordenadaX) {
		this.coordenadaX = coordenadaX;
	}
	public double getCoordenadaY() {
		return coordenadaY;
	}
	public void setCoordenadaY(double coordenadaY) {
		this.coordenadaY = coordenadaY;
	}
}
