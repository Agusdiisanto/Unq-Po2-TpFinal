package actividad;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class FinDeSemana implements IRetriccionTemporal{

	@Override
	public boolean cumpleLaRestricion(LocalDateTime fecha) {
		DayOfWeek dia = fecha.getDayOfWeek();
		return dia == DayOfWeek.SATURDAY || dia == DayOfWeek.SUNDAY;
	}
}
