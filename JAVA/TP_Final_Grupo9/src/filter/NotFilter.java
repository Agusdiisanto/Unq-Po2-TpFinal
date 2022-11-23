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
<<<<<<< HEAD
	}	
	
	public List<Proyecto> buscar(List<Proyecto> proyectos) {
		List <Proyecto> resultados = new ArrayList<>(proyectos);
		for(IFilter filtros : this.filtros) {
			List <Proyecto>filtrados = filtros.buscar(proyectos);
			resultados.removeAll(filtrados);
		}  
=======
	}

	@Override
	public ArrayList<Proyecto> buscar(ArrayList<Proyecto> proyectos) {
		ArrayList<Proyecto> temporal   = filtro.buscar(proyectos);
		ArrayList<Proyecto> resultados = new ArrayList<Proyecto>(proyectos);
		resultados.removeAll(temporal);
>>>>>>> 3bd6600a0b05939a2942da6faf92736532987d8c
		return resultados;
	}
}
