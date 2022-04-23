package ar.unrn.tp4.modelo;

import java.time.LocalDate;

public class Empleado {
	private String nombre;
	private String apellido;
	private LocalDate fechaNacimiento;
	private String correoElectronico;

	public Empleado(String apellido, String nombre, String fechaNacimiento, String correoElectronico) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = LocalDate.parse(fechaNacimiento);
		this.correoElectronico = correoElectronico;
	}

	public Boolean evaluarCumple(LocalDate fecha) {
		if (fechaNacimiento.getDayOfMonth() == fecha.getDayOfMonth()
				&& fechaNacimiento.getMonthValue() == fecha.getMonthValue()) {
			return true;
		}
		return false;
	}

	public String nombre() {
		return this.nombre;
	}

	public String correoElectronico() {
		return this.correoElectronico;
	}

}
