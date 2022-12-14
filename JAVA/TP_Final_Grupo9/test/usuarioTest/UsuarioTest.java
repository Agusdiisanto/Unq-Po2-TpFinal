package usuarioTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import actividad.Caracteristica;
import actividad.Desafio;
import actividad.Dificultad;
import estadoDeUsuario.ProgresoDeDesafio;
import muestra.Muestra;
import proyectos.Proyecto;
import usuario.Perfil;
import usuario.RecomendacionSegunPreferencias;
import usuario.Usuario;

public class UsuarioTest {
	private Usuario						   usuario;
	private Perfil						   perfil;
	private ProgresoDeDesafio			   progreso;
	private Desafio						   desafio;
	private Proyecto					   proyecto;
	private Muestra 					   muestra;
	private Desafio						   desafio2;
	private Caracteristica				   caracteristica;
	private RecomendacionSegunPreferencias estrategia;
	
	@BeforeEach
	public void setUp() {
		proyecto	   = mock(Proyecto.class);
		perfil		   = mock(Perfil.class);
		progreso	   = mock(ProgresoDeDesafio.class);
		desafio		   = mock(Desafio.class);
		muestra		   = mock(Muestra.class);
		desafio2	   = mock(Desafio.class);
		caracteristica = mock(Caracteristica.class);
		estrategia	   = mock(RecomendacionSegunPreferencias.class);
		usuario		   = new Usuario("Agustin", perfil);
	}
	
	@Test
	public void test01_UnUsuarioSabeSuNombre() {
		assertEquals("Agustin", usuario.getNombre());
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
		usuario.registrarDesafioCompletado(desafio,desafio.getRecompensa(),10,0);
		
		assertTrue(usuario.getDesafiosCompletados().containsKey(desafio));
		assertEquals(1, usuario.cantidadDeDesafiosCompletados());
		assertFalse(usuario.getDesafiosCompletados().isEmpty());
	}
	  
	@Test
	public void test07_UnUsuarioNoTieneDesafiosCompletadosRepetidos() {
		when(desafio.getRecompensa()).thenReturn(3456);
		usuario.registrarDesafioCompletado(desafio,desafio.getRecompensa(),10,0);
		usuario.registrarDesafioCompletado(desafio,desafio.getRecompensa(),10,0);
		
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
		LocalDateTime fecha = LocalDateTime.now();
		
		usuario.agregarNuevoProgresoDeDesafio(progreso);
		when(progreso.esDesafioActual(fecha)).thenReturn(true);
		assertTrue(usuario.estaEnDesafioActualmente(fecha));
	}
	
	@Test
	public void test09_UnUsuarioSabeCuandoEstaEnDesafioActualmente() {
		LocalDateTime fecha = LocalDateTime.now();
		
		usuario.agregarNuevoProgresoDeDesafio(progreso);
		when(progreso.esDesafioActual(fecha)).thenReturn(false);
		assertFalse(usuario.estaEnDesafioActualmente(fecha));
	}
	
	@Test
	public void test10_UnUsuarioSabeIncribirseAUnDesafio() throws Exception {
		usuario.inscribirseEnUnDesafio(desafio);
		assertEquals(1, usuario.cantidadDeDesafiosEnCurso());
		assertFalse(usuario.getDesafiosEnCurso().isEmpty());
	}
	
	@Test
	public void test11_UnUsuarioPuedeInscribiriseEnUnProyecto() {
		usuario.solicitarSuscripcionAProyecto(proyecto);
		verify(proyecto,times(1)).agregarParticipante(usuario);
	} 
	
	@Test
	public void test12_UnUsuarioPuedeRecolectarMuestras() throws Exception {
		usuario.agregarNuevoProyectoEnCurso(proyecto);
		usuario.recolectarMuestra(muestra);
		verify(proyecto,times(usuario.getProyectosDeInteres(muestra).size())).agregarMuestra(muestra);
	}
	
	@Test
	public void test13_UnUsuarioPuedeRecolectarMuestrasParaDesafios() throws Exception {
		LocalDateTime fecha = LocalDateTime.now();
		usuario.agregarNuevoProgresoDeDesafio(progreso);
		usuario.recolectarMuestraParaLosDesafios(muestra,fecha);
		verify(progreso,times(1)).recolectarMuestra(usuario, muestra,fecha);
	}
	
	@Test
	public void test14_UnUsuarioPuedeRecolectarMuestrasParaProyectoSiEsDeInteres() throws Exception {
		when(proyecto.esMuestraDeInteres(muestra)).thenReturn(true);
		usuario.agregarNuevoProyectoEnCurso(proyecto);
		usuario.recolectarMuestraParaLosProyectos(muestra);
		verify(proyecto,times(usuario.getProyectosDeInteres(muestra).size())).agregarMuestra(muestra);
	}
	
	@Test
	public void test15_UnUsuarioPuedeRecolectarMuestrasParaProyectoSiNoEsDeInteres() throws Exception {
		when(proyecto.esMuestraDeInteres(muestra)).thenReturn(false);
		usuario.agregarNuevoProyectoEnCurso(proyecto);
		usuario.recolectarMuestraParaLosProyectos(muestra);
		verify(proyecto,times(usuario.getProyectosDeInteres(muestra).size())).agregarMuestra(muestra);
	}
	
	@Test
	public void test16_UnUsuarioTieneUnDesafioFavorito(){
		usuario.registrarDesafioCompletado(desafio2,2,5,5);
		usuario.registrarDesafioCompletado(desafio,3,2,2);
	    assertEquals(usuario.getDesafioFavorito(), desafio2);
	    assertEquals(usuario.getDesafiosCompletados().size(), 2);
	}
	
	@Test
	public void test17_UnUsuarioNoTieneUnDesafioFavorito(){
		// Retorna null porque no encuentra ningun desafio favorito
		usuario.registrarDesafioCompletado(desafio2,12,345,0);
	    assertEquals(usuario.getDesafioFavorito(), null);
	}
	
	@Test
	public void test18_UnUsuarioTieneAfinidadConCaracteristica() {
		when(perfil.afinidadConCaracteristica(caracteristica)).thenReturn(2.3);
		assertEquals(usuario.afinidadConCaracteristica(caracteristica), 2.3);
		verify(perfil,times(1)).afinidadConCaracteristica(caracteristica);
	}
	
	@Test
	public void test19_UnUsuarioNoTieneAfinidadConCaracteristica() {
		when(perfil.afinidadConCaracteristica(caracteristica)).thenReturn(0.0);
		assertEquals(usuario.afinidadConCaracteristica(caracteristica), 0.0);
		verify(perfil,times(1)).afinidadConCaracteristica(caracteristica);
	}
	
	@Test
	public void test20_UnUsuarioContieneCaracteristicaConDescripcion() {
		when(perfil.includesCaracteristicaConDescripcion("s")).thenReturn(true);
		assertTrue(usuario.contieneCaracteristicaConDescripcion("s"));
		verify(perfil,only()).includesCaracteristicaConDescripcion("s");
	}
	
	@Test
	public void test21_UnUsuarioNoContieneCaracteristicaConDescripcion() {
		when(perfil.includesCaracteristicaConDescripcion("s")).thenReturn(false);
		assertFalse(usuario.contieneCaracteristicaConDescripcion("s"));
		verify(perfil,times(1)).includesCaracteristicaConDescripcion("s");
	}
	
	@Test
	public void test22_UnUsuarioSabeLaSimilitudEntreUnDesafioYSuFavorito() {
		usuario.registrarDesafioCompletado(desafio2,2,5,5);
	
		when(desafio.getObjetivo()).thenReturn(30);
		when(desafio.getDificultad()).thenReturn(Dificultad.MUY_FACIL);
		when(desafio.getRecompensa()).thenReturn(3000);
	
		when(desafio2.getObjetivo()).thenReturn(10);
		when(desafio2.getDificultad()).thenReturn(Dificultad.MUY_DIFICIL);
		when(desafio2.getRecompensa()).thenReturn(1000);
		
		assertEquals(usuario.getDesafioFavorito(), desafio2);
		assertEquals(usuario.similitudConFavorito(desafio),676.0);
	}
	
	@Test
	public void test23_UnUsuarioSabeLaEstrategiaARecomendar() {
		when(perfil.getRecomendacionPreferida()).thenReturn(estrategia);
		
		assertEquals(usuario.getEstrategia(), estrategia);
		verify(perfil,times(1)).getRecomendacionPreferida();
	}
}
