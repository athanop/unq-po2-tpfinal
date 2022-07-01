package ar.edu.unq.po2.tpFinal.FiltroDeBusqueda;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.tpFinal.Muestra;

public class FiltroUltimaVotacion implements IFiltroBusquedaMuestra {

	private LocalDate fechaUltimaVotacion;

	public FiltroUltimaVotacion(LocalDate fecha) {
		this.fechaUltimaVotacion = fecha;
	}

	@Override
	public List<Muestra> buscarMuestras(List<Muestra> muestras) {
		List<Muestra> resultadoBusqueda = new ArrayList<Muestra>();
		for (int i = 0; i < muestras.size(); i++) {
			if (this.fechaUltimaVotacion.equals(muestras.get(i).getFechaUltimaVotacion())) {
				resultadoBusqueda.add(muestras.get(i));
			}
		}
		return resultadoBusqueda;
	}
}
