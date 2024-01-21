package Modelo;

import java.util.HashMap;
import java.util.Collection;

public class GestorLibros {
    private HashMap<Integer, Libro> libros;

    public GestorLibros() {
        libros = new HashMap<>();
    }

    public void agregarLibro(Libro libro) {
        libros.put(libro.getIsbn(), libro);
    }

    public Libro buscarLibro(int isbn) {
        return libros.get(isbn);
    }

    public Collection<Libro> listarLibros() {
        return libros.values();
    }
}
