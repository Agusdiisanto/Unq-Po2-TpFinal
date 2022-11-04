package usuario;

import java.util.ArrayList;

import actividad.Caracteristica;
import actividad.Desafio;

public abstract class EstrategiaDeRecomendacion { 

	public abstract ArrayList<Desafio> recomendarDesafiosAlUsuario(Usuario usuario,ArrayList<Desafio> desafios);

	public ArrayList<Desafio> quedarseConLosPrimeros(ArrayList<Desafio> desafios, int cantidadRequerida) {
		ArrayList<Desafio> primerosDesafios = new ArrayList<Desafio>();
		for (int i=0; i < min(cantidadRequerida,desafios.size()); i++) {
			primerosDesafios.add(desafios.get(i));
		}
		return primerosDesafios;
	}
	
	public ArrayList<Desafio> desafiosRecomendadosPara(Usuario usuario, ArrayList<Desafio> desafiosARecomendar) {
		ArrayList<Desafio> desafios = new ArrayList<Desafio>();
		desafios.addAll(desafiosARecomendar);
		return this.ordenarDesafiosSegunCoincidenciaPara(desafios, usuario);
	}
	
	// ================== PRIVATE =====================
	private ArrayList<Desafio> ordenarDesafiosSegunCoincidenciaPara(ArrayList<Desafio> desafios, Usuario usuario) {
		ArrayList<Desafio> desafiosOrdenados = new ArrayList<Desafio>();
		while (!desafios.isEmpty()) {
			desafiosOrdenados.add(this.desafioConMayorCoincidenciaPara(desafios, usuario));
			desafios.remove(this.desafioConMayorCoincidenciaPara(desafios, usuario));
		}
		return desafiosOrdenados;
	}

	private Desafio desafioConMayorCoincidenciaPara(ArrayList<Desafio> desafios, Usuario u) {
		Desafio current = desafios.get(0);
		desafios.remove(0);
		for (Desafio desafio : desafios) {
			current = desafioConMayorCoincidenciaEntre(current, desafio, u);
		}
		return current;
	}

	private Desafio desafioConMayorCoincidenciaEntre(Desafio desafio1 ,Desafio desafio2, Usuario usuario) {
		return coincidenciaConUsuario(desafio1,usuario) < coincidenciaConUsuario(desafio2,usuario) ? desafio1 : desafio2;
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
