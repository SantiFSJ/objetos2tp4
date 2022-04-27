package ar.unrn.tp4.main;

import ar.unrn.tp4.accesos.EnBaseDeDatosRegistroInscripto;
import ar.unrn.tp4.accesos.JDBCConcurso;
import ar.unrn.tp4.ui.Ui;

public class Main {
	public static void main(String[] args) {
		// LectorDeConcursosEnDisco lector = new LectorDeConcursosEnDisco();
		// EnDiscoRegistroInscripto registro = new EnDiscoRegistroInscripto();
		JDBCConcurso lector = new JDBCConcurso();
		EnBaseDeDatosRegistroInscripto registro = new EnBaseDeDatosRegistroInscripto();
		Ui ui = new Ui(lector, registro);

	}

}
