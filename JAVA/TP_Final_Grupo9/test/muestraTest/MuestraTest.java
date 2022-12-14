package muestraTest;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import actividad.Caracteristica;

import org.junit.jupiter.api.BeforeEach;

import muestra.Coordenada;
import muestra.Muestra;
import usuario.Perfil;
import usuario.Usuario;

public class MuestraTest {
	private Muestra 		muestra1;
	private Usuario 		usuario1;
	private LocalDateTime 	fechaYHoraDeRecoleccion1;
	private Coordenada 		coordenadaDeRecoleccion;
	private Perfil  		perfil1;
	private Caracteristica  caracteristica1;
	
    @BeforeEach
    public void setUp() {
    	perfil1		= new Perfil();
    	usuario1	= mock(Usuario.class);
    	fechaYHoraDeRecoleccion1 = LocalDateTime.now(); 
    	coordenadaDeRecoleccion  = mock(Coordenada.class);
    	muestra1				 = new Muestra(usuario1, fechaYHoraDeRecoleccion1, coordenadaDeRecoleccion);
    	caracteristica1			 = mock(Caracteristica.class);
    	perfil1.addGusto("Gusto1");
    	perfil1.addCaracteristica(caracteristica1);
    	perfil1.addComportamiento("Comportamiento1");
    	when(coordenadaDeRecoleccion.getX()).thenReturn(1.0);
    	when(coordenadaDeRecoleccion.getY()).thenReturn(2.0);
    }
    
    @Test
    public void test01CuandoUnaMuestraSeCreaTieneUnUsuarioQueLaRecolecta() {
    	assertEquals(muestra1.getUsuarioQueLaRecolecto(), usuario1);
    }
    
    @Test
    public void test02CuandoUnaMuestraSeCreaNoTieneCaracteristicas() {
    	assertEquals(muestra1.cantidadDeCaracteristicas(), 0);
    }
    
    @Test
    public void test03CuandoAUnaMuestraSeLeAgregaUnaCaracteristicaLaMismaEstaEnElSet() {
    	muestra1.addCaracteristica(caracteristica1);
    	assertEquals(muestra1.cantidadDeCaracteristicas(), 1);
    	assertTrue(muestra1.includes(caracteristica1));
    }
    
    @Test 
    public void test04CuandoUnaMuestraSeCreaTieneUnaCoordenadaYUnaHoraDeRecoleccion() {
    	assertEquals(muestra1.getCoordenada().getX(),1);
    	assertEquals(muestra1.getCoordenada().getY(), 2);
    	assertEquals(muestra1.getFechaYHoraDeRecoleccion().getDayOfYear(), LocalDateTime.now().getDayOfYear());
    	assertEquals(muestra1.getFechaYHoraDeRecoleccion().getHour(), LocalDateTime.now().getHour());
    }
}

