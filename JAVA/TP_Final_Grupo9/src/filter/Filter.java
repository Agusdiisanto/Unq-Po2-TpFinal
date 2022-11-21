package filter;

import java.util.ArrayList;

/*
 * Esta clase abstracta se encarga de modelar un filtro.
 * 
 */

public abstract class Filter implements IFilter{
	ArrayList<IFilter> filtros;
	
	public void addFilter(IFilter iFilter) {
		if(!this.containsFilter(iFilter)) {
			getFiltros().add(iFilter);
		}
	}
	
	public ArrayList<IFilter> getFiltros(){ 
		return this.filtros;
	}
	
	public boolean containsFilter(IFilter iFilter) {
		return this.getFiltros().contains(iFilter);
	}
}
