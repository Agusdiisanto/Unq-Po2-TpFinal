package actividad;

import java.time.LocalDateTime;

public interface IRetriccionTemporal {
	
	public boolean cumpleLaRestriccion(LocalDateTime fecha);

}
