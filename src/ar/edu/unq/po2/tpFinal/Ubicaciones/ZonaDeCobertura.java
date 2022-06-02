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
	
	
	public ZonaDeCobertura(String nombreDeZona, Ubicacion epicentro, Integer radio) {
		this.nombreDeZona = nombreDeZona;
		this.epicentro = epicentro;
		this.radio = radio;
		this.muestras = new ArrayList<Muestra>();
	}

	public List<Muestra> getMuestras() {
		return this.muestras;
	}

	public String getNombreDeZona() {
		return nombreDeZona;
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
		return(zonaDeCobertura.getRadio() + otraZona.getRadio());
	}

	
	
	@Override
	public void agregar(IOrganizacionObserver observer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminar(IOrganizacionObserver observer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void notificar() {
		// TODO Auto-generated method stub

	}

	//public void muestraVerificada(Muestra muestra) {
	//	this.avisarNuevaVerificacion(muestra);
	//}

	//private void avisarNuevaVerificacion(Muestra muestra) {
	//	for (IOrganizacionObserver observer : observers) {
	//		observer.actualizarNuevaVerificacion(this, muestra);
	//	}

//	}

	//private void avisarNuevaMuestra(Muestra muestra) {
	//	for (IOrganizacionObserver observer : observers) {
	//		observer.actualizarNuevaMuestra(this, muestra);
	//	}

	//}

	
	//agrego este metodo para probar las muestras que voy agregando al método muestras cercanas
	public void agregarMuestra(Muestra muestra) {
		this.getMuestras().add(muestra);
	}



	public void muestraVerificada(Muestra muestra) {
		// TODO Auto-generated method stub
		
	}

	
	
}
