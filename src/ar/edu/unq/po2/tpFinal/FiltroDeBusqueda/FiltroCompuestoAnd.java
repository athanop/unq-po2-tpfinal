package ar.edu.unq.po2.tpFinal.FiltroDeBusqueda;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.tpFinal.Muestra;

public class FiltroCompuestoAnd extends FiltroDeMuestraCompuesto {

	public List<Muestra> buscarMuestras(List<Muestra> muestras) {
		List<Muestra> resultadosMuestras = new ArrayList<Muestra>();
		resultadosMuestras.addAll(super.getTiposDeFiltrosChildren().get(0).buscarMuestras(muestras));
		for (IFiltroBusquedaMuestra filtro : super.getTiposDeFiltrosChildren()) {
			List<Muestra> muestrasFiltradas = filtro.buscarMuestras(muestras);
			resultadosMuestras.retainAll(muestrasFiltradas);

		}
		return resultadosMuestras;
	}

}
