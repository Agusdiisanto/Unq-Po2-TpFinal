package ciencia.participativa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import desafios.ActividadLudica;
import muestra.Muestra;
import usuario.IParticipante;

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
	
	private Proyecto proyecto;
	
	@BeforeEach
	public void setUp() {
		
		muestra1 = mock(Muestra.class);
		muestra2 = mock(Muestra.class);
		muestra3 = mock(Muestra.class);
		participante1 = mock(IParticipante.class);
		participante2 = mock(IParticipante.class);
		participante3 = mock(IParticipante.class);
		actividad1 = mock(ActividadLudica.class);
		actividad2 = mock(ActividadLudica.class);
		actividad3 = mock(ActividadLudica.class);
		proyecto = new Proyecto("ProyectoNueve","GrupoNueve");
		
	}
	
	@Test
	public void test01_unProyectoTieneVariosParticipantes() {
		proyecto.agregarMuestra(muestra1);
		proyecto.agregarMuestra(muestra2);
		proyecto.agregarMuestra(muestra3);
		
	    assertEquals(3, proyecto.cantidadDeMuestras());
	}
	
	
	
	
}
