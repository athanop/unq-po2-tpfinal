package ar.edu.unq.po2.tpFinal;

public class EstadoDeMuestraVotada implements EstadoDeMuestra {

	@Override
	public String getNivelDeVerificacion(Muestra muestra) {
		return "votada";
	}

	@Override
	public void agregarOpinion(Muestra muestra, Opinion opinion, Usuario usuario) throws Exception {
		if (!muestra.contieneAlUsuario(usuario)) {
			muestra.agregarLaOpinionDelUsuario(opinion, usuario);
		} else {
			throw new Exception("El usuario ya ha opinado sobre la muestra");
		}
	}

	@Override
	public void actualizarEstado(Muestra muestra) throws Exception {
		muestra.getHistorialDeOpiniones().clear();
		muestra.setEstadoDeMuestra(new EstadoMuestraVotadaPorExperto());

	}
}
