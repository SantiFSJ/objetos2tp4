package ar.unrn.tp4.modelo;

import java.io.IOException;

public interface SistemaInscriptos {
	Inscripto nuevoInscripto(String nombre, String apellido, String dni, String telefono, String email)
			throws IOException;
}
