package ar.unrn.tp4.modelo;

import java.io.IOException;

public class Participante {
	private String nombre;
	private Telefono telefono;
	private String region;

	public Participante(String nombre, Telefono telefono, String region) throws IOException {
		this.validar(nombre, region);
		this.nombre = nombre;
		this.telefono = telefono;
		this.region = region;
	}

	private void validar(String nombre, String region) throws IOException {
		if (nombre.equals(""))
			throw new IOException("Debe Cargar Un Nombre");
		if (!region.equals("China") && !region.equals("US") && !region.equals("Europa"))
			throw new IOException("Region desconocida. Las conocidas son: China, US, Europa");
	}

	public String nombre() {
		return nombre;
	}

	public Telefono telefono() {
		return telefono;
	}

	public String region() {
		return region;
	}

}
