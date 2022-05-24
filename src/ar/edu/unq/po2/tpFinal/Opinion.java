package ar.edu.unq.po2.tpFinal;

import java.time.LocalDate;

public class Opinion {

	private Calificacion calificacion;
	private LocalDate fechaDeEmision;
	
	public Calificacion getCalificacion() {
		return calificacion;
	}


	public LocalDate getFechaDeEmision() {
		return fechaDeEmision;
	}
	
	public void setCalificacion(Calificacion calificacion) {
		this.calificacion = calificacion;
	}
	
	public Opinion(Calificacion calificacion, LocalDate fechaDeEmision) {
		this.setCalificacion(calificacion);
		this.fechaDeEmision = fechaDeEmision;
	}


	
}
