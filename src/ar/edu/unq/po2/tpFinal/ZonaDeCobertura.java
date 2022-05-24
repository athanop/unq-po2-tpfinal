package ar.edu.unq.po2.tpFinal;

import java.util.List;

public class ZonaDeCobertura implements IListenerZonaCobertura{

	private String nombreDeZona;
	private Integer epicentro;
	private Integer distanciaEnKms;
	private List<Muestra> muestras;
	
	
	
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
	
	
	
}
