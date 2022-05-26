package ar.edu.unq.po2.tpFinal;

import java.time.LocalDate;

public class Opinion {

	private Calificacion calificacion;
	private LocalDate fechaDeEmision;

	public String getCalificacion() {
		return calificacion.toString();
	}

	public LocalDate getFechaDeEmision() {
		return fechaDeEmision;
	}

	public Opinion(Calificacion calificacion) {
		fechaDeEmision = LocalDate.now();
		this.calificacion = calificacion;

	}

	public void setCalificacion(Calificacion calificacionDeOpinion) {
		this.calificacion = calificacionDeOpinion;
		
	}

}
