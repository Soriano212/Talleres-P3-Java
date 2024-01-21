package Modelo;

public class Ventas {
    private GestorLibros gestorLibros;

    public Ventas(GestorLibros gestorLibros) {
        this.gestorLibros = gestorLibros;
    }

    public boolean realizarVenta(int isbn, int cantidad) {
        Libro libro = gestorLibros.buscarLibro(isbn);
        if (libro != null && libro.getStock() >= cantidad) {
            libro.setStock(libro.getStock() - cantidad);
            return true;
        }
        return false;
    }
}
