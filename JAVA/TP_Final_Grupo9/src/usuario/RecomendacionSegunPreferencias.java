package usuario;

import java.util.ArrayList;

import actividad.Desafio;

/**
 * 
 * 
 * Esta clase se encarga de modelar una recomendación según las preferencias de un usuario.
 *
 */

public class RecomendacionSegunPreferencias extends EstrategiaDeRecomendacion {

	@Override
	public ArrayList<Desafio> recomendarDesafiosAlUsuario(Usuario user, ArrayList<Desafio> desafios) {
		return this.primerosN(desafiosRecomendadosPara(user,desafios),cantidadASeleccionar());
	}
  
	private int cantidadASeleccionar() {
		return 5;
	}
}
