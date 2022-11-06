package filter;

import java.util.List;
import java.util.stream.Collectors;

import proyectos.Proyecto;


public class FilterTitulo implements IFilter {
	
	private String tituloBuscado;
	
	public FilterTitulo(String tituloBuscado) {
		this.tituloBuscado= tituloBuscado;
	}

	@Override
	public List<Proyecto> filter(List<Proyecto> proyectos) {
		return proyectos.stream().filter(proyecto ->proyecto.
						 tieneElTitulo(this.tituloBuscado)).
				         collect(Collectors.toList());
	}
 
}
