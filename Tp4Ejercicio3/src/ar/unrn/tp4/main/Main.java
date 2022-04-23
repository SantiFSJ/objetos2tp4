package ar.unrn.tp4.main;

import ar.unrn.tp4.accesos.EnDiscoRegistroInscripto;
import ar.unrn.tp4.accesos.LectorDeConcursosEnDisco;
import ar.unrn.tp4.ui.Ui;

public class Main {
	public static void main(String[] args) {
		LectorDeConcursosEnDisco lector = new LectorDeConcursosEnDisco();
		EnDiscoRegistroInscripto registro = new EnDiscoRegistroInscripto();
		Ui ui = new Ui(lector, "C:\\Users\\santi\\OneDrive\\Escritorio\\concursos.txt", registro);
	}

}
