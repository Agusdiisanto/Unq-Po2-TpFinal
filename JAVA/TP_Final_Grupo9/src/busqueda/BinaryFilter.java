package busqueda;

public abstract class BinaryFilter implements IFilter {
	
	protected IFilter filter1;
	protected IFilter filter2;

	public BinaryFilter(IFilter iFilter1, IFilter iFilter2) {
		this.filter1 = iFilter1;
		this.filter2 = iFilter2;
	}
	
	
	
}
