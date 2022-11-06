package filter;


import java.util.List;

public abstract class Filter implements IFilter{
	
	List <IFilter> filtros;
	
	public void addFilter(IFilter iFilter) {
		if(!this.containsFilter(iFilter)) {
				getFiltros().add(iFilter);
			}
		}
	public List <IFilter> getFiltros(){ 
		return this.filtros;
	}
	
	public boolean containsFilter(IFilter iFilter) {
		
		return this.getFiltros().contains(iFilter);
	}

	public void deleteFilter(IFilter iFilter) {
		if(this.containsFilter(iFilter)) {
			this.getFiltros().remove(iFilter);
		}
	}
	
}
