package ar.unrn.tp4.accesos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ar.unrn.tp4.modelo.Inscripto;
import ar.unrn.tp4.modelo.RepositorioInscriptos;

public class EnBaseDeDatosRegistroInscripto implements RepositorioInscriptos {

	@Override
	public void guardarInscripto(Inscripto inscripto, String idConcurso) {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement statement = conn.prepareStatement(
					"INSERT INTO inscriptos(apellido,nombre,telefono,email,id_concurso) " + "VALUES (?,?,?,?,?)");
			statement.setString(1, inscripto.apellido());
			statement.setString(2, inscripto.nombre());
			statement.setString(3, inscripto.telefono().telefono());
			statement.setString(4, inscripto.email().email());
			statement.setString(5, idConcurso);
			statement.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException("No se puedo conectar a la base de datos");
		} finally {
			ConnectionManager.disconnect();
		}
	}

}
