package busquedaTest;

import static org.junit.Assert.assertTrue;
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

public class FilterTituloTest {
	
	private ArrayList <IFilter> lista1;
	private ArrayList <IFilter> lista2;
	
	
	private Proyecto proyecto1;
	private Proyecto proyecto2;
	private Proyecto proyecto3;
	private Filter filter1;

	
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
}
	
	@Test 
	public void testOne() {

		filter1 = new FilterTitulo("Proyecto1");
		
		assertTrue(lista2.equals(filter1.verificar(lista1)));
	}
	
	
	
	
}