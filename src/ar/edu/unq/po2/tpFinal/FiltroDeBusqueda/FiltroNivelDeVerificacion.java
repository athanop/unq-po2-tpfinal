package ar.edu.unq.po2.tpFinal.FiltroDeBusqueda;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.tpFinal.Muestra;
import ar.edu.unq.po2.tpFinal.EstadoDeMuestra.EstadoDeMuestra;

public class FiltroNivelDeVerificacion implements IFiltroBusquedaMuestra {

	private String nivelVerificacion;

	public FiltroNivelDeVerificacion(String nivel) {
		this.nivelVerificacion = nivel;
	}

	@Override
	public List<Muestra> buscarMuestras(List<Muestra> muestras) {
		List<Muestra> resultadoBusqueda = new ArrayList<Muestra>();
		for (int i = 0; i < muestras.size(); i++) {
			EstadoDeMuestra estado = muestras.get(i).getEstadoMuestra();
			if (this.nivelVerificacion.equals(estado.getNivelDeVerificacion(muestras.get(i)))) {
				resultadoBusqueda.add(muestras.get(i));
			}
		}
		return resultadoBusqueda;
	}
}
