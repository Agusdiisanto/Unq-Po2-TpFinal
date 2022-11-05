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
import filter.FilterIncluedCategoria;
import filter.FilterTitulo;
import filter.IFilter;
import proyectos.Proyecto;

public class AndFilterTest {
	
	private Proyecto proyecto1;
	private Proyecto proyecto2;
	private Proyecto proyecto3;
	
	private ArrayList <IFilter>  todosLosIFilters;
	
	private Caracteristica caracteristica1;
	private Caracteristica caracteristica2;
	private String texto1;
	private String texto2;
	private String texto3;
	private FilterTitulo filterTitulo1;
	private FilterTitulo filterTitulo2;
	private AndFilter andFilter;
	private ArrayList <IFilter> iFilters1;
	private ArrayList <IFilter> iFilters2;
	private ArrayList <IFilter> iFilters3;
	
	
	@BeforeEach
	public void setUp() {
		
		iFilters1 = new ArrayList <IFilter>();
		iFilters2 = new ArrayList <IFilter>();
		iFilters3 = new ArrayList <IFilter>();
		todosLosIFilters = new ArrayList <IFilter>();
		proyecto1 = mock(Proyecto.class);
		proyecto2 = mock(Proyecto.class);
		proyecto3 = mock(Proyecto.class);
		
		when(proyecto1.getNombre()).thenReturn("Proyecto1");
		when(proyecto2.getNombre()).thenReturn("Proyecto2");
		when(proyecto3.getNombre()).thenReturn("Proyecto3");

	
		
		
		
		
		
		
		andFilter= new AndFilter(filterTitulo1, filterTitulo2);
		
	}
	
	@Test
	public void test01() {
		
		List <Proyecto> proyectos = new ArrayList <Proyecto>();
		proyectos.add(proyecto1);
		
		
		List <Proyecto> proyectosBuscados = andFilter.buscarProyecto(todosLosProyectos);
		
		assertEquals(proyectos, proyectosBuscados);
	}
	
	
}
