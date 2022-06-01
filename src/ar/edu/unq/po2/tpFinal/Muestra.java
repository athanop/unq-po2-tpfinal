package ar.edu.unq.po2.tpFinal;

import java.awt.image.BufferedImage;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BinaryOperator;

import ar.edu.unq.po2.tpFinal.Enumerativos.Calificacion;
import ar.edu.unq.po2.tpFinal.EstadoDeMuestra.EstadoDeMuestra;
import ar.edu.unq.po2.tpFinal.EstadoDeMuestra.EstadoDeMuestraVotada;
import ar.edu.unq.po2.tpFinal.EstadoDeUsuario.Usuario;
import ar.edu.unq.po2.tpFinal.Ubicaciones.Ubicacion;
import ar.edu.unq.po2.tpFinal.Ubicaciones.ZonaDeCobertura;

public class Muestra {

	private BufferedImage fotoVinchuca;
	private Calificacion especie;
	private Usuario usuario;
	private Ubicacion ubicacion;
	private EstadoDeMuestra estadoActual;
	private LocalDate fechaDeCreacion;
	private LocalDate fechaDeUltimaVotacion;
	private Map<Usuario, Opinion> historialDeOpiniones;
	private List<ZonaDeCobertura> zonasDeCobertura;
	

	public Muestra(BufferedImage fotoVinchuca, Ubicacion ubicacion, Usuario usuario, Opinion opinion,
			LocalDate fechaDeCreacion) throws Exception {

		this.fotoVinchuca = fotoVinchuca;
		this.ubicacion = ubicacion;
		this.usuario = usuario;
		this.estadoActual = new EstadoDeMuestraVotada();
		this.zonasDeCobertura = new ArrayList<ZonaDeCobertura>();
		this.historialDeOpiniones = new HashMap<Usuario, Opinion>();
		this.agregarLaOpinionDelUsuario(opinion, usuario);
		this.fechaDeCreacion = fechaDeCreacion;
		this.fechaDeUltimaVotacion = fechaDeCreacion;
	}
	
	public LocalDate getFechaDeCreacion() {
		return this.fechaDeCreacion;
	}

	public Map<Usuario, Opinion> getHistorialDeOpiniones() {
		return this.historialDeOpiniones;
	}
	
	public LocalDate getFechaUltimaVotacion() {
		return this.fechaDeUltimaVotacion;
	}
	
	public Calificacion getEspecieDeVinchuca() {
		return especie;
	}


	public BufferedImage getFotoVinchuca() {
		return this.fotoVinchuca;
	}

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public String getIdentificacionPropietarioDeLaMuestra() {
		return this.usuario.getIdentificacion();
	}

	public EstadoDeMuestra getEstadoMuestra() {
		return estadoActual;
	}

	public void setEstadoDeMuestra(EstadoDeMuestra estado) {
		this.estadoActual = estado;
	}

	public List<ZonaDeCobertura> getZonasDeCobertura() {
		return this.zonasDeCobertura;
	}


	public void agregarZonaDeCobertura(ZonaDeCobertura zona) {
		this.zonasDeCobertura.add(zona);
	}

	
	public void verificarMuestra() throws Exception {
		this.estadoActual.actualizarEstado(this);
	}

	public String getNivelDeVerificacion() {
		return this.getEstadoMuestra().getNivelDeVerificacion(this);
	}
	
	public void muestrasCercanas(Muestra muestra, double distancia) {
		this.ubicacion.muestrasCercanas(muestra, distancia);
	}

	public void avisarVerificacionAZonasDeCobertura() {
		for (ZonaDeCobertura zona : this.zonasDeCobertura) {
			zona.muestraVerificada(this);
		}
	}

	
	public boolean contieneAlUsuario(Usuario usuario) {
		return this.historialDeOpiniones.containsKey(usuario);
	}

	public boolean contieneLaOpinion(Opinion opinion) {
		return this.historialDeOpiniones.containsValue(opinion);
	}
	
	
	public void agregarLaOpinionDelUsuario(Opinion opinion, Usuario usuario) {
		this.historialDeOpiniones.put(usuario, opinion);
		this.actualizarFechaUltimaVotacion(opinion);
		usuario.agregarOpinionEnviada(opinion);
	}
	
	private void actualizarFechaUltimaVotacion(Opinion opinion) {
		this.fechaDeUltimaVotacion = opinion.getFechaDeEmision();
	}
	//es el objetoSistemaMuestra para mejorar
	

	public List<Calificacion> getCalificacionDeOpiniones() {
		ArrayList<Calificacion> opiniones = new ArrayList<Calificacion>(); //esto es lo que cambié 
		for (HashMap.Entry<Usuario, Opinion> opinionDeUsuario : this.getHistorialDeOpiniones().entrySet()) {
			opiniones.add((opinionDeUsuario.getValue()).getCalificacion());
		}
		return opiniones;
	}
	
	public boolean coincidenDosExpertosEnSuCalificacionDeOpinion() {
		final Set<Calificacion> calificacionDeOpiniones = new HashSet<Calificacion>();
		boolean retorno = false;
		for (Calificacion calificacion: getCalificacionDeOpiniones()) {
			retorno |= !calificacionDeOpiniones.add(calificacion);
		}
		return retorno;
	}

	public Calificacion getResultadoActual() { //también cambié esto
		Calificacion opinionMasVotada = getCalificacionDeOpiniones().stream().reduce(BinaryOperator.maxBy((o1, o2) -> Collections.frequency(getCalificacionDeOpiniones(), o1) - 
				Collections.frequency(getCalificacionDeOpiniones(), o2)))
				.orElse(Calificacion.NO_DEFINIDO);
		return (opinionMasVotada); 
	}
	


}
