package ar.edu.unq.po2.tpFinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpFinal.Observer.Organizacion;
import ar.edu.unq.po2.tpFinal.Ubicaciones.Ubicacion;
import ar.edu.unq.po2.tpFinal.Ubicaciones.ZonaDeCobertura;

class ZonaDeCoberturaTestCase {

	ZonaDeCobertura zonaDeCobertura, otraZonaDeCobertura;
	Organizacion organizacion;
	Ubicacion ubicacion1, ubicacion2;
	
	
	@BeforeEach
	void setUp() throws Exception {
		ubicacion1 = mock(Ubicacion.class);
		ubicacion2 = mock(Ubicacion.class);
		organizacion = mock(Organizacion.class);
		
	}

	
	@Test
	void testUnaZonaSeNoSolapaConOtraZona(){
		when(ubicacion1.getLatitud()).thenReturn(50d);
		when(ubicacion1.getLongitud()).thenReturn(40d);
		when(ubicacion2.getLatitud()).thenReturn(40d);
		when(ubicacion2.getLongitud()).thenReturn(50d);
		when(ubicacion1.distanciaHasta(ubicacion2)).thenReturn(1360.56d);
		
		zonaDeCobertura = new ZonaDeCobertura("Berazategui", ubicacion1, 500);
		otraZonaDeCobertura = new ZonaDeCobertura("Ezpeleta", ubicacion2, 200);
		
		assertFalse(zonaDeCobertura.seSolapaCon(otraZonaDeCobertura));
	}
	
	@Test
	void testUnaZonaSeSolapaConOtraZona(){
		when(ubicacion1.getLatitud()).thenReturn(300d);
		when(ubicacion1.getLongitud()).thenReturn(300d);
		when(ubicacion2.getLatitud()).thenReturn(299d);
		when(ubicacion2.getLongitud()).thenReturn(299d);
		when(ubicacion1.distanciaHasta(ubicacion2)).thenReturn(124.06d);
		
		zonaDeCobertura = new ZonaDeCobertura("Berazategui", ubicacion1, 500);
		otraZonaDeCobertura = new ZonaDeCobertura("Ezpeleta", ubicacion2, 600);		
		

		assertTrue(zonaDeCobertura.seSolapaCon(otraZonaDeCobertura));
	}

	
	
}
