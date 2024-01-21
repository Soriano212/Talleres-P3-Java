package Vista;

import javax.swing.*;
import java.awt.*;

public class InterfazLibreria {

    public JFrame frame;
    public JTextField isbnField, tituloField, autorField, precioField, stockField, isbnVenderField, cantidadField;
    public JTable table;
    public JButton addButton, venderButton;

    public InterfazLibreria() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Sistema de Gestión de Librería");
        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(0, 2));
        frame.add(panel, BorderLayout.NORTH);

        panel.add(new JLabel("- Agregar Libros -"));
        panel.add(new JLabel(""));

        panel.add(new JLabel("ISBN:"));
        isbnField = new JTextField();
        panel.add(isbnField);

        panel.add(new JLabel("Título:"));
        tituloField = new JTextField();
        panel.add(tituloField);

        panel.add(new JLabel("Autor:"));
        autorField = new JTextField();
        panel.add(autorField);

        panel.add(new JLabel("Precio:"));
        precioField = new JTextField();
        panel.add(precioField);

        panel.add(new JLabel("Stock:"));
        stockField = new JTextField();
        panel.add(stockField);

        addButton = new JButton("Agregar Libro");
        panel.add(addButton);
        panel.add(new JLabel(""));

        panel.add(new JLabel("- Vender Libros -"));
        panel.add(new JLabel(""));

        panel.add(new JLabel("ISBN:"));
        isbnVenderField = new JTextField();
        panel.add(isbnVenderField);

        panel.add(new JLabel("Cantidad:"));
        cantidadField = new JTextField();
        panel.add(cantidadField);

        venderButton = new JButton("Vender Libros");
        panel.add(venderButton);

        // Tabla para mostrar los libros
        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
