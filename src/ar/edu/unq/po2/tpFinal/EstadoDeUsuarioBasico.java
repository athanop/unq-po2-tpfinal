package ar.edu.unq.po2.tpFinal;

public class EstadoDeUsuarioBasico implements EstadoDeUsuario {

	@Override
	public void opinarSobreMuestra(Muestra muestra, Opinion opinion, Usuario usuario) throws Exception {
		muestra.agregarOpinion(opinion, usuario);
	}

	@Override
	public Boolean esUsuarioBasico() {
		return true;
	}

	@Override
	public Boolean esUsuarioExperto() {
		return false;
	}

	@Override
	public void actualizarCategoria(Usuario usuario) {
		if (usuario.cumpleConRevisionesNecesarias() & usuario.cumpleConEnviosNecesarios()) {
			usuario.setEstadoDeUsuario(new EstadoDeUsuarioExperto());
		}
	}

	@Override
	public void agregarOpinionAMuestraVotadaPorExperto(Usuario usuario, Muestra muestra, Opinion opinionAAgregar)
			throws Exception {
		throw new Exception("La muestra solo puede ser votada por usuarios expertos");
	}

}
