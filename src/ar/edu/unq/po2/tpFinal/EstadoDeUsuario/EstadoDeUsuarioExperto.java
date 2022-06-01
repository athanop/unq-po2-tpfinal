package ar.edu.unq.po2.tpFinal.EstadoDeUsuario;

import ar.edu.unq.po2.tpFinal.Muestra;
import ar.edu.unq.po2.tpFinal.Opinion;

public class EstadoDeUsuarioExperto implements EstadoDeUsuario {
	@Override
	public void opinarSobreMuestra(Muestra muestra, Opinion opinion, Usuario usuario) throws Exception {
		muestra.verificarMuestra();
		muestra.agregarLaOpinionDelUsuario(opinion, usuario);
	}

	@Override
	public Boolean esUsuarioBasico() {
		return false;
	}

	@Override
	public Boolean esUsuarioExperto() {
		return true;
	}

	@Override
	public void actualizarCategoria(Usuario usuario) {
		if (!usuario.cumpleConRevisionesNecesarias() | !usuario.cumpleConEnviosNecesarios()) {
			usuario.setEstadoDeUsuario(new EstadoDeUsuarioBasico());
		}
	}

	@Override
	public void agregarOpinionAMuestraVotadaPorExperto(Usuario usuario, Muestra muestra, Opinion opinion)
			throws Exception {
		muestra.agregarLaOpinionDelUsuario(opinion, usuario);
	}
}
