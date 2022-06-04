package ar.edu.unq.po2.tpFinal.FiltroDeBusqueda;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.tpFinal.Muestra;

public abstract class FiltroDeMuestraCompuesto implements IFiltroBusquedaMuestra {

	private List<IFiltroBusquedaMuestra> tiposDeFiltrosChildren;

	public FiltroDeMuestraCompuesto(IFiltroBusquedaMuestra filtro1, IFiltroBusquedaMuestra filtro2) {
		this.tiposDeFiltrosChildren = new ArrayList<IFiltroBusquedaMuestra>();
		this.addFiltro(filtro1);
		this.addFiltro(filtro2);
	}

	public List<IFiltroBusquedaMuestra> getTiposDeFiltrosChildren() {
		return tiposDeFiltrosChildren;
	}

	public void addFiltro(IFiltroBusquedaMuestra filtro) {
		this.getTiposDeFiltrosChildren().add(filtro);
	}

	// el template
	public final List<Muestra> buscarMuestras(List<Muestra> muestras) {
		List<Muestra> resultadoBusquedaCompuesta = new ArrayList<Muestra>();

		for (int i = 0; i < muestras.size(); i++) {
			List<Muestra> muestrasDeFiltro1 = this.getTiposDeFiltrosChildren().get(0).buscarMuestras(muestras);
			List<Muestra> muestrasDeFiltro2 = this.getTiposDeFiltrosChildren().get(1).buscarMuestras(muestras);
			if (muestraEstaContenidaEnLosFiltros(muestras, i, muestrasDeFiltro1, muestrasDeFiltro2)) {
				resultadoBusquedaCompuesta.add(muestras.get(i));
			}
		}
		return resultadoBusquedaCompuesta;
	}

	protected abstract Boolean muestraEstaContenidaEnLosFiltros(List<Muestra> muestras, int i,
			List<Muestra> muestrasDeFiltro1, List<Muestra> muestrasDeFiltro2);

}
