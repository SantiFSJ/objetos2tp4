package ar.unrn.tp4.modelo;

public class Inscripto {
	private String nombre;
	private String apellido;
	private String telefono;
	private String email;

	public Inscripto(String nombre, String apellido, String telefono, String email) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.email = telefono;
	}

	public String nombre() {
		return nombre;
	}

	public String apellido() {
		return apellido;
	}

	public String telefono() {
		return telefono;
	}

	public String email() {
		return email;
	}

}
