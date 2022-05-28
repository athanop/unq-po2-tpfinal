package ar.edu.unq.po2.tpFinal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ZonaDeCobertura implements IListenerZonaCobertura {

	private String nombreDeZona;
	private Integer epicentro;
	private Integer radio;
	private List<Muestra> muestras;
	
	public List<Muestra> getMuestras() {
		return this.muestras;
	}
	
	
	public ZonaDeCobertura(String nombreDeZona, Integer epicentro, Integer radio) {
		this.nombreDeZona = nombreDeZona;
		this.epicentro = epicentro;
		this.radio = radio;
		this.muestras = new ArrayList<Muestra>();
	}

	public Boolean seSolapaCon(ZonaDeCobertura zona) {
		return null;
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


	public String getNombreDeZona() {
		return nombreDeZona;
	}


	public Integer getEpicentro() {
		return epicentro;
	}


	public Integer getRadio() {
		return radio;
	}

	
}
