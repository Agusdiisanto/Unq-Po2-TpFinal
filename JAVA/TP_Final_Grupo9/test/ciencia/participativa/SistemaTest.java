package ciencia.participativa;

import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import usuario.Usuario;

public class SistemaTest {
	
	private Proyecto proyecto1;
	private Proyecto proyecto2;
	private Proyecto proyecto3;
	private Usuario usuario1;
	private Usuario usuario2;
	private Usuario usuario3;
	
	private Sistema system;
	
	
	@BeforeEach 
	public void setUp() {
		
		proyecto1 = mock(Proyecto.class);
		proyecto2 = mock(Proyecto.class);
		proyecto3 = mock(Proyecto.class);
		usuario1 = mock(Usuario.class);
		usuario2 = mock(Usuario.class);
		usuario3 = mock(Usuario.class);
		
		system = new Sistema();
	}
	
	@Test
	public void test01_sistema() {
		system.getProyectos().(proyecto1);
		
	}
	
	
	
	
}
