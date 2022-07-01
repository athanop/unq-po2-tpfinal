package ar.edu.unq.po2.tpFinal.FiltroDeBusqueda;

import java.time.LocalDate;

import ar.edu.unq.po2.tpFinal.Muestra;

public class FiltroUltimaVotacion implements IFiltroBusquedaMuestra {

	private LocalDate fechaUltimaVotacion;

	public FiltroUltimaVotacion(LocalDate fecha) {
		this.fechaUltimaVotacion = fecha;
	}

	@Override
	public Boolean coincideCon(Muestra muestra) {
		return this.fechaUltimaVotacion.equals(muestra.getFechaUltimaVotacion());
	}
}
