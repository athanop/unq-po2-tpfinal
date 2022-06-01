package ar.edu.unq.po2.tpFinal.EstadoDeMuestra;

import ar.edu.unq.po2.tpFinal.Muestra;
import ar.edu.unq.po2.tpFinal.Opinion;
import ar.edu.unq.po2.tpFinal.EstadoDeUsuario.Usuario;

public interface EstadoDeMuestra {

	abstract void agregarOpinion(Muestra muestra, Opinion opinion, Usuario usuario) throws Exception;

	abstract String getNivelDeVerificacion(Muestra muestra);

	abstract void actualizarEstado(Muestra muestra) throws Exception;
}
