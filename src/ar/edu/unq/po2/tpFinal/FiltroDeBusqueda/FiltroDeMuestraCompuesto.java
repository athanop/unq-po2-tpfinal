package ar.edu.unq.po2.tpFinal.FiltroDeBusqueda;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.tpFinal.Muestra;

public class FiltroDeMuestraCompuesto implements IFiltroBusquedaMuestra {

	private List<IFiltroBusquedaMuestra> tiposDeFiltrosChildren;

	public FiltroDeMuestraCompuesto() {
		this.tiposDeFiltrosChildren = new ArrayList<IFiltroBusquedaMuestra>();
	}

	@Override
	public List<Muestra> buscarMuestras(List<Muestra> muestras) {
		List<Muestra> resultadoBusqueda = new ArrayList<Muestra>();
		for (int i = 0; i < this.tiposDeFiltrosChildren.size(); i++) {
			resultadoBusqueda.addAll(this.tiposDeFiltrosChildren.get(i).buscarMuestras(muestras));
		}
		return resultadoBusqueda;
	}

}
