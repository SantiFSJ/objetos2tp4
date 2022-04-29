package ar.unrn.tp4.modelo;

import java.io.IOException;

public class Telefono {
	private String telefono;

	public Telefono(String telefono) throws IOException {
		validar(telefono);
		this.telefono = telefono;
	}

	private void validar(String telefono) throws IOException {
		if (telefono.equals("")) {
			throw new IOException("Debe Cargar Un Telefono");
		}
		if (!validarTelefono(telefono)) {
			throw new IOException("El teléfono debe ingresarse de la siguiente forma: NNNN-NNNNNN");
		}

	}

	private boolean validarTelefono(String telefono) {
		String regex = "\\d{4}-\\d{6}";
		return telefono.matches(regex);
	}

	public String telefono() {
		return telefono;
	}
}
