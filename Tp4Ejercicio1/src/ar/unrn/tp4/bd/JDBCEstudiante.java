package ar.unrn.tp4.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ar.unrn.tp4.modelo.Participante;
import ar.unrn.tp4.modelo.RepositorioParticipantes;

public class JDBCEstudiante implements RepositorioParticipantes {
	private Connection dbConn;

	private static String url = "jdbc:mysql://localhost:3306/objetos2_tp4";
	protected static String user = "root";
	protected static String password = "";

	@Override
	public void nuevoParticipante(Participante p) throws SQLException {
		/*
		 * String url = "jdbc:derby://localhost:1527/participantes"; String user =
		 * "app"; String password = "app";
		 */

		this.dbConn = DriverManager.getConnection(url, user, password);

		PreparedStatement st = dbConn
				.prepareStatement("insert into participantes(nombre, telefono, region)values(?,?,?)");
		try {
			st.setString(1, p.nombre());
			st.setString(2, p.telefono());
			st.setString(3, p.region());
			st.executeUpdate();
		} finally {
			st.close();
		}

	}
}
