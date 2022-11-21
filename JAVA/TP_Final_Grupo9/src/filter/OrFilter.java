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
	private IFilter filtro1;
	private IFilter filtro2;
	
	public OrFilter() {
		this.filtros = new ArrayList<IFilter>();
	}

	@Override
	public ArrayList<Proyecto> buscar(ArrayList<Proyecto> proyectos) {
		ArrayList<Proyecto> resultados = new ArrayList<Proyecto>();
		for (IFilter iFilter : this.getFiltros()) {
			List<Proyecto> newP = iFilter.buscar(proyectos).stream().
									filter(proyecto -> !resultados.contains(proyecto)).
									collect(Collectors.toList());
			resultados.addAll(newP);
		}
		return resultados;
	}
}
