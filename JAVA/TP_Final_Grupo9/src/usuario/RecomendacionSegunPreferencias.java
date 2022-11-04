package usuario;

import java.util.ArrayList;

import desafios.Desafio;

public class RecomendacionSegunPreferencias extends EstrategiaDeRecomendacion {

	@Override 
	public ArrayList<Desafio> recomendarDesafiosAlUsuario(Usuario user, ArrayList<Desafio> desafios) {
		return this.quedarseConLosPrimeros(desafiosRecomendadosPara(user,desafios),cantidadDeDesafiosASeleccionar());
	}
 
	private int cantidadDeDesafiosASeleccionar() {
		return 5;
	}
}
