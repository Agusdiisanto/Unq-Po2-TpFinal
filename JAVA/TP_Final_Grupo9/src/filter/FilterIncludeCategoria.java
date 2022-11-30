package filter;

import proyectos.Proyecto;

/**
 * 
 * Esta clase se encarga de modelar un filtro que incluye una categoria "c".
 *
 */

public class FilterIncludeCategoria extends Filter{
	private String categoriaBuscada;

	public FilterIncludeCategoria(String categoriaBuscada) {
		this.categoriaBuscada = categoriaBuscada;
	}

	@Override
	public boolean containsFilter(Proyecto proyecto) {
		return proyecto.includes(categoriaBuscada);
	}
}