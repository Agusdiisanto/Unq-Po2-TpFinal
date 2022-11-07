package filter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import proyectos.Proyecto;

/**
 * 
 * Esta clase se encarga de modelar un Filtro OR.
 * 
 */

public class OrFilter extends Filter {
	
	public OrFilter() {
		this.filtros= new ArrayList <IFilter>();
	}

	@Override
	public List<Proyecto> filter(List<Proyecto> proyectos) {
		List <Proyecto> resultados = new ArrayList<Proyecto>();
		for (IFilter iFilter : this.getFiltros()) {
			List <Proyecto> newP = iFilter.filter(proyectos).stream().
									filter(proyecto -> !resultados.contains(proyecto)).
									collect(Collectors.toList());
			resultados.addAll(newP);
		}
		return resultados;
	}
}
	