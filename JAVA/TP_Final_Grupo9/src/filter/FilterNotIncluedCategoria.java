package filter;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import proyectos.Proyecto;

public class FilterNotIncluedCategoria implements IFilter {
	
	private Set<String> categorias;
	
	public FilterNotIncluedCategoria(Set<String> categorias) {
		super();
		this.categorias = categorias;
	}

	@Override
	public List<Proyecto> buscarProyecto(List<Proyecto> proyectos) {
		// TODO Auto-generated method stub
		return proyectos.stream().filter(p -> p.noContieneCategorias(categorias)).collect(Collectors.toList());
	}

}
