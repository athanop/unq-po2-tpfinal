package ar.edu.unq.po2.tpFinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpFinal.Enumerativos.tipoDeOrganizacion;
import ar.edu.unq.po2.tpFinal.Observer.IFuncionalidadExterna;
import ar.edu.unq.po2.tpFinal.Observer.Organizacion;
import ar.edu.unq.po2.tpFinal.Ubicaciones.Ubicacion;
import ar.edu.unq.po2.tpFinal.Ubicaciones.ZonaDeCobertura;

class OrganizacionTestCase {
	
	Organizacion organizacion;
	ZonaDeCobertura zona1;
	ZonaDeCobertura zona2;
	ZonaDeCobertura zona3;
	Ubicacion ubicacion;
	IFuncionalidadExterna nuevaMuestra;
	IFuncionalidadExterna verificacionMuestra;

	@BeforeEach
	void setUp() throws Exception {
		ubicacion = mock(Ubicacion.class);
		zona1 = mock(ZonaDeCobertura.class);
		zona2 = mock(ZonaDeCobertura.class);
		zona3 = mock(ZonaDeCobertura.class);
		organizacion = new Organizacion(ubicacion, tipoDeOrganizacion.SALUD, 5, nuevaMuestra, verificacionMuestra);
	}

	@Test
	void testConstructorOrganizacion() {
		assertEquals(organizacion.getCantidadDePersonas(), 5);
		assertEquals(organizacion.getTipo(), tipoDeOrganizacion.SALUD);
		assertEquals(organizacion.getUbicacion(), ubicacion);
	}
	
	
	
	

}
