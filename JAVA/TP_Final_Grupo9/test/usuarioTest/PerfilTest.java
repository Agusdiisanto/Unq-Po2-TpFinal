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
	private Caracteristica					caracteristica2,caracteristica3;
	
	@BeforeEach
    public void setUp() {
		caracteristica1			 = mock(Caracteristica.class);
		caracteristica2          = mock(Caracteristica.class);
		caracteristica3          = mock(Caracteristica.class);
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
		when(caracteristica1.include(caracteristica1.getDescripicion())).thenReturn(true);
		
		perfil.agregarCaracteristicaPreferida(caracteristica1);
		assertTrue(perfil.getCaracteristicasPreferidas().contains(caracteristica1));
		assertTrue(perfil.contieneCaracteristicaConDescripcion("Botánica"));
    }
	
	
	@Test
    public void test13_unPerfilCalculaLaAfinidadConUnaCaracteristicaSiEstaEnLaDescripcion() {
			
		when(caracteristica1.getDescripicion()).thenReturn("c1");
		when(caracteristica1.getAfinidad()).thenReturn(5.0);
		
		when(caracteristica2.getDescripicion()).thenReturn("c2");
		when(caracteristica2.getAfinidad()).thenReturn(7.0);
		
		perfil.agregarCaracteristicaPreferida(caracteristica1);
		perfil.agregarCaracteristicaPreferida(caracteristica2);
		assertEquals(perfil.afinidadConCaracteristica(caracteristica1), 0);
		
    }
	
	@Test
    public void test14_unPerfilCalculaLaAfinidadConUnaCaracteristicaSiNoEstaEnLaDescripcion() {
		
		when(caracteristica1.getDescripicion()).thenReturn("s1");
		when(caracteristica1.getAfinidad()).thenReturn(5.0);
		when(caracteristica2.getDescripicion()).thenReturn("s2");
		when(caracteristica2.getAfinidad()).thenReturn(7.0);
		when(caracteristica3.getDescripicion()).thenReturn("sert");
		when(caracteristica3.getAfinidad()).thenReturn(3.0);
		when(caracteristica2.include(caracteristica3.getDescripicion())).thenReturn(true);
		when(caracteristica1.include(caracteristica3.getDescripicion())).thenReturn(true);
		
		perfil.agregarCaracteristicaPreferida(caracteristica1);
		perfil.agregarCaracteristicaPreferida(caracteristica2);
		perfil.agregarCaracteristicaPreferida(caracteristica3); 
		
		assertEquals(perfil.afinidadConCaracteristica(caracteristica3), 0);
		
		// Faltan verify y este es el caso positivo pero da 0 porque se restan mutuamente cambiar eso
		// post hay que ver el if de la condicion caso positivo y caso negativo
		
    }
	
}
