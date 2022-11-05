package busquedaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import actividad.Caracteristica;
import filter.AndFilter;
import filter.FilterTitulo;
import filter.OrFilter;
import proyectos.Proyecto;

public class OrFilterTest {
	
	private Proyecto proyecto1;
	private Proyecto proyecto2;
	private Proyecto proyecto3;
	
	private List <Proyecto>  todosLosProyectos;
	
	private Caracteristica caracteristica1;
	private Caracteristica caracteristica2;
	private String texto1;
	private String texto2;
	private String texto3;
	private FilterTitulo filterTitulo1;
	private FilterTitulo filterTitulo2;
	private OrFilter orFilter;
	
	
	@BeforeEach
	public void setUp() {
		
		todosLosProyectos = new ArrayList<Proyecto>();
		proyecto1 = new Proyecto("ProyectoNueve","GrupoNueve");
		proyecto2 = new Proyecto("ProyectoDiez","GrupoDiez");
		proyecto3 = new Proyecto("ProyectoOcho","Ocho");
		todosLosProyectos.add(proyecto1);
		todosLosProyectos.add(proyecto2);
		todosLosProyectos.add(proyecto3);
		texto1 = "ProyectoNueve";
		texto2 = "ProyectoDiez";
		texto3 = "Texto3";
		
		
		
		filterTitulo1 = new FilterTitulo(texto1);
		filterTitulo2 = new FilterTitulo(texto2);
		
		
		orFilter = new OrFilter(filterTitulo1, filterTitulo2);
		
	}
	
	
	@Test
	public void test01() {
		
		List <Proyecto> proyectos = new ArrayList <Proyecto>();
		proyectos.add(proyecto1);
		proyectos.add(proyecto2);
		proyectos.add(proyecto3);
		
		List <Proyecto> proyectosBuscados = orFilter.buscarProyecto(todosLosProyectos);
		
		assertEquals(proyectos, proyectosBuscados);
	}
	

}
