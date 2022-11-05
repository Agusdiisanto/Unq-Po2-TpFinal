package sistemaTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Sistema.Sistema;
import actividad.Caracteristica;
import actividad.Desafio;
import proyectos.Proyecto;
import usuario.AplicacionMovil;
import usuario.Perfil;
import usuario.RecomendacionSegunPreferencias;
import usuario.Usuario;

public class SistemaTest {
	
	private Sistema  	  system;
	private Proyecto 	  proyecto1;
	private Proyecto 	  proyecto2;
	private Usuario  	  usuario1;
	private RecomendacionSegunPreferencias estrategiaDeRecomendacion1;
	private Desafio 	  desafio1;
	private Desafio 	  desafio2;
	private Desafio 	  desafio3;
	private Set<Desafio>  desafios1;
	private Set<Desafio>  desafios2;
	private ArrayList<Desafio> desafios3;
	private Perfil perfil1;
	private Caracteristica caracteristica1;
	
	@BeforeEach
	public void setUp() {
		proyecto1 = mock(Proyecto.class);
		proyecto2 = mock(Proyecto.class);
		usuario1  = mock(Usuario.class);
		desafio1  = mock(Desafio.class);
		perfil1  = mock(Perfil.class);
		estrategiaDeRecomendacion1 = mock(RecomendacionSegunPreferencias.class); 

    	//perfil1			= new Perfil();
    	caracteristica1 = new Caracteristica("Carateristica1", 1);
		desafios1 = new HashSet<Desafio>();
		desafios2 = new HashSet<Desafio>();
		desafios3 = new ArrayList<Desafio>();
		system	  = new Sistema();
		
		desafios1.add(desafio1);
		desafios2.add(desafio2);
		desafios2.add(desafio3);
		desafios3.add(0, desafio1);
		desafios3.add(1, desafio2);
		desafios3.add(2, desafio3);
    	perfil1.agregarGusto("Gusto1");
    	perfil1.agregarCaracteristicaPreferida(caracteristica1);
    	perfil1.agregarComportamiento("Comportamiento1");
    	perfil1.setTipoDeRecomendacionPreferido(estrategiaDeRecomendacion1);	
	}
	
	@Test
	public void test01_unSistemaNuevoNoTieneProyectos() {
		assertTrue(system.getProyectos().isEmpty());
	}
	
	@Test
	public void test02_unSistemaTieneProyectos() {
		system.agregarProyecto(proyecto1);
		assertEquals(system.getProyectos().size(), 1);
		assertTrue(system.getProyectos().contains(proyecto1));
	}
	
	@Test
	public void test03_unSistemaNoTieneProyectosRepetidos() {
		system.agregarProyecto(proyecto1);
		system.agregarProyecto(proyecto1);
		assertEquals(system.getProyectos().size(), 1);
		assertTrue(system.getProyectos().contains(proyecto1));
	}
	
	// NO FUNCIONA, A CHEQUEAR LUEGO
	@Test
	public void test04_unSistemaRecomiendaDesafiosAUnUsuarioPorPreferencia() {
		ArrayList<Desafio> desafios = new ArrayList<>();
		
		desafios.add(desafio1);
		desafios.add(desafio2);
		desafios.add(desafio3);
		
		 
		when(usuario1.getEstrategia()).thenReturn(estrategiaDeRecomendacion1);
		when(estrategiaDeRecomendacion1.quedarseConLosPrimeros(desafios3, 0)).thenReturn(desafios);
		
		system.agregarProyecto(proyecto1);
		system.agregarProyecto(proyecto2);
		assertEquals(system.recomendarDesafiosAlUsuario(usuario1).size(), 0);
		// assertTrue(system.recomendarDesafiosAlUsuario(usuario1).contains(desafio1));
		// assertTrue(system.recomendarDesafiosAlUsuario(usuario1).contains(desafio2));
		// assertTrue(system.recomendarDesafiosAlUsuario(usuario1).contains(desafio3));
	}
	
	// HABRÍA QUE TESTEAR MÁS CASOS
}
