package actividad;

import java.time.LocalDate;
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
	
	public boolean cumpleLaRestriccion(LocalDateTime fecha) {
	   return true;
	}
	
	// ================== COSTRUCTOR ==================
	public RestriccionTemporalMixta() {
		retricciones = new HashSet<IRetriccionTemporal>();
	} 
	
	// ============== GETTERS & SETTERS ==============
	
	@Override
	public boolean validar(LocalDate fecha) {
		// TODO Auto-generated method stub
		return this.getRetricciones().stream().allMatch(r -> r.validar(fecha));
	}

	public Set<IRetriccionTemporal> getRetricciones() {
		return retricciones;
	}
	
	public void agregarRetriccionTemporal(IRetriccionTemporal retriccion) {
		this.getRetricciones().add(retriccion);
	}
	
	
}
