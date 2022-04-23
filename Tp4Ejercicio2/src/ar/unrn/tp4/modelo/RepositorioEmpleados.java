package ar.unrn.tp4.modelo;

import java.util.ArrayList;

import javax.mail.MessagingException;

public interface RepositorioEmpleados {
	public void evaluarCumpleaņosEmpleados(ArrayList<Empleado> empleados) throws MessagingException;
}
