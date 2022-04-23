package ar.unrn.tp4.modelo;

import java.time.LocalDate;

public class Concurso {
	private String id;
	private String nombre;
	private LocalDate fechaInicioInscripcion;
	private LocalDate fechaFinInscripcion;

	public Concurso(String id, String nombre, LocalDate fechaInicio, LocalDate fechaFin) {
		this.id = id;
		this.nombre = nombre;
		this.fechaInicioInscripcion = fechaInicio;
		this.fechaFinInscripcion = fechaFin;
	}

	public Boolean estaAbierto() {
		if (LocalDate.now().isAfter(fechaInicioInscripcion) && LocalDate.now().isBefore(fechaFinInscripcion))
			return true;
		return false;
	}

	public String nombre() {
		return nombre;
	}

	public String id() {
		return id;
	}
}
