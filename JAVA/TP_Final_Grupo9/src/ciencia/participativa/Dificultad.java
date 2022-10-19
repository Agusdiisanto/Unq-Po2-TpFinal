package ciencia.participativa;

public enum Dificultad {
	MUYFACIL(1), FACIL(2), MEDIO(3), DIFICIL(4), MUY_DIFICIL(5);
	
	private Dificultad(final int dificultad) {
		this.dificultad = dificultad; 
	}
	
	private int dificultad;

	public int getDificultad() {
		return dificultad;
	}
}
