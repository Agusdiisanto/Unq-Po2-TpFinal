package muestra;

/**
 * 
 * Esta clase se encarga de modelar una coordenada.
 *
 */

public class Coordenada {
	private double x;
	private double y;

	// ============ CONSTRUCTOR ===================
	public Coordenada(double x, double y) {
		this.setX(x);
		this.setY(y);
	}
	
	// ============= METHODS =======================
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
}
