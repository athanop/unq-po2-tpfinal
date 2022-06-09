package ar.edu.unq.po2.tpFinal.Observer;

import ar.edu.unq.po2.tpFinal.Muestra;

public interface IListenerZonaCobertura {

	public void agregar(IOrganizacionObserver observer);
	public void eliminar(IOrganizacionObserver observer);
	public void notificarNuevaMuestra(Muestra muestra);
	
}
