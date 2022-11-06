package busquedaTest;

import static org.junit.Assert.assertFalse;
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

public class FIltroTest {
	
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
	private Filter        otroFiltroOr;
	
	
	
	@BeforeEach
	public void setUp() {
		proyecto1 = mock(Proyecto.class);
		proyecto2 = mock(Proyecto.class);
		proyecto3 = mock(Proyecto.class);
		
		
		proyectos = Arrays.asList(proyecto1, proyecto2, proyecto3);

		
		proyecto1.agregarCategoria("Categoria1");
		proyecto1.agregarCategoria("Categoria2");
		
		
		when(proyecto1.tieneElTitulo("Proyecto1")).thenReturn(true);
		when(proyecto2.tieneElTitulo("Proyecto2")).thenReturn(true);
		when(proyecto3.tieneElTitulo("Proyecto3")).thenReturn(true);
		
		
		filterCategoria = new FilterIncludeCategoria("Categoria1");
		orFilter = new OrFilter();
		andFilter = new AndFilter();
		
		filterTitulo = new FilterTitulo("Proyecto1");
		orFilter.addFilter(filterTitulo);
		otroFiltroOr = filterCategoria;
		
		
		andFilter.addFilter(filterTitulo);
		
		
	}
	
	@Test
	public void test01() {
		
		List <Proyecto> proyectos1 = orFilter.filter(proyectos);

		assertEquals(proyectos1.size(), 1);
		assertTrue(proyectos1.contains(proyecto1));
		assertFalse(proyectos1.contains(proyecto3));
	
}
	@Test
	public void test02() {
		
		List <Proyecto> proyectos1 = andFilter.filter(proyectos);
				
		assertEquals(proyectos1.size(), 1);
		
		assertTrue(proyectos1.contains(proyecto1));
		assertFalse(proyectos1.contains(proyecto2));
	}
	
	@Test
	public void test03() {
		
		List <Proyecto> proyectos1 = filterTitulo.filter(proyectos);
		
		
		assertEquals(proyectos1.size(), 1);
		
	}
	
	@Test 
	
	public void test04() {
		
	}
	
	

}