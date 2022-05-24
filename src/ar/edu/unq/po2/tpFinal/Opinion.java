package ar.edu.unq.po2.tpFinal;

import java.time.LocalDate;

public class Opinion {

	private Calificacion calificacion;
	private LocalDate fechaDeEmision;
	private Usuario usuario;
	
	public Calificacion getCalificacion() {
		return calificacion;
	}

	public LocalDate getFechaDeEmision() {
		return fechaDeEmision;
	}
	
	public void setCalificacion(Calificacion calificacion) {
		this.calificacion = calificacion;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	
	public Opinion(Calificacion calificacion, LocalDate fechaDeEmision, Usuario usuario) {
		this.setCalificacion(calificacion);
		this.fechaDeEmision = fechaDeEmision;
		this.usuario = usuario;
	}


	


	
}
