package ar.edu.unq.po2.tpFinal.Observer;

import ar.edu.unq.po2.tpFinal.Muestra;
import ar.edu.unq.po2.tpFinal.Enumerativos.tipoDeOrganizacion;
import ar.edu.unq.po2.tpFinal.Ubicaciones.Ubicacion;
import ar.edu.unq.po2.tpFinal.Ubicaciones.ZonaDeCobertura;

public class Organizacion implements IOrganizacionObserver{

	private Ubicacion ubicacion;
	private tipoDeOrganizacion tipo;
	private Integer cantidadDePersonas;

	@Override
	public void nuevoEvento(Organizacion organizacion, ZonaDeCobertura zona, Muestra muestra) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	
}
