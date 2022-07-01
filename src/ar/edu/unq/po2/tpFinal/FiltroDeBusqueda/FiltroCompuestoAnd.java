package ar.edu.unq.po2.tpFinal.FiltroDeBusqueda;

import ar.edu.unq.po2.tpFinal.Muestra;

public class FiltroCompuestoAnd extends FiltroDeMuestraCompuesto {

	public FiltroCompuestoAnd(IFiltroBusquedaMuestra filtro1, IFiltroBusquedaMuestra filtro2) {
		super(filtro1, filtro2);
	}

	@Override
	public Boolean coincideCon(Muestra muestra) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Boolean condicionDeBusqueda(Muestra muestra, IFiltroBusquedaMuestra filtro1,
			IFiltroBusquedaMuestra filtro2) {

		return filtro1.coincideCon(muestra) && filtro2.coincideCon(muestra);
	}

}
