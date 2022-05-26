package ar.edu.unq.po2.tpFinal;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Muestra {

	private BufferedImage fotoVinchuca;
	// private Calificacion especieFotografiada;
	private List<Calificacion> listEspecieFotografiada = new ArrayList<Calificacion>();
	private Ubicacion ubicacion;
	private Usuario identificacionDeLaPersona;

	public Muestra(BufferedImage fotoVinchuca, Calificacion especieFotografiada, Ubicacion ubicacion,
			Usuario identificacionDeLaPersona) {
		this.fotoVinchuca = fotoVinchuca;
		// this.especieFotografiada = especieFotografiada;
		this.listEspecieFotografiada.add(especieFotografiada);
		this.ubicacion = ubicacion;
		this.identificacionDeLaPersona = identificacionDeLaPersona;
	}

	public BufferedImage getFotoVinchuca() {
		return this.fotoVinchuca;
	}

	/*
	 * public Calificacion getEspecieFotografiada() { return especieFotografiada; }
	 */

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public Usuario getIdentificacionDeLaPersona() {
		return identificacionDeLaPersona;
	}

	public void addCalificacion(Calificacion calificacionMuestra) {
		this.listEspecieFotografiada.add(calificacionMuestra);

	}

	public List<Calificacion> getListEspecieFotografiada() {
		return listEspecieFotografiada;
	}

	public Calificacion resultadoActual() {
		Calificacion resultadoActual = Calificacion.NO_DEFINIDO;

		if (this.hayMasDeUnVotoEnMuestra()) {
			resultadoActual = this.resultadoActualVotosPorOpinionEnMuestra();
			return resultadoActual;
		} else {
			return resultadoActual; // el resultado actual es no_definido por empate
		}
	}

	private Calificacion resultadoActualVotosPorOpinionEnMuestra() {
		Calificacion resultadoActual = this.listEspecieFotografiada.get(0);
		/*
		 * faltaria aplicar la logica de obtener la calificacion que más votos tiene
		 * y retornarla 
		 */
		return resultadoActual; // en caso de que sólo hay un voto para una calificacion, la retorna
	}

	private Boolean hayMasDeUnVotoEnMuestra() {
		return this.getListEspecieFotografiada().size() >= 1;
	}

}
