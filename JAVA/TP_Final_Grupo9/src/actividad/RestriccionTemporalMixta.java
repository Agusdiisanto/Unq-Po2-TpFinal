package actividad;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * Esta clase se encarga de modelar una restricción temporal con una fecha de inicio y una fecha de fin.
 *
 */

public class RestriccionTemporalMixta implements IRetriccionTemporal {
	
	private Set<IRetriccionTemporal> retricciones;
	
	// =================== METHODS ====================
	@Override
	public boolean cumpleLaRestricion(LocalDateTime fecha) {
		return this.getRetricciones().stream().allMatch(r -> r.cumpleLaRestricion(fecha));
	}
	
	public void agregarRetriccionTemporal(IRetriccionTemporal retriccion) {
		this.getRetricciones().add(retriccion);
	}
	
	// ================== COSTRUCTOR ==================
	public RestriccionTemporalMixta() {
		this.setRetricciones(new HashSet<IRetriccionTemporal>());
	}
	
	// ============== GETTERS & SETTERS ==============
	public Set<IRetriccionTemporal> getRetricciones() {
		return retricciones;
	}
	private void setRetricciones(Set<IRetriccionTemporal> retricciones) {
		this.retricciones = retricciones;
	}
}
