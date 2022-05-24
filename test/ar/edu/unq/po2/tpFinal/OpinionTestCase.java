package ar.edu.unq.po2.tpFinal;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OpinionTestCase {

	Opinion opinion;
	Calificacion calificacionDeOpinion;
	
	@BeforeEach
	void setUp() throws Exception {
		calificacionDeOpinion = Calificacion.CHINCHE_FOLIADA;
		opinion = new Opinion(calificacionDeOpinion, LocalDate.now());
	}

	@Test
	void testOpinionConCalificaciónDeChincheFoliada() {
		assertEquals(opinion.getCalificacion(), calificacionDeOpinion);
	}

	@Test
	void testOpinionConCalificaciónImagenPocoClara() {
		calificacionDeOpinion = Calificacion.IMAGEN_POCO_CLARA;
		opinion.setCalificacion(calificacionDeOpinion);
		assertEquals(opinion.getCalificacion(), calificacionDeOpinion);
	}
	
	@Test
	void testFechaDeEmisionDeLaOpinion() {
		LocalDate fechaEmision = LocalDate.now();
		assertEquals(opinion.getFechaDeEmision(), fechaEmision);
	}
}
