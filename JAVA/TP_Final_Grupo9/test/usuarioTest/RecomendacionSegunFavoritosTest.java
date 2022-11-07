package usuarioTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import actividad.Desafio;
import usuario.RecomendacionSegunFavoritos;
import usuario.Usuario;

class RecomendacionSegunFavoritosTest {
	private RecomendacionSegunFavoritos tipoDeRecomendacion;
	private Usuario						usuario1;
	private ArrayList<Desafio>			listaDeDesafios;
	private Desafio						desafio1;
	private Desafio						desafio2;
	
	@BeforeEach
	public void setUp() {
		tipoDeRecomendacion = new RecomendacionSegunFavoritos();
		usuario1			= mock(Usuario.class);
		listaDeDesafios		= new ArrayList<Desafio>(); 
		desafio1			= mock(Desafio.class);
		desafio2			= mock(Desafio.class);
		listaDeDesafios.add(desafio1);
		listaDeDesafios.add(desafio2);
	}

	@Test
	void test04_unaEstrategiaRecomiendaDesafiosAUnUsuario() {
		assertTrue(tipoDeRecomendacion.recomendarDesafiosAlUsuario(usuario1, listaDeDesafios).contains(desafio1));
	}
}
