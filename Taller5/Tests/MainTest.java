import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    // Test para el método calcularFactorial
    @Test
    void testFactorialNumeroPositivo() {
        assertEquals(120, Main.calcularFactorial(5), "El factorial de 5 debe ser 120");
    }

    @Test
    void testFactorialCero() {
        assertEquals(1, Main.calcularFactorial(0), "El factorial de 0 debe ser 1");
    }

    @Test
    void testFactorialNumeroNegativo() {
        assertThrows(IllegalArgumentException.class, () -> {
            Main.calcularFactorial(-5);
        }, "Calcular el factorial de un número negativo debe lanzar IllegalArgumentException");
    }

    // Test para el método esPalindromo
    @Test
    void testEsPalindromoConPalindromos() {
        assertTrue(Main.esPalindromo("ana"), "ana es un palíndromo");
        assertTrue(Main.esPalindromo("Anita lava la tina"), "'Anita lava la tina' es un palíndromo");
    }

    @Test
    void testEsPalindromoConNoPalindromos() {
        assertFalse(Main.esPalindromo("java"), "java no es un palíndromo");
    }

    @Test
    void testEsPalindromoConCadenaVacia() {
        assertTrue(Main.esPalindromo(""), "Una cadena vacía es un palíndromo");
    }

    @Test
    void testEsPalindromoConMayusculasYMinusculas() {
        assertTrue(Main.esPalindromo("Ana"), "Ana es un palíndromo ignorando mayúsculas y minúsculas");
    }

    // Test para el método busquedaBinaria
    @Test
    void testBusquedaBinariaConElementoPresente() {
        ArrayList<Integer> lista = new ArrayList<>();
        lista.add(1);
        lista.add(3);
        lista.add(5);
        lista.add(7);
        lista.add(9);
        assertEquals(2, Main.busquedaBinaria(lista, 5), "El elemento 5 debería estar en el índice 2");
    }

    @Test
    void testBusquedaBinariaConElementoNoPresente() {
        ArrayList<Integer> lista = new ArrayList<>();
        lista.add(2);
        lista.add(4);
        lista.add(6);
        assertEquals(-1, Main.busquedaBinaria(lista, 5), "El elemento 5 no está en la lista, debería devolver -1");
    }

    @Test
    void testBusquedaBinariaConListaVacia() {
        ArrayList<Integer> lista = new ArrayList<>();
        assertEquals(-1, Main.busquedaBinaria(lista, 1), "Una lista vacía debería devolver -1 para cualquier búsqueda");
    }

    @Test
    void testBusquedaBinariaConListaDeUnElemento() {
        ArrayList<Integer> lista = new ArrayList<>();
        lista.add(1);
        assertEquals(0, Main.busquedaBinaria(lista, 1), "El elemento 1 debería estar en el índice 0");
        assertEquals(-1, Main.busquedaBinaria(lista, 2), "El elemento 2 no está en la lista, debería devolver -1");
    }

    @Test
    void testBusquedaBinariaConListaNoOrdenada() {
        ArrayList<Integer> listaNoOrdenada = new ArrayList<>();
        listaNoOrdenada.add(3);
        listaNoOrdenada.add(1);
        listaNoOrdenada.add(4);
        listaNoOrdenada.add(2);

        int resultado = Main.busquedaBinaria(listaNoOrdenada, 3);

        assertNotEquals(0, resultado, "La búsqueda en una lista no ordenada no debería funcionar correctamente");
    }
}