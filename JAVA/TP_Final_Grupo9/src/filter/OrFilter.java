package filter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

	@Override
<<<<<<< HEAD
	public List<Proyecto> buscar(List<Proyecto> proyectos) {
		List <Proyecto> resultados = new ArrayList<Proyecto>();
		for (IFilter iFilter : this.getFiltros()) {
			List <Proyecto> newP = iFilter.buscar(proyectos).stream().
=======
	public ArrayList<Proyecto> buscar(ArrayList<Proyecto> proyectos) {
		ArrayList<Proyecto> resultados = new ArrayList<Proyecto>();
		for (IFilter iFilter : this.getFiltros()) {
			List<Proyecto> newP = iFilter.buscar(proyectos).stream().
>>>>>>> 3bd6600a0b05939a2942da6faf92736532987d8c
									filter(proyecto -> !resultados.contains(proyecto)).
									collect(Collectors.toList());
			resultados.addAll(newP);
		}
		return resultados;
	}
}
