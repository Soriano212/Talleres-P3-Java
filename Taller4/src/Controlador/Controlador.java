package Controlador;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modelo.GestorLibros;
import Modelo.Libro;
import Vista.InterfazLibreria;
import Modelo.Ventas;

public class Controlador implements ActionListener{

    private InterfazLibreria vista;
    private GestorLibros gestorLibros;
    private Ventas ventas;
    private DefaultTableModel tableModel;

    public Controlador(InterfazLibreria vista) {
        this.vista = vista;
        this.gestorLibros = new GestorLibros();
        this.ventas = new Ventas(gestorLibros);

        this.vista.addButton.addActionListener(this);
        this.vista.venderButton.addActionListener(this);

        this.actualizarTabla();
    }

    private void actualizarTabla(){
        this.tableModel = new DefaultTableModel();
        this.tableModel.addColumn("ISBN");
        this.tableModel.addColumn("Título");
        this.tableModel.addColumn("Autor");
        this.tableModel.addColumn("Precio");
        this.tableModel.addColumn("Stock");
        for(Libro libro : this.gestorLibros.listarLibros()){
            Object[] fila = new Object[5];
            fila[0] = libro.getIsbn();
            fila[1] = libro.getTitulo();
            fila[2] = libro.getAutor();
            fila[3] = libro.getPrecio();
            fila[4] = libro.getStock();
            this.tableModel.addRow(fila);
        }
        this.vista.table.setModel(tableModel);
    }

    private void venderLibros() {
        try {
            int isbn = Integer.parseInt(vista.isbnVenderField.getText());
            int cantidad = Integer.parseInt(vista.cantidadField.getText());
            if (ventas.realizarVenta(isbn, cantidad)) {
                JOptionPane.showMessageDialog(vista.frame, "Venta realizada exitosamente!");
                this.actualizarTabla();
                this.limpiaCampos();
            } else {
                JOptionPane.showMessageDialog(vista.frame, "No se pudo realizar la venta", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(vista.frame, "Error en los datos ingresados", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void agregarLibro() {
        try {
            int isbn = Integer.parseInt(vista.isbnField.getText());
            String titulo = vista.tituloField.getText();
            String autor = vista.autorField.getText();
            double precio = Double.parseDouble(vista.precioField.getText());
            int stock = Integer.parseInt(vista.stockField.getText());
            Libro libro = new Libro(isbn, titulo, autor, precio, stock);
            gestorLibros.agregarLibro(libro);
            JOptionPane.showMessageDialog(vista.frame, "Libro agregado exitosamente!");
            this.actualizarTabla();
            this.limpiaCampos();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(vista.frame, "Error en los datos ingresados", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpiaCampos() {
        vista.isbnField.setText("");
        vista.tituloField.setText("");
        vista.autorField.setText("");
        vista.precioField.setText("");
        vista.stockField.setText("");
        vista.isbnVenderField.setText("");
        vista.cantidadField.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.addButton) {
            agregarLibro();
        } else if (e.getSource() == vista.venderButton) {
            venderLibros();
        }
    }
}
