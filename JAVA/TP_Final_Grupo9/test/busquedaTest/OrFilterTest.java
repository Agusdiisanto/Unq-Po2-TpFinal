package busquedaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import actividad.Caracteristica;
import filter.AndFilter;
import filter.Filter;
import filter.FilterTitulo;
import filter.IFilter;
import filter.OrFilter;
import proyectos.Proyecto;

public class OrFilterTest {
	
	private Proyecto proyecto1;
	private Proyecto proyecto2;
	private Proyecto proyecto3;
	
	private List lista1;
	private List lista2;
	
	private Caracteristica caracteristica1;
	private Caracteristica caracteristica2;
	private String texto1;
	private String texto2;
	private String texto3;
	private FilterTitulo filterTitulo1;
	private FilterTitulo filterTitulo2;
	private OrFilter orFilter;
	private Filter filter1;
	private Filter filter2;
	private Filter orFilter;
	
	
	@BeforeEach
	public void setUp() {
		
		   lista1= new ArrayList <IFilter>();
		   lista2= new ArrayList <IFilter>();
			proyecto1 = mock(Proyecto.class);
			proyecto2 = mock(Proyecto.class);
			proyecto3 = mock(Proyecto.class);
			

			when(proyecto1.getNombre()).thenReturn("Proyecto1");
			when(proyecto2.getNombre()).thenReturn("Proyecto2");
			when(proyecto3.getNombre()).thenReturn("Proyecto3");
			lista1.add(proyecto1);
			lista1.add(proyecto2);
			lista1.add(proyecto3);
			lista2.add(proyecto1);
		}
			
		
	
	
	@Test
	public void test01() {
		
	
		filter1  = new FilterTitulo("Proyecto1");
		filter2  = new FilterTitulo("Proyecto2");
		orFilter = new OrFilter(filter1, filter2);
		
		assertTrue(lista2.equals(orFilter.verificar(lista1)));
		
	}

}
