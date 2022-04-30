package ar.unrn.tp4.webServices;

import javax.mail.MessagingException;

import ar.unrn.tp4.modelo.Mandador;

public class StubBirthdayEmailSender implements Mandador {

	private StringBuffer emails;

	public StubBirthdayEmailSender() {
		emails = new StringBuffer();
	}

	@Override
	public void mandarEmail(String nombre, String correo) throws MessagingException {
		this.emails.append("Feliz Cumple " + nombre);
	}

	public StringBuffer emails() {
		return emails;
	}
}
