package ar.unrn.tp4.modelo;

import java.io.IOException;

public class Inscriptos implements SistemaInscriptos {

	@Override
	public Inscripto nuevoInscripto(String nombre, String apellido, String dni, String telefono, String email)
			throws IOException {
		return new Inscripto(nombre, apellido, dni, new Telefono(telefono), new Email(email));
	}

}
