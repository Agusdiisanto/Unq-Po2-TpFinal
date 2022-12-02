package busquedaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import filter.FilterIncludeCategoria;
import filter.FilterNotIncludeCategoria;
import proyectos.Proyecto;

public class FilterNotIncludeCategoriaTest {
	
	private FilterNotIncludeCategoria condicion1;
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
		
		proyecto1.agregarCategoria("Categoria1");
		proyecto2.agregarCategoria("Categoria2");
		proyecto3.agregarCategoria("Categoria3");;
		
		when(proyecto1.includes("Categoria1")).thenReturn(true);
		when(proyecto2.includes("Categoria1")).thenReturn(false);
		when(proyecto3.includes("Categoria1")).thenReturn(false);
		condicion1 = new FilterNotIncludeCategoria("Categoria1");
		condicion2 = new FilterIncludeCategoria("Categoria1");
		
	}

	
    @Test
	
	public void testFiltrarProyectosNotIncludeCategoria() {
		
		List<Proyecto> proyectos = Arrays.asList(proyecto1, proyecto2, proyecto3);
		
		List<Proyecto> filtrados = Arrays.asList(proyecto2, proyecto3); 
		
		assertEquals(condicion1.buscar(proyectos), filtrados);
		assertEquals(condicion1.buscar(proyectos).size(), 2);
		
	}
    
    @Test
	
   	public void testFiltrarProyectosQuencludeCategoria() {
   		
   		List<Proyecto> proyectos = Arrays.asList(proyecto1, proyecto2, proyecto3);
   		
   		List<Proyecto> filtrados = Arrays.asList(proyecto1); 
   		
   		assertEquals(condicion2.buscar(proyectos), filtrados);
   		assertEquals(condicion2.buscar(proyectos).size(), 1);
   		
   	}
       

}

