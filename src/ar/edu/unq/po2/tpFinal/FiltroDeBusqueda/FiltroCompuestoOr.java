package ar.edu.unq.po2.tpFinal.FiltroDeBusqueda;

import java.util.List;

import ar.edu.unq.po2.tpFinal.Muestra;

public class FiltroCompuestoOr extends FiltroDeMuestraCompuesto {

	public FiltroCompuestoOr(IFiltroBusquedaMuestra filtro1, IFiltroBusquedaMuestra filtro2) {
		super(filtro1, filtro2);
	}

	@Override
	protected Boolean muestraEstaContenidaEnLosFiltros(List<Muestra> muestras, int i, List<Muestra> muestrasDeFiltro1,
			List<Muestra> muestrasDeFiltro2) {
		return muestrasDeFiltro1.contains(muestras.get(i)) || muestrasDeFiltro2.contains(muestras.get(i));
	}

}
