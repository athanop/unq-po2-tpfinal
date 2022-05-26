package ar.edu.unq.po2.tpFinal;

public class EstadoMuestraVotadaPorExperto implements EstadoDeMuestra {

	@Override
	public void agregarOpinion(Muestra muestra, Opinion opinion, Usuario usuario) throws Exception {
		if (!muestra.contieneAlUsuario(usuario)) {
			usuario.agregarOpinionAMuestraVotadaPorExperto(muestra, opinion);
		} else {
			throw new Exception("El usuario ya ha opinado sobre la muestra");
		}
	}

	@Override
	public String getNivelDeVerificacion(Muestra muestra) {
		return "votada";
	}

	@Override
	public void actualizarEstado(Muestra muestra) {
		if (muestra.coincidenDosExpertosEnSuOpinion()) {
			muestra.setEstadoDeMuestra(new EstadoDeMuestraVerificada());
			muestra.avisarVerificacionAZonasDeCobertura();
		}

	}

}
