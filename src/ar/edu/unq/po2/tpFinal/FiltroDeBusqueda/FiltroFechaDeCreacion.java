package ar.edu.unq.po2.tpFinal.FiltroDeBusqueda;

import java.time.LocalDate;

import ar.edu.unq.po2.tpFinal.Muestra;

public class FiltroFechaDeCreacion implements IFiltroBusquedaMuestra {

	private LocalDate fechaCreacion;

	public FiltroFechaDeCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	@Override
	public Boolean coincideCon(Muestra muestra) {
		return this.fechaCreacion.equals(muestra.getFechaDeCreacion());
	}

}
