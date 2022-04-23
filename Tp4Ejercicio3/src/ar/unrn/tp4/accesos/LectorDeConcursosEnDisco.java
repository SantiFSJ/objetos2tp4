package ar.unrn.tp4.accesos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ar.unrn.tp4.modelo.Concurso;
import ar.unrn.tp4.modelo.LectorConcursos;

public class LectorDeConcursosEnDisco implements LectorConcursos {

	@Override
	public ArrayList<Concurso> leerConcuros(String filename) throws IOException {
		List<String> fileData = Files.readAllLines(Paths.get(filename));

		ArrayList<Concurso> listaConcursos = new ArrayList<>();

		for (String s : fileData) {
			String[] camposFila = s.split(",");

			String[] camposFechaIni = camposFila[2].split("/");
			LocalDate fechaIni = LocalDate.of(Integer.parseInt(camposFechaIni[0]), Integer.parseInt(camposFechaIni[1]),
					Integer.parseInt(camposFechaIni[2]));

			String[] camposFechaFin = camposFila[3].split("/");
			LocalDate fechaFin = LocalDate.of(Integer.parseInt(camposFechaFin[0]), Integer.parseInt(camposFechaFin[1]),
					Integer.valueOf(camposFechaFin[2]));

			listaConcursos.add(new Concurso(camposFila[0], camposFila[1], fechaIni, fechaFin));
		}

		return listaConcursos;
	}

}
