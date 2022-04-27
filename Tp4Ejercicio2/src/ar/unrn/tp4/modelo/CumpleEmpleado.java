package ar.unrn.tp4.modelo;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.mail.MessagingException;

import ar.unrn.tp4.webServices.BirthdayEmailSender;

public class CumpleEmpleado {

	private RepositorioEmpleados repo;
	private Mandador mandador;

	public CumpleEmpleado(RepositorioEmpleados repo, BirthdayEmailSender mandador) {
		this.repo = repo;
		this.mandador = mandador;

		try {
			this.run();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void run() throws IOException {

		List<Empleado> empleados = repo.leerArchivo();

		for (Empleado e : empleados) {
			if (e.evaluarCumple(LocalDate.now())) {
				try {
					mandador.mandarEmail(e.nombre(), e.correoElectronico());
				} catch (MessagingException e1) {
					// TODO Auto-generated catch block
					throw new RuntimeException(e1);
				}
			}
		}
	}
}
