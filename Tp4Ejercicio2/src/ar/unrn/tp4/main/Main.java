package ar.unrn.tp4.main;

import java.io.IOException;

import javax.mail.MessagingException;

import ar.unrn.tp4.accesos.Escaner;
import ar.unrn.tp4.modelo.CumpleEmpleado;
import ar.unrn.tp4.webServices.BirthdayEmailSender;

public class Main {
	public static void main(String[] args) throws IOException, MessagingException {
		BirthdayEmailSender emailSender = new BirthdayEmailSender();
		Escaner escaner = new Escaner("C:\\Users\\santi\\OneDrive\\Escritorio\\listaEmpleados.txt");

		CumpleEmpleado ce = new CumpleEmpleado(escaner, emailSender);
		ce.run();
	}
}
