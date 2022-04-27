package ar.unrn.tp4.main;

import java.sql.SQLException;

import ar.unrn.tp4.bd.JDBCEstudiante;
import ar.unrn.tp4.modelo.Participantes;
import ar.unrn.tp4.ui.UI;

public class Main {
	public static void main(String[] args) throws SQLException {
		JDBCEstudiante repositorio = new JDBCEstudiante();
		Participantes interPartic = new Participantes();
		UI ui = new UI(repositorio, interPartic);
	}
}
