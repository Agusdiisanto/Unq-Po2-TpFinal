package actividad;

import java.time.LocalDateTime;

public class EntreFecha implements IRetriccionTemporal{
	private LocalDateTime inicio;
	private LocalDateTime cierre;

	// ============================ METHODS ============================
	@Override
	public boolean cumpleLaRestricion(LocalDateTime fecha) {
		return fecha.isAfter(this.getInicio()) && fecha.isBefore(this.getCierre());
	}
	
	// ========================== CONSTRUCTOR ==========================
	public EntreFecha(LocalDateTime inicio, LocalDateTime cierre) {
		this.setInicio(inicio);
		this.setCierre(cierre);
	}

	// ======================= GETTERS & SETTERS =======================
	public LocalDateTime getInicio() {
		return inicio;
	}
	public void setInicio(LocalDateTime inicio) {
		this.inicio = inicio;
	}
	public LocalDateTime getCierre() {
		return cierre;
	}
	public void setCierre(LocalDateTime cierre) {
		this.cierre = cierre;
	}
}
