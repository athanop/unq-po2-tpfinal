package ar.edu.unq.po2.tpFinal.FiltroDeBusqueda;

import ar.edu.unq.po2.tpFinal.Muestra;
import ar.edu.unq.po2.tpFinal.Enumerativos.Calificacion;

public class FiltroTipoInsectoDetectado implements IFiltroBusquedaMuestra {

	private Calificacion tipoInsecto;

	public FiltroTipoInsectoDetectado(Calificacion tipoInsecto) {
		this.tipoInsecto = tipoInsecto;
	}

	public Boolean coincideCon(Muestra muestra) {
		return this.tipoInsecto.equals(muestra.getEspecieDeVinchuca());
	}

}
