package ar.unrn.tp4.accesos;

import java.io.FileWriter;
import java.io.IOException;

import ar.unrn.tp4.modelo.Inscripto;
import ar.unrn.tp4.modelo.RepositorioInscriptos;

public class EnDiscoRegistroInscripto implements RepositorioInscriptos {

	@Override
	public void guardarInscripto(Inscripto inscripto, String idConcurso) {
		try {
			FileWriter myWriter = new FileWriter("C:\\Users\\santi\\OneDrive\\Escritorio\\inscriptos.txt", true);
			myWriter.write(inscripto.nombre() + ", " + inscripto.apellido() + ", " + inscripto.telefono() + ", "
					+ inscripto.email() + ", " + idConcurso);
			myWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
