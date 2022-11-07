package usuario;

import java.util.ArrayList;

import actividad.Desafio;

/**
 * 
 * Esta clase se encarga de modelar una recomendación según los favoritos de un usuario.
 *
 */

public class RecomendacionSegunFavoritos extends EstrategiaDeRecomendacion {
	
	// ======================== METHODS =========================
	@Override 
	public ArrayList<Desafio> recomendarDesafiosAlUsuario(Usuario user, ArrayList<Desafio> desafios) {
		ArrayList<Desafio> desafiosAOrdenar = this.primerosN(desafiosRecomendadosPara(user,desafios),cantidadASeleccionar());
		ArrayList<Desafio> desafiosOrdenados = new ArrayList<Desafio>();
		while (!desafiosAOrdenar.isEmpty()) {
			desafiosOrdenados.add(desafioConMayorSimilitudPara(desafiosAOrdenar, user));
		}
		return desafiosOrdenados;
	}
	
	// ==================== PRIVATE METHODS =====================
	private Desafio desafioConMayorSimilitudPara(ArrayList<Desafio> desafios, Usuario user) {
		Desafio current = desafios.get(0);
		desafios.remove(0);
		for (Desafio desafio : desafios) {
			current = desafioConMayorSimilitudEntre(current, desafio, user);
		}
		return current;
	}

	private Desafio desafioConMayorSimilitudEntre(Desafio desafio1, Desafio desafio2, Usuario usuario) {
		return usuario.similitudConFavorito(desafio1) > usuario.similitudConFavorito(desafio2) ? desafio1 : desafio2;
	}

	private int cantidadASeleccionar() {
		return 20;
	}
}
