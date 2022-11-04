package caracteristicas.desafio;

import java.time.LocalDateTime;

public class RestriccionTemporal {
	private Etapa etapa;
	private LocalDateTime fechaDeInicio;
	private LocalDateTime fechaDeCierre;

	public boolean cumpleLaRestriccion(LocalDateTime fecha) {
		return fecha.isAfter(this.getFechaDeInicio()) && fecha.isBefore(this.getFechaDeCierre());
	}
	
	// ================== COSTRUCTOR ==================
	public RestriccionTemporal(LocalDateTime fechaDeInicio, LocalDateTime fechaDeCierre) {
		this.fechaDeInicio = fechaDeInicio;
		this.fechaDeCierre = fechaDeCierre;
	}
	
	// ============== GETTERS & SETTERS ==============
	public LocalDateTime getFechaDeInicio() {
		return fechaDeInicio;
	}
	public LocalDateTime getFechaDeCierre() {
		return fechaDeCierre;
	}
	public Etapa getEtapa() {
		return etapa;
	}
	public void setEtapa(Etapa etapa) {
		this.etapa = etapa;
	}
}
