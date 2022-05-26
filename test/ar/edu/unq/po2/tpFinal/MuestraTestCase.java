package ar.edu.unq.po2.tpFinal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.awt.image.BufferedImage;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MuestraTestCase {

	private Muestra muestra;
	private LocalDate fechaActual;
	private Usuario usuarioBasico;
	private Usuario usuarioExperto;
	private Usuario nahuelExperto;
	private Usuario sofiaBasico;
	private Opinion opinionChincheFoliada;
	private Opinion opinionChincheFoliada2;
	private Opinion opinionGuasayana;
	private Opinion opinionGuasayana2;
	private Ubicacion ubicacion;
	private ZonaDeCobertura zonaDeCobertura;
	private Calificacion calificacion1;
	private BufferedImage fotoVinchuca;

	@BeforeEach
	void SetUp() throws Exception {

		usuarioBasico = mock(Usuario.class);
		usuarioExperto = mock(Usuario.class);
		nahuelExperto = mock(Usuario.class);
		sofiaBasico = mock(Usuario.class);
		opinionChincheFoliada = mock(Opinion.class);
		opinionChincheFoliada2 = mock(Opinion.class);
		opinionGuasayana = mock(Opinion.class);
		opinionGuasayana2 = mock(Opinion.class);

		ubicacion = mock(Ubicacion.class);
		zonaDeCobertura = mock(ZonaDeCobertura.class);
		fotoVinchuca = mock(BufferedImage.class);

		muestra = new Muestra(fotoVinchuca, ubicacion, sofiaBasico, opinionGuasayana, LocalDate.of(2022, 5, 13));
		
		when(usuarioBasico.esUsuarioBasico()).thenReturn(true);
		when(usuarioExperto.esUsuarioExperto()).thenReturn(true);
		when(nahuelExperto.esUsuarioExperto()).thenReturn(true);
		when(sofiaBasico.esUsuarioBasico()).thenReturn(true);
		
		when(opinionGuasayana.getCalificacion()).thenReturn("GUASAYANA");
		when(opinionGuasayana.getFechaDeEmision()).thenReturn(LocalDate.now());
		when(opinionGuasayana2.getCalificacion()).thenReturn("GUASAYANA");
		when(opinionGuasayana2.getFechaDeEmision()).thenReturn(LocalDate.now());
		when(opinionChincheFoliada.getCalificacion()).thenReturn("CHINCHE_FOLIADA");
		when(opinionChincheFoliada.getFechaDeEmision()).thenReturn(LocalDate.now());
		when(opinionChincheFoliada2.getCalificacion()).thenReturn("CHINCHE_FOLIADA");
		when(opinionChincheFoliada2.getFechaDeEmision()).thenReturn(LocalDate.now());
	}

	@Test
	void testConstructor() {
		assertEquals("GUASAYANA", muestra.getEspecieDeVinchuca());
		assertTrue(muestra.contieneLaOpinion(opinionGuasayana));
		assertEquals(fotoVinchuca, muestra.getFotoVinchuca());
		assertEquals(ubicacion, muestra.getUbicacion());
		when(muestra.getIdentificacionPropietarioDeLaMuestra()).thenReturn("Sofia");
		assertEquals("Sofia", muestra.getIdentificacionPropietarioDeLaMuestra());
		assertEquals(LocalDate.of(2022, 5, 13), muestra.getFechaDeCreacion());
		assertTrue(muestra.getZonasDeCobertura().isEmpty());	
		assertEquals(1, muestra.getHistorialDeOpiniones().size());
	}

	@Test
	void testMuestraConUnaSolaOpinionObtieneResultadoActualComoGuasayana() {
		muestra.agregarLaOpinionDelUsuario(opinionChincheFoliada, usuarioBasico);

		assertEquals("GUASAYANA", muestra.getResultadoActual());
	}

}