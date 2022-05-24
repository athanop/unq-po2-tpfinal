package ar.edu.unq.po2.tpFinal;

import java.awt.image.BufferedImage;

public class Muestra {

	private BufferedImage fotoVinchuca;
	private Calificacion especieFotografiada;
	private Ubicacion ubicacion;
	private Usuario identificacionDeLaPersona;

	public Muestra(BufferedImage fotoVinchuca, Calificacion especieFotografiada, Ubicacion ubicacion,
			Usuario identificacionDeLaPersona) {
		this.fotoVinchuca = fotoVinchuca;
		this.especieFotografiada = especieFotografiada;
		this.ubicacion = ubicacion;
		this.identificacionDeLaPersona = identificacionDeLaPersona;
	}

	public BufferedImage getFotoVinchuca() {
		return this.fotoVinchuca;
	}

	public Calificacion getEspecieFotografiada() {
		return especieFotografiada;
	}

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public Usuario getIdentificacionDeLaPersona() {
		return identificacionDeLaPersona;
	}

}
