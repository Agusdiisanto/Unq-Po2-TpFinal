package filter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import proyectos.Proyecto;

public class FilterIncluedCategoria extends Filter{
	
	private String filterTituloCategoria;
	private Pattern patron; 

	public FilterIncluedCategoria() {
		this.patron = Pattern.compile(filterTituloCategoria);
	}



	@Override
	public ArrayList<IFilter> verificar(ArrayList<IFilter> list) {
		ArrayList <IFilter> iFilter = new ArrayList<IFilter>();
		
		return (ArrayList<IFilter>) iFilter.stream().
				filter(f -> f.getCategorias().stream().
						 anyMatch(c -> patron.matcher(c).matches())).collect(Collectors.toList());

}
}
