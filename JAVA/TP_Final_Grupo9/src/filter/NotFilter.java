package filter;

import java.util.ArrayList;
import java.util.List;


import proyectos.Proyecto;

/**
 * 
 * Esta clase se encarga de modelar un NotFilter.
 *
 */

public class NotFilter extends Filter{
	
	public NotFilter() {
		this.filtros = new ArrayList<IFilter>();
	}	
	
	public List<Proyecto> buscar(List<Proyecto> proyectos) {
		List <Proyecto> resultados = new ArrayList<>(proyectos);
		for(IFilter filtros : this.filtros) {
			List <Proyecto>filtrados = filtros.buscar(proyectos);
			resultados.removeAll(filtrados);
		}  
		return resultados;
	}
}
