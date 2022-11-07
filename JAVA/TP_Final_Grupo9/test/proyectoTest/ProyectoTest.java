package proyectoTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import actividad.ActividadLudica;
import actividad.Caracteristica;
import actividad.Desafio;
import muestra.Muestra;
import proyectos.Proyecto;
import usuario.IParticipante;

public class ProyectoTest {
	private Muestra 			muestra1;
	private Muestra 			muestra2;
	private IParticipante 		participante1;
	private Proyecto 			proyecto;
	private Caracteristica 		caracteristica1;
	private Caracteristica 		caracteristica2;
	private Set<Caracteristica>	caracteristicas1;
	private Set<Caracteristica> caracteristicas2;
	private ActividadLudica 	actividad1;
	private Desafio				desafio1;
	private Desafio				desafio2;
	
	@BeforeEach
	public void setUp() {
		inicializadorDeObjetos();
		iniciarComportamientoDeObjetos();
	}
	
	@Test
	public void test01_TodoProyectoTieneNombre() {
		assertEquals(proyecto.getNombre(), "ProyectoNueve");
	}
	
	@Test
	public void test02_TodoProyectoTieneDescripcion() {
		assertEquals(proyecto.getDescripcion(), "GrupoNueve");
	}

	@Test
	public void test03_unProyectoNuevoNoTieneActividades() {
		assertEquals(proyecto.cantidadDeActividades(), 0);
	}
	
	@Test
	public void test04_unProyectoTieneActividades() {
		proyecto.agregarActividad(desafio1);
		assertEquals(proyecto.cantidadDeActividades(), 1);
		assertTrue(proyecto.getActividades().contains(desafio1));
	}
	
	@Test
	public void test05_unProyectoNoTieneActividadesRepetidas() {
		proyecto.agregarActividad(desafio1);
		proyecto.agregarActividad(desafio1);
		assertEquals(proyecto.cantidadDeActividades(), 1);
		assertTrue(proyecto.getActividades().contains(desafio1));
	}

	@Test
	public void test06_unProyectoNuevoNoTieneCategorias() {
		assertEquals(proyecto.cantidadDeCategorias(), 0);
	}
	
	@Test
	public void test07_unProyectoTieneCategorias() {
		proyecto.agregarCategoria("Botánica");
		assertEquals(proyecto.cantidadDeCategorias(), 1);
		assertTrue(proyecto.getCategorias().contains("Botánica"));
	}
	
	@Test
	public void test08_unProyectoNoTieneCategoriasRepetidas() {
		proyecto.agregarCategoria("Botánica");
		proyecto.agregarCategoria("Botánica");
		assertEquals(proyecto.cantidadDeCategorias(), 1);
		assertTrue(proyecto.getCategorias().contains("Botánica"));
	}
	
	@Test
	public void test09_unProyectoNuevoNoTieneMuestras() {
		 assertEquals(proyecto.cantidadDeMuestrasRecolectadas(), 0);
	}
	
	@Test
	public void test10_unProyectoTieneMuestras() {
		proyecto.agregarMuestra(muestra1);
		assertEquals(proyecto.cantidadDeMuestrasRecolectadas(), 1);
		assertTrue(proyecto.getMuestrasRecolectadas().contains(muestra1));
	}
	
	@Test
	public void test11_unProyectoNoTieneMuestrasRepetidas() {
		proyecto.agregarMuestra(muestra1);
		proyecto.agregarMuestra(muestra1);
		assertEquals(proyecto.cantidadDeMuestrasRecolectadas(), 1);
		assertTrue(proyecto.getMuestrasRecolectadas().contains(muestra1));
	}
	
	@Test
	public void test12_unProyectoNuevoNoTieneParticipantes() {
		assertEquals(proyecto.cantidadDeParticipantes(), 0);
	}
	
	@Test
	public void test13_unProyectoTieneParticipantes() {
		proyecto.agregarParticipante(participante1);
		assertEquals(proyecto.cantidadDeParticipantes(), 1);
		assertTrue(proyecto.getParticipantes().contains(participante1));
	}
	
	@Test
	public void test14_unProyectoNoTieneParticipantesRepetidos() {
		proyecto.agregarParticipante(participante1);
		proyecto.agregarParticipante(participante1);
		assertEquals(proyecto.cantidadDeParticipantes(), 1);
		assertTrue(proyecto.getParticipantes().contains(participante1));
	}

	@Test
	public void test15_unProyectoNuevoNoTieneCaracteristicasDeInteres() {
		assertEquals(proyecto.cantidadDeCaracteristicasDeInteres(), 0);
	}
	
	@Test
	public void test16_unProyectoTieneCaracteristicasDeInteres() {
		proyecto.agregarCaracteristicaDeInteres(caracteristica1);
		assertEquals(proyecto.cantidadDeCaracteristicasDeInteres(), 1);
	    assertTrue(proyecto.getCaracteristicasDeInteres().contains(caracteristica1));
	}

	@Test
	public void test17_unProyectoNoTieneCateristicasRepetidas() {
		proyecto.agregarCaracteristicaDeInteres(caracteristica1);
		proyecto.agregarCaracteristicaDeInteres(caracteristica1);
		assertEquals(proyecto.cantidadDeCaracteristicasDeInteres(), 1);
		assertTrue(proyecto.getCaracteristicasDeInteres().contains(caracteristica1));
	}
	
	// ============================ MAIN METHODS ============================
	@Test
	public void test18_unProyectoFiltraDesafios() {
		proyecto.agregarActividad(actividad1);
		proyecto.agregarActividad(desafio1);
		assertEquals(proyecto.getDesafios().size(), 1);
		assertTrue(proyecto.getDesafios().contains(desafio1));
	}
	
	@Test
	public void test19_unProyectoIndicaSiUnaMuestraEsDeInteres() {
		proyecto.agregarCaracteristicaDeInteres(caracteristica1);
		assertTrue(proyecto.esMuestraDeInteres(muestra1));
	}
	
	@Test
	public void test20_unProyectoIndicaSiUnaMuestraNoEsDeInteres() {
		proyecto.agregarCaracteristicaDeInteres(caracteristica1);
		assertFalse(proyecto.esMuestraDeInteres(muestra2));
	}
	
	@Test
	public void test21_unProyectoIndicaSiTieneRegistradoAUnUsuario() {
		proyecto.agregarParticipante(participante1);
		assertTrue(proyecto.tieneRegistradoAlUsuario(participante1));
	}
	
	@Test
	public void test22_unProyectoIndicaSiNoTieneRegistradoAUnUsuario() {
		assertFalse(proyecto.tieneRegistradoAlUsuario(participante1));
	}
	
	@Test
	public void test23_unProyectoIndicaSiContieneUnasCategorias() {
		HashSet<String> categorias = new HashSet<>();
		categorias.add("Botánica");
		categorias.add("Fauna");
		proyecto.agregarCategoria("Botánica");
		proyecto.agregarCategoria("Árboles");
		proyecto.agregarCategoria("Fauna");
		assertTrue(proyecto.contieneCategorias(categorias));
	}
	
	@Test
	public void test24_unProyectoIndicaSiNoContieneUnasCategorias() {
		HashSet<String> categorias = new HashSet<>();
		categorias.add("Botánica");
		categorias.add("Fauna");
		proyecto.agregarCategoria("Árboles");
		proyecto.agregarCategoria("Fauna");
		assertFalse(proyecto.contieneCategorias(categorias));
	}
	
	@Test
	public void test25_unProyectoIndicaSiNoContieneUnasCategorias() {
		HashSet<String> categorias = new HashSet<>();
		categorias.add("Botánica");
		categorias.add("Fauna");
		proyecto.agregarCategoria("Árboles");
		proyecto.agregarCategoria("Fauna");
		assertTrue(proyecto.noContieneCategorias(categorias));
	}
	
	@Test
	public void test26_unProyectoIndicaSiContieneUnasCategorias() {
		HashSet<String> categorias = new HashSet<>();
		categorias.add("Botánica");
		categorias.add("Fauna");
		proyecto.agregarCategoria("Botánica");
		proyecto.agregarCategoria("Árboles");
		proyecto.agregarCategoria("Fauna");
		assertFalse(proyecto.noContieneCategorias(categorias));
	}
	
	
	private void inicializadorDeObjetos() {
		caracteristica1  = mock(Caracteristica.class);
		caracteristica2  = mock(Caracteristica.class);
		muestra1		 = mock(Muestra.class);
		muestra2		 = mock(Muestra.class);
		participante1	 = mock(IParticipante.class);
		actividad1		 = mock(ActividadLudica.class);
		desafio1		 = mock(Desafio.class);
		desafio2		 = mock(Desafio.class);
		proyecto		 = new Proyecto("ProyectoNueve","GrupoNueve");
		caracteristicas1 = new HashSet<Caracteristica>();
		caracteristicas2 = new HashSet<Caracteristica>();
		caracteristicas1.add(caracteristica1);
		caracteristicas2.add(caracteristica2);
	}
	
	private void iniciarComportamientoDeObjetos() {
		when(actividad1.esDesafio()).thenReturn(false);
		when(desafio1.esDesafio()).thenReturn(true);
		when(desafio2.esDesafio()).thenReturn(true);
		when(caracteristica1.getDescripicion()).thenReturn("Caracteristica1");
		when(caracteristica2.getDescripicion()).thenReturn("Caracteristica2");
		when(muestra1.getCaracteristicas()).thenReturn(caracteristicas1);
		when(muestra2.getCaracteristicas()).thenReturn(caracteristicas2);
	}	
}
 