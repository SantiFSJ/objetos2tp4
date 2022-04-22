package ar.unrn.tp4.modelo;

import java.sql.SQLException;

public interface RepositorioParticipantes {
	void nuevoParticipante(Participante participante) throws SQLException;
}
