package caracteristicas.desafio;

import java.time.LocalDateTime;

public class RestriccionTemporal {
	private Etapa etapa;
	private LocalDateTime fechaDeInicio;
	private LocalDateTime fechaDeCierre;

	// Posible composite? 
	
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
	
	// ================== COSTRUCTOR ==================
	public RestriccionTemporal(LocalDateTime fechaDeInicio, LocalDateTime fechaDeCierre) {
		this.fechaDeInicio = fechaDeInicio;
		this.fechaDeCierre = fechaDeCierre;
	}
	
	public boolean estaHabilitado(LocalDateTime fecha) {
	    
		/* Mal olor
		
		switch (this.getEtapa()) {
	    case DIA_SEMANA:
	       return fecha.getDayOfWeek().getValue() < 6 && this.estaDentroDelRango(fecha);
	    case FIN_DE_SEMANA:
	       return fecha.getDayOfWeek().getValue() > 5 && this.estaDentroDelRango(fecha);
	    default:
	        return this.estaDentroDelRango(fecha);
	     }
	     */
		
		return this.estaDentroDelRango(fecha);
	}
	
	private boolean estaDentroDelRango(LocalDateTime fecha) {
	       
		return (fecha.isAfter(this.getFechaDeInicio()) && fecha.isBefore(this.getFechaDeCierre()));
		
	}
	
}
