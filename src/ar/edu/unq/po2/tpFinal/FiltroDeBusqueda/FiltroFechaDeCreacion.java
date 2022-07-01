package ar.edu.unq.po2.tpFinal.FiltroDeBusqueda;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.tpFinal.Muestra;

public class FiltroFechaDeCreacion implements IFiltroBusquedaMuestra {

	private LocalDate fechaCreacion;

	public FiltroFechaDeCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public List<Muestra> buscarMuestras(List<Muestra> muestras) {
		List<Muestra> resultadoBusqueda = new ArrayList<Muestra>();
		for (int i = 0; i < muestras.size(); i++) {
			if (this.fechaCreacion.equals(muestras.get(i).getFechaDeCreacion())) {
				resultadoBusqueda.add(muestras.get(i));
			}
		}
		return resultadoBusqueda;
	}

}
