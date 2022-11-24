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
	public boolean containsFilter(IFilter iFilter) {
		// TODO Auto-generated method stub
		return false;
	}
}
