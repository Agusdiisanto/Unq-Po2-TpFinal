package usuario;

import java.util.ArrayList;

import caracteristicas.desafio.Caracteristica;
import desafios.Desafio;

public abstract class EstrategiaDeRecomendacion { 

	public abstract ArrayList<Desafio> recomendarDesafiosAlUsuario(Usuario user,ArrayList<Desafio> desafios);

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
	private ArrayList<Desafio> ordenarDesafiosSegunCoincidenciaPara(ArrayList<Desafio> desafios, Usuario u) {
		ArrayList<Desafio> desafiosOrdenados = new ArrayList<Desafio>();
		while (!desafios.isEmpty()) {
			desafiosOrdenados.add(this.desafioConMayorCoincidenciaPara(desafios, u));
			desafios.remove(this.desafioConMayorCoincidenciaPara(desafios, u));
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

	private Desafio desafioConMayorCoincidenciaEntre(Desafio d1 ,Desafio d2, Usuario user) {
		return coincidenciaConUsuario(d1,user) < coincidenciaConUsuario(d2,user) ? d1 : d2;
	}

	private double coincidenciaConUsuario(Desafio d1, Usuario user) {
		double indiceDeCoincidencia = 0;
		for (Caracteristica caracteristica : d1.getCaracteristicas()) {
			indiceDeCoincidencia += user.afinidadConCaracteristica(caracteristica);
		}
		return indiceDeCoincidencia;
	}

	private int min(int i, int j) {
		return i < j ? i : j;
	}
}
