package ar.edu.unq.po2.tpFinal.FiltroDeBusqueda;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.tpFinal.Muestra;

public abstract class FiltroDeMuestraCompuesto implements IFiltroBusquedaMuestra {

	private List<IFiltroBusquedaMuestra> tiposDeFiltrosChildren;

	public FiltroDeMuestraCompuesto() {
		this.tiposDeFiltrosChildren = new ArrayList<IFiltroBusquedaMuestra>();

	}

	public void agregarFiltro(IFiltroBusquedaMuestra filtro) {
		this.tiposDeFiltrosChildren.add(filtro);
	}

	public abstract List<Muestra> buscarMuestras(List<Muestra> muestras);

	public List<IFiltroBusquedaMuestra> getTiposDeFiltrosChildren() {
		return tiposDeFiltrosChildren;
	}

}
