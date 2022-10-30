package ciencia.participativa;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import caracteristicas.desafio.Caracteristica;
import desafios.ActividadLudica;
import muestra.Coordenada;
import muestra.Muestra;
import usuario.IParticipante;
import usuario.Usuario;

public class ProyectoTest {
	
	private Muestra muestra1;
	private Muestra muestra2;
	private Muestra muestra3;
	private IParticipante participante1;
	private IParticipante participante2;
	private IParticipante participante3;
	private ActividadLudica actividad1;
	private ActividadLudica actividad2;
	private ActividadLudica actividad3;
	private Muestra         muestra4;
	private Coordenada      coordenada1;
	private LocalDateTime   fecha1;
	private Usuario         usuario1;
	private LocalDateTime   fecha2;
	
	private Proyecto proyecto;
	private Caracteristica caracteristica1;
	
	@BeforeEach
	public void setUp() {
		fecha2 = LocalDateTime.now();
		muestra1 = new Muestra(usuario1, fecha2 , coordenada1);
		muestra2 = mock(Muestra.class);
		muestra3 = mock(Muestra.class);
		usuario1 = mock(Usuario.class); 
		fecha1 = LocalDateTime.now();
		coordenada1= mock(Coordenada.class);
		participante1 = mock(IParticipante.class);
		participante2 = mock(IParticipante.class);
		participante3 = mock(IParticipante.class);
		muestra4= new Muestra(usuario1,fecha1 , coordenada1);
		actividad1 = mock(ActividadLudica.class);
		actividad2 = mock(ActividadLudica.class);
		actividad3 = mock(ActividadLudica.class);
		proyecto = new Proyecto("ProyectoNueve","GrupoNueve");
		this.caracteristica1 = new Caracteristica("Carateristica1", 1);
		proyecto.agregarInteres(caracteristica1);
		
	}
	
//	Hay que testear por el caso verdadero y el caso falso.

	
	@Test
	public void test01_unProyectoTieneMuestras() {
		muestra1.agregarCaracteristicaAMuestra(caracteristica1);
		proyecto.agregarMuestra(muestra1);
	    assertTrue(muestra1.tieneLaCaracteristica(caracteristica1.getDescripicion()));
	    assertEquals(proyecto.cantidadDeMuestras(), 1);
	}
	
	@Test 
	public void test02() {
		muestra4.agregarCaracteristicaAMuestra(caracteristica1);
		proyecto.agregarMuestra(muestra4);
		assertEquals(proyecto.getMuestrasRecolectadas().size(), 1);
		assertTrue(muestra4.tieneLaCaracteristica(caracteristica1.getDescripicion()));
		assertTrue(proyecto.getMuestrasRecolectadas().contains(muestra4));
	
	}
}
