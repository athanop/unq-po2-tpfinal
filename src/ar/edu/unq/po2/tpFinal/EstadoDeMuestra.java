package ar.edu.unq.po2.tpFinal;

public interface EstadoDeMuestra {

	abstract void agregarOpinion(Muestra muestra, Opinion opinion, Usuario usuario) throws Exception;

	abstract String getNivelDeVerificacion(Muestra muestra);

	abstract void actualizarEstado(Muestra muestra) throws Exception;
}
