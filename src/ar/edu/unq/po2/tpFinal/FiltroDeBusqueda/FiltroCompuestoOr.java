package ar.edu.unq.po2.tpFinal.FiltroDeBusqueda;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.tpFinal.Muestra;

public class FiltroCompuestoOr extends FiltroDeMuestraCompuesto {

	@Override
	public List<Muestra> buscarMuestras(List<Muestra> muestras) {
		List<Muestra> resultadosMuestras = new ArrayList<Muestra>();
		for (IFiltroBusquedaMuestra filtro : super.getTiposDeFiltrosChildren()) {
			List<Muestra> muestrasFiltradas = filtro.buscarMuestras(muestras);
			resultadosMuestras.addAll(muestrasFiltradas);

		}
		return resultadosMuestras;
	}

}
