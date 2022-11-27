package filter;

import java.util.List;
import java.util.stream.Collectors;

import proyectos.Proyecto;

/*
 * Esta clase abstracta se encarga de modelar un filtro.
 * 
 */

public abstract class Filter implements IFilter{
	
	
	public  List<Proyecto> buscar(List<Proyecto> proyectos){
		return proyectos.stream().filter(p -> this.containsFilter(p)).collect(Collectors.toList());
	}

	public abstract boolean containsFilter(Proyecto proyecto);
	
}
