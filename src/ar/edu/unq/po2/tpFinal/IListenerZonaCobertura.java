package ar.edu.unq.po2.tpFinal;

public interface IListenerZonaCobertura {

	public void añadir(IOrganizacionObserver observer);
	public void eliminar(IOrganizacionObserver observer);
	public void notificar();
	
}
