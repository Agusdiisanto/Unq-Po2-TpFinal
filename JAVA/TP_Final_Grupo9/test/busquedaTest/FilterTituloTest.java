package busquedaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import filter.FilterTitulo;
import proyectos.Proyecto;

public class FilterTituloTest {
	private FilterTitulo condicion1;
	private Proyecto proyecto1, proyecto2, proyecto3;
	
	@BeforeEach
	public void setUp() {
				
		condicion1 = new FilterTitulo("Programacion con Java");
		proyecto1 = mock(Proyecto.class);
		proyecto2 = mock(Proyecto.class);
		proyecto3 = mock(Proyecto.class);
		
		when(proyecto1.getNombre()).thenReturn("Programacion con Java");
		when(proyecto2.getNombre()).thenReturn("Patrones De Dieseño");
		when(proyecto3.getNombre()).thenReturn("Programacion con C#");
		
		when(proyecto1.tieneElTitulo("Programacion con Java")).thenReturn(true);
		when(proyecto2.tieneElTitulo("Programacion con Java")).thenReturn(false);
		when(proyecto3.tieneElTitulo("Programacion con Java")).thenReturn(false);
		condicion1= new FilterTitulo("Programacion con Java");
		
	}
	
	@Test
	
	public void testFiltrarProyectosAND() {
		
		List<Proyecto> proyectos = Arrays.asList(proyecto1, proyecto2, proyecto3);
		
		List<Proyecto> filtrados = Arrays.asList(proyecto1); 
		
		assertEquals(condicion1.buscar(proyectos), filtrados);
		assertEquals(condicion1.buscar(proyectos).size(), 1);
		
	}
	

}
