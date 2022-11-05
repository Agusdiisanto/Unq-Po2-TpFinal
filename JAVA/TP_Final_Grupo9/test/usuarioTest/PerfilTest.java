package usuarioTest;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import actividad.Caracteristica;
import usuario.Perfil;
import usuario.RecomendacionSegunFavoritos;
import usuario.RecomendacionSegunPreferencias;

public class PerfilTest {
	
	private Caracteristica			  		caracteristica1;
	private RecomendacionSegunPreferencias	estategiaDeRecomedacion1;
	private RecomendacionSegunFavoritos		estategiaDeRecomedacion2;
	private Perfil							perfil;
	private Caracteristica caracteristica2;
	
	@BeforeEach
    public void setUp() {
		
		caracteristica1			 = mock(Caracteristica.class);
		caracteristica2          = mock(Caracteristica.class);
		estategiaDeRecomedacion1 = mock(RecomendacionSegunPreferencias.class);
		estategiaDeRecomedacion2 = mock(RecomendacionSegunFavoritos.class);
		perfil					 = new Perfil();
	}
	  
	@Test
    public void test01_unPerfilNuevoNoTieneGustos() {
    	assertEquals(perfil.getGustos().size(), 0);
    }
	
	@Test
    public void test02_unPerfilTieneGustos() {
		perfil.agregarGusto("Futbol");
		assertEquals(perfil.getGustos().size(), 1);
		assertTrue(perfil.getGustos().contains("Futbol"));
    }
	
	@Test
    public void test03_unPerfilNoTieneGustosRepetidos() {
		perfil.agregarGusto("Futbol");
		perfil.agregarGusto("Futbol");
		assertEquals(perfil.getGustos().size(), 1);
		assertTrue(perfil.getGustos().contains("Futbol"));
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
		perfil.agregarComportamiento("Caminar");
		assertEquals(perfil.getComportamientos().size(), 1);
		assertTrue(perfil.getComportamientos().contains("Caminar"));
    }
	
	@Test
    public void test09_unPerfilNoTieneComportamientosRepetidos() {
		perfil.agregarComportamiento("Caminar");
		perfil.agregarComportamiento("Caminar");
		assertEquals(perfil.getComportamientos().size(), 1);
		assertTrue(perfil.getComportamientos().contains("Caminar"));
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
		
		when(caracteristica1.getDescripicion()).thenReturn("Botánica");
		when(caracteristica1.getAfinidad()).thenReturn(0.5);
		
		perfil.agregarCaracteristicaPreferida(caracteristica1);
		assertTrue(perfil.getCaracteristicasPreferidas().contains(caracteristica1));
		assertTrue(perfil.contieneCaracteristicaConDescripcion("Botánica"));
    }
	
	
	@Test
    public void test13_unPerfilCalculaLaAfinidadConUnaCaracteristica() {
		
		caracteristica1 = new Caracteristica("c1", 5);
		caracteristica2 = new Caracteristica("c2", 7);
		/*
		when(caracteristica1.getDescripicion()).thenReturn("Caminar");
		when(caracteristica1.getAfinidad()).thenReturn(0.5);
		
		when(caracteristica2.getDescripicion()).thenReturn("Caminar");
		when(caracteristica2.getAfinidad()).thenReturn(100.5);
		*/
		perfil.agregarCaracteristicaPreferida(caracteristica1);
		perfil.agregarCaracteristicaPreferida(caracteristica2);
		
		assertEquals(perfil.afinidadConCaracteristica(caracteristica1), 0);	
    }
	
	
	/*
	 * 
	 *  ESTOS MENSAJES FALTAN 
				public double afinidadConCaracteristica(Caracteristica caracteristica) {
					return Math.abs(this.getCaracteristicaSegunDescripcion(caracteristica).getAfinidad() - caracteristica.getAfinidad());
				}
			 
				private Caracteristica getCaracteristicaSegunDescripcion(Caracteristica caracteristica) {
					return (Caracteristica) this.getCaracteristicasPreferidas().stream().
							filter(c -> c.getDescripicion().equals(caracteristica.getDescripicion()));
				}
	*/
	
	
}
