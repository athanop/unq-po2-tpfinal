package ar.edu.unq.po2.tpFinal;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpFinal.EstadoDeUsuario.Usuario;
import ar.edu.unq.po2.tpFinal.FiltroDeBusqueda.IFiltroBusquedaMuestra;
import ar.edu.unq.po2.tpFinal.Ubicaciones.ZonaDeCobertura;

class AplicacionWebTestCase {

	AplicacionWeb aplicacionWeb;
	Muestra muestra;
	Muestra muestra2;
	Muestra muestra3;
	ZonaDeCobertura zonaDeCobertura;
	ZonaDeCobertura zonaDeCobertura2;
	ZonaDeCobertura zonaDeCobertura3;

	@BeforeEach
	void setUp() {
		aplicacionWeb = new AplicacionWeb();
		muestra = mock(Muestra.class);
		muestra2 = mock(Muestra.class);
		muestra3 = mock(Muestra.class);
		zonaDeCobertura = mock(ZonaDeCobertura.class);
		zonaDeCobertura2 = mock(ZonaDeCobertura.class);
		zonaDeCobertura3 = mock(ZonaDeCobertura.class);
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
	void testUnaAplicacionWebNoTieneZonasDeCoberturaRegistradasYSuCantidadDeZonasDeCoberturaEsCero() {
		assertEquals(0, aplicacionWeb.getZonasDeCobertura().size());
	}

	@Test
	void testUnaAplicacionWebTieneUnaZonaDeCoberturaRegistradaYSuCantidadDeZonasDeCoberturaEsUna() {
		aplicacionWeb.agregarZonaDeCobertura(zonaDeCobertura);

		assertEquals(1, aplicacionWeb.getZonasDeCobertura().size());
	}

	@Test
	void testUnaAplicacionWebActualizaLaCategoriaDeTodosLosUsuarios() {
		Usuario sofia = mock(Usuario.class);
		Usuario julian = mock(Usuario.class);

		aplicacionWeb.registrarUsuario(sofia);
		aplicacionWeb.registrarUsuario(julian);
		aplicacionWeb.actualizarCategoriaDeUsuariosALaFecha();

		verify(sofia).actualizarCategoria();
		verify(julian).actualizarCategoria();
	}

	@Test
	void testUnaAplicacionWebRegistraUnaNuevaMuestraYLeAvisaALasZonasDeCoberturaRegistradas() {
		aplicacionWeb.agregarZonaDeCobertura(zonaDeCobertura);
		aplicacionWeb.agregarZonaDeCobertura(zonaDeCobertura2);
		aplicacionWeb.registrarMuestra(muestra);

		verify(zonaDeCobertura).agregarMuestra(muestra);
		verify(zonaDeCobertura2).agregarMuestra(muestra);
	}

	@Test
	void testUnaAplicacionWebFiltraSuListraDeMuestraYLeDelegaLaResponsabilidadAlFiltro() {
		List<Muestra> listaDeMuestras = new ArrayList<Muestra>();
		IFiltroBusquedaMuestra filtro = mock(IFiltroBusquedaMuestra.class);

		listaDeMuestras.add(muestra);
		listaDeMuestras.add(muestra2);
		listaDeMuestras.add(muestra3);
		aplicacionWeb.registrarMuestra(muestra);
		aplicacionWeb.registrarMuestra(muestra2);
		aplicacionWeb.registrarMuestra(muestra3);
		aplicacionWeb.filtrarMuestras(filtro);

		verify(filtro).buscarMuestras(listaDeMuestras);
	}

	@Test
	void testUnaAplicacionWebFiltraSusMuestrasYElFiltroLeDevuelveLasMismasMuestras() {
		List<Muestra> listaDeMuestras = new ArrayList<Muestra>();
		IFiltroBusquedaMuestra filtro = mock(IFiltroBusquedaMuestra.class);

		listaDeMuestras.add(muestra);
		listaDeMuestras.add(muestra2);
		listaDeMuestras.add(muestra3);
		aplicacionWeb.registrarMuestra(muestra);
		aplicacionWeb.registrarMuestra(muestra2);
		aplicacionWeb.registrarMuestra(muestra3);
		when(filtro.buscarMuestras(listaDeMuestras)).thenReturn(listaDeMuestras);

		assertEquals(listaDeMuestras, aplicacionWeb.filtrarMuestras(filtro));
	}

	@Test
	void testUnaAplicacionWebQuiereSaberCualesSonLasZonasQueSeSolapanConUnaZonaDeCoberturaYLeDelegaLaResponsabilidadALaZonaDecobertura() {
		Set<ZonaDeCobertura> zonasDeCobertura = new HashSet<ZonaDeCobertura>();

		zonasDeCobertura.add(zonaDeCobertura2);
		zonasDeCobertura.add(zonaDeCobertura3);
		aplicacionWeb.agregarZonaDeCobertura(zonaDeCobertura2);
		aplicacionWeb.agregarZonaDeCobertura(zonaDeCobertura3);
		aplicacionWeb.zonasQueSeSolapanCon(zonaDeCobertura);

		verify(zonaDeCobertura).zonasQueSolapan(zonasDeCobertura);
	}

}
