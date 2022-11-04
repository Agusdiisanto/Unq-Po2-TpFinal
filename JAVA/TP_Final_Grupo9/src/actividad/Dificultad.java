package actividad;

public enum Dificultad {
	MUY_FACIL(1), FACIL(2), MEDIO(3), DIFICIL(4), MUY_DIFICIL(5);
	
	private Dificultad(final int dificultad) {
		this.nivelDeDificultad = dificultad; 
	}
	
	private int nivelDeDificultad;

	public int getNivelDeDificultad() {
		return nivelDeDificultad;
	}
} 
