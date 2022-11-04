package filter;

import java.util.List;

import proyectos.Proyecto;

public class NotFilter {
	protected IFilter iFilter;

	
	public NotFilter (IFilter iFilter) {
		this.iFilter = iFilter;
	}

	public List<Proyecto> buscarProyecto(List<Proyecto> proyectos) {
		List <Proyecto> proyectosFiltrados = iFilter.buscarProyecto(proyectos);
		proyectosFiltrados.removeAll(proyectosFiltrados);
		return proyectosFiltrados;
	}
	
}
