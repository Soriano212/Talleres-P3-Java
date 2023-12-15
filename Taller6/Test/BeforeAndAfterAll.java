import Controlador.ControladorDatos;
import Vista.InterfazDatos;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BeforeAndAfterAll {
    private static ControladorDatos controlador;

    @BeforeAll
    public static void setUp() {
        // Configurar el controlador antes de todas las pruebas
        InterfazDatos vista = new InterfazDatos();
        controlador = new ControladorDatos(vista);
    }

    @AfterAll
    public static void tearDown() {
        // Limpiar los datos después de todas las pruebas
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
