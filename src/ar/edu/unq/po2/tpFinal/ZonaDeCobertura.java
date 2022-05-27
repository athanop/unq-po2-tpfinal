package ar.edu.unq.po2.tpFinal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ZonaDeCobertura implements IListenerZonaCobertura {

	private String nombreDeZona;
	private Integer epicentro;
	private Integer distanciaEnKms;
	private List<Muestra> muestras;
	private Ubicacion ubicacion; //le agregue esto por el muestras cercanas

	
	
	public ZonaDeCobertura(String nombreDeZona, Integer epicentro, Integer distanciaEnKms, Ubicacion ubicacion) {
		this.nombreDeZona = nombreDeZona;
		this.epicentro = epicentro;
		this.distanciaEnKms = distanciaEnKms;
		this.muestras = new ArrayList<Muestra>();
		this.ubicacion = ubicacion;
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

	public void muestraVerificada(Muestra muestra) {
		this.avisarNuevaVerificacion(muestra);
	}

	private void avisarNuevaVerificacion(Muestra muestra) {
		for (IOrganizacionObserver observer : observers) {
			observer.actualizarNuevaVerificacion(this, muestra);
		}

	}

	private void avisarNuevaMuestra(Muestra muestra) {
		for (IOrganizacionObserver observer : observers) {
			observer.actualizarNuevaMuestra(this, muestra);
		}

	}

	//tengo q terminar de revisar esto para ver como comparar las muestras por el error del hashcode
	public Set<Muestra> muestrasCercanas(Muestra muestra, double distancia) {
		Set<Muestra> retorno = new HashSet<Muestra>();
		for (Muestra m : this.muestras) {
			if (this.ubicacion.distanciaHasta(muestra.getUbicacion()) <= distancia) {
				retorno.add(muestra);
			}
		}
		return retorno;
		
	}
	
	//agrego este metodo para probar las muestras que voy agregando al método muestras cercanas
	public void agregarMuestra(Muestra muestra) {
		this.muestras.add(muestra);
	}
}
