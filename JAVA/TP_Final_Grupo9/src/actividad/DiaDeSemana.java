package actividad;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class DiaDeSemana implements IRetriccionTemporal{

	@Override
	public boolean validar(LocalDate fecha) {
		DayOfWeek dia = fecha.getDayOfWeek();
		return dia != DayOfWeek.SATURDAY && dia!= DayOfWeek.SUNDAY;
	}

}
