package ar.unrn.tp4.servicios;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import ar.unrn.tp4.modelo.Empleado;
import ar.unrn.tp4.modelo.RepositorioEmpleados;

public class BirthdayEmailSender implements RepositorioEmpleados {

	@Override
	public void evaluarCumplea�osEmpleados(ArrayList<Empleado> empleados) throws MessagingException {
		for (Empleado empleado : empleados) {
			if (empleado.evaluarCumple(LocalDate.now()))
				mandarEmail(empleado.nombre(), empleado.correoElectronico());
		}

	}

	private void mandarEmail(String nombre, String correo) throws MessagingException {
		// Put recipient�s address
		String to = correo;

		// Put sender�s address
		// String from = "from@example.com";
		final String username = "5073f6cdd71bde";// username generated by Mailtrap
		final String password = "fcfc0636ac8f16";// password generated by Mailtrap

		// Paste host address from the SMTP settings tab in your Mailtrap Inbox
		String host = "smtp.mailtrap.io";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");

		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "2525");// use one of the options in the SMTP settings tab in your Mailtrap Inbox

		// Get the Session object.

		// Get the Session object.
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		Message message = new MimeMessage(session);

		// Set Subject: header field
		message.setSubject("My first message with JavaMail");

		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

		// Put the content of your message
		message.setText("Feliz Cumple " + nombre + "!!!!");

		// Send message
		Transport.send(message);

		System.out.println("Sent message successfully....");

	}
}
