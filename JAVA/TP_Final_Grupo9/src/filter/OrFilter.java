package filter;

import java.util.ArrayList;
import java.util.List;

import proyectos.Proyecto;

public class OrFilter extends Filter {
	private Filter filter1;
	private Filter filter2;
	
	
	public OrFilter (Filter filter1, Filter filter2) {
	 this.filter1= filter1;
	 this.filter2= filter2;
}
	

	@Override
	public ArrayList<IFilter> iFilter(ArrayList<IFilter> list) {
		ArrayList <IFilter> iFilter1 = this.filter1.iFilter(list);
		ArrayList <IFilter> iFilter2 = this.filter1.iFilter(list);
		ArrayList <IFilter> iFilter  = iFilter1;
		iFilter.removeAll(iFilter2);
		iFilter.addAll(iFilter2);
		
		return iFilter;
	}
}
