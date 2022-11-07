package filter;

import java.util.List;

import proyectos.Proyecto;


/**
 * 
 * Esta interfaz contiene la lista de filtros en donde están los proyectos de la clase Proyecto.
 *
 */

public interface IFilter {

	public List <Proyecto> filter(List<Proyecto> proyectos);
}

