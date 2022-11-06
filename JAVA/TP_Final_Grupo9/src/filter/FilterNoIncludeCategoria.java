package filter;

import java.util.List;
import java.util.stream.Collectors;

import proyectos.Proyecto;

public class FilterNoIncludeCategoria extends Filter {
	private String filterNombreCategoria;

	@Override
	public List<Proyecto> filter(List<Proyecto> proyectos) {
		
		return proyectos.stream().filter(pr -> !pr.getCategorias().
				 contains(filterNombreCategoria)).
				collect(Collectors.toList());
	}

}
