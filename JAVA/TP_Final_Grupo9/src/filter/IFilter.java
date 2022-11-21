package filter;

import java.util.ArrayList;

import proyectos.Proyecto;

/**
 * 
 * Esta interfaz contiene la lista de filtros en donde están los proyectos de la clase Proyecto.
 *
 */

public interface IFilter {
	public ArrayList<Proyecto> buscar(ArrayList<Proyecto> proyectos);
}
