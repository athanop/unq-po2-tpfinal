package ar.edu.unq.po2.tpFinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class OpinionTestCase {

	Opinion opinion;
	Calificacion calificacionDeOpinion;
	Usuario usuario;
	
	@BeforeEach
	void setUp() throws Exception {
		calificacionDeOpinion = Calificacion.CHINCHE_FOLIADA;
		usuario = mock(Usuario.class);
		opinion = new Opinion(calificacionDeOpinion, LocalDate.now(), usuario);
		
	}

	@Test
	void testOpinionConCalificacionDeChincheFoliada() {
		assertEquals(opinion.getCalificacion(), calificacionDeOpinion);
	}

	@Test
	void testOpinionConCalificacionImagenPocoClara() {
		calificacionDeOpinion = Calificacion.IMAGEN_POCO_CLARA;
		opinion.setCalificacion(calificacionDeOpinion);
		assertEquals(opinion.getCalificacion(), calificacionDeOpinion);
	}
	
	@Test
	void testFechaDeEmisionDeLaOpinion() {
		LocalDate fechaEmision = LocalDate.now();
		assertEquals(opinion.getFechaDeEmision(), fechaEmision);
	}
	
	@Test
	void testUnUsuarioBasicoRealizaUnaOpinion() {
		assertEquals(opinion.getUsuario(), usuario);
	}
	
}
