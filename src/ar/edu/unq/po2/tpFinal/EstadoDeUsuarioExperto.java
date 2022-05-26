package ar.edu.unq.po2.tpFinal;

public class EstadoDeUsuarioExperto implements EstadoDeUsuario {
	@Override
	public void opinarSobreMuestra(Muestra muestra, Opinion opinion, Usuario usuario) throws Exception {
		muestra.verificarMuestra();
		muestra.agregarOpinion(opinion, usuario);
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
