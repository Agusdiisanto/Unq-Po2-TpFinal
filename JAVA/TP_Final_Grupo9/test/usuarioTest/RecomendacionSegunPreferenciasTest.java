package usuarioTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import actividad.Desafio;
import usuario.AplicacionMovil;
import usuario.Perfil;
import usuario.RecomendacionSegunPreferencias;
import usuario.Usuario;

class RecomendacionSegunPreferenciasTest {
	private RecomendacionSegunPreferencias tipoDeRecomendacion;
	private Usuario						   usuario1;
	private ArrayList<Desafio>			   listaDeDesafios;
	private Desafio						   desafio1;
	private Desafio						   desafio2;
	private AplicacionMovil				   app1;
	private Perfil						   perfil1;
	
	@BeforeEach
	public void setUp() {
		tipoDeRecomendacion = new RecomendacionSegunPreferencias();
		usuario1			= new Usuario("Agus", app1, perfil1);
		listaDeDesafios		= new ArrayList<Desafio>();
		desafio1			= mock(Desafio.class);
		desafio2			= mock(Desafio.class);
		app1				= mock(AplicacionMovil.class);
		perfil1				= mock(Perfil.class);
		listaDeDesafios.add(desafio1);
		//desafios1.add(desafio2);
	}

	@Test
	void test01() {
		//assertTrue(tipoDeRecomendacion.recomendarDesafiosAlUsuario(usuario1, desafios1).contains(desafio1));
		//assertTrue(tipoDeRecomendacion.recomendarDesafiosAlUsuario(usuario1, desafios1).contains(desafio2));
		//assertEquals(tipoDeRecomendacion.recomendarDesafiosAlUsuario(usuario1, desafios1), desafio1);
		assertEquals(tipoDeRecomendacion.primerosN(listaDeDesafios, 2), listaDeDesafios);
	}

	@Test
	void test02() {
		assertTrue(tipoDeRecomendacion.desafiosRecomendadosPara(usuario1, listaDeDesafios).contains(desafio1));
		//assertTrue(tipoDeRecomendacion.recomendarDesafiosAlUsuario(usuario1, desafios1).contains(desafio2));
	}

	@Test
	void test03() {
		//listaDeDesafios.add(desafio2);
		assertTrue(tipoDeRecomendacion.ordenarDesafiosSegunCoincidenciaPara2(usuario1, listaDeDesafios).contains(desafio1));
		//assertTrue(tipoDeRecomendacion.ordenarDesafiosSegunCoincidenciaPara2(usuario1, listaDeDesafios).contains(desafio2));
		assertEquals(tipoDeRecomendacion.desafioConMayorCoincidenciaPara(usuario1, listaDeDesafios), desafio1);
	}
}
