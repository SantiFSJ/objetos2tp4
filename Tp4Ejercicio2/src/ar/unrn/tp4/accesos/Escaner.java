package ar.unrn.tp4.accesos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;

import ar.unrn.tp4.modelo.Empleado;
import ar.unrn.tp4.modelo.RepositorioEmpleados;

public class Escaner {

	private RepositorioEmpleados repo;

	public Escaner() {
	}

	public Escaner(RepositorioEmpleados repo) {
		this.repo = repo;
	}

	public void leerArchivo(String filename) throws IOException {

		List<String> fileData = Files.readAllLines(Paths.get(filename));

		ArrayList<Empleado> listaEmpleados = new ArrayList<>();

		for (String s : fileData) {
			String[] camposFila = s.split(",");
			listaEmpleados.add(new Empleado(camposFila[0], camposFila[1], camposFila[2], camposFila[3]));
		}

		try {
			repo.evaluarCumpleañosEmpleados(listaEmpleados);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
