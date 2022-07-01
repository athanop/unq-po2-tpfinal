package ar.edu.unq.po2.tpFinal.FiltroDeBusqueda;

import ar.edu.unq.po2.tpFinal.Muestra;

public class FiltroNivelDeVerificacion implements IFiltroBusquedaMuestra {

	private String nivelVerificacion;

	public FiltroNivelDeVerificacion(String nivel) {
		this.nivelVerificacion = nivel;
	}

	@Override
	public Boolean coincideCon(Muestra muestra) {
		return this.nivelVerificacion.equals(muestra.getNivelDeVerificacion());
	}
}
