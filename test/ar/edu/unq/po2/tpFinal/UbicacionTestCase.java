package ar.edu.unq.po2.tpFinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UbicacionTestCase {

	Ubicacion ubicacion1, ubicacion2, ubicacion3, ubicacion4;
	List<Ubicacion> ubicaciones, resultado;
	Muestra muestra;
	Muestra otraMuestraA1200KM;
	Muestra otraMuestraA500km;
	
	@BeforeEach
	void setUp() throws Exception {
		ubicacion1 = new Ubicacion(50d, 40d);
		ubicacion2 = new Ubicacion(40d, 50d);
		ubicacion3 = new Ubicacion(10d, 20d);
		ubicacion4 = new Ubicacion();
		ubicaciones = new ArrayList<Ubicacion>();
		ubicaciones.add(ubicacion2);
		ubicaciones.add(ubicacion3);
		resultado = new ArrayList<Ubicacion>();
		resultado.add(ubicacion2);
		ubicacion1 = mock(Ubicacion.class);
		ubicacion2 = mock(Ubicacion.class);
		muestra = mock(Muestra.class);
		otraMuestraA1200KM = mock(Muestra.class);
		otraMuestraA500km = mock(Muestra.class);
		when(ubicacion1.getLatitud()).thenReturn(30d);
		when(ubicacion1.getLongitud()).thenReturn(30d);
		when(otraMuestraA1200KM.getUbicacion()).thenReturn(ubicacion1); //ubicacion 30 30
		when(muestra.getUbicacion()).thenReturn(ubicacion1); //ubicacion 30 30
		when(ubicacion2.getLatitud()).thenReturn(30d);
		when(ubicacion2.getLongitud()).thenReturn(25d);
		when(otraMuestraA500km.getUbicacion()).thenReturn(ubicacion2);
		
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
		assertEquals(1359.2545257553352, ubicacion1.distanciaHasta(ubicacion2)); //el resultado 1359 son km's
	}
	
	@Test
	public void testUbicacionesAMenosDe1500km() {
		assertEquals(resultado, ubicacion1.getUbicacionesAMenosDe(1500d, ubicaciones)); 
	}
	
	//esto lo tenemos que revisar
	@Test
	void testMuestrasAMenosDe500KmEnLaZonaDeCobertura() {
		zonaDeCobertura.agregarMuestra(otraMuestraA1200KM);
		zonaDeCobertura.agregarMuestra(otraMuestraA500km);
		assertEquals(zonaDeCobertura.muestrasCercanas(muestra, 500d), otraMuestraA500km); //deberia poder compararlos pero devuelven diferente hashcode
	}
}
