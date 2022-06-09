package ar.edu.unq.po2.tpFinal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.awt.image.BufferedImage;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpFinal.Enumerativos.Calificacion;
import ar.edu.unq.po2.tpFinal.EstadoDeUsuario.Usuario;
import ar.edu.unq.po2.tpFinal.Ubicaciones.Ubicacion;
import ar.edu.unq.po2.tpFinal.Ubicaciones.ZonaDeCobertura;

class MuestraTestCase {

	Muestra muestra;
	Usuario usuarioBasico;
	Usuario usuarioExperto;
	Usuario nahuelExperto;
	Usuario sofiaBasico;
	Opinion opinionChincheFoliada;
	Opinion opinionChincheFoliada2;
	Opinion opinionGuasayana;
	Opinion opinionGuasayana2;
	Ubicacion ubicacion;
	Ubicacion ubicacionEpicentro;
	BufferedImage fotoVinchuca;
	ZonaDeCobertura zona1;
	
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
		zona1 = mock(ZonaDeCobertura.class);
		ubicacion = mock(Ubicacion.class);
		fotoVinchuca = mock(BufferedImage.class);
		
		
		when(ubicacion.getZona()).thenReturn(zona1);

		muestra = new Muestra(fotoVinchuca, ubicacion, sofiaBasico, opinionGuasayana, LocalDate.of(2022, 5, 13));

		when(usuarioBasico.esUsuarioBasico()).thenReturn(true);
		when(usuarioExperto.esUsuarioExperto()).thenReturn(true);
		when(nahuelExperto.esUsuarioExperto()).thenReturn(true);
		when(sofiaBasico.esUsuarioBasico()).thenReturn(true);

		when(opinionGuasayana.getCalificacion()).thenReturn(Calificacion.GUASAYANA);
		when(opinionGuasayana.getFechaDeEmision()).thenReturn(LocalDate.now());
		when(opinionGuasayana2.getCalificacion()).thenReturn(Calificacion.GUASAYANA);
		when(opinionGuasayana2.getFechaDeEmision()).thenReturn(LocalDate.now());
		when(opinionChincheFoliada.getCalificacion()).thenReturn(Calificacion.CHINCHE_FOLIADA);
		when(opinionChincheFoliada.getFechaDeEmision()).thenReturn(LocalDate.now());
		when(opinionChincheFoliada2.getCalificacion()).thenReturn(Calificacion.CHINCHE_FOLIADA);
		when(opinionChincheFoliada2.getFechaDeEmision()).thenReturn(LocalDate.now());
	}

	@Test
	void testConstructor() {
		assertEquals(fotoVinchuca, muestra.getFotoVinchuca());
		assertEquals(ubicacion, muestra.getUbicacion());
		when(muestra.getIdentificacionPropietarioDeLaMuestra()).thenReturn("Sofia");
		assertEquals("Sofia", muestra.getIdentificacionPropietarioDeLaMuestra());
		assertEquals(LocalDate.of(2022, 5, 13), muestra.getFechaDeCreacion());
		assertEquals(1, muestra.getHistorialDeOpiniones().size());
	}

	@Test
	void testMuestraConUnaSolaOpinionObtieneResultadoActualComoGuasayana() {
		muestra.agregarLaOpinionDelUsuario(opinionGuasayana, usuarioBasico);
		assertEquals(Calificacion.GUASAYANA, muestra.getResultadoActual());
	}

	@Test
	void testEstadoDeLaMuestraConVerificacionParcialChincheFoliada() {
		muestra.agregarLaOpinionDelUsuario(opinionGuasayana, usuarioBasico);
		muestra.agregarLaOpinionDelUsuario(opinionChincheFoliada, sofiaBasico);
		muestra.agregarLaOpinionDelUsuario(opinionChincheFoliada, usuarioExperto);

		assertEquals(Calificacion.CHINCHE_FOLIADA, muestra.getResultadoActual());
	}

	@Test
	void testSeAgregaUnaOpinionALaMuestraYSeActualizaLaUltimaFechaDeVotacion() {
		assertEquals(LocalDate.of(2022, 5, 13), muestra.getFechaUltimaVotacion());
		muestra.agregarLaOpinionDelUsuario(opinionGuasayana, sofiaBasico);

		assertEquals(LocalDate.now(), muestra.getFechaUltimaVotacion());

	}

	@Test
	void testUnaMuestraNoPuedeVolverASerOpinadaPorSuPropietario() throws Exception {
		assertThrows(Exception.class, () -> muestra.agregarLaOpinion(opinionGuasayana, sofiaBasico));
	}

	@Test
	void test_UnaMuestraNoContieneLaOpinionDeUnUsuarioQueNoOpino() {
		assertFalse(muestra.contieneAlUsuario(usuarioExperto));
	}

	@Test
	void testCuandoSeAgregaUnaOpinionALaMuestraSeLeAgregaAsuHistorialDeOpiniones() throws Exception {
		assertFalse(muestra.contieneLaOpinion(opinionChincheFoliada));
		muestra.agregarLaOpinionDelUsuario(opinionChincheFoliada, nahuelExperto);

		assertTrue(muestra.contieneLaOpinion(opinionChincheFoliada));
	}

	@Test
	void testSeAgregaUnaOpinionEnElHistorialDeOpinionesYContiene2DeLasMismas() throws Exception {
		muestra.agregarLaOpinion(opinionChincheFoliada2, usuarioBasico);

		assertEquals(2, muestra.getHistorialDeOpiniones().size());
	}

	@Test
	void testUnaMuestraEsComentadaPorUnUsuarioExperto() throws Exception {
		muestra.verificarMuestra();
		muestra.agregarLaOpinion(opinionChincheFoliada, usuarioExperto);

		verify(usuarioExperto).agregarOpinionAMuestraVotadaPorExperto(muestra, opinionChincheFoliada);
	}

	@Test
	void testCuandoOpinaUnExpertoLasOpinionesQueValenSonSoloLasDeLosExpertos() throws Exception {
		assertTrue(muestra.contieneLaOpinion(opinionGuasayana));

		muestra.verificarMuestra();
		muestra.agregarLaOpinionDelUsuario(opinionChincheFoliada, nahuelExperto);

		assertFalse(muestra.contieneLaOpinion(opinionGuasayana));
		assertTrue(muestra.contieneLaOpinion(opinionChincheFoliada));
	}

	@Test
	void testDosExpertosCoincidenEnSuOpinionVerificandoLaMuestra() throws Exception {
		muestra.verificarMuestra();
		muestra.agregarLaOpinionDelUsuario(opinionGuasayana, nahuelExperto);
		muestra.agregarLaOpinionDelUsuario(opinionGuasayana, usuarioExperto);
		muestra.verificarMuestra();

		assertTrue(muestra.coincidenDosExpertosEnSuCalificacionDeOpinion());
		assertEquals("verificada", muestra.getNivelDeVerificacion());
	}

	@Test
	void testUnaMuestraVerificadaNoSePuedeVolverAVerificar() throws Exception {
		muestra.verificarMuestra();
		muestra.agregarLaOpinionDelUsuario(opinionChincheFoliada, usuarioExperto);
		muestra.agregarLaOpinionDelUsuario(opinionChincheFoliada2, nahuelExperto);
		muestra.verificarMuestra();

		assertThrows(Exception.class, () -> muestra.verificarMuestra());
	}

	@Test
	void testCuandoDosUsuariosExpertosNoCoincidenEnLaOpinionSobreUnaMuestraEstaNoSeVerifica() throws Exception {
		muestra.verificarMuestra();
		muestra.agregarLaOpinionDelUsuario(opinionChincheFoliada, sofiaBasico);
		muestra.agregarLaOpinionDelUsuario(opinionGuasayana2, usuarioExperto);
		muestra.verificarMuestra();

		assertFalse(muestra.coincidenDosExpertosEnSuCalificacionDeOpinion());
		assertEquals("votada", muestra.getNivelDeVerificacion());
	}

	@Test
	void testCuandoUnUsuarioExpertoTrataDeVotarUnaMuestraVerificadaSuOpinionNoCuenta() throws Exception {
		muestra.verificarMuestra();
		muestra.agregarLaOpinionDelUsuario(opinionChincheFoliada, usuarioExperto);
		muestra.agregarLaOpinionDelUsuario(opinionChincheFoliada2, nahuelExperto);
		muestra.verificarMuestra();

		assertThrows(Exception.class, () -> muestra.agregarLaOpinion(opinionGuasayana2, usuarioExperto));
	}
	
	@Test
	void testCuandoUnUsuarioExpertoTrataDeVotarUnaMuestraQueYaVotóNoPuedeVolverAOpinar() throws Exception {
		muestra.verificarMuestra();
		muestra.agregarLaOpinionDelUsuario(opinionChincheFoliada, usuarioExperto);
		muestra.agregarLaOpinionDelUsuario(opinionChincheFoliada2, usuarioExperto);
		muestra.verificarMuestra();

		assertThrows(Exception.class, () -> muestra.agregarLaOpinion(opinionGuasayana2, usuarioExperto));
	}

	@Test
	void testUnaMuestraTieneNivelDeVerificacionVotadaSiNoOpinaNingunExperto() {
		assertEquals("votada", muestra.getNivelDeVerificacion());
	}

	@Test
	void test_unaMuestraTieneUnNivelDeVerificacionVotadaPorExpertoSiOpinoAlMenosUnExperto() throws Exception {
		muestra.agregarLaOpinionDelUsuario(opinionChincheFoliada, usuarioExperto);
		muestra.verificarMuestra();

		assertEquals("votada", muestra.getNivelDeVerificacion());
	}

	@Test
	void testCuandoSeLePideAUnaMuestraSuResultadoActualRetornaLaOpinionConMasVotos() throws Exception {
		muestra.agregarLaOpinionDelUsuario(opinionChincheFoliada, usuarioBasico);
		muestra.agregarLaOpinionDelUsuario(opinionChincheFoliada2, usuarioExperto);
		muestra.agregarLaOpinionDelUsuario(opinionChincheFoliada2, nahuelExperto);

		assertEquals(Calificacion.CHINCHE_FOLIADA, muestra.getResultadoActual());
	}
	
	

	// 1) Faltaria que cuando una Muestra agrega una ZonaDeCobertura se le agregue a su lista de ZonasDeCoberturas.
	
	
}