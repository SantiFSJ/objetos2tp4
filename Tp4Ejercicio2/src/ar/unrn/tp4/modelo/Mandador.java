package ar.unrn.tp4.modelo;

import javax.mail.MessagingException;

public interface Mandador {
	public void mandarEmail(String nombre, String correo) throws MessagingException;
}
