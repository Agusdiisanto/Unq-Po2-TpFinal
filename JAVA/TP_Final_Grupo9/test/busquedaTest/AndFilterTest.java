package busquedaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import filter.AndFilter;
import filter.FilterIncludeCategoria;
import filter.FilterTitulo;
import proyectos.Proyecto;


public class AndFilterTest {
	
	private AndFilter compositeAND1;
	private FilterTitulo condicion1;
	private FilterIncludeCategoria condicion2;
	private Proyecto proyecto1, proyecto2, proyecto3;
	
	@BeforeEach
	public void setUp() {
				
		proyecto1 = mock(Proyecto.class);
		proyecto2 = mock(Proyecto.class);
		proyecto3 = mock(Proyecto.class);
		
		when(proyecto1.getNombre()).thenReturn("Programacion con Java");
		when(proyecto2.getNombre()).thenReturn("Patrones De Dieseño");
		when(proyecto3.getNombre()).thenReturn("Programacion con C#");

		when(proyecto1.tieneElTitulo("Programacion con Java")).thenReturn(true);
		when(proyecto2.tieneElTitulo("Programacion con Java")).thenReturn(false);
		when(proyecto3.tieneElTitulo("Programacion con Java")).thenReturn(false);
		
		proyecto1.agregarCategoria("Dificultad");
		proyecto2.agregarCategoria("Categoria2");
		proyecto3.agregarCategoria("Categoria3");
		
		when(proyecto1.includes("Dificultad")).thenReturn(true);
		when(proyecto2.includes("Categoria2")).thenReturn(true);
		when(proyecto3.includes("Categoria3")).thenReturn(true);
		
		
		condicion1 = new FilterTitulo("Programacion con Java");
		condicion2 = new FilterIncludeCategoria("Dificultad");

		
		
		compositeAND1 = new AndFilter (condicion1, condicion2);
		
	}
	
	@Test
	public void testFiltrarProyectosAND() {
		
		List<Proyecto> proyectos = Arrays.asList(proyecto1, proyecto2, proyecto3);
		
		List<Proyecto> filtrados = Arrays.asList(proyecto1); 
		
		assertEquals(compositeAND1.buscar(proyectos), filtrados);
		
	}
	
}
