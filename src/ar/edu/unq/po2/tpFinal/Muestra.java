package ar.edu.unq.po2.tpFinal;

import java.awt.image.BufferedImage;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.function.BinaryOperator;

public class Muestra {

	private BufferedImage fotoVinchuca;
	private Ubicacion ubicacion;
	private Usuario usuario;
	private EstadoDeMuestra estadoActual;
	private ArrayList<ZonaDeCobertura> zonasDeCobertura;
	private Opinion opinion;
	private LinkedHashMap<Usuario, Opinion> historialDeOpiniones;
	private LocalDate fechaDeCreacion;
	private LocalDate fechaDeUltimaVotacion;

	public Muestra(BufferedImage fotoVinchuca, Ubicacion ubicacion, Usuario usuario, Opinion opinion,
			LocalDate fechaDeCreacion) throws Exception {

		this.fotoVinchuca = fotoVinchuca;
		this.ubicacion = ubicacion;
		this.usuario = usuario;
		this.estadoActual = new EstadoDeMuestraVotada();
		this.zonasDeCobertura = new ArrayList<ZonaDeCobertura>();
		this.opinion = opinion;
		this.historialDeOpiniones = new LinkedHashMap<Usuario, Opinion>();
		this.agregarLaOpinionDelUsuario(opinion, usuario);
		this.fechaDeCreacion = fechaDeCreacion;
		this.fechaDeUltimaVotacion = fechaDeCreacion;
	}

	public BufferedImage getFotoVinchuca() {
		return this.fotoVinchuca;
	}

	public String getEspecieDeVinchuca() {
		return this.opinion.getCalificacion();
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

	public LocalDate getFechaDeCreacion() {
		return this.fechaDeCreacion;
	}

	public LinkedHashMap<Usuario, Opinion> getHistorialDeOpiniones() {
		return this.historialDeOpiniones;
	}

	public EstadoDeMuestra getEstadoMuestra() {
		return estadoActual;
	}

	protected void setEstadoDeMuestra(EstadoDeMuestra estado) {
		this.estadoActual = estado;
	}

	public LocalDate getFechaUltimaVotacion() {
		return this.fechaDeUltimaVotacion;
	}

	public ArrayList<ZonaDeCobertura> getZonasDeCobertura() {
		return this.zonasDeCobertura;
	}

	private void actualizarFechaUltimaVotacion(Opinion opinion) {
		this.fechaDeUltimaVotacion = opinion.getFechaDeEmision();
	}

	public void agregarZonaDeCobertura(ZonaDeCobertura zona) {
		this.zonasDeCobertura.add(zona);
	}

	public void agregarOpinion(Opinion opinion, Usuario usuario) throws Exception {
		this.estadoActual.agregarOpinion(this, opinion, usuario);
	}

	public void agregarLaOpinionDelUsuario(Opinion opinion, Usuario usuario) {
		this.historialDeOpiniones.put(usuario, opinion);
		this.actualizarFechaUltimaVotacion(opinion);
		usuario.agregarOpinionEnviada(opinion);
	}

	public void verificarMuestra() throws Exception {
		this.estadoActual.actualizarEstado(this);
	}

	public void muestrasCercanas(Muestra muestra, double distancia) {
		this.ubicacion.muestrasCercanas(muestra, distancia);
	}

	protected void avisarVerificacionAZonasDeCobertura() {
		for (ZonaDeCobertura zona : this.zonasDeCobertura) {
			zona.muestraVerificada(this);
		}
	}

	public ArrayList<String> getOpiniones() {
		ArrayList<String> opiniones = new ArrayList<String>();
		for (HashMap.Entry<Usuario, Opinion> opinionDeUsuario : historialDeOpiniones.entrySet()) {
			opiniones.add((opinionDeUsuario.getValue()).getCalificacion());
		}
		return opiniones;
	}

	public boolean contieneAlUsuario(Usuario usuario) {
		return this.historialDeOpiniones.containsKey(usuario);
	}

	public boolean contieneLaOpinion(Opinion opinion) {
		return this.historialDeOpiniones.containsValue(opinion);
	}

	public boolean coincidenDosExpertosEnSuOpinion() {
		final Set<String> opiniones = new HashSet<String>();
		boolean retorno = false;
		for (String opinion : getOpiniones()) {
			retorno |= !opiniones.add(opinion);
		}
		return retorno;
	}

	public String getResultadoActual() {
		String opinionMasVotada = getOpiniones().stream().reduce(BinaryOperator.maxBy(
				(o1, o2) -> Collections.frequency(getOpiniones(), o1) - Collections.frequency(getOpiniones(), o2)))
				.orElse("No Definido");
		return (opinionMasVotada);
	}

//	private Calificacion resultadoActualVotosPorOpinionEnMuestra() {
//		Calificacion resultadoActual = this.listEspecieFotografiada.get(0);
	/*
	 * faltaria aplicar la logica de obtener la calificacion que más votos tiene y
	 * retornarla
	 */
//		return resultadoActual; // en caso de que sólo hay un voto para una calificacion, la retorna
//	}

//	private Boolean hayMasDeUnVotoEnMuestra() {
//		return this.getListEspecieFotografiada().size() >= 1;
//	}

}
