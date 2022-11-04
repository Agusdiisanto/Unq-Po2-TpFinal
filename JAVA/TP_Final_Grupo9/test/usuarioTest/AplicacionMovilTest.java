package usuarioTest;import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import muestra.Muestra;
import proyectos.Proyecto;
import usuario.AplicacionMovil;
import usuario.Usuario;

public class AplicacionMovilTest {
		
	AplicacionMovil ap;
	Muestra muestra;
	Proyecto proyecto;
	Usuario usuario;

	
	
	@BeforeEach
	public void setUp() {
		muestra = mock(Muestra.class);
		proyecto = mock(Proyecto.class);
		ap = new AplicacionMovil();
		usuario = mock(Usuario.class);
	}
	
	@Test
	public void test01_UnaAplicacionCuandoSeCreaNoContieneMuestras() {
		assertTrue(ap.getMuestras().isEmpty());
	}
	
	@Test
	public void test02_UnaAplicacionPuedeAgregarMuestras() {
		
		ap.cargarMuestraEnAplicacion(muestra);
		
		assertTrue(ap.getMuestras().contains(muestra));
		assertFalse(ap.getMuestras().isEmpty());
	}
	
	@Test
	public void test03_UnaAplicacionPuedeRecolectarLaMuestraSiEsDeInteresParaElProyecto() throws Exception {
		
		when(proyecto.tieneRegistradoAlParticipante(usuario)).thenReturn(true); 
		when(proyecto.esMuestraDeInteres(muestra)).thenReturn(true);
		
		ap.recolectarMuestra(muestra,usuario,proyecto);
		
		assertTrue(ap.getMuestras().contains(muestra));
		assertFalse(ap.getMuestras().isEmpty());
	
	}

	@Test
	public void test04_UnaAplicacionNoPuedeRecolectarLaMuestraSiNoEsDeInteresParaElProyectoPeroSiEstaRegistrado() throws Exception {
		
		when(proyecto.tieneRegistradoAlParticipante(usuario)).thenReturn(true); 
		when(proyecto.esMuestraDeInteres(muestra)).thenReturn(false);
		
		ap.recolectarMuestra(muestra,usuario,proyecto);

		assertTrue(ap.getMuestras().isEmpty());
	}
	
	@Test
	public void test05_UnaAplicacionNoPuedeRecolectarLaMuestraSiEsDeInteresParaElProyectoPeroNoEstaRegistrado() throws Exception {
		
		when(proyecto.tieneRegistradoAlParticipante(usuario)).thenReturn(false); 
		when(proyecto.esMuestraDeInteres(muestra)).thenReturn(true);
		
		ap.recolectarMuestra(muestra,usuario,proyecto);

		assertTrue(ap.getMuestras().isEmpty());
	}
	
	@Test
	public void test06_UnaAplicacionNoPuedeRecolectarLaMuestraSiNoEsDeInteresParaElProyectoPeroNoEstaRegistrado() throws Exception {
		
		when(proyecto.tieneRegistradoAlParticipante(usuario)).thenReturn(false); 
		when(proyecto.esMuestraDeInteres(muestra)).thenReturn(false);
		
		ap.recolectarMuestra(muestra,usuario,proyecto);

		assertTrue(ap.getMuestras().isEmpty());
	}
	
}
