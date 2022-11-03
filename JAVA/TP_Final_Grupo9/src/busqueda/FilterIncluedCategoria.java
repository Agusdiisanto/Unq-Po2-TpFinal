package busqueda;

import java.util.List;
import java.util.stream.Collectors;

import proyectos.Proyecto;

public class FilterIncluedCategoria implements IFilter{
	
	private List<String> categorias;
	
	
	public List<String> getCategorias() {
		return categorias;
	}

	public FilterIncluedCategoria(List<String> categorias) {
		super();
		this.categorias = categorias;
	}

	@Override
	public List<Proyecto> buscarProyecto(List<Proyecto> proyectos) {
		return proyectos.stream().filter(p -> p.contieneCategorias(categorias)).collect(Collectors.toList());
	}
	
	public void agregarNuevaCategoria(String categoria) {
		this.getCategorias().add(categoria);
	}
	
	
}