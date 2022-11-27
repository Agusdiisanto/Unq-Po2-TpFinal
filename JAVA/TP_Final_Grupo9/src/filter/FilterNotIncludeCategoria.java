package filter;

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
	public boolean containsFilter(Proyecto proyecto) {
		// TODO Auto-generated method stub
		return !proyecto.contieneALaCategoria(filterNombreCategoria);
	}
}
