package ar.unrn.tp4.modelo;

public class Participantes implements SistemaParticipantes {
	@Override
	public Participante nuevoParticipante(String nombre, String telefono, String region) {
		return new Participante(nombre, telefono, region);
	}
}
