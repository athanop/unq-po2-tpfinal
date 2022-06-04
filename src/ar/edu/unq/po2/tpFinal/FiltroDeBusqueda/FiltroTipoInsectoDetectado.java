package ar.edu.unq.po2.tpFinal.FiltroDeBusqueda;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.tpFinal.Muestra;
import ar.edu.unq.po2.tpFinal.Enumerativos.Calificacion;

public class FiltroTipoInsectoDetectado implements IFiltroBusquedaMuestra {

	private Calificacion tipoInsecto;

	public FiltroTipoInsectoDetectado(Calificacion tipoInsecto) {
		this.tipoInsecto = tipoInsecto;
	}

	@Override
	public List<Muestra> buscarMuestras(List<Muestra> muestras) {
		List<Muestra> resultadoBusqueda = new ArrayList<Muestra>();
		for (Muestra m : muestras) {
			if (this.tipoInsecto.equals(m.getEspecieDeVinchuca())) {
				resultadoBusqueda.add(m);
			}
		}
		return resultadoBusqueda;
	}
}
