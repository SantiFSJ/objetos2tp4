package ar.unrn.tp4.accesos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ar.unrn.tp4.modelo.Empleado;
import ar.unrn.tp4.modelo.RepositorioEmpleados;

public class StubEscaner implements RepositorioEmpleados {

	public StubEscaner() {

	}

	@Override
	public List<Empleado> leerArchivo() throws IOException {

		ArrayList<Empleado> listaEmpleados = new ArrayList<>();

		listaEmpleados.add(new Empleado("Young", "Angus", "1982-10-08", "angus@acdc.com"));
		listaEmpleados.add(new Empleado("Johnson", "Brian", "1975-04-29", "brian@acdc.com"));
		listaEmpleados.add(new Empleado("Martinez", "Julio", "1990-04-22", "julio@acdc.com"));

		return listaEmpleados;

	}
}
