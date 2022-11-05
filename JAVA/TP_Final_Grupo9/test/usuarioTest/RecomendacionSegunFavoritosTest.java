package usuarioTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import actividad.Desafio;
import usuario.AplicacionMovil;
import usuario.Perfil;
import usuario.RecomendacionSegunFavoritos;
import usuario.Usuario;

class RecomendacionSegunFavoritosTest {
	private RecomendacionSegunFavoritos tipoDeRecomendacion;
	private Usuario						usuario1;
	private ArrayList<Desafio>			desafios1;
	private Desafio						desafio1;
	private Desafio						desafio2;
	private AplicacionMovil				app1;
	private Perfil						perfil1;
	
	@BeforeEach
	public void setUp() {
		tipoDeRecomendacion = new RecomendacionSegunFavoritos();
		usuario1			= new Usuario("Agus", app1, perfil1);
		desafios1			= new ArrayList<Desafio>(); 
		desafio1			= new Desafio(null, null, 5, null, 0);
		desafio2			= new Desafio(null, null, 5, null, 0);
		app1				= new AplicacionMovil();
		perfil1				= new Perfil();
		desafios1.add(desafio1);
		desafios1.add(desafio2);
	} 

	@Test
	public void test01_unaEstrategiaRecomiendaDesafiosAUnUsuario() {
		//assertEquals(tipoDeRecomendacion.recomendarDesafiosAlUsuario(usuario1, desafios1), desafios1);
	}
}
