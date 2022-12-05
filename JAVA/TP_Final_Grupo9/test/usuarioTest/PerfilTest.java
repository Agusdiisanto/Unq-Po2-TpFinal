package usuarioTest;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
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
		perfil.addGusto("Futbol");
		assertEquals(perfil.getGustos().size(), 1);
		assertTrue(perfil.getGustos().contains("Futbol"));
    }
	
	@Test
    public void test03_unPerfilNoTieneGustosRepetidos() {
		perfil.addGusto("Futbol");
		perfil.addGusto("Futbol");
		assertEquals(perfil.getGustos().size(), 1);
		assertTrue(perfil.getGustos().contains("Futbol"));
    }
	
	@Test
    public void test04_unPerfilNuevoNoTieneCaracteristicas() {
    	assertEquals(perfil.getCaracteristicas().size(), 0);
    }
	
	@Test
    public void test05_unPerfilTieneCaracteristicas() {
		perfil.addCaracteristica(caracteristica1);
		assertEquals(perfil.getCaracteristicas().size(), 1);
		assertTrue(perfil.getCaracteristicas().contains(caracteristica1));
    }
	
	@Test
    public void test06_unPerfilNoTieneCaracteristicasRepetidas() {
		perfil.addCaracteristica(caracteristica1);
		perfil.addCaracteristica(caracteristica1);
		assertEquals(perfil.getCaracteristicas().size(), 1);
		assertTrue(perfil.getCaracteristicas().contains(caracteristica1));
    }
	
	@Test
    public void test07_unPerfilNuevoNoTieneComportamientos() {
    	assertEquals(perfil.getComportamientos().size(), 0);
    }
	
	@Test
    public void test08_unPerfilTieneComportamientos() {
		perfil.addComportamiento("Caminar");
		assertEquals(perfil.getComportamientos().size(), 1);
		assertTrue(perfil.getComportamientos().contains("Caminar"));
    }
	
	@Test
    public void test09_unPerfilNoTieneComportamientosRepetidos() {
		perfil.addComportamiento("Caminar");
		perfil.addComportamiento("Caminar");
		assertEquals(perfil.getComportamientos().size(), 1);
		assertTrue(perfil.getComportamientos().contains("Caminar"));
    }

	@Test
    public void test10_unPerfilUsaRecomendacionPorPreferencias() {
		perfil.setRecomendacionPreferida(estategiaDeRecomedacion1);
		assertEquals(perfil.getRecomendacionPreferida(), estategiaDeRecomedacion1);
    }

	@Test
    public void test11_unPerfilUsaRecomendacionPorFavoritos() {
		perfil.setRecomendacionPreferida(estategiaDeRecomedacion2);
		assertEquals(perfil.getRecomendacionPreferida(), estategiaDeRecomedacion2);
    }
	
	@Test
    public void test12_unPerfilMacheaCaracteristicasSegunDescripcion() {
		when(caracteristica1.getDescripicion()).thenReturn("Botánica");
		when(caracteristica1.getAfinidad()).thenReturn(0.5);
		when(caracteristica1.tieneDescripcion(caracteristica1.getDescripicion())).thenReturn(true);
		
		perfil.addCaracteristica(caracteristica1);
		
		assertTrue(perfil.getCaracteristicas().contains(caracteristica1));
		assertTrue(perfil.includesCaracteristicaConDescripcion("Botánica"));
		
		verify(caracteristica1, times(1)).getDescripicion();
		verify(caracteristica1, times(0)).getAfinidad();
		verify(caracteristica1, times(1)).tieneDescripcion(caracteristica1.getDescripicion());
    }
	
	@Test
    public void test13_unPerfilCalculaLaAfinidadConUnaCaracteristicaSiEstaEnLaDescripcion() {
		when(caracteristica1.getDescripicion()).thenReturn("c1");
		when(caracteristica1.getAfinidad()).thenReturn(5.0);
		when(caracteristica2.getDescripicion()).thenReturn("c2");
		when(caracteristica2.getAfinidad()).thenReturn(7.0);
		
		perfil.addCaracteristica(caracteristica1);
		perfil.addCaracteristica(caracteristica2);
		
		assertEquals(perfil.afinidadConCaracteristica(caracteristica1), 0);
		
		verify(caracteristica1, times(1)).getDescripicion();
		verify(caracteristica2, times(0)).getDescripicion();
		verify(caracteristica1, times(0)).getAfinidad();
		verify(caracteristica2, times(0)).getAfinidad();
    }
	
	@Test
    public void test14_unPerfilCalculaLaAfinidadConUnaCaracteristicaSiNoEstaEnLaDescripcion() {
		when(caracteristica1.getDescripicion()).thenReturn("s1");
		when(caracteristica1.getAfinidad()).thenReturn(5.0);
		when(caracteristica2.getDescripicion()).thenReturn("s2");
		when(caracteristica2.getAfinidad()).thenReturn(7.0);
		when(caracteristica3.getDescripicion()).thenReturn("s1");
		when(caracteristica3.getAfinidad()).thenReturn(3.0);
		when(caracteristica2.tieneDescripcion(caracteristica3.getDescripicion())).thenReturn(false);
		when(caracteristica1.tieneDescripcion(caracteristica3.getDescripicion())).thenReturn(true);
		
		perfil.addCaracteristica(caracteristica1);
		perfil.addCaracteristica(caracteristica2);
		
		assertEquals(perfil.afinidadConCaracteristica(caracteristica3), 2.0);
		
		verify(caracteristica1, times(1)).getDescripicion();
		verify(caracteristica2, times(1)).getDescripicion();
		verify(caracteristica3, times(4)).getDescripicion();
		verify(caracteristica1, times(1)).getAfinidad();
		verify(caracteristica2, times(0)).getAfinidad();
		verify(caracteristica3, times(1)).getAfinidad();
    }
}
