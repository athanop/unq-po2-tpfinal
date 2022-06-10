package ar.edu.unq.po2.tpFinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.awt.image.BufferedImage;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpFinal.Enumerativos.Calificacion;
import ar.edu.unq.po2.tpFinal.EstadoDeUsuario.EstadoDeUsuario;
import ar.edu.unq.po2.tpFinal.EstadoDeUsuario.Usuario;
import ar.edu.unq.po2.tpFinal.Ubicaciones.Ubicacion;

class UsuarioTestCase {

	Usuario usuarioBasico; // sut
	Usuario usuarioExperto; // sut
	Usuario usuarioExpertoJuli;
	Usuario usuarioEspecialista; // sut
	EstadoDeUsuario estadoExperto;

	AplicacionWeb app;// doc
	Muestra muestra, muestra2, muestra3, muestra4, muestra5, muestra6, muestra7, muestra8, muestra9, muestra10;
	Ubicacion ubicacion1;
	BufferedImage imagen1;
	Opinion opinion, opinion1;
	List<Opinion> opiniones;
	Set<Muestra> muestrasEnviadas;

	@BeforeEach
	void setUp() throws Exception {
		estadoExperto = mock(EstadoDeUsuario.class);
		when(estadoExperto.esUsuarioExperto()).thenReturn(true);
		app = mock(AplicacionWeb.class);
		usuarioBasico = new Usuario("IdNahuel", app);
		usuarioExperto = new Usuario("IdSofi", app);
		usuarioExpertoJuli = new Usuario("IdCX", app);
		usuarioEspecialista = new Usuario("IdJuli", app);
		opinion = mock(Opinion.class);

		when(opinion.getCalificacion()).thenReturn(Calificacion.GUASAYANA);
		when(opinion.getFechaDeEmision()).thenReturn(LocalDate.now());

		muestra = mock(Muestra.class);
		muestra2 = mock(Muestra.class);
		muestra3 = mock(Muestra.class);
		muestra4 = mock(Muestra.class);
		muestra5 = mock(Muestra.class);
		muestra6 = mock(Muestra.class);
		muestra7 = mock(Muestra.class);
		muestra8 = mock(Muestra.class);
		muestra9 = mock(Muestra.class);
		muestra10 = mock(Muestra.class);

		when(muestra.getFechaDeCreacion()).thenReturn(LocalDate.now());
		when(muestra2.getFechaDeCreacion()).thenReturn(LocalDate.now());
		when(muestra3.getFechaDeCreacion()).thenReturn(LocalDate.now());
		when(muestra4.getFechaDeCreacion()).thenReturn(LocalDate.now());
		when(muestra5.getFechaDeCreacion()).thenReturn(LocalDate.now());
		when(muestra6.getFechaDeCreacion()).thenReturn(LocalDate.now());
		when(muestra7.getFechaDeCreacion()).thenReturn(LocalDate.now());
		when(muestra8.getFechaDeCreacion()).thenReturn(LocalDate.now());
		when(muestra9.getFechaDeCreacion()).thenReturn(LocalDate.now());
		when(muestra10.getFechaDeCreacion()).thenReturn(LocalDate.now());

		muestrasEnviadas = new HashSet<Muestra>();
		muestrasEnviadas.add(muestra);
		muestrasEnviadas.add(muestra2);
		muestrasEnviadas.add(muestra3);
		muestrasEnviadas.add(muestra4);
		muestrasEnviadas.add(muestra5);
		muestrasEnviadas.add(muestra6);
		muestrasEnviadas.add(muestra7);
		muestrasEnviadas.add(muestra8);
		muestrasEnviadas.add(muestra9);
		muestrasEnviadas.add(muestra10);

		// PARA TESTEAR LAS OPINIONES ENVIADAS EN LOS ULTIMOS 30 DIAS

		opiniones = Arrays.asList(opinion, opinion, opinion, opinion, opinion, opinion, opinion, opinion, opinion,
				opinion, opinion, opinion, opinion, opinion, opinion, opinion, opinion, opinion, opinion, opinion,
				opinion);

	}

	// TESTS DEL USUARIO BASICO
	@Test
	void testUnUsuarioAlSerCreadoConoceSusDatos() {
		assertEquals(usuarioBasico.getEnvios(), 0);
		assertEquals(usuarioBasico.getRevisiones(), 0);
		assertEquals(usuarioBasico.getIdentificacion(), "IdNahuel");

	}

	@Test
	void testUnUsuarioAlSerCreadoEsUnUsuarioBasico() {
		assertTrue(usuarioBasico.esUsuarioBasico());
	}

	@Test
	void testNoEsUnUsuarioExperto() {
		assertFalse(usuarioBasico.esUsuarioExperto());
	}

	@Test
	void testlasOpinionesEstanDentroDe30DiasDeLaFechaActual() {
		usuarioBasico.setOpinionesEnviadas(opiniones);
		assertEquals(usuarioBasico.cantidadDeOpinionesEnLosUltimos30Dias(), 21);
	}

	@Test
	void testLasMuestrasEstanDentroDe30DiasDeLaFechaActual() {
		usuarioBasico.setMuestras(muestrasEnviadas);
		assertEquals(usuarioBasico.cantidadDeEnviosEnLosUltimos30Dias(), 10);
	}

	@Test
	void testUnUsuarioActualizaSuCategoriaAExperto() {
		usuarioBasico.setMuestras(muestrasEnviadas);
		usuarioBasico.setOpinionesEnviadas(opiniones);
		usuarioBasico.actualizarCategoria();
		assertTrue(usuarioBasico.esUsuarioExperto());
	}

	// TESTS DEL USUARIO EXPERTO
	@Test
	void testUnUsuarioAgregarOpinionAMuestraVotadaPorExpertoYNoLoDeja() throws Exception {
		muestra.verificarMuestra();
		usuarioExperto.agregarOpinionEnviada(opinion);
		muestra.verificarMuestra();

		assertThrows(Exception.class, () -> usuarioBasico.agregarOpinionAMuestraVotadaPorExperto(muestra, opinion));
	}

	@Test
	void testEsUnUsuarioExperto() {
		usuarioExperto.setEstadoDeUsuario(estadoExperto);
		assertTrue(usuarioExperto.esUsuarioExperto());
	}

	@Test
	void testNoEsUnUsuarioBasico() {
		usuarioExperto.setEstadoDeUsuario(estadoExperto);
		assertFalse(usuarioExperto.esUsuarioBasico());
	}

	@Test
	void testLasOpinionesNoEstanDentroDe30DiasDeLaFecha() {
		when(opinion.getFechaDeEmision()).thenReturn(LocalDate.of(2020, 5, 5));
		opiniones = Arrays.asList(opinion);
		usuarioExperto.setOpinionesEnviadas(opiniones);
		assertEquals(usuarioExperto.cantidadDeOpinionesEnLosUltimos30Dias(), 0);
	}

	@Test
	void testLasMuestrasNoEstanDentroDe30DiasDeLaFecha() {
		when(muestra.getFechaDeCreacion()).thenReturn(LocalDate.of(2020, 5, 5));
		muestrasEnviadas = new HashSet<Muestra>();
		muestrasEnviadas.add(muestra);

		usuarioExperto.setMuestras(muestrasEnviadas);
		assertEquals(usuarioExperto.cantidadDeEnviosEnLosUltimos30Dias(), 0);

	}

	@Test
	void testUnUsuarioBasicoQueTieneCategoriaExpertoBajaACategoriaBasicoPorNoCumplirLosRequisitos() {
		usuarioBasico.actualizarCategoria();
		usuarioBasico.setMuestras(muestrasEnviadas);
		usuarioBasico.setOpinionesEnviadas(opiniones);
		usuarioBasico.actualizarCategoria();
		Boolean usuarioConEstadoAnteriorExperto = usuarioBasico.esUsuarioExperto();

		when(muestra.getFechaDeCreacion()).thenReturn(LocalDate.of(2020, 5, 5));
		muestrasEnviadas = new HashSet<Muestra>();
		muestrasEnviadas.add(muestra);

		usuarioBasico.setMuestras(muestrasEnviadas);
		usuarioBasico.actualizarCategoria();

		Boolean usuarioConEstadoNuevoBasico = usuarioBasico.esUsuarioBasico();
		assertTrue(usuarioConEstadoAnteriorExperto);
		assertTrue(usuarioConEstadoNuevoBasico);

	}

	@Test
	void testUnUsuarioConEstadoDeUsuarioExpertoOpinaSobreUnaMuestraEnEstadoVotadaPorExpertoYLeEnviaElMensajeVerificarMuestra()
			throws Exception {
		usuarioExperto.setMuestras(muestrasEnviadas);
		usuarioExperto.setOpinionesEnviadas(opiniones);
		usuarioExperto.actualizarCategoria();
		usuarioExperto.agregarOpinionAMuestraVotadaPorExperto(muestra, opinion);
		verify(muestra).agregarLaOpinionDelUsuario(opinion, usuarioExperto);
	}

	@Test
	void testUnUsuarioConEstadoDeUsuarioExpertoOpinaSobreUnaMuestra() throws Exception {
		usuarioExperto.setMuestras(muestrasEnviadas);
		usuarioExperto.setOpinionesEnviadas(opiniones);
		usuarioExperto.actualizarCategoria();
		usuarioExperto.opinarSobreMuestra(muestra, opinion);
		verify(muestra).agregarLaOpinionDelUsuario(opinion, usuarioExperto);
	}

	// TEST USUARIO ESPECIALISTA
	@Test
	void testUnUsuarioEspecialistaSiempreTieneEstadoExperto() {
		usuarioEspecialista.cambiarAUsuarioEspecialista();

		assertFalse(usuarioEspecialista.esUsuarioBasico());
		assertTrue(usuarioEspecialista.esUsuarioExperto());
	}

	@Test
	void testUnUsuarioEspecialistaQuiereModificarSuEstadoYSiempreEsExperto() {
		usuarioEspecialista.cambiarAUsuarioEspecialista();

		usuarioEspecialista.actualizarCategoria();
		assertTrue(usuarioEspecialista.esUsuarioExperto());

	}

	@Test
	void testUnUsuarioQueEnviaUnaMuestraLeEnviaElMensajeALaAplicionWebParaRegistrarla() {
		usuarioBasico.enviarMuestra(muestra);
		verify(app).registrarMuestra(muestra);
	}

	@Test
	void testUnUsuarioEmiteUnaOpinionYLeEnviaElMensajeDeAgregarOpinionALaMuestra() throws Exception {
		usuarioBasico.opinarSobreMuestra(muestra, opinion);
		verify(muestra).agregarLaOpinionDelUsuario(opinion, usuarioBasico);
	}

}
