package ar.edu.unq.po2.tpFinal;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UbicacionTestCase {

	Ubicacion ubicacion1, ubicacion2, ubicacion3, ubicacion4;
	List<Ubicacion> ubicaciones, resultado;
	
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
	
}
