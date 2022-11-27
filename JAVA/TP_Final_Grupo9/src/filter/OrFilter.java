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

public class OrFilter implements IFilter {
	private IFilter filtro1;
	private IFilter filtro2;
	
	public OrFilter(IFilter filtro1, IFilter filtro2) {
		this.filtro1 = filtro1;
		this.filtro2 = filtro2;
	}
	
	public List<Proyecto> buscar(List<Proyecto> proyectos) {
		
		Set<Proyecto> result = new HashSet<Proyecto>();
		
		result.addAll(filtro1.buscar(proyectos));
		result.addAll(filtro2.buscar(proyectos));
		
		return new ArrayList<Proyecto>(result);
		
	}
}
