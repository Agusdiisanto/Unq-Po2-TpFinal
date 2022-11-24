package filter;

import java.util.ArrayList;
import java.util.List;

import proyectos.Proyecto;

/**
 * 
 * Esta clase se encarga de modelar un NotFilter.
 *
 */

public class NotFilter implements IFilter{
	private IFilter filtro;
	
	@Override
	public List<Proyecto> buscar(List<Proyecto> proyectos) {
		List<Proyecto> temporal   = filtro.buscar(proyectos);
		List<Proyecto> resultados = new ArrayList<Proyecto>(proyectos);
		resultados.removeAll(temporal);
		return resultados;
	}
}
