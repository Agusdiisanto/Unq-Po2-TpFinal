package filter;

import proyectos.Proyecto;

/**
 * 
 * Esta clase se encarga de modelar un filtro que incluye una titulo "t".
 *
 */

public class FilterTitulo extends Filter {
	private String tituloBuscado;
	
	public FilterTitulo(String tituloBuscado) {
		this.tituloBuscado = tituloBuscado;
	}

	@Override
	public boolean containsFilter(Proyecto proyecto) {
		return proyecto.getNombre().equals(tituloBuscado);
	}
}
