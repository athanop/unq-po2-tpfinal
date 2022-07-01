package ar.edu.unq.po2.tpFinal.FiltroDeBusqueda;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.tpFinal.Muestra;

public abstract class FiltroDeMuestraCompuesto implements IFiltroBusquedaMuestra {

	private List<IFiltroBusquedaMuestra> tiposDeFiltrosChildren;

	// un filtro compuesto siempre recibe 2 tipos d filtro para filtrar muestras
	public FiltroDeMuestraCompuesto(IFiltroBusquedaMuestra filtro1, IFiltroBusquedaMuestra filtro2) {
		this.tiposDeFiltrosChildren = new ArrayList<IFiltroBusquedaMuestra>();
		this.tiposDeFiltrosChildren.add(filtro1);
		this.tiposDeFiltrosChildren.add(filtro2);
	}

	public List<IFiltroBusquedaMuestra> getTiposDeFiltrosChildren() {
		return tiposDeFiltrosChildren;
	}

	public List<Muestra> buscarMuestras(List<Muestra> muestras) {
		IFiltroBusquedaMuestra filtro1 = this.getTiposDeFiltrosChildren().get(0);
		IFiltroBusquedaMuestra filtro2 = this.getTiposDeFiltrosChildren().get(1);

		List<Muestra> muestrasDeFiltro = this.buscarMuestrasQueCoincidaCon(muestras, filtro1, filtro2);

		return muestrasDeFiltro;
	}

	public final List<Muestra> buscarMuestrasQueCoincidaCon(List<Muestra> muestras, IFiltroBusquedaMuestra filtro1,
			IFiltroBusquedaMuestra filtro2) {

		List<Muestra> resultadoMuestras = new ArrayList<Muestra>();
		for (int i = 0; i < muestras.size(); i++) {
			if (condicionDeBusqueda(muestras.get(i), filtro1, filtro2)) {
				resultadoMuestras.add(muestras.get(i));
			}
		}
		return resultadoMuestras;
	}

	protected abstract Boolean condicionDeBusqueda(Muestra muestra, IFiltroBusquedaMuestra filtro1,
			IFiltroBusquedaMuestra filtro2);

}
