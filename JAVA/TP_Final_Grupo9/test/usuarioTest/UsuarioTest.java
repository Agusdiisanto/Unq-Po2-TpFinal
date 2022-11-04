package usuarioTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import caracteristicas.desafio.Caracteristica;
import caracteristicas.desafio.Dificultad;
import caracteristicas.desafio.DificultadTest;
import desafios.Desafio;
import estadoDeUsuario.ProgresoDesafio;
import muestra.Muestra;
import proyectos.Proyecto;
import usuario.AplicacionMovil;
import usuario.Estadisticas;
import usuario.Perfil;
import usuario.RecomendacionSegunPreferencias;
import usuario.Usuario;

public class UsuarioTest {
	
	private Usuario usuario;
	private AplicacionMovil appMovil;
	private Perfil perfil;
	private ProgresoDesafio progreso;
	private Desafio desafio;
	private Proyecto proyecto;
	private Muestra muestra;
	private Desafio desafio2;
	private Caracteristica caracteristica;
	private RecomendacionSegunPreferencias estrategia;
	
	@BeforeEach
	public void setUp() {
		proyecto = mock(Proyecto.class);
		appMovil = mock(AplicacionMovil.class);
		perfil = mock(Perfil.class);
		progreso = mock(ProgresoDesafio.class);
		desafio = mock(Desafio.class);
		muestra = mock(Muestra.class);
		desafio2 = mock(Desafio.class);
		caracteristica = mock(Caracteristica.class);
		estrategia = mock(RecomendacionSegunPreferencias.class);
		
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

		usuario.solicitarSuscripcionAProyecto(proyecto);
		verify(proyecto,times(1)).agregarParticipante(usuario);
	} 
	
	@Test
	public void test12_UnUsuarioPuedeRecolectarMuestras() throws Exception {
		usuario.agregarNuevoProyectoEnCurso(proyecto);
		usuario.recolectarMuestra(muestra);
		verify(appMovil,times(1)).recolectarMuestra(muestra, usuario, proyecto);

	}
	
	@Test
	public void test13_UnUsuarioPuedeRecolectarMuestrasParaDesafios() throws Exception {
		
		usuario.agregarNuevoProgresoDeDesafio(progreso);
		usuario.recolectarMuestraParaLosDesafios(muestra);
		
		verify(progreso,times(1)).recolectarMuestra(usuario, muestra);
	}
	
	@Test
	public void test14_UnUsuarioPuedeRecolectarMuestrasParaProyecto() throws Exception {
		
		usuario.agregarNuevoProyectoEnCurso(proyecto);
		usuario.recolectarMuestraParaLosProyectos(muestra);
		
		verify(appMovil,times(1)).recolectarMuestra(muestra, usuario, proyecto);
	}
	
	@Test
	public void test15_UnUsuarioTieneUnDesafioFavorito(){
		
		usuario.registrarDesafioCompletado(desafio2,2,5,5);
		usuario.registrarDesafioCompletado(desafio,3,2,2);
		
	    assertEquals(usuario.getDesafioFavorito(), desafio2);
	    assertEquals(usuario.getDesafiosCompletados().size(), 2);
	}
	
	@Test
	public void test16_UnUsuarioTieneAfinidadConCaracteristica() {
	
		when(perfil.afinidadConCaracteristica(caracteristica)).thenReturn(2.3);
		assertEquals(usuario.afinidadConCaracteristica(caracteristica), 2.3);
		verify(perfil,times(1)).afinidadConCaracteristica(caracteristica);
	}
	
	@Test
	public void test17_UnUsuarioNoTieneAfinidadConCaracteristica() {
	
		when(perfil.afinidadConCaracteristica(caracteristica)).thenReturn(0.0);
		assertEquals(usuario.afinidadConCaracteristica(caracteristica), 0.0);
		verify(perfil,times(1)).afinidadConCaracteristica(caracteristica);
	}
	
	@Test
	public void test18_UnUsuarioContieneCaracteristicaConDescripcion() {
		
		when(perfil.contieneCaracteristicaConDescripcion("s")).thenReturn(true);
		assertTrue(usuario.contieneCaracteristicaConDescripcion("s"));
		verify(perfil,only()).contieneCaracteristicaConDescripcion("s");
	}
	
	@Test
	public void test19_UnUsuarioNoContieneCaracteristicaConDescripcion() {
		
		when(perfil.contieneCaracteristicaConDescripcion("s")).thenReturn(false);
		assertFalse(usuario.contieneCaracteristicaConDescripcion("s"));
		verify(perfil,times(1)).contieneCaracteristicaConDescripcion("s");
	}
	
	@Test
	public void test20_UnUsuarioSabeLaSimilitudEntreUnDesafioYSuFavorito() {
		
		usuario.registrarDesafioCompletado(desafio2,2,5,5);
	
		when(desafio.getCantidadDeMuestrasARecolectar()).thenReturn(30);
		when(desafio.getDificultad()).thenReturn(Dificultad.MUY_FACIL);
		when(desafio.getRecompensa()).thenReturn(3000);
	
		when(desafio2.getCantidadDeMuestrasARecolectar()).thenReturn(10);
		when(desafio2.getDificultad()).thenReturn(Dificultad.MUY_DIFICIL);
		when(desafio2.getRecompensa()).thenReturn(1000);
		
		
		assertEquals(usuario.getDesafioFavorito(), desafio2);
		assertEquals(usuario.similitudConFavorito(desafio),676.0);
	}
	
	@Test
	public void test21_UnUsuarioSabeLaEstrategiaARecomendar() {
		
		when(perfil.getTipoDeRecomendacionPreferida()).thenReturn(estrategia);
		
		assertEquals(usuario.getEstrategia(), estrategia);
		verify(perfil,times(1)).getTipoDeRecomendacionPreferida();
		
	}
	
	
	
}
