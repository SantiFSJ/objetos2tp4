package ar.unrn.tp4.modelo;

import java.util.ArrayList;

import javax.mail.MessagingException;

public interface RepositorioEmpleados {
	public void evaluarCumplea�osEmpleados(ArrayList<Empleado> empleados) throws MessagingException;
}
