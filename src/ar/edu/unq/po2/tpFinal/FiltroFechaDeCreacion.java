package ar.edu.unq.po2.tpFinal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FiltroFechaDeCreacion implements IFiltroBusquedaMuestra{
	
	private LocalDate fechaCreacion;
	
	public FiltroFechaDeCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	@Override
	public List<Muestra> buscarMuestras(List<Muestra> muestras) {
		List<Muestra> resultadoBusqueda = new ArrayList<Muestra>();
		//muestras.stream().filter(muestra -> muestra.getFechaDeCreacion().equals(this.fechaCreacion));
		for (int i = 0; i < muestras.size(); i++) {
			if(muestras.get(i).getFechaDeCreacion().equals(this.fechaCreacion)) {
				resultadoBusqueda.add(muestras.get(i));
			}
		}
		return resultadoBusqueda;
	}
	
	 
	
	

}
