package usuario;

import java.util.ArrayList;

import desafios.Desafio;

public class RecomendacionSegunFavoritos extends EstrategiaDeRecomendacion {

	@Override 
	public ArrayList<Desafio> recomendarDesafiosAlUsuario(Usuario user, ArrayList<Desafio> desafios) {
		ArrayList<Desafio> desafiosAOrdenar = this.quedarseConLosPrimeros(desafiosRecomendadosPara(user,desafios),cantidadDeDesafiosASeleccionar());
		ArrayList<Desafio> desafiosOrdenados = new ArrayList<Desafio>();
		while (!desafiosAOrdenar.isEmpty()) {
			desafiosOrdenados.add(desafioConMayorSimilitudPara(desafiosAOrdenar, user));
			desafiosAOrdenar.remove(desafioConMayorSimilitudPara(desafiosAOrdenar, user));
		}
		return desafiosOrdenados;
	}

	private Desafio desafioConMayorSimilitudPara(ArrayList<Desafio> desafios, Usuario user) {
		Desafio current = desafios.get(0);
		desafios.remove(0);
		for (Desafio desafio : desafios) {
			current = desafioConMayorSimilitudEntre(current, desafio, user);
		}
		return current;
	}

	private Desafio desafioConMayorSimilitudEntre(Desafio d1, Desafio d2, Usuario user) {
		return user.similitudConFavorito(d1) > user.similitudConFavorito(d2) ? d1 : d2;
	}

	private int cantidadDeDesafiosASeleccionar() {
		return 20;
	}

} 
