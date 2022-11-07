package filter;

import java.util.List;
import java.util.stream.Collectors;

import proyectos.Proyecto;

/**
 * 
 * Esta clase se encarga de modelar un filtro que no incluye una categoria "c".
 *
 */

public class FilterNotIncludeCategoria extends Filter {
	private String filterNombreCategoria;

	public FilterNotIncludeCategoria(String filterNombreCategoria) {
		this.filterNombreCategoria = filterNombreCategoria;
	}
	
	@Override
	public List<Proyecto> filter(List<Proyecto> proyectos) {
		return proyectos.stream().filter(pr -> !pr.contieneALaCategoria(filterNombreCategoria)).
			   collect(Collectors.toList());
	}
}
