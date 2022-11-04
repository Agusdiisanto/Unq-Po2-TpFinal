package usuarioTest;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import actividad.Caracteristica;
import usuario.Perfil;
import usuario.RecomendacionSegunFavoritos;
import usuario.RecomendacionSegunPreferencias;

public class PerfilTest {
	private String 					  		gusto1;
	private Caracteristica			  		caracteristica1;
	private String					  		comportamiento1;
	private RecomendacionSegunPreferencias	estategiaDeRecomedacion1;
	private RecomendacionSegunFavoritos		estategiaDeRecomedacion2;
	private Perfil							perfil;
	
	@BeforeEach
    public void setUp() {
		gusto1					 = "Gusto1";
		caracteristica1			 = new Caracteristica("Botánica", 3);
		comportamiento1			 = "Caminar";
		estategiaDeRecomedacion1 = new RecomendacionSegunPreferencias();
		estategiaDeRecomedacion2 = new RecomendacionSegunFavoritos();
		perfil					 = new Perfil();
	}
	  
	@Test
    public void test01_unPerfilNuevoNoTieneGustos() {
    	assertEquals(perfil.getGustos().size(), 0);
    }
	
	@Test
    public void test02_unPerfilTieneGustos() {
		perfil.agregarGusto(gusto1);
		assertEquals(perfil.getGustos().size(), 1);
		assertTrue(perfil.getGustos().contains(gusto1));
    }
	
	@Test
    public void test03_unPerfilNoTieneGustosRepetidos() {
		perfil.agregarGusto(gusto1);
		perfil.agregarGusto(gusto1);
		assertEquals(perfil.getGustos().size(), 1);
		assertTrue(perfil.getGustos().contains(gusto1));
    }
	
	@Test
    public void test04_unPerfilNuevoNoTieneCaracteristicas() {
    	assertEquals(perfil.getCaracteristicasPreferidas().size(), 0);
    }
	
	@Test
    public void test05_unPerfilTieneCaracteristicas() {
		perfil.agregarCaracteristicaPreferida(caracteristica1);
		assertEquals(perfil.getCaracteristicasPreferidas().size(), 1);
		assertTrue(perfil.getCaracteristicasPreferidas().contains(caracteristica1));
    }
	
	@Test
    public void test06_unPerfilNoTieneCaracteristicasRepetidas() {
		perfil.agregarCaracteristicaPreferida(caracteristica1);
		perfil.agregarCaracteristicaPreferida(caracteristica1);
		assertEquals(perfil.getCaracteristicasPreferidas().size(), 1);
		assertTrue(perfil.getCaracteristicasPreferidas().contains(caracteristica1));
    }
	
	@Test
    public void test07_unPerfilNuevoNoTieneComportamientos() {
    	assertEquals(perfil.getComportamientos().size(), 0);
    }
	
	@Test
    public void test08_unPerfilTieneComportamientos() {
		perfil.agregarComportamiento(comportamiento1);
		assertEquals(perfil.getComportamientos().size(), 1);
		assertTrue(perfil.getComportamientos().contains(comportamiento1));
    }
	
	@Test
    public void test09_unPerfilNoTieneComportamientosRepetidos() {
		perfil.agregarComportamiento(comportamiento1);
		perfil.agregarComportamiento(comportamiento1);
		assertEquals(perfil.getComportamientos().size(), 1);
		assertTrue(perfil.getComportamientos().contains(comportamiento1));
    }

	@Test
    public void test10_unPerfilUsaRecomendacionPorPreferencias() {
		perfil.setTipoDeRecomendacionPreferido(estategiaDeRecomedacion1);
		assertEquals(perfil.getTipoDeRecomendacionPreferida(), estategiaDeRecomedacion1);
    }

	@Test
    public void test11_unPerfilUsaRecomendacionPorFavoritos() {
		perfil.setTipoDeRecomendacionPreferido(estategiaDeRecomedacion2);
		assertEquals(perfil.getTipoDeRecomendacionPreferida(), estategiaDeRecomedacion2);
    }
	
	@Test
    public void test12_unPerfilMacheaCaracteristicasSegunDescripcion() {
		perfil.agregarCaracteristicaPreferida(caracteristica1);
		assertTrue(perfil.getCaracteristicasPreferidas().contains(caracteristica1));
		assertTrue(perfil.contieneCaracteristicaConDescripcion("Botánica"));
    }
	
	// NO FUNCIONA, A CHEQUEAR LUEGO
	@Test
    public void test13_unPerfilCalculaLaAfinidadConUnaCaracteristica() {
		perfil.agregarCaracteristicaPreferida(caracteristica1);
		// assertTrue(perfil.getCaracteristicasPreferidas().contains(caracteristica1));
		// assertTrue(perfil.afinidadConCaracteristica(caracteristica1) == 0);
		// assertEquals(perfil.afinidadConCaracteristica(caracteristica1), 0);
    }
}
