package filter;

import java.util.List;
import java.util.stream.Collectors;

import proyectos.Proyecto;


public class FilterIncludeCategoria extends Filter{
	
	private String filterNombreCategoria;

	public FilterIncludeCategoria(String filterNombreCategoria) {
		this.filterNombreCategoria = filterNombreCategoria;
	}
	
	@Override
	public List<Proyecto> filter(List<Proyecto> proyectos) {
		
		return proyectos.stream().filter(pr -> pr.getCategorias().
			   contains(this.filterNombreCategoria)).
				collect(Collectors.toList());
	}
}