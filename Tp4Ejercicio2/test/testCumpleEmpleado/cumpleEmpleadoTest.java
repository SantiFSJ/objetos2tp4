package testCumpleEmpleado;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

//import org.junit.jupiter.api.Test;

import ar.unrn.tp4.accesos.StubEscaner;
import ar.unrn.tp4.modelo.CumpleEmpleado;
import ar.unrn.tp4.webServices.StubBirthdayEmailSender;

public class cumpleEmpleadoTest {
	@Test
	public void testMandarFelicitacionCumple() throws IOException {
		// Set up
		StubBirthdayEmailSender emailSender = new StubBirthdayEmailSender();
		StubEscaner escaner = new StubEscaner();
		CumpleEmpleado ce = new CumpleEmpleado(escaner, emailSender);

		// Ejecucion
		ce.run();

		// Verificacion
		String resultadoEsperado = "Feliz cumple Brian";
		assertEquals(resultadoEsperado, emailSender.emails().toString());
	}
}
