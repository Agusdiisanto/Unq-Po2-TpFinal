package ciencia.participativa;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import caracteristicas.desafio.Caracteristica;
import desafios.ActividadLudica;
import desafios.Desafio;
import muestra.Coordenada;
import muestra.Muestra;
import proyectos.Proyecto;
import usuario.IParticipante;
import usuario.Usuario;

public class ProyectoTest {
	
	private Muestra 		muestra1;
	private Muestra 		muestra2;
	private Muestra 		muestra3;
	private IParticipante 	participante1;
	private IParticipante 	participante2;
	private IParticipante 	participante3;
	private ActividadLudica actividad1;
	private ActividadLudica actividad2;
	private ActividadLudica actividad3;
	private Muestra         muestra4;
	private Coordenada      coordenada1;
	private LocalDateTime   fecha1;
	private Usuario         usuario1;
	private LocalDateTime   fecha2;
	
	private Proyecto 		proyecto;
	
	private Caracteristica 	caracteristica1;
	private Caracteristica 	caracteristica2;
	
	private Desafio			desafio1;
	private Desafio			desafio2;
	
	@BeforeEach
	public void setUp() {
		inicializadorDeObjetos();
		iniciarComportamientoDeObjetos();
		proyecto.agregarInteres(caracteristica1); 
	}
	
//	Hay que testear por el caso verdadero y el caso falso.
	
	@Test
	public void test01_unProyectoCuandoArrancaNoTieneMuestras() {
		 assertEquals(proyecto.cantidadDeMuestras(), 0);
	}
	
	@Test
	public void test02_unProyectoTieneMuestras() {
		muestra1.agregarCaracteristicaAMuestra(caracteristica1);
		proyecto.agregarMuestra(muestra1);
	    assertTrue(muestra1.tieneLaCaracteristica(caracteristica1));
	    assertEquals(proyecto.cantidadDeMuestras(), 1);
	} 
	
	@Test
	public void test03_unProyectoTieneUnNombre() {
		assertEquals("ProyectoNueve", proyecto.getNombre());
	}
	
	@Test
	public void test04_unProyectoTieneUnaDescripcion() {
		assertEquals("GrupoNueve", proyecto.getDescripcion());
	}
	
	@Test
	public void test05_unProyectoCuandoArrancaTieneCaracteristicas() {
		assertEquals(proyecto.cantidadDeCaracteristicas(), 1);
	}
	
	@Test
	public void test06_unProyectoTieneCaracteristicas() {
		proyecto.agregarInteres(caracteristica1);
		assertEquals(proyecto.cantidadDeCaracteristicas(), 1);
	}
	
	@Test
	public void test07_unProyectoCuandoArrancaNoTieneParticipantes() {
		assertTrue(proyecto.getParticipantes().isEmpty());
	}
	
	@Test
	public void test08_unProyectoTieneUnParticipante() {
		proyecto.agregarNuevoParticipante(participante1);
		assertEquals(proyecto.cantidadDeParticipantes(), 1);
		assertTrue(proyecto.getParticipantes().contains(participante1));
	}
	
	@Test
	public void test09_unProyectoTieneUnaDescripcion() {
		assertEquals(proyecto.getDescripcion(), "GrupoNueve");
	}

	@Test
	public void test10_unProyectoCuandoArrancaNoContieneActividades() {
		assertTrue(proyecto.getActividades().isEmpty());
	}
	
	@Test
	public void test11_unProyectoTieneActividadesLudicas() {
		
		proyecto.agregarActividadLudica(actividad1);
		
		assertEquals(proyecto.cantidadDeActividades(), 1);
		assertTrue(proyecto.getActividades().contains(actividad1));
		assertFalse(proyecto.getActividades().isEmpty());
	}
	
	@Test
	public void test12_unProyectoTieneActividadesLudicasSinRepetir() {
		
		proyecto.agregarActividadLudica(actividad1);
		proyecto.agregarActividadLudica(actividad1);
		
		assertEquals(proyecto.cantidadDeActividades(), 1);
		assertTrue(proyecto.getActividades().contains(actividad1));
		assertFalse(proyecto.getActividades().isEmpty());
	}
	
	@Test
	public void test13_unProyectoTieneParticipantesSinRepetir() {
		
		proyecto.agregarNuevoParticipante(participante1);
		proyecto.agregarNuevoParticipante(participante1);
		
		assertEquals(proyecto.cantidadDeParticipantes(), 1);
		assertTrue(proyecto.getParticipantes().contains(participante1));
		assertFalse(proyecto.getParticipantes().isEmpty());
	}
	
	@Test
	public void test14_unProyectoTieneMuestrasSinRepetir() {
		
		proyecto.agregarMuestra(muestra1);
		proyecto.agregarMuestra(muestra1);
		
		assertEquals(proyecto.cantidadDeMuestras(), 1);
		assertTrue(proyecto.getMuestrasRecolectadas().contains(muestra1));
		assertFalse(proyecto.getMuestrasRecolectadas().isEmpty());
	}

	@Test
	public void test15_unProyectoTieneCateristicasSinRepetir() {
		
		proyecto.agregarInteres(caracteristica1);
		proyecto.agregarInteres(caracteristica1);
		
		assertEquals(proyecto.cantidadDeCaracteristicas(), 1);
		assertTrue(proyecto.getCaracteristicasDeInteres().contains(caracteristica1));
		assertFalse(proyecto.getCaracteristicasDeInteres().isEmpty());
	}
	
	@Test
	public void test16_unProyectoTieneCategoriasSinRepetir() {
		
		proyecto.agregarCategorias("Categoria");
		proyecto.agregarCategorias("Categoria");
		
		assertEquals(proyecto.cantidadDeCategorias(), 1);
		assertTrue(proyecto.getCategorias().contains("Categoria"));
		assertFalse(proyecto.getCategorias().isEmpty());
	}
	
	
	@Test 
	public void test03() {
		muestra4.agregarCaracteristicaAMuestra(caracteristica1);
		proyecto.agregarMuestra(muestra4);
		
		assertEquals(proyecto.getMuestrasRecolectadas().size(), 1);
		assertTrue(muestra4.tieneLaCaracteristica(caracteristica1));
		assertTrue(proyecto.getMuestrasRecolectadas().contains(muestra4));
	
	} 
	  
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	 
	
	private void inicializadorDeObjetos() {
		caracteristica1 = mock(Caracteristica.class);
		caracteristica2 = mock(Caracteristica.class);
		
		fecha2 = LocalDateTime.now();
		
		muestra1 = new Muestra(usuario1, fecha2 , coordenada1);
		muestra2 = mock(Muestra.class);
		muestra3 = mock(Muestra.class);
		usuario1 = mock(Usuario.class);
		
		fecha1      = LocalDateTime.now();
		coordenada1 = mock(Coordenada.class);
		
		participante1 = mock(IParticipante.class);
		participante2 = mock(IParticipante.class);
		participante3 = mock(IParticipante.class);
		
		muestra4   = new Muestra(usuario1,fecha1 , coordenada1);
		
		actividad1 = mock(ActividadLudica.class);
		actividad2 = mock(ActividadLudica.class);
		actividad3 = mock(ActividadLudica.class);
		
		desafio1   = mock(Desafio.class);
		desafio2   = mock(Desafio.class);
		
		proyecto   = new Proyecto("ProyectoNueve","GrupoNueve");
	}
	
	private void iniciarComportamientoDeObjetos() {
		
		when(caracteristica1.getDescripicion()).thenReturn("Caracteristica1");
		when(caracteristica2.getDescripicion()).thenReturn("Caracteristica2");
	}	
}
 