package filter;

import java.util.List;
import java.util.stream.Collectors;

import proyectos.Proyecto;

/**
 * 
 * Esta clase se encarga de modelar un filtro que incluye una titulo "t".
 *
 */

public class FilterTitulo implements IFilter {
	private String tituloBuscado;
	
	public FilterTitulo(String tituloBuscado) {
		this.tituloBuscado= tituloBuscado;
	}

	@Override
	public List<Proyecto> filter(List<Proyecto> proyectos) {
		return proyectos.stream().filter(proyecto ->proyecto.
						 tieneElNombre(this.tituloBuscado)).
				         collect(Collectors.toList());
	}
}
