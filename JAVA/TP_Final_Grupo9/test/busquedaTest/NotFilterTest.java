package busquedaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import filter.FilterTitulo;
import filter.NotFilter;
import proyectos.Proyecto;

public class NotFilterTest {
	
	private NotFilter condicion1;
	private Proyecto proyecto1, proyecto2, proyecto3;
	private FilterTitulo filtro1;
	
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
		
		filtro1    = new FilterTitulo("Programacion con Java"); 
		condicion1 = new NotFilter(filtro1);
		
	}

	
    @Test
	
	public void testFiltrarProyectosNOT() {
		
		List<Proyecto> proyectos = Arrays.asList(proyecto1, proyecto2, proyecto3);
		
		List<Proyecto> filtrados = Arrays.asList(proyecto2, proyecto3); 
		
		assertEquals(condicion1.buscar(proyectos), filtrados);
		assertEquals(condicion1.buscar(proyectos).size(), 2);
		
	}

}


