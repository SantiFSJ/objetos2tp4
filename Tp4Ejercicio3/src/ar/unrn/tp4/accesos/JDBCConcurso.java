package ar.unrn.tp4.accesos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ar.unrn.tp4.modelo.Concurso;
import ar.unrn.tp4.modelo.LectorConcursos;

public class JDBCConcurso implements LectorConcursos {

	@Override
	public ArrayList<Concurso> leerConcuros() throws IOException {
		ArrayList<Concurso> concursos = new ArrayList<>();
		try {
			Connection conn = ConnectionManager.getConnection();
			Statement statement = conn.createStatement();
			ResultSet ResultSetConcursos = statement.executeQuery("SELECT * from concursos");

			while (ResultSetConcursos.next()) {
				concursos.add(new Concurso(Integer.toString(ResultSetConcursos.getInt("id_concurso")),
						ResultSetConcursos.getString("nombre"),
						ResultSetConcursos.getDate("fecha_inicio_inscripcion").toLocalDate(),
						ResultSetConcursos.getDate("fecha_fin_inscripcion").toLocalDate()));
			}
		} catch (SQLException e) {
			throw new RuntimeException("Error al encontrar los beneficios: " + e.getMessage());
		} finally {
			ConnectionManager.disconnect();
		}
		return concursos;
	}

}
