package ar.edu.unq.po2.tpFinal.Observer;

public interface IListenerZonaCobertura {

	public void agregar(IOrganizacionObserver observer);
	public void eliminar(IOrganizacionObserver observer);
	public void notificar();
	
}
