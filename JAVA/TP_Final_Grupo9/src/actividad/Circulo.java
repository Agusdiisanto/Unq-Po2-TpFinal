package actividad;

import muestra.Coordenada;

/**
 * 
 * Esta clase se encarga de modelar un Area con su latitud, su longitud y su radio.
 *
 */

public class Circulo {
	private Coordenada centro;
	private double	   radio;
	
	// =================== METHODS ====================
	public boolean includes(Coordenada coordenada) {
		double x = coordenada.getX() - this.getCentro().getX();
		double y = coordenada.getY() - this.getCentro().getY();
		return Math.pow(x, 2) + Math.pow(y, 2) <= Math.pow(this.getRadio(), 2);
	}
	
	// ================== COSTRUCTOR ==================
	public Circulo(Coordenada centro, double radio) {
		this.setCentro(centro);
		this.setRadio(radio);
	}
	
	// ============== GETTERS & SETTERS ===============
	public double getRadio() {
		return radio;
	}

	public Coordenada getCentro() {
		return centro;
	}

	public void setCentro(Coordenada centro) {
		this.centro = centro;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}
}
