package actividad;

/**
 * 
 * Este enum se encarga de modelar la difícultad de un desafío. 
 *
 */

public enum Dificultad {
	MUY_FACIL(1), FACIL(2), MEDIO(3), DIFICIL(4), MUY_DIFICIL(5);
	
	private Dificultad(final int dificultad) {
		this.nivel = dificultad; 
	}
	
	private int nivel;

	public int getNivel() {
		return nivel;
	}
} 
