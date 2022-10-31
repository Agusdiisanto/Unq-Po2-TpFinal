package muestraTest;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;

import caracteristicas.desafio.Caracteristica;
import muestra.Coordenada;
import usuario.AplicacionMovil;
import usuario.Perfil;
import usuario.Usuario;

public class MuestraTest {

	private Usuario usuario1;
	private LocalDateTime fechaYHoraDeRecoleccion1;
	private Coordenada coordenadaDeRecoleccion;
	private Perfil  perfil1;
	private Caracteristica caracteristica1;
	private AplicacionMovil aplicacion1;
	
	
    @BeforeEach
    void setUp() {
    	perfil1= new Perfil();
    	aplicacion1 = new AplicacionMovil();
    	caracteristica1 = new Caracteristica("Carateristica1", 1);
    	perfil1.agregarGusto("Gusto1");
    	perfil1.agregarCaracteristicaPreferida(caracteristica1);
    	perfil1.agregarComportamiento("Comportamiento1");
    	
  
    	usuario1= new Usuario("Tomas", aplicacion1, perfil1, recomendacionPreferida1)
    	
    }
	
}


