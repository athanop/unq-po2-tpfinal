package ar.edu.unq.po2.tpFinal;

import java.util.function.BooleanSupplier;

public abstract class Usuario {

	private SistemaMuestra aplicacion;

	public Usuario(SistemaMuestra aplicacion) {
		this.aplicacion = aplicacion;
	}

	public SistemaMuestra getAplicacion() {
		return aplicacion;
	}

	public void opinar(Calificacion calificacionMuestra, Muestra muestra) {
		this.getAplicacion().calificar(calificacionMuestra, muestra);

	}

	public void enviarMuestra(Muestra muestra) {
		this.aplicacion.subir(muestra);
		
	}

	public Boolean subioMuestraAlSistema(Muestra muestra) {
		return this.aplicacion.tieneMuestra(muestra);
	}

}
