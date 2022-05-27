package ar.edu.unq.po2.tpFinal;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.image.BufferedImage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UsuarioTest {

	Usuario usuarioBasico1; // sut
	SistemaMuestra app;// doc
	Muestra muestra;
	Muestra muestra2;
	Ubicacion ubicacion1;
	BufferedImage imagen1;
	Opinion opinion;
/*
	@BeforeEach
	void setUp() throws Exception {
		app = new SistemaMuestra();
		usuarioBasico1 = new UsuarioBasico(app);
		muestra = new Muestra(imagen1, Calificacion.CHINCHE_FOLIADA, ubicacion1, usuarioBasico1);
	}

	@Test
	void testConstructorUsuario() {
		assertEquals(usuarioBasico1.getAplicacion(), app);
	}

	@Test
	void testUsuarioBasicoSubeUnaMuestraALaApp() {
		muestra2 = new Muestra(imagen1, Calificacion.GUASAYANA, ubicacion1, usuarioBasico1);
		usuarioBasico1.enviarMuestra(muestra2);

		assertTrue(usuarioBasico1.subioMuestraAlSistema(muestra2));
	}

	@Test
	void testUsuarioBasicoOpinaUnaFotoDeUnaMuestraYaSubidaEnLaApp() {
		usuarioBasico1.opinar(Calificacion.IMAGEN_POCO_CLARA, muestra);

		assertEquals(muestra.getListEspecieFotografiada().size(), 2);
	}
*/
}

