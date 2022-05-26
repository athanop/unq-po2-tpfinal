package ar.edu.unq.po2.tpFinal;

public interface EstadoDeUsuario {

	public abstract void opinarSobreMuestra(Muestra muestra, Opinion opinion, Usuario usuario) throws Exception;

	public abstract Boolean esUsuarioBasico();

	public abstract Boolean esUsuarioExperto();

	public abstract void actualizarCategoria(Usuario usuario);

	public abstract void agregarOpinionAMuestraVotadaPorExperto(Usuario usuario, Muestra muestra,
			Opinion opinionAAgregar) throws Exception;
}
