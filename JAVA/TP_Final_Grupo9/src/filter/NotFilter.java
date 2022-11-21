package filter;

import java.util.ArrayList;

import proyectos.Proyecto;

/**
 * 
 * Esta clase se encarga de modelar un NotFilter.
 *
 */

public class NotFilter extends Filter{
	private IFilter filtro;
	
	public NotFilter() {
		this.filtros = new ArrayList<IFilter>();
	}

	@Override
	public ArrayList<Proyecto> buscar(ArrayList<Proyecto> proyectos) {
		ArrayList<Proyecto> temporal   = filtro.buscar(proyectos);
		ArrayList<Proyecto> resultados = new ArrayList<Proyecto>(proyectos);
		resultados.removeAll(temporal);
		return resultados;
	}
}
