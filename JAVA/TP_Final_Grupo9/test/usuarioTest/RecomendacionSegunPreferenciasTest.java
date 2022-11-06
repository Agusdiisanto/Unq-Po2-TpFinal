package usuarioTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import actividad.Caracteristica;
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
	private Caracteristica				   caracteristica1;
	private Caracteristica				   caracteristica2;
	private HashSet<Caracteristica>			   caracteristicas;
	private AplicacionMovil				   app1;
	private Perfil						   perfil1;
	
	@BeforeEach
	public void setUp() {
		tipoDeRecomendacion = new RecomendacionSegunPreferencias();
		//usuario1			= new Usuario("Agus", app1, perfil1);
		usuario1			= mock(Usuario.class);
		listaDeDesafios		= new ArrayList<Desafio>();
		desafio1			= mock(Desafio.class);
		desafio2			= mock(Desafio.class);
		caracteristica1		= mock(Caracteristica.class);
		caracteristica2		= mock(Caracteristica.class);
		app1				= mock(AplicacionMovil.class);
		perfil1				= mock(Perfil.class);
		caracteristicas		= new HashSet<Caracteristica>();
		caracteristicas.add(caracteristica1);
		caracteristicas.add(caracteristica2);
		listaDeDesafios.add(desafio1);
		listaDeDesafios.add(desafio2);
	}

	@Test
	void test01_unaEstrategiaSeQuedaConLosPrimerosDosDesafios() {
		assertEquals(tipoDeRecomendacion.primerosN(listaDeDesafios, 2), listaDeDesafios);
	}

	@Test
	void test02_unaEstrategiaRecomiendaDesafiosAUnUsuario() {
		assertTrue(tipoDeRecomendacion.desafiosRecomendadosPara(usuario1, listaDeDesafios).contains(desafio1));
		//assertTrue(tipoDeRecomendacion.recomendarDesafiosAlUsuario(usuario1, desafios1).contains(desafio2));
	}

	@Test
	void test03_unaEstrategiaOrdenaLosDesafiosParaUnUsuario() {
		when(desafio1.getCaracteristicas()).thenReturn(caracteristicas);
		when(desafio2.getCaracteristicas()).thenReturn(caracteristicas);
		assertTrue(tipoDeRecomendacion.ordenarDesafiosSegunCoincidenciaPara(usuario1, listaDeDesafios).contains(desafio1));
		//assertTrue(tipoDeRecomendacion.ordenarDesafiosSegunCoincidenciaPara(usuario1, listaDeDesafios).contains(desafio2));
	}

	@Test
	void test04_unaEstrategiaRecomiendaDesafiosAUnUsuario() {
		assertTrue(tipoDeRecomendacion.recomendarDesafiosAlUsuario(usuario1, listaDeDesafios).contains(desafio1));
		//assertTrue(tipoDeRecomendacion.recomendarDesafiosAlUsuario(usuario1, desafios1).contains(desafio2));
	}
}
