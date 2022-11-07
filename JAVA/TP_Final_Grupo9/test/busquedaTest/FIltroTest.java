package busquedaTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import filter.AndFilter;
import filter.Filter;
import filter.FilterIncludeCategoria;
import filter.FilterNotIncludeCategoria;
import filter.FilterTitulo;

import filter.NotFilter;
import filter.OrFilter;
import proyectos.Proyecto;

public class FIltroTest {
	private List <Proyecto> proyectos;
	private Proyecto 	    proyecto1;
	private Proyecto 	    proyecto2;
	private Proyecto 	    proyecto3;
	private Filter 		 	andFilter;
	private Filter 		 	orFilter;
	private Filter 		 	filterCategoria;
	private FilterTitulo 	filterTitulo;
	private Filter       	otroFiltroOr;
	private Filter   	 	filterNoIncluyeCategoria;
	private Filter		 	notFilter;
	
	@BeforeEach
	public void setUp() {
		proyecto1 = mock(Proyecto.class);
		proyecto2 = mock(Proyecto.class);
		proyecto3 = mock(Proyecto.class);
		proyectos = Arrays.asList(proyecto1, proyecto2, proyecto3);

		proyecto1.agregarCategoria("Categoria1");
		proyecto1.agregarCategoria("Categoria2");
		
		when(proyecto1.tieneElNombre("Proyecto1")).thenReturn(true);
		when(proyecto2.tieneElNombre("Proyecto2")).thenReturn(true);
		when(proyecto3.tieneElNombre("Proyecto3")).thenReturn(true);
		when(proyecto1.contieneALaCategoria("Categoria1")).thenReturn(true);
		when(proyecto1.contieneALaCategoria("Categoria2")).thenReturn(true);
		
		filterCategoria = new FilterIncludeCategoria("Categoria1");
		filterNoIncluyeCategoria = new FilterNotIncludeCategoria ("Categoria1");
		orFilter = new OrFilter();
		andFilter = new AndFilter();
		
		filterTitulo = new FilterTitulo("Proyecto1");
		orFilter.addFilter(filterTitulo);
		otroFiltroOr = new OrFilter();
		otroFiltroOr.addFilter(andFilter);
		otroFiltroOr.addFilter(filterCategoria);
		
		andFilter.addFilter(filterTitulo);
		
		notFilter = new NotFilter();
		notFilter.addFilter(andFilter);
		notFilter.addFilter(filterCategoria);
	}
	
	@Test
	public void test01puedoFiltrarProyectosConElOrFilter() {
		List <Proyecto> proyectos1 = orFilter.filter(proyectos);

		assertEquals(proyectos1.size(), 1);
		assertTrue(proyectos1.contains(proyecto1));
		assertFalse(proyectos1.contains(proyecto3));
	}
	
	@Test
	public void test02puedoFiltrarProyectosConElAndFilter() {
		List <Proyecto> proyectos1 = andFilter.filter(proyectos);
				
		assertEquals(proyectos1.size(), 1);
		assertTrue(proyectos1.contains(proyecto1));
		assertFalse(proyectos1.contains(proyecto2));
	}
	
	@Test
	public void test03puedoFiltrarProyectosConElFilterTitulo() {
		List <Proyecto> proyectos1 = filterTitulo.filter(proyectos);
		assertEquals(proyectos1.size(), 1);
		assertTrue(proyectos1.contains(proyecto1));
		assertFalse(proyectos1.contains(proyecto2));
	}
	
	@Test
	public void test04puedoFiltrarProyectosConElFilterQueIncluyeUnaCategoria() {
		List <Proyecto> proyectos1 = filterCategoria.filter(proyectos);
		
		assertEquals(proyectos1.size(), 1);
		assertTrue(proyectos1.contains(proyecto1));
		assertFalse(proyectos1.contains(proyecto2));
	}
	
	@Test 
	public void test05puedoFiltrarProyectosConElFilterQueNoIncluyeUnaCategoria() {
		List <Proyecto> proyectos1 = filterNoIncluyeCategoria.filter(proyectos);
		
		assertEquals(proyectos1.size(), 2);
		assertTrue(proyectos1.contains(proyecto2));
		assertFalse(proyectos1.contains(proyecto1));
	}

	@Test
	public void test046uedoFiltrarProyectosConElNotFilter() {
		List <Proyecto> proyectos1 = notFilter.filter(proyectos);
		
		assertEquals(proyectos1.size(), 2);
		assertTrue(proyectos1.contains(proyecto2));
		assertFalse(proyectos1.contains(proyecto1));
	}
}
