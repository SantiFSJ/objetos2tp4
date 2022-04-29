package ar.unrn.tp4.modelo;

import java.io.IOException;

public class Participantes implements SistemaParticipantes {
	@Override
	public Participante nuevoParticipante(String nombre, String telefono, String region) throws IOException {
		return new Participante(nombre, new Telefono(telefono), region);
	}
}
