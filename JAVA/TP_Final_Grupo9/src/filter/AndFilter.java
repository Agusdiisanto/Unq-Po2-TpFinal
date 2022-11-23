package filter;

import java.util.ArrayList;
import java.util.List;

import proyectos.Proyecto;

/**
 * 
 * Esta clase se encarga de modelar un filtro And.
 *
 */

public class AndFilter extends Filter{

	public AndFilter() {
		this.filtros= new ArrayList <IFilter>();
	}

	@Override
	public List<Proyecto> buscar(List<Proyecto> proyectos) {
		List<Proyecto> resultados = proyectos;
		for (IFilter filtros : this.getFiltros()) {
			resultados= filtros.buscar(resultados);
		}
		return resultados;
	}
}

