package usuario;

import java.util.ArrayList;

import actividad.Caracteristica;
import actividad.Desafio;

/**
 * 
 * Esta clase abstracta se encarga de modelar una estrategia de recomendación.
 *
 */

public abstract class EstrategiaDeRecomendacion { 

	public abstract ArrayList<Desafio> recomendarDesafiosAlUsuario(Usuario usuario,ArrayList<Desafio> desafios);

	public ArrayList<Desafio> primerosN(ArrayList<Desafio> desafios, int cantidadRequerida) {
		ArrayList<Desafio> primerosDesafios = new ArrayList<Desafio>();
		for (int i=0; i < min(cantidadRequerida,desafios.size()); i++) {
			primerosDesafios.add(desafios.get(i));
		}
		return primerosDesafios;
	}
	
	public ArrayList<Desafio> desafiosRecomendadosPara(Usuario usuario, ArrayList<Desafio> desafiosARecomendar) {
		ArrayList<Desafio> desafios = new ArrayList<Desafio>();
		desafios.addAll(desafiosARecomendar);
		return this.ordenarDesafiosSegunCoincidenciaPara(usuario, desafios);
	}
	
	// ================== PRIVATE =====================
	public ArrayList<Desafio> ordenarDesafiosSegunCoincidenciaPara(Usuario usuario, ArrayList<Desafio> desafios) {
		ArrayList<Desafio> desafiosOrdenados = new ArrayList<Desafio>();
		ArrayList<Desafio> desafiosAOrdenar  = desafios;
		while (desafiosOrdenados.size() < desafiosAOrdenar.size()) {
			desafiosOrdenados.add(this.desafioConMayorCoincidenciaPara(usuario, desafiosAOrdenar));
		}
		return desafiosOrdenados;
	}

	public Desafio desafioConMayorCoincidenciaPara(Usuario usuario, ArrayList<Desafio> desafios) {
		ArrayList<Desafio> desafiosARecorrer = new ArrayList<Desafio>(desafios);
		Desafio current = desafiosARecorrer.get(0);
		desafiosARecorrer.remove(0);
		for (Desafio desafio : desafiosARecorrer) {
			current = desafioConMayorCoincidenciaEntre(current, desafio, usuario);
		}
		return current;
	}

	private Desafio desafioConMayorCoincidenciaEntre(Desafio desafio1 ,Desafio desafio2, Usuario usuario) {
		return coincidenciaConUsuario(desafio1,usuario) <= coincidenciaConUsuario(desafio2,usuario) ? desafio1 : desafio2;
	}

	private double coincidenciaConUsuario(Desafio desafio, Usuario usuario) {
		double indiceDeCoincidencia = 0;
		for (Caracteristica caracteristica : desafio.getCaracteristicas()) {
			indiceDeCoincidencia += usuario.afinidadConCaracteristica(caracteristica);
		}
		return indiceDeCoincidencia;
	}

	private int min(int i, int j) {
		return i<j ? i : j;
	}
}
