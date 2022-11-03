package muestra;

public class Coordenada {
	
	private int coordenadaX;
	private int coordenadaY;
	
	// ============ CONSTRUCTOR ===================
	
	public Coordenada(int coordenadaX, int coordenadaY) {
		this.setCoordenadaX(coordenadaX);
		this.setCoordenadaY(coordenadaY);
	}
	
	
	// ============= METHODS =======================
	
	public int getCoordenadaX() {
		return coordenadaX;
	}
	
	public void setCoordenadaX(int coordenadaX) {
		this.coordenadaX = coordenadaX;
	}
	public int getCoordenadaY() {
		return coordenadaY;
	}
	public void setCoordenadaY(int coordenadaY) {
		this.coordenadaY = coordenadaY;
	}
	
	
	
}
