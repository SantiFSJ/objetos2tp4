package ar.unrn.tp4.modelo;

import java.io.IOException;

public interface SistemaParticipantes {
	Participante nuevoParticipante(String nombre, String telefono, String region) throws IOException;
}
