package ar.unrn.tp4.main;

import java.io.IOException;

import javax.mail.MessagingException;

import ar.unrn.tp4.accesos.Escaner;
import ar.unrn.tp4.servicios.BirthdayEmailSender;

public class Main {
	public static void main(String[] args) throws IOException, MessagingException {
		BirthdayEmailSender emailSender = new BirthdayEmailSender();
		Escaner escaner = new Escaner(emailSender);
		escaner.leerArchivo("C:\\Users\\santi\\OneDrive\\Escritorio\\listaEmpleados.txt");
	}
}
