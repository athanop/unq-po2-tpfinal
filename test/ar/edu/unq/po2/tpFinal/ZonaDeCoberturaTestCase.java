package ar.edu.unq.po2.tpFinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ZonaDeCoberturaTestCase {

	ZonaDeCobertura zonaDeCobertura;
	Organizacion organizacion;
	Ubicacion ubicacion;
	Ubicacion ubicacion2;
	Muestra muestra;
	Muestra otraMuestraA1200KM;
	Muestra otraMuestraA500km;
	
	
	@BeforeEach
	void setUp() throws Exception {
		
		organizacion = mock(Organizacion.class);
		ubicacion = mock(Ubicacion.class);
		ubicacion2 = mock(Ubicacion.class);
		muestra = mock(Muestra.class);
		otraMuestraA1200KM = mock(Muestra.class);
		otraMuestraA500km = mock(Muestra.class);
		when(ubicacion.getLatitud()).thenReturn(30d);
		when(ubicacion.getLongitud()).thenReturn(30d);
		when(otraMuestraA1200KM.getUbicacion()).thenReturn(ubicacion);
		when(ubicacion2.getLatitud()).thenReturn(30d);
		when(ubicacion2.getLongitud()).thenReturn(25d);
		when(otraMuestraA500km.getUbicacion()).thenReturn(ubicacion2);
		zonaDeCobertura = new ZonaDeCobertura("Berazategui", 500, 1500, ubicacion);
	}

	@Test
	void testMuestrasAMenosDe500KmEnLaZonaDeCobertura() {
		zonaDeCobertura.agregarMuestra(otraMuestraA1200KM);
		zonaDeCobertura.agregarMuestra(otraMuestraA500km);
		assertEquals(zonaDeCobertura.muestrasCercanas(muestra, 500d), otraMuestraA500km); //deberia poder compararlos pero devuelven diferente hashcode
	}

}
