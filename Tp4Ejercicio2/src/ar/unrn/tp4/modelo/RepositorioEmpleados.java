package ar.unrn.tp4.modelo;

import java.io.IOException;
import java.util.List;

public interface RepositorioEmpleados {
	List<Empleado> leerArchivo() throws IOException;
}
