package filter;

import proyectos.Proyecto;

/**
 * 
 * Esta clase se encarga de modelar un filtro que no incluye una categoria "c".
 *
 */

public class FilterNotIncludeCategoria extends Filter {
	private String categoriaBuscada;

	public FilterNotIncludeCategoria(String categoriaBuscada) {
		this.categoriaBuscada = categoriaBuscada;
	}
	
	@Override
	public boolean containsFilter(Proyecto proyecto) {
		return !proyecto.includes(categoriaBuscada);
	}
}
