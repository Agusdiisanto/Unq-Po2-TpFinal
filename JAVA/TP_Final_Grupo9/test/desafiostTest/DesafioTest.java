package desafiostTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import caracteristicas.desafio.Area;
import caracteristicas.desafio.Caracteristica;
import caracteristicas.desafio.Dificultad;
import caracteristicas.desafio.RestriccionTemporal;
import desafios.Desafio;


public class DesafioTest {
		
	private Area area;
	private RestriccionTemporal restriccionTemporal;
	private Desafio desafio;
	private Caracteristica caracteristica1;
	private Caracteristica caracteristica2;
	private Caracteristica caracteristica3;
	private Set<Caracteristica> caracteristicas;
		
	@BeforeEach
	public void setUp() {
		
	 area = mock(Area.class);
	 restriccionTemporal = mock(RestriccionTemporal.class);
	 caracteristica1 = mock(Caracteristica.class);
	 caracteristica2 = mock(Caracteristica.class);
	 caracteristica3 = mock(Caracteristica.class);
	 
	 when(area.getLatitud()).thenReturn(6);
	 when(area.getLongitud()).thenReturn(2);
	 when(area.getRadio()).thenReturn(4);
	 when(restriccionTemporal.estaHabilitado(LocalDateTime.of(2018, 10, 30,5,56))).thenReturn(true);
	 when(caracteristica1.getDescripicion()).thenReturn("Agustin es mejor");
	 when(caracteristica1.getAfinidad()).thenReturn(9.9);
	 when(caracteristica2.getDescripicion()).thenReturn("Tomi es mejor");
	 when(caracteristica2.getAfinidad()).thenReturn(5.5);
	 when(caracteristica3.getDescripicion()).thenReturn("Santi es mejor");
	 when(caracteristica3.getAfinidad()).thenReturn(7.7);
	 desafio = new Desafio(area, restriccionTemporal, 30, Dificultad.MEDIO, 2359);
	}
	
	@Test
	public void test01_cuandoUnDesafioTieneUnaCantidadDeMuestras() {
		desafio = new Desafio(area, restriccionTemporal, 30, Dificultad.MEDIO, 2359);
		assertEquals(30, desafio.getCantidadDeMuestrasARecolectar());
	}
	
	
	
}
