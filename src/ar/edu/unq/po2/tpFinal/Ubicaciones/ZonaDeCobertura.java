package ar.edu.unq.po2.tpFinal.Ubicaciones;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ar.edu.unq.po2.tpFinal.Muestra;
import ar.edu.unq.po2.tpFinal.Observer.IListenerZonaCobertura;
import ar.edu.unq.po2.tpFinal.Observer.IOrganizacionObserver;

public class ZonaDeCobertura implements IListenerZonaCobertura {

	private String nombreDeZona;
	private Ubicacion epicentro;
	private Integer radio;
	private List<Muestra> muestras;
	private List<IOrganizacionObserver> observers;

	public ZonaDeCobertura(String nombreDeZona, Ubicacion epicentro, Integer radio) {
		this.nombreDeZona = nombreDeZona;
		this.epicentro = epicentro;
		this.radio = radio;
		this.muestras = new ArrayList<Muestra>();
		this.observers = new ArrayList<IOrganizacionObserver>();
	}

	public List<Muestra> getMuestras() {
		return this.muestras;
	}

	public List<IOrganizacionObserver> getObservers() {
		return observers;
	}

	public Ubicacion getEpicentro() {
		return epicentro;
	}

	public Integer getRadio() {
		return radio;
	}

	public Boolean seSolapaCon(ZonaDeCobertura zona) {
		Ubicacion primerUbicacion = this.getEpicentro();
		Ubicacion segundaUbicacion = zona.getEpicentro();

		return (sumarRadios(this, zona) > primerUbicacion.distanciaHasta(segundaUbicacion));
	}

	private Integer sumarRadios(ZonaDeCobertura zonaDeCobertura, ZonaDeCobertura otraZona) {
		return (zonaDeCobertura.getRadio() + otraZona.getRadio());
	}

	@Override
	public void agregar(IOrganizacionObserver observer) {
		this.observers.add(observer);
	}

	@Override
	public void eliminar(IOrganizacionObserver observer) {
		this.observers.remove(observer);
	}

	@Override
	public void notificarNuevaMuestra(Muestra muestra) {
		for (IOrganizacionObserver observer : this.getObservers()) {
			observer.nuevaMuestra(this, muestra);
		}
	}

	public void notificarNuevaVerificacion(Muestra muestra) {
		for (IOrganizacionObserver observer : this.getObservers()) {
			observer.nuevaVerificacion(this, muestra);
		}
	}

	public void agregarMuestra(Muestra muestra) {
		if (this.perteneceAZonaDeCobertura(muestra)) {
			muestras.add(muestra);
			this.notificarNuevaMuestra(muestra);
		}
	}

	public void muestraVerificada(Muestra muestra) {
		this.notificarNuevaVerificacion(muestra);
	}

	private boolean perteneceAZonaDeCobertura(Muestra muestra) {

		return epicentro.distanciaHasta(muestra.getUbicacion()) <= radio;
	}

	public Set<ZonaDeCobertura> zonasQueSolapan(Set<ZonaDeCobertura> zonas) {
		Set<ZonaDeCobertura> zonasQueSolapan = new HashSet<ZonaDeCobertura>();

		for (ZonaDeCobertura zona : zonas) {
			this.agregarSiSeSolapa(zona, zonasQueSolapan);
		}
		return zonasQueSolapan;
	}

	private void agregarSiSeSolapa(ZonaDeCobertura zona, Set<ZonaDeCobertura> zonasQueSolapan) {
		if (seSolapaCon(zona)) {
			zonasQueSolapan.add(zona);
		}
	}
}
