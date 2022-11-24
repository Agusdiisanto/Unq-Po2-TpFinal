package filter;

import java.util.ArrayList;
import java.util.List;

import proyectos.Proyecto;

/**
 * 
 * Esta clase se encarga de modelar un filtro And.
 *
 */

public class AndFilter implements IFilter{
	private IFilter filtro1;
	private IFilter filtro2;

	@Override
	public List<Proyecto> buscar(List<Proyecto> proyectos) {
		List<Proyecto> resultado = new ArrayList<Proyecto>(filtro1.buscar(proyectos));
		resultado.retainAll(filtro2.buscar(proyectos));
		return resultado;
	}
}

