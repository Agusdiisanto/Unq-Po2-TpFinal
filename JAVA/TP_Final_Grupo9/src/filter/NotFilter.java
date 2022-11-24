package filter;

import java.util.ArrayList;
import java.util.List;

import proyectos.Proyecto;

/**
 * 
 * Esta clase se encarga de modelar un NotFilter.
 *
 */

public class NotFilter extends Filter{
	private IFilter filtro;
	
	public NotFilter() {
		this.filtros = new ArrayList<IFilter>();
	}	
	
	
	@Override
	public List<Proyecto> buscar(List<Proyecto> proyectos) {
		List<Proyecto> temporal   = filtro.buscar(proyectos);
		List<Proyecto> resultados = new ArrayList<Proyecto>(proyectos);
		resultados.removeAll(temporal);
		return resultados;
	}
}
