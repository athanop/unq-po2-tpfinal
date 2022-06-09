package ar.edu.unq.po2.tpFinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.awt.image.BufferedImage;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import ar.edu.unq.po2.tpFinal.Enumerativos.Calificacion;
import ar.edu.unq.po2.tpFinal.EstadoDeUsuario.Usuario;
import ar.edu.unq.po2.tpFinal.Ubicaciones.Ubicacion;

class UsuarioTest {

	Usuario usuarioBasico; // sut
	Usuario usuarioExperto; // sut
	Usuario usuarioEspecialista; // sut
	AplicacionWeb app;// doc
	Muestra muestra, muestra2, muestra3, muestra4, muestra5, muestra6, muestra7, muestra8, muestra9, muestra10;
	Ubicacion ubicacion1;
	BufferedImage imagen1;
	Opinion opinion;
	List<Opinion> opiniones;
	Set<Muestra> muestrasEnviadas;
	
	@BeforeEach 
	void setUp() throws Exception { 
	
	app = mock(AplicacionWeb.class);
	usuarioBasico = new Usuario("IdNahuel", app);
	usuarioExperto = new Usuario("IdSofi", app);
	usuarioEspecialista = new Usuario("IdJuli", app);
	opinion = mock(Opinion.class);
	when(opinion.getCalificacion()).thenReturn(Calificacion.GUASAYANA);
	
	when(opinion.getFechaDeEmision()).thenReturn(LocalDate.now());
	}
	 
	
	@Test
	void testEsUnUsuarioBasico() {
		assertTrue(usuarioBasico.esUsuarioBasico());
	}
	
	@Test
	void testNoEsUnUsuarioExperto() {
		assertFalse(usuarioBasico.esUsuarioExperto());
	}
	
	@Test
	void testlaOpinionEstaDentroDe30DiasDeLaFecha() { //esto te lo dejo de tarea juli arreglalo porque quedó horrible
		opiniones = Arrays.asList(opinion,opinion,opinion,opinion,opinion,opinion,opinion,opinion,
								  opinion,opinion,opinion,opinion,opinion,opinion,opinion,opinion,opinion,opinion,opinion,opinion,opinion);

		usuarioBasico.setOpinionesEnviadas(opiniones);
		
		assertEquals(usuarioBasico.cantidadDeOpinionesEnLosUltimos30Dias(), 21);
	}
	
	
	@Test
	void testLasOpinionEstaDentroDe30DiasDeLaFecha() { //esto te lo dejo de tarea juli arreglalo porque quedó horrible
		muestra = mock(Muestra.class);
		muestra2 = mock(Muestra.class);
		muestra3 = mock(Muestra.class);
		muestra4 = mock(Muestra.class);
		muestra5 = mock(Muestra.class);
		muestra6 = mock(Muestra.class);
		muestra7 = mock(Muestra.class);
		muestra8 = mock(Muestra.class);
		muestra9 = mock(Muestra.class);
		muestra10 = mock(Muestra.class);
		
		when(muestra.getFechaDeCreacion()).thenReturn(LocalDate.now());
		when(muestra2.getFechaDeCreacion()).thenReturn(LocalDate.now());
		when(muestra3.getFechaDeCreacion()).thenReturn(LocalDate.now());
		when(muestra4.getFechaDeCreacion()).thenReturn(LocalDate.now());
		when(muestra5.getFechaDeCreacion()).thenReturn(LocalDate.now());
		when(muestra6.getFechaDeCreacion()).thenReturn(LocalDate.now());
		when(muestra7.getFechaDeCreacion()).thenReturn(LocalDate.now());
		when(muestra8.getFechaDeCreacion()).thenReturn(LocalDate.now());
		when(muestra9.getFechaDeCreacion()).thenReturn(LocalDate.now());
		when(muestra10.getFechaDeCreacion()).thenReturn(LocalDate.now());
		
		
		muestrasEnviadas = new HashSet<Muestra>();
		muestrasEnviadas.add(muestra);
		muestrasEnviadas.add(muestra2);
		muestrasEnviadas.add(muestra3);
		muestrasEnviadas.add(muestra4);
		muestrasEnviadas.add(muestra5);
		muestrasEnviadas.add(muestra6);
		muestrasEnviadas.add(muestra7);
		muestrasEnviadas.add(muestra8);
		muestrasEnviadas.add(muestra9);
		muestrasEnviadas.add(muestra10);
		
		usuarioBasico.setMuestras(muestrasEnviadas);
		
		assertEquals(usuarioBasico.cantidadDeEnviosEnLosUltimos30Dias(), 10);
	}
	
	
}

