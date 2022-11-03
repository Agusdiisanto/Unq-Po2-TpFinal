package busqueda;

import java.util.List;

import proyectos.Proyecto;

public class OrFilter extends BinaryFilter {
	
	public OrFilter (IFilter iFilter1, IFilter iFilter2) {
		super(iFilter1, iFilter2);
	}

	@Override
	public List<Proyecto> buscarProyecto(List<Proyecto> todosLosProyectos) {
		List <Proyecto> proyectosFiltrados1 = filter1.buscarProyecto(todosLosProyectos);
		List <Proyecto> proyectosFiltrados2 = filter2.buscarProyecto(todosLosProyectos);
		proyectosFiltrados1.removeAll(proyectosFiltrados2);
		proyectosFiltrados1.addAll(proyectosFiltrados2);
		return proyectosFiltrados1;
	}
}
