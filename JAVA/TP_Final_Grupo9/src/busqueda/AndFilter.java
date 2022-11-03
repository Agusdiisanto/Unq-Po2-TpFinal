package busqueda;

import java.util.List;

import proyectos.Proyecto;

public class AndFilter extends BinaryFilter {

	public AndFilter (IFilter iFilter1, IFilter iFilter2) {
		super(iFilter1, iFilter2);
	}

	@Override
	public List<Proyecto> buscarProyecto(List<Proyecto> todosLosProyectos) {
		List <Proyecto> proyectosFiltrados = filter1.buscarProyecto(todosLosProyectos);
		return filter2.buscarProyecto(proyectosFiltrados);
	}
	
}
