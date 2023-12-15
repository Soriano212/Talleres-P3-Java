import Controlador.ControladorDatos;
import Vista.InterfazDatos;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BeforeAndAfterEach {
    private ControladorDatos controlador;

    @BeforeEach
    public void setUp() {
        // Configurar el controlador antes de cada prueba
        InterfazDatos vista = new InterfazDatos();
        controlador = new ControladorDatos(vista);
    }

    @AfterEach
    public void tearDown() {
        // Limpiar los datos después de cada prueba
        controlador.limpiarDatos();
    }

    @Test
    public void testAgregarDatos() {
        // Verificar que los datos se agreguen correctamente
        controlador.agregarDatos("John", "Doe");
        controlador.agregarDatos("Alice", "Smith");

        assertEquals(2, controlador.obtenerCantidadDeDatos());
    }

    @Test
    public void testAgregarDatos2() {
        // Verificar que los datos se agreguen correctamente
        controlador.agregarDatos("John", "Doe");
        controlador.agregarDatos("Alice", "Smith");

        assertEquals(2, controlador.obtenerCantidadDeDatos());
    }
}
