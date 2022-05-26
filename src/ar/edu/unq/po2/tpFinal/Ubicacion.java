package ar.edu.unq.po2.tpFinal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Ubicacion {

	private Double latitud;
	private Double longitud;

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

	public Ubicacion(Double latitud, Double longitud) {
		this.latitud = latitud;
		this.longitud = longitud;
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

	public Boolean ubicacionEstaAMenosDe(Double kilometros, Ubicacion ubicacion) {
		return this.distanciaHasta(ubicacion) < kilometros;
	}

	public Double medirDistancias(Ubicacion ubicacion2) {
		return medirDistanciasEntreUbicaciones(this.getLatitud(), this.getLongitud(), ubicacion2.getLatitud(),
				ubicacion2.getLongitud());
	}

	private Double medirDistanciasEntreUbicaciones(double lat1, double lng1, double lat2, double lng2) {
		// double radioTierra = 3958.75;//millas
		double radioTierra = 6371;// kilometers
		double dLat = Math.toRadians(lat2 - lat1);
		double dLng = Math.toRadians(lng2 - lng1);
		double sindLat = Math.sin(dLat / 2);
		double sindLng = Math.sin(dLng / 2);
		double va1 = Math.pow(sindLat, 2)
				+ Math.pow(sindLng, 2) * Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2));
		double va2 = 2 * Math.atan2(Math.sqrt(va1), Math.sqrt(1 - va1));
		double distancia = radioTierra * va2;

		return Math.abs(distancia);
	}

	public Set<Muestra> muestrasCercanas(Set<Muestra> muestras, double distancia) {
		Set<Muestra> retorno = new HashSet<Muestra>();
		for (Muestra muestra : muestras) {
			if (this.medirDistancias(muestra.getUbicacion()) <= distancia) {
				retorno.add(muestra);
			}
		}
		return retorno;
	}

}
