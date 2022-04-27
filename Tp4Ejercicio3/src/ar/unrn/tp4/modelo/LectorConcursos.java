package ar.unrn.tp4.modelo;

import java.io.IOException;
import java.util.ArrayList;

public interface LectorConcursos {
	ArrayList<Concurso> leerConcuros() throws IOException;
}
