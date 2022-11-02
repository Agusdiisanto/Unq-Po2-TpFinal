package estadoDeUsuario;

import muestra.Muestra;
import usuario.IParticipante;

public class EstadoDeProgreso implements IEstadoDelProgreso {

	@Override
	public boolean esDesafioEnCurso(ProgresoDesafio progresoDesafio) { return false;}

	@Override
	public void recolectarMuestra(ProgresoDesafio progresoDesafio, Muestra muestra) throws Exception {}

	@Override
	public void concederRecompensaDelDesafioA(IParticipante participante, ProgresoDesafio progresoDesafio) {}
	
	@Override
	public boolean completoElDesafio(ProgresoDesafio progresoDesafio) {return false;}

	@Override
	public void verificarSiCompletoElDesafio(ProgresoDesafio progreso) {}
}
