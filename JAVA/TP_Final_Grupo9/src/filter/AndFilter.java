package filter;

import java.util.ArrayList;
import java.util.List;

import proyectos.Proyecto;

public class AndFilter extends Filter{

	
	
	public AndFilter() {
		this.filtros= new ArrayList <IFilter>();
		
	}

	@Override
	public List<Proyecto> filter(List<Proyecto> proyectos) {
		List<Proyecto> resultados = proyectos;
		for (IFilter filtros : this.getFiltros()) {
			resultados= filtros.filter(resultados);
		}
		return resultados;
	}
	

	
}

