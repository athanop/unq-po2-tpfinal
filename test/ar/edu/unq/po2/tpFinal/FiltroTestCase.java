package ar.edu.unq.po2.tpFinal;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpFinal.Enumerativos.Calificacion;
import ar.edu.unq.po2.tpFinal.EstadoDeMuestra.EstadoDeMuestra;
import ar.edu.unq.po2.tpFinal.FiltroDeBusqueda.FiltroCompuestoAnd;
import ar.edu.unq.po2.tpFinal.FiltroDeBusqueda.FiltroCompuestoOr;
import ar.edu.unq.po2.tpFinal.FiltroDeBusqueda.FiltroFechaDeCreacion;
import ar.edu.unq.po2.tpFinal.FiltroDeBusqueda.FiltroNivelDeVerificacion;
import ar.edu.unq.po2.tpFinal.FiltroDeBusqueda.FiltroTipoInsectoDetectado;
import ar.edu.unq.po2.tpFinal.FiltroDeBusqueda.FiltroUltimaVotacion;
import ar.edu.unq.po2.tpFinal.FiltroDeBusqueda.IFiltroBusquedaMuestra;

class FiltroTestCase {

	IFiltroBusquedaMuestra filtroInsectoInfestans;
	IFiltroBusquedaMuestra filtroInsectoGuasayana;
	IFiltroBusquedaMuestra filtroInsectoSordida;
	IFiltroBusquedaMuestra filtroFecha;
	IFiltroBusquedaMuestra filtroVotacion;
	IFiltroBusquedaMuestra filtroNivelVerificacionVotada;
	IFiltroBusquedaMuestra filtroNivelVerificacionVerificada;
	IFiltroBusquedaMuestra filtroCompuestoAnd;
	IFiltroBusquedaMuestra filtroCompuestoAnd2;
	IFiltroBusquedaMuestra filtroCompuestoOR;
	IFiltroBusquedaMuestra filtroCompuestoOR2;
	List<Muestra> muestras;
	Muestra muestraInfestans;
	Muestra muestraGuasayana;
	Muestra muestraSordida;
	Opinion opinion;
	EstadoDeMuestra estadoVotada;
	EstadoDeMuestra estadoVerificada;

	@BeforeEach
	void setUp() throws Exception {
		filtroInsectoInfestans = new FiltroTipoInsectoDetectado(Calificacion.INFESTANS);
		filtroInsectoGuasayana = new FiltroTipoInsectoDetectado(Calificacion.GUASAYANA);
		filtroInsectoSordida = new FiltroTipoInsectoDetectado(Calificacion.SORDIDA);
		filtroFecha = new FiltroFechaDeCreacion(LocalDate.of(2022, 6, 17));
		filtroVotacion = new FiltroUltimaVotacion(LocalDate.of(2022, 5, 15));
		filtroNivelVerificacionVotada = new FiltroNivelDeVerificacion("votada");
		filtroNivelVerificacionVerificada = new FiltroNivelDeVerificacion("verificada");

		// filtroCompuestoAnd = new FiltroCompuestoAnd();

		muestraInfestans = mock(Muestra.class);
		muestraGuasayana = mock(Muestra.class);
		muestraSordida = mock(Muestra.class);
		estadoVotada = mock(EstadoDeMuestra.class);
		estadoVerificada = mock(EstadoDeMuestra.class);

		when(muestraInfestans.getEspecieDeVinchuca()).thenReturn(Calificacion.INFESTANS);
		when(muestraGuasayana.getEspecieDeVinchuca()).thenReturn(Calificacion.GUASAYANA);
		when(muestraSordida.getEspecieDeVinchuca()).thenReturn(Calificacion.SORDIDA);

		when(muestraInfestans.getEstadoMuestra()).thenReturn(estadoVerificada);
		when(muestraGuasayana.getEstadoMuestra()).thenReturn(estadoVotada);
		when(muestraSordida.getEstadoMuestra()).thenReturn(estadoVerificada);

		when(muestraInfestans.getFechaDeCreacion()).thenReturn(LocalDate.of(2022, 6, 17));
		when(muestraGuasayana.getFechaDeCreacion()).thenReturn(LocalDate.of(2022, 6, 17));
		when(muestraSordida.getFechaDeCreacion()).thenReturn(LocalDate.of(2022, 6, 12));

		when(muestraInfestans.getFechaUltimaVotacion()).thenReturn(LocalDate.of(2022, 2, 12));
		when(muestraGuasayana.getFechaUltimaVotacion()).thenReturn(LocalDate.of(2022, 5, 15));
		when(muestraSordida.getFechaUltimaVotacion()).thenReturn(LocalDate.of(2022, 5, 15));

		when(estadoVerificada.getNivelDeVerificacion(muestraInfestans)).thenReturn("verificada");
		when(estadoVotada.getNivelDeVerificacion(muestraGuasayana)).thenReturn("votada");
		when(estadoVerificada.getNivelDeVerificacion(muestraSordida)).thenReturn("verificada");

		muestras = Arrays.asList(muestraInfestans, muestraGuasayana, muestraSordida);

	}

	@Test
	void testFiltroDeTipoInsectoConVinchucaInfestans() {
		List<Muestra> filtro = filtroInsectoInfestans.buscarMuestras(muestras);

		assertTrue(filtro.contains(muestraInfestans));
		assertFalse(filtro.contains(muestraGuasayana));
		assertFalse(filtro.contains(muestraSordida));
	}

	@Test
	void testFiltroDeCreacionDeLaMuestra() {
		List<Muestra> filtro = filtroFecha.buscarMuestras(muestras);

		assertTrue(filtro.contains(muestraInfestans));
		assertTrue(filtro.contains(muestraGuasayana));
		assertFalse(filtro.contains(muestraSordida));
	}

	@Test
	void testFiltroDeUltimaVotacionDeLaMuestra() {
		List<Muestra> filtro = filtroVotacion.buscarMuestras(muestras);

		assertFalse(filtro.contains(muestraInfestans));
		assertTrue(filtro.contains(muestraGuasayana));
		assertTrue(filtro.contains(muestraSordida));
	}

	@Test
	void testFiltroDeNivelDeVerificacionEstadoVerificadoDeLasMuestrasInfestansYSordida() {
		List<Muestra> filtro = filtroNivelVerificacionVerificada.buscarMuestras(muestras);

		assertTrue(filtro.contains(muestraInfestans));
		assertTrue(filtro.contains(muestraSordida));
		assertFalse(filtro.contains(muestraGuasayana));
	}

	@Test
	void testFiltroDeNivelDeVerificacionEstadoVotadaDeLaMuestraGuasayana() {
		List<Muestra> filtro = filtroNivelVerificacionVotada.buscarMuestras(muestras);

		assertTrue(filtro.contains(muestraGuasayana));
		assertFalse(filtro.contains(muestraInfestans));
		assertFalse(filtro.contains(muestraSordida));
	}

	@Test
	void testFiltroCompuestoANDConFiltroInsectoYFiltroFecha() {
		filtroCompuestoAnd = new FiltroCompuestoAnd(filtroFecha, filtroInsectoInfestans);

		/*
		 * que me filtre las muestras que son tipo insecto INFESTANS Y fecha
		 * LocalDate.of(2022, 6, 17) osea la muestraInfestans
		 */

		List<Muestra> filtroCompuesto = filtroCompuestoAnd.buscarMuestras(muestras);

		assertTrue(filtroCompuesto.contains(muestraInfestans));
		assertFalse(filtroCompuesto.contains(muestraGuasayana));
		assertFalse(filtroCompuesto.contains(muestraSordida));
	}

	@Test
	void testFiltroCompuestoANDConFiltroInsectoYOtroFiltroCompuestoAND() {
		filtroCompuestoAnd2 = new FiltroCompuestoAnd(filtroFecha, filtroVotacion);
		filtroCompuestoAnd = new FiltroCompuestoAnd(filtroInsectoGuasayana, filtroCompuestoAnd2);
		// guasayana y LocalDate.of(2022, 6, 17) fecha y LocalDate.of(2022, 5, 15)
		// votacion

		List<Muestra> filtroCompuesto = filtroCompuestoAnd.buscarMuestras(muestras);

		assertTrue(filtroCompuesto.contains(muestraGuasayana));
		assertFalse(filtroCompuesto.contains(muestraInfestans));
		assertFalse(filtroCompuesto.contains(muestraSordida));
	}

	@Test
	void testFiltroCompuestoORConFiltroInsectoOYFiltroNivelVotada() {
		filtroCompuestoOR = new FiltroCompuestoOr(filtroNivelVerificacionVotada, filtroInsectoInfestans);
		// muestras de nivel "votada" OR infestans

		List<Muestra> filtroCompuesto = filtroCompuestoOR.buscarMuestras(muestras);

		assertTrue(filtroCompuesto.contains(muestraGuasayana));
		assertTrue(filtroCompuesto.contains(muestraInfestans));
		assertFalse(filtroCompuesto.contains(muestraSordida));
	}

	@Test
	void testFiltroCompuestoORConFiltroNivelVerificadaYOtroCompuestoOR() {
		filtroCompuestoOR2 = new FiltroCompuestoOr(filtroVotacion, filtroInsectoGuasayana);
		filtroCompuestoOR = new FiltroCompuestoOr(filtroNivelVerificacionVerificada, filtroCompuestoOR2);

		List<Muestra> filtroCompuesto = filtroCompuestoOR.buscarMuestras(muestras);

		assertTrue(filtroCompuesto.contains(muestraGuasayana));
		assertTrue(filtroCompuesto.contains(muestraInfestans));
		assertTrue(filtroCompuesto.contains(muestraSordida));
	}

	@Test
	void testFiltroCompuestoANDCombinadoConFiltroCompuestoOR() {
		filtroCompuestoOR = new FiltroCompuestoOr(filtroNivelVerificacionVerificada, filtroVotacion);
		filtroCompuestoAnd = new FiltroCompuestoAnd(filtroInsectoSordida, filtroCompuestoOR);

		List<Muestra> filtroCompuesto = filtroCompuestoAnd.buscarMuestras(muestras);

		assertTrue(filtroCompuesto.contains(muestraSordida));
		assertFalse(filtroCompuesto.contains(muestraGuasayana));
		assertFalse(filtroCompuesto.contains(muestraInfestans));
	}


}
