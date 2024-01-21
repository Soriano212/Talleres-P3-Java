package Modelo;

public class Libro {
    private int isbn;
    private String titulo;
    private String autor;
    private double precio;
    private int stock;

    public Libro(int isbn, String titulo, String autor, double precio, int stock) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.precio = precio;
        this.stock = stock;
    }

    // Métodos get y set para cada atributo
    public int getIsbn() { return isbn; }
    public void setIsbn(int isbn) { this.isbn = isbn; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }
    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }
    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }
}

