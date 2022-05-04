package ar.unrn.tp4.modelo;

import java.io.IOException;

public class Inscripto {
	private String nombre;
	private String apellido;
	private String dni;
	private Telefono telefono;
	private Email email;

	public Inscripto(String nombre, String apellido, String dni, Telefono telefono2, Email email2) throws IOException {
		validar(nombre, apellido, dni);
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.telefono = telefono2;
		this.email = email2;
	}

	private void validar(String nombre, String apellido, String dni) throws IOException {
		if ("".equals(nombre))
			throw new IOException("Nombre no puede ser vacio");
		if ("".equals(apellido))
			throw new IOException("apellido no puede ser vacio");
		if ("".equals(dni))
			throw new IOException("dni no puede ser vacio");

	}

	public String nombre() {
		return nombre;
	}

	public String apellido() {
		return apellido;
	}

	public Telefono telefono() {
		return telefono;
	}

	public Email email() {
		return email;
	}

}
