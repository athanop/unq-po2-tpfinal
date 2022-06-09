package ar.edu.unq.po2.tpFinal;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpFinal.EstadoDeUsuario.Usuario;
import ar.edu.unq.po2.tpFinal.Ubicaciones.ZonaDeCobertura;

class AplicacionWebTestCase {

	AplicacionWeb aplicacionWeb;
	Muestra muestra;
	Muestra muestra2;
	ZonaDeCobertura zonaDeCobertura;
	ZonaDeCobertura zonaDeCobertura2;

	@BeforeEach
	void setUp() {
		aplicacionWeb = new AplicacionWeb();
		muestra = mock(Muestra.class);
		muestra2 = mock(Muestra.class);
		zonaDeCobertura = mock(ZonaDeCobertura.class);
		zonaDeCobertura2 = mock(ZonaDeCobertura.class);
	}

	@Test
	void testNoSeRegistranMuestrasYLaCantidadDeMuestrasDeAplicacionWebEsCero() {
		assertEquals(0, aplicacionWeb.getMuestrasRegistradas().size());
	}

	@Test
	void testAplicacionWebTieneUnaMuestraRegistradaYSuCantidadDeMuestrasEsUno() {
		aplicacionWeb.registrarMuestra(muestra);

		assertEquals(1, aplicacionWeb.getMuestrasRegistradas().size());
	}

	@Test
	void testNoSeRegistranUsuariosYLaCantidadDeUsuariosDeAplicacionWebEsCero() {
		assertEquals(0, aplicacionWeb.getUsuariosRegistrados().size());
	}

	@Test
	void testSeRegistraUnUsuariosYLaCantidadDeUsuariosDeAplicacionWebEsUno() {
		Usuario usuario = mock(Usuario.class);
		aplicacionWeb.registrarUsuario(usuario);

		assertEquals(1, aplicacionWeb.getUsuariosRegistrados().size());
	}

	@Test
	void testAplicacionWebNoTieneZonasDeCoberturaRegistradasYSuCantidadDeZonasDeCoberturaEsCero() {
		assertEquals(0, aplicacionWeb.getZonasDeCobertura().size());
	}

	@Test
	void testAplicacionWebTieneUnaZonaDeCoberturaRegistradaYSuCantidadDeZonasDeCoberturaEsUna() {
		aplicacionWeb.agregarZonaDeCobertura(zonaDeCobertura);

		assertEquals(1, aplicacionWeb.getZonasDeCobertura().size());
	}

}
