package actividad;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class DiaDeSemana implements IRetriccionTemporal{

	@Override
	public boolean cumpleLaRestriccion(LocalDateTime fecha) {
		DayOfWeek dia = fecha.getDayOfWeek();
		return dia != DayOfWeek.SATURDAY && dia != DayOfWeek.SUNDAY;
	}
}
