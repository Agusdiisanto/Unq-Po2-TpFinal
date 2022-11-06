package busquedaTest;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import actividad.Caracteristica;
import filter.AndFilter;
import filter.Filter;
import filter.FilterIncludeCategoria;
import filter.FilterTitulo;
import filter.IFilter;
import filter.OrFilter;
import proyectos.Proyecto;

public class AndFilterTest {
	
	private List <Proyecto> proyectos;
	private Proyecto proyecto1;
	private Proyecto proyecto2;
	private Proyecto proyecto3;
	private Filter andFilter;
	private Filter orFilter;
	private Filter filterTitulo1;
	private Filter filterTitulo2;
	private Filter filterCategoria;
	private Filter filterSinCategoria;
	private Set <String> categorias1;
	private FilterTitulo filterTitulo;
	
	
	
	@BeforeEach
	public void setUp() {
		proyecto1 = mock(Proyecto.class);
		proyecto2 = mock(Proyecto.class);
		proyecto3 = mock(Proyecto.class);
		
		
		proyectos = Arrays.asList(proyecto1, proyecto2, proyecto3);

		
		proyecto1.agregarCategoria("Categoria1");
		proyecto1.agregarCategoria("Categoria2");
		
		
		when(proyecto1.getNombre()).thenReturn("Proyecto1");
		when(proyecto2.getNombre()).thenReturn("Proyecto2");
		when(proyecto3.getNombre()).thenReturn("Proyecto3");
		
		
		filterCategoria = new FilterIncludeCategoria("Categoria1");
		orFilter = new OrFilter();
		
		filterTitulo = new FilterTitulo("Proyecto1");
	}
	
	@Test
	public void test01() {
	
		List <Proyecto> proyectos1= orFilter.filter(proyectos);

		assertEquals(proyectos1.size(), 1);
	
}
	@Test
	public void test02() {
		
	}

}