package ar.edu.unq.po2.tpFinal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Ubicacion {

	private Double latitud;
	private Double longitud;
	private ZonaDeCobertura zona; 

	public Double getLatitud() {
		return latitud;
	}

	public Double getLongitud() {
		return longitud;
	}

	public Ubicacion() {
		this.latitud = 0d;
		this.longitud = 0d;
	}

	public Ubicacion(Double latitud, Double longitud, ZonaDeCobertura zona) {
		this.latitud = latitud;
		this.longitud = longitud;
		this.zona = zona;
	}

	public Double distanciaHasta(Ubicacion ubicacion) {
		return this.distanciaCoordenada(this.getLatitud(), this.getLongitud(), ubicacion.getLatitud(),
				ubicacion.getLongitud());
	}

	private Double distanciaCoordenada(Double latitud1, Double longitud1, Double latitud2, Double longitud2) {
		Double radioTierra = 6371d;
		Double dLat = Math.toRadians(latitud2 - latitud1);
		Double dLng = Math.toRadians(longitud2 - longitud1);
		Double sindLat = Math.sin(dLat / 2);
		Double sindLng = Math.sin(dLng / 2);
		Double va1 = Math.pow(sindLat, 2)
				+ Math.pow(sindLng, 2) * Math.cos(Math.toRadians(latitud1)) * Math.cos(Math.toRadians(latitud2));
		Double va2 = 2 * Math.atan2(Math.sqrt(va1), Math.sqrt(1 - va1));
		Double distancia = radioTierra * va2;
		return distancia;
	}

	public List<Ubicacion> getUbicacionesAMenosDe(Double kilometros, List<Ubicacion> ubicaciones) {
		ArrayList<Ubicacion> resultado = new ArrayList<Ubicacion>();
		for (Ubicacion ubicacion : ubicaciones) {
			if (this.ubicacionEstaAMenosDe(kilometros, ubicacion)) {
				resultado.add(ubicacion);
			}
		}
		return resultado;
	}

	public ZonaDeCobertura getZona() {
		return zona;
	}

	public Boolean ubicacionEstaAMenosDe(Double kilometros, Ubicacion ubicacion) {
		return this.distanciaHasta(ubicacion) < kilometros;
	}


	
	public Set<Muestra> muestrasCercanas(Muestra muestra, double distancia) {
		Set<Muestra> muestrascercanas = new HashSet<Muestra>();
		for (Muestra m : this.zona.getMuestras()) {
			if (m.getUbicacion().distanciaHasta(muestra.getUbicacion()) <= distancia) {
					muestrascercanas.add(m);
			}
		}
			return muestrascercanas;
		}

}
