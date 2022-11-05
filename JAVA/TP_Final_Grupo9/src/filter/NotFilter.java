package filter;

import java.util.ArrayList;
import java.util.List;

import proyectos.Proyecto;

public class NotFilter extends Filter{
	private Filter filter;

	
	public NotFilter (Filter filter) {
		this.filter = filter;
	}

	@Override
	public ArrayList<IFilter> verificar(ArrayList<IFilter> list) {
		
		ArrayList <IFilter> iFilter = this.filter.verificar(list);
		
		ArrayList <IFilter> iFilter1 = list;
		
		iFilter.removeAll(iFilter1);
		
		return iFilter;
		
	}
	
}
