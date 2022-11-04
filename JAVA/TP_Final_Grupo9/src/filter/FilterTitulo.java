package filter;

import java.util.List;
import java.util.stream.Collectors;

import proyectos.Proyecto;

public class FilterTitulo implements IFilter {
	
	private String filterTitulo;
	
	public FilterTitulo(String filterTitulo) {
		super();
		this.filterTitulo = filterTitulo;
	}

	@Override
	public List<Proyecto> buscarProyecto(List<Proyecto> proyectos) {
		return proyectos.stream()
				.filter(proyecto -> proyecto.getNombre().equals(filterTitulo))
				.collect(Collectors.toList());
	}
 
}
