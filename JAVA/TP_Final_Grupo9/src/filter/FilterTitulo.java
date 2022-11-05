package filter;

import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class FilterTitulo extends Filter {
	
	private String filterTitulo;
	private Pattern patron;
	
	public FilterTitulo(String filterTitulo) {
		this.patron = Pattern.compile(filterTitulo);
	}


	@Override
	public ArrayList<IFilter> verificar (ArrayList<IFilter> list) {
		ArrayList <IFilter> iFilter = new ArrayList<IFilter>();
		
		return (ArrayList<IFilter>) iFilter.stream().
				filter(f -> patron.matcher(f.getNombre()).matches()).
				collect(Collectors.toList());
	}
 
}
