package usuarioTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.calls;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import desafios.Desafio;
import estadoDeUsuario.ProgresoDesafio;
import muestra.Muestra;
import proyectos.Proyecto;
import usuario.AplicacionMovil;
import usuario.Estadisticas;
import usuario.Perfil;
import usuario.Usuario;

public class UsuarioTest {
		
	Usuario usuario;
	AplicacionMovil appMovil;
	Perfil perfil;
	ProgresoDesafio progreso;
	Desafio desafio;
	Estadisticas estadistica;
	Proyecto proyecto;
	Muestra muestra;
	
	@BeforeEach
	public void setUp() {
		proyecto = mock(Proyecto.class);
		appMovil = mock(AplicacionMovil.class);
		perfil = mock(Perfil.class);
		progreso = mock(ProgresoDesafio.class);
		desafio = mock(Desafio.class);
		estadistica = mock(Estadisticas.class);
		muestra = mock(Muestra.class);
		
		usuario = new Usuario("Agustin", appMovil, perfil);
		
	}
	
	@Test
	public void test01_UnUsuarioSabeSuNombre() {
		assertEquals("Agustin", usuario.getNombre());
	}
	
	@Test
	public void test02_UnUsuarioTieneUnaAplicacion() {
		assertEquals(appMovil, usuario.getAplicacion());
	}
	
	@Test
	public void test03_UnUsuarioTieneUnPerfil() {
		assertEquals(perfil, usuario.getPerfil());
	}
	
	@Test
	public void test04_UnUsuarioSabeAgregarLosProyectosEnProgreso() {
		usuario.agregarNuevoProyectoEnCurso(proyecto);
		assertTrue(usuario.getProyectoEnCurso().contains(proyecto));
		assertFalse(usuario.getProyectoEnCurso().isEmpty());
	}
	
	@Test
	public void test05_UnUsuarioNoTieneProyectosEnProgresoRepetidos() {
		usuario.agregarNuevoProyectoEnCurso(proyecto);
		usuario.agregarNuevoProyectoEnCurso(proyecto);
		assertEquals(1, usuario.cantidadDeProyectosEnCurso());
		assertTrue(usuario.getProyectoEnCurso().contains(proyecto));
		assertFalse(usuario.getProyectoEnCurso().isEmpty());
	} 
	
	@Test
	public void test06_UnUsuarioRegistraLosDesafiosCompletados() {
		
		when(desafio.getRecompensa()).thenReturn(3456);
		usuario.registrarDesafioCompletado(desafio,desafio.getRecompensa(),10);
		
		assertTrue(usuario.getDesafiosCompletados().containsKey(desafio));
		assertEquals(1, usuario.cantidadDeDesafiosCompletados());
		assertFalse(usuario.getDesafiosCompletados().isEmpty());
	}
	
	@Test
	public void test07_UnUsuarioNoTieneDesafiosCompletadosRepetidos() {
		
		when(desafio.getRecompensa()).thenReturn(3456);
		usuario.registrarDesafioCompletado(desafio,desafio.getRecompensa(),10);
		usuario.registrarDesafioCompletado(desafio,desafio.getRecompensa(),10);
		
		assertTrue(usuario.getDesafiosCompletados().containsKey(desafio));
		assertEquals(1, usuario.cantidadDeDesafiosCompletados());
		assertFalse(usuario.getDesafiosCompletados().isEmpty());
	}
	
	@Test
	public void test07_UnUsuarioPuedeAgregarDesafiosEnCurso() {
		
		usuario.agregarNuevoProgresoDeDesafio(progreso);
		
		assertTrue(usuario.getDesafiosEnCurso().contains(progreso));
		assertEquals(1, usuario.cantidadDeDesafiosEnCurso());
		assertFalse(usuario.getDesafiosEnCurso().isEmpty());
	}
	
	@Test
	public void test07_UnUsuarioNoPuedeAgregarDosVecesElDesafiosEnCurso() {
		
		usuario.agregarNuevoProgresoDeDesafio(progreso);
		usuario.agregarNuevoProgresoDeDesafio(progreso);
		
		assertTrue(usuario.getDesafiosEnCurso().contains(progreso));
		assertEquals(1, usuario.cantidadDeDesafiosEnCurso());
		assertFalse(usuario.getDesafiosEnCurso().isEmpty());
	}
	
	@Test
	public void test08_UnUsuarioSabeCuandoEstaEnDesafioActualmente() {
		usuario.agregarNuevoProgresoDeDesafio(progreso);
		when(progreso.esDesafioActual()).thenReturn(true);
		assertTrue(usuario.estaEnDesafioActualmente());
	}
	
	@Test
	public void test09_UnUsuarioSabeCuandoEstaEnDesafioActualmente() {
		usuario.agregarNuevoProgresoDeDesafio(progreso);
		when(progreso.esDesafioActual()).thenReturn(false);
		assertFalse(usuario.estaEnDesafioActualmente());
	}
	
	@Test
	public void test10_UnUsuarioSabeIncribirseAUnDesafio() throws Exception {
		
		usuario.inscribirseEnUnDesafio(desafio);
		assertEquals(1, usuario.cantidadDeDesafiosEnCurso());
		assertFalse(usuario.getDesafiosEnCurso().isEmpty());
	}
	
	@Test
	public void test11_UnUsuarioPuedeInscribiriseEnUnProyecto() {
		
		when(proyecto.tieneAlParticipante(usuario)).thenReturn(true);
		
		usuario.solicitarSuscripcionAProyecto(proyecto);
		assertTrue(proyecto.tieneAlParticipante(usuario));
	} 
	
	@Test
	public void test12_UnUsuarioPuedeRecolectarMuestras() throws Exception {
		
		usuario.recolectarMuestra(muestra);
		verify(appMovil,times(1)).recolectarMuestra(muestra, usuario, proyecto);
		
	}
	

/*
	@Test
	public void test04_unProyectoTieneMuestras() {
		usuario1.registrarDesafioCompletado(desafio1, 3, 2);
		//usuario1.registrarDesafioCompletado(desafio2, 3, 2);
	    assertEquals(usuario1.getDesafioFavorito(), desafio1);
	}
	*/	
	
}
