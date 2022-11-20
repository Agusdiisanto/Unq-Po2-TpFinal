package actividad;

import muestra.Coordenada;

/**
 * 
 * Esta clase se encarga de modelar un Area con su latitud, su longitud y su radio.
 *
 */

public class Circulo {
	private Coordenada centro;
	private double radio;
	
	/*public boolean estaDentroDelArea(double coordenadaX, double coordenadaY) {   ---SANTI
		double x = coordenadaX - this.getLatitud();
		double y = coordenadaY - this.getLongitud();
		return Math.pow(x, 2) + Math.pow(y, 2) <= Math.pow(this.getRadio(), 2);
	}*/

	// ================== COSTRUCTOR ==================
	public Circulo(Coordenada centro, double radio) {
		this.setCentro(centro);
		this.setRadio(radio);
	}
	
	// ============== GETTERS & SETTERS ==============
	
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
