package filter;

import java.util.ArrayList;
import java.util.List;

import proyectos.Proyecto;

public class NotFilter extends Filter{
	
	public NotFilter() {
		this.filtros = new ArrayList<IFilter>();
	}

	@Override
	public List<Proyecto> filter(List<Proyecto> proyectos) {
		
		List <Proyecto>resultados= proyectos;
		for(IFilter iFilters : this.getFiltros()) {
			resultados = iFilters.filter(resultados);
			resultados.removeAll(proyectos);
		}
		
		return resultados;
	}

	

}
