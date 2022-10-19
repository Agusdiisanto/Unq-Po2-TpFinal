package ciencia.participativa;

import java.util.ArrayList;
import java.util.List;

public class AplicacionMovil {
	private List<Muestra> muestras;

	public List<Muestra> getMuestras() {
		return muestras;
	}

	public AplicacionMovil() {
		this.muestras = new ArrayList<>();
	}
	
	public void recolectarMuestra(Muestra m,Proyecto p) {
		if (this.esMuestraDeInteresParaProyecto(m, p)) {
			this.getMuestras().add(m);
		}
	}
	
	public Boolean esMuestraDeInteresParaProyecto(Muestra m, Proyecto p) {
		return m.getCaracteristicas().stream().anyMatch(c -> p.getIntereses().contains(c));
	}
}
