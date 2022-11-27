package busquedaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.util.collections.Sets;

import filter.AndFilter;
import filter.FilterIncludeCategoria;
import filter.FilterTitulo;
import proyectos.Proyecto;


public class AndFilterTest {
	
	private AndFilter compositeAND;
	private FilterTitulo condicion1;
	private FilterIncludeCategoria condicion2;
	private Proyecto proyecto1, proyecto2, proyecto3;
	
	@BeforeEach
	public void setUp() {
				
		condicion1 = new FilterTitulo("Programacion");
		condicion2 = new FilterIncludeCategoria("Dificultad");
		
		proyecto1 = mock(Proyecto.class);
		proyecto2 = mock(Proyecto.class);
		proyecto3 = mock(Proyecto.class);
		
		when(proyecto1.getNombre()).thenReturn("Programacion con Java");
		when(proyecto2.getNombre()).thenReturn("Patrones De Dieseño");
		when(proyecto3.getNombre()).thenReturn("Programacion con C#");
		
		when(proyecto1.getCategorias()).thenReturn(Sets.newSet("Dificultad","Arte"));
		when(proyecto2.getCategorias()).thenReturn(Sets.newSet("Programacion","Desenpeño"));
		when(proyecto3.getCategorias()).thenReturn(Sets.newSet("Patron","Objetos"));
		
		compositeAND = new AndFilter(condicion1, condicion2);
		
	}
	
	@Test
	
	public void testFiltrarProyectosAND() {
		
		List<Proyecto> proyectos = Arrays.asList(proyecto1, proyecto2, proyecto3);
		
		List<Proyecto> filtrados = Arrays.asList(proyecto1); 
		
		assertEquals(compositeAND.buscar(proyectos), filtrados);
		
	}
	
	
}
