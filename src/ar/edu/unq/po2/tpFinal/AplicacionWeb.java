package ar.edu.unq.po2.tpFinal;

import java.util.ArrayList;
import java.util.List;

public class AplicacionWeb {

	public void registrarMuestra(Muestra muestra) {

	}

	private List<Muestra> muestras = new ArrayList<Muestra>();

	// public void calificar(Calificacion calificacionMuestra, Muestra muestra) {
	// muestra.addCalificacion(calificacionMuestra);

	// }

	public List<Muestra> getMuestras() {
		return muestras;
	}

	public void subir(Muestra muestra) {
		this.muestras.add(muestra);

	}

	public Boolean tieneMuestra(Muestra muestra) {
		return this.muestras.contains(muestra);
	}

}
