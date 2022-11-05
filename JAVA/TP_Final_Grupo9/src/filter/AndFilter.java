package filter;

import java.util.ArrayList;
import java.util.List;

import proyectos.Proyecto;

public class AndFilter extends Filter {
	private Filter filter1;
	private Filter filter2;

	public AndFilter (Filter filter1, Filter filter2) {
		this.filter1 = filter1;
		this.filter2 = filter2;
	}

	
	@Override
	public ArrayList<IFilter> verificar(ArrayList<IFilter> list) {
		
		ArrayList <IFilter> iFilter1 = this.filter1.verificar(list);
		ArrayList <IFilter> iFilter2 = this.filter2.verificar(list);
		ArrayList <IFilter> iFilter  = iFilter1;
		iFilter = iFilter1;
		iFilter.retainAll(iFilter2);
	
		return iFilter;
	}
	
}
