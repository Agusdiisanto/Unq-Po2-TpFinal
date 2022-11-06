package filter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import proyectos.Proyecto;

public class NotFilter extends Filter{
	
	public NotFilter() {
		this.filtros = new ArrayList<IFilter>();
	}

	
	
	public List<Proyecto> filter(List<Proyecto> proyectos) {

		List <Proyecto> filters = filtros
}
