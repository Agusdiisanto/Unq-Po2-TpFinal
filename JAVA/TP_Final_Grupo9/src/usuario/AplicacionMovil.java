package usuario;

import java.util.ArrayList;
import java.util.List;

import ciencia.participativa.Proyecto;
import muestra.Muestra;

public class AplicacionMovil {
	private List<Muestra> muestras;

	public List<Muestra> getMuestras() {
		return muestras;
	}

	public AplicacionMovil() {
		this.muestras = new ArrayList<>();
	}
	
	// ===== DUDA ====
	// ¿Que sea un parametro la muestra o que sea new Muestra?
	
	public void recolectarMuestra(Muestra m,Proyecto p) {
				
		if (this.esMuestraDeInteresParaProyecto(m, p)) {
			this.getMuestras().add(m);
			
		}
	}
	
	public Boolean esMuestraDeInteresParaProyecto(Muestra m, Proyecto p) {
		return m.getCaracteristicas().stream().anyMatch(c -> p.getIntereses().contains(c));
	}
}
