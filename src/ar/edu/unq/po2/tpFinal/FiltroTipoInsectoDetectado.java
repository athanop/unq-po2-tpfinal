package ar.edu.unq.po2.tpFinal;

import java.util.List;

public class FiltroTipoInsectoDetectado implements IFiltroBusquedaMuestra {

	private Calificacion tipoInsecto;

	public FiltroTipoInsectoDetectado(Calificacion tipoInsecto) {
		this.tipoInsecto = tipoInsecto;
	}

	@Override
	public List<Muestra> buscarMuestras(List<Muestra> muestras) {
		/*
		 * me falta filtrar por las opiniones
		 */
		return null;
	}

}
