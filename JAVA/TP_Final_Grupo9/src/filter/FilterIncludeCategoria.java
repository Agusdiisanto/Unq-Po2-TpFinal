package filter;

import proyectos.Proyecto;

/**
 * 
 * Esta clase se encarga de modelar un filtro que incluye una categoria "c".
 *
 */

public class FilterIncludeCategoria extends Filter{
	private String filterNombreCategoria;

	public FilterIncludeCategoria(String filterNombreCategoria) {
		this.filterNombreCategoria = filterNombreCategoria;
	}

	@Override
	public boolean containsFilter(Proyecto proyecto) {
		// TODO Auto-generated method stub
		return proyecto.contieneALaCategoria(filterNombreCategoria);
	}
}