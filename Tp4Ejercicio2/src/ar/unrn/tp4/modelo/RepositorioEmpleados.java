package ar.unrn.tp4.modelo;

import java.util.ArrayList;

import javax.mail.MessagingException;

public interface RepositorioEmpleados {
	public void evaluarCumpleañosEmpleados(ArrayList<Empleado> empleados) throws MessagingException;
}
