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
		
	AplicacionMovil app;
	Muestra muestra;
	Proyecto proyecto;
	Usuario usuario;

	
	
	@BeforeEach
	public void setUp() {
		muestra = mock(Muestra.class);
		proyecto = mock(Proyecto.class);
		app = new AplicacionMovil();
		usuario = mock(Usuario.class);
	}
	
	@Test
	public void test01_UnaAplicacionCuandoSeCreaNoContieneMuestras() {
		assertTrue(app.getMuestras().isEmpty());
	}
	
	@Test
	public void test02_UnaAplicacionPuedeAgregarMuestras() {
		
		app.cargarMuestraEnAplicacion(muestra);
		
		assertTrue(app.getMuestras().contains(muestra));
		assertFalse(app.getMuestras().isEmpty());
	}
	
	@Test
	public void test03_UnaAplicacionPuedeRecolectarLaMuestraSiEsDeInteresParaElProyecto() throws Exception {
		
		when(proyecto.tieneRegistradoAlParticipante(usuario)).thenReturn(true); 
		when(proyecto.esMuestraDeInteres(muestra)).thenReturn(true);
		
		app.recolectarMuestra(muestra,usuario,proyecto);
		
		assertTrue(app.getMuestras().contains(muestra));
		assertFalse(app.getMuestras().isEmpty());
	
	}

	@Test
	public void test04_UnaAplicacionNoPuedeRecolectarLaMuestraSiNoEsDeInteresParaElProyectoPeroSiEstaRegistrado() throws Exception {
		
		when(proyecto.tieneRegistradoAlParticipante(usuario)).thenReturn(true); 
		when(proyecto.esMuestraDeInteres(muestra)).thenReturn(false);
		
		app.recolectarMuestra(muestra,usuario,proyecto);

		assertTrue(app.getMuestras().isEmpty());
	}
	
	@Test
	public void test05_UnaAplicacionNoPuedeRecolectarLaMuestraSiEsDeInteresParaElProyectoPeroNoEstaRegistrado() throws Exception {
		
		when(proyecto.tieneRegistradoAlParticipante(usuario)).thenReturn(false); 
		when(proyecto.esMuestraDeInteres(muestra)).thenReturn(true);
		
		app.recolectarMuestra(muestra,usuario,proyecto);

		assertTrue(app.getMuestras().isEmpty());
	}
	
	@Test
	public void test06_UnaAplicacionNoPuedeRecolectarLaMuestraSiNoEsDeInteresParaElProyectoPeroNoEstaRegistrado() throws Exception {
		
		when(proyecto.tieneRegistradoAlParticipante(usuario)).thenReturn(false); 
		when(proyecto.esMuestraDeInteres(muestra)).thenReturn(false);
		
		app.recolectarMuestra(muestra,usuario,proyecto);

		assertTrue(app.getMuestras().isEmpty());
	}
	
}
