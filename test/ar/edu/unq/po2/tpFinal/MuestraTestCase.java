package ar.edu.unq.po2.tpFinal;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.awt.image.BufferedImage;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MuestraTestCase {

	private Muestra muestra;
	private LocalDate fechaActual;
	private Usuario usuario1;
	private Usuario usuario2;
	private Usuario usuario3;
	private Usuario usuario4;
	private Opinion opinion1;
	private Opinion opinion2;
	private Opinion opinion3;
	private Opinion opinion4;
	private Ubicacion ubicacion1;
	private Ubicacion ubicacion2;
	private Ubicacion ubicacion3;
	private Ubicacion ubicacion4;
	private Calificacion calificacion1;
	private BufferedImage imagen1;
	private BufferedImage imagen2;
	private BufferedImage imagen3;
	private BufferedImage imagen4;

	@BeforeEach
	void SetUp() throws Exception {
		usuario1 = mock(Usuario.class);
		usuario2 = mock(Usuario.class);
		usuario3 = mock(Usuario.class);
		usuario4 = mock(Usuario.class);
		opinion1 = mock(Opinion.class);
		opinion2 = mock(Opinion.class);
		opinion3 = mock(Opinion.class);
		opinion4 = mock(Opinion.class);
		calificacion1 = mock(Calificacion.class);
		ubicacion1 = mock(Ubicacion.class);
		ubicacion2 = mock(Ubicacion.class);
		ubicacion3 = mock(Ubicacion.class);
		ubicacion4 = mock(Ubicacion.class);
		imagen1 = mock(BufferedImage.class);
		imagen2 = mock(BufferedImage.class);
		imagen3 = mock(BufferedImage.class);
		imagen4 = mock(BufferedImage.class);
		this.fechaActual = LocalDate.now();
	}

	@Test
	void testConstructor() {
		
		muestra = new Muestra(imagen1, calificacion1, ubicacion1, usuario1);
		
		assertEquals(muestra.getFotoVinchuca(), imagen1);
		assertEquals(muestra.getEspecieFotografiada(), calificacion1);
		assertEquals(muestra.getUbicacion(), ubicacion1);
		assertEquals(muestra.getIdentificacionDeLaPersona(), usuario1);
	}
	
}