package ar.edu.unq.po2.tpFinal;

public interface IListenerZonaCobertura {

	public void agregar(IOrganizacionObserver observer);
	public void eliminar(IOrganizacionObserver observer);
	public void notificar();
	
}
