package ar.edu.unq.po2.tpFinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpFinal.Enumerativos.Calificacion;
import ar.edu.unq.po2.tpFinal.FiltroDeBusqueda.FiltroFechaDeCreacion;
import ar.edu.unq.po2.tpFinal.FiltroDeBusqueda.FiltroTipoInsectoDetectado;
import ar.edu.unq.po2.tpFinal.FiltroDeBusqueda.FiltroUltimaVotacion;

class FiltroTestCase {

	FiltroTipoInsectoDetectado filtroInsecto;
	FiltroFechaDeCreacion filtroFecha;
	FiltroUltimaVotacion filtroVotacion;
	List<Muestra> muestras;
	Muestra muestraInfestans;
	Muestra muestraGuasayana;
	Muestra muestraSordida;
	Opinion opinion;
	
	@BeforeEach
	void setUp() throws Exception {
		filtroInsecto = new FiltroTipoInsectoDetectado(Calificacion.INFESTANS);
		filtroFecha = new FiltroFechaDeCreacion(LocalDate.of(2022, 6, 17));
		filtroVotacion = new FiltroUltimaVotacion(LocalDate.of(2022, 5, 15));
		muestraInfestans = mock(Muestra.class);
		muestraGuasayana = mock(Muestra.class);
		muestraSordida = mock(Muestra.class);
		when(muestraInfestans.getEspecieDeVinchuca()).thenReturn(Calificacion.INFESTANS);
		when(muestraGuasayana.getEspecieDeVinchuca()).thenReturn(Calificacion.GUASAYANA);
		when(muestraSordida.getEspecieDeVinchuca()).thenReturn(Calificacion.SORDIDA);
		
		muestras = Arrays.asList(muestraInfestans,muestraGuasayana,muestraSordida);
		
		
	}

	@Test
	void testFiltroDeTipoInsectoConVinchucaInfestans() { //este ya funciona
		List<Muestra> filtro = filtroInsecto.buscarMuestras(muestras);
		assertTrue(filtro.contains(muestraInfestans));
		assertFalse(filtro.contains(muestraGuasayana));
	}

	
	@Test
	void testFiltroDeCreacionDeLaMuestra() {
		when(muestraInfestans.getFechaDeCreacion()).thenReturn(LocalDate.of(2022, 6, 17)); //tiene que estar
		when(muestraGuasayana.getFechaDeCreacion()).thenReturn(LocalDate.of(2022, 6, 17)); //tiene que estar
		when(muestraSordida.getFechaDeCreacion()).thenReturn(LocalDate.of(2022, 6, 12)); //no tiene que estar
		List<Muestra> filtro = filtroFecha.buscarMuestras(muestras);
		assertTrue(filtro.contains(muestraInfestans));
		assertTrue(filtro.contains(muestraGuasayana));
		assertFalse(filtro.contains(muestraSordida));
	}
	
	
	@Test
	void testFiltroDeUltimaVotacionDeLaMuestra() {
		when(muestraInfestans.getFechaUltimaVotacion()).thenReturn(LocalDate.of(2022, 2, 12)); //no tiene que estar
		when(muestraGuasayana.getFechaUltimaVotacion()).thenReturn(LocalDate.of(2022, 5, 15)); //tiene que estar
		when(muestraSordida.getFechaUltimaVotacion()).thenReturn(LocalDate.of(2022, 5, 15)); //tiene que estar
		List<Muestra> filtro = filtroVotacion.buscarMuestras(muestras);
		assertFalse(filtro.contains(muestraInfestans));
		assertTrue(filtro.contains(muestraGuasayana));
		assertTrue(filtro.contains(muestraSordida));
	}
	
	//falta filtro de verificacion y filtro compuesto
	
}
