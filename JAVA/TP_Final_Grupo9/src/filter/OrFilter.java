package filter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import proyectos.Proyecto;

/**
 * 
 * Esta clase se encarga de modelar un Filtro OR.
 * 
 */

public class OrFilter extends Filter {
	private IFilter filtro1;
	private IFilter filtro2;
	
	public OrFilter() {
		this.filtros = new ArrayList<IFilter>();
	}
	
	public List<Proyecto> buscar(List<Proyecto> proyectos) {
		
		Set<Proyecto> result = new HashSet<Proyecto>();
		
		result.addAll(filtro1.buscar(proyectos));
		result.addAll(filtro2.buscar(proyectos));
		
		return new ArrayList<Proyecto>(result);
		
	}
}
