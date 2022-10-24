package caracteristicas.desafio;

import java.time.LocalDateTime;

public class RestriccionTemporal {
	private LocalDateTime fechaDeInicio;
	private LocalDateTime fechaDeCierre;
	
	// ============== GETTERS & SETTERS ==============
	public LocalDateTime getFechaDeInicio() {
		return fechaDeInicio;
	}
	public LocalDateTime getFechaDeCierre() {
		return fechaDeCierre;
	}
	
	
	// ================== COSTRUCTOR ==================
	public RestriccionTemporal(LocalDateTime fechaDeInicio, LocalDateTime fechaDeCierre) {
		this.fechaDeInicio = fechaDeInicio;
		this.fechaDeCierre = fechaDeCierre;
	}
	
	
}
