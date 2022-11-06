package usuarioTest;

import static org.junit.jupiter.api.Assertions.*;

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
	private ArrayList<Desafio>			   desafios1;
	private Desafio						   desafio1;
	private Desafio						   desafio2;
	private AplicacionMovil				   app1;
	private Perfil						   perfil1;
	
	@BeforeEach
	public void setUp() {
		tipoDeRecomendacion = new RecomendacionSegunPreferencias();
		usuario1			= new Usuario("Agus", app1, perfil1);
		desafios1			= new ArrayList<Desafio>();
		desafio1			= new Desafio(null, null, 5, null, 0);
		desafio2			= new Desafio(null, null, 5, null, 0);
		app1				= new AplicacionMovil();
		perfil1				= new Perfil();
		desafios1.add(desafio1);
		//desafios1.add(desafio2);
	}

	@Test
	void test01() {
		//assertTrue(tipoDeRecomendacion.recomendarDesafiosAlUsuario(usuario1, desafios1).contains(desafio1));
		//assertTrue(tipoDeRecomendacion.recomendarDesafiosAlUsuario(usuario1, desafios1).contains(desafio2));
		//assertEquals(tipoDeRecomendacion.recomendarDesafiosAlUsuario(usuario1, desafios1), desafio1);
		assertEquals(tipoDeRecomendacion.primerosN(desafios1, 2), desafios1);
	}

	@Test
	void test02() {
		assertTrue(tipoDeRecomendacion.desafiosRecomendadosPara(usuario1, desafios1).contains(desafio1));
		//assertTrue(tipoDeRecomendacion.recomendarDesafiosAlUsuario(usuario1, desafios1).contains(desafio2));
	}

	@Test
	void test03() {
		desafios1.add(desafio2);
		assertTrue(tipoDeRecomendacion.ordenarDesafiosSegunCoincidenciaPara2(usuario1, desafios1).contains(desafio2));
		assertEquals(tipoDeRecomendacion.desafioConMayorCoincidenciaPara(usuario1, desafios1), desafio1);
	}

}
