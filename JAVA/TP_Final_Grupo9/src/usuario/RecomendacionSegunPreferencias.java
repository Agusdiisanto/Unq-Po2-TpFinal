package usuario;

import java.util.ArrayList;

import actividad.Desafio;

public class RecomendacionSegunPreferencias extends EstrategiaDeRecomendacion {

	@Override
	public ArrayList<Desafio> recomendarDesafiosAlUsuario(Usuario user, ArrayList<Desafio> desafios) {
		return this.primerosN(desafiosRecomendadosPara(user,desafios),cantidadASeleccionar());
	}
  
	private int cantidadASeleccionar() {
		return 5;
	}
}
