package ar.edu.unq.po2.tpFinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpFinal.Ubicaciones.Ubicacion;
import ar.edu.unq.po2.tpFinal.Ubicaciones.ZonaDeCobertura;

class UbicacionTestCase {

	Ubicacion ubicacion1, ubicacion2, ubicacion3, ubicacion4, ubicacion5;
	List<Ubicacion> ubicaciones, resultado;
	Muestra muestra, otraMuestra, otraMuestraMuyLejos;
	ZonaDeCobertura zona;

	@BeforeEach
	void setUp() throws Exception {

		zona = new ZonaDeCobertura("Wilde", ubicacion1, 30);

		muestra = mock(Muestra.class);
		otraMuestra = mock(Muestra.class);
		otraMuestraMuyLejos = mock(Muestra.class);
		ubicacion1 = new Ubicacion(50d, 40d, zona);
		ubicacion2 = new Ubicacion(40d, 50d, zona);
		ubicacion3 = new Ubicacion(10d, 20d, zona);
		ubicacion5 = new Ubicacion(60d, 60d, zona);
		when(otraMuestra.getUbicacion()).thenReturn(ubicacion1); // ubicacion 50 40
		when(muestra.getUbicacion()).thenReturn(ubicacion2); // ubicacion 40 50
		when(otraMuestraMuyLejos.getUbicacion()).thenReturn(ubicacion5);
		zona.agregarMuestra(otraMuestra);
		zona.agregarMuestra(otraMuestraMuyLejos);

		ubicacion4 = new Ubicacion();
		ubicaciones = new ArrayList<Ubicacion>();
		ubicaciones.add(ubicacion2);
		ubicaciones.add(ubicacion3);
		resultado = new ArrayList<Ubicacion>();
		resultado.add(ubicacion2);

	}

	@Test
	void testUbicacionCero() {
		assertEquals(0d, ubicacion4.getLatitud());
		assertEquals(0d, ubicacion4.getLongitud());
	}

	@Test
	void testUbicacionConLatitudYLongitud() {
		assertEquals(50d, ubicacion1.getLatitud());
		assertEquals(40d, ubicacion1.getLongitud());
	}

	@Test
	public void testDistanciaEntreDosUbicacionesDiferentes() {
		assertEquals(1359.2545257553352, ubicacion1.distanciaHasta(ubicacion2)); // el resultado 1359 son km's
	}

	@Test
	public void testUbicacionesAMenosDe1500km() {
		assertEquals(resultado, ubicacion1.getUbicacionesAMenosDe(1500d, ubicaciones));
	}

	@Test
	void testMuestrasAMenosDe1359KmEnLaZonaDeCobertura() {
		ubicacion1.getZona().agregarMuestra(otraMuestra);
		ubicacion1.getZona().agregarMuestra(otraMuestraMuyLejos);
		assertTrue(ubicacion1.muestrasCercanas(muestra, 1359.2545257553352).contains(otraMuestra)); 
		
	}

}
