package Vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class InterfazDatos extends JFrame {
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JButton btnAbrir;
    private JButton btnAgregar;
    private JButton btnGuardar;
    private JTable tabla;
    private DefaultTableModel tableModel;
    private ArrayList<ActionListener> agregarListeners;
    private ArrayList<ActionListener> guardarListeners;
    private ArrayList<ActionListener> abrirListeners;

    public InterfazDatos() {
        super("Aplicación de Datos");

        txtNombre = new JTextField(20);
        txtApellido = new JTextField(20);
        btnAbrir = new JButton("Abrir");
        btnAgregar = new JButton("Agregar");
        btnGuardar = new JButton("Guardar");

        // Crear la tabla y su modelo
        tableModel = new DefaultTableModel();
        tabla = new JTable(tableModel);
        tableModel.addColumn("Nombre");
        tableModel.addColumn("Apellido");

        JPanel panelDatos = new JPanel();
        panelDatos.setLayout(new FlowLayout());
        panelDatos.add(new JLabel("Nombre:"));
        panelDatos.add(txtNombre);
        panelDatos.add(new JLabel("Apellido:"));
        panelDatos.add(txtApellido);
        panelDatos.add(btnAgregar);
        panelDatos.add(btnAbrir);
        panelDatos.add(btnGuardar);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panelDatos, BorderLayout.NORTH);
        getContentPane().add(new JScrollPane(tabla), BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setVisible(true);

        agregarListeners = new ArrayList<>();
        guardarListeners = new ArrayList<>();
        abrirListeners = new ArrayList<>();

        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (ActionListener listener : agregarListeners) {
                    listener.actionPerformed(e);
                }
            }
        });

        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (ActionListener listener : guardarListeners) {
                    listener.actionPerformed(e);
                }
            }
        });

        btnAbrir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (ActionListener listener : abrirListeners) {
                    listener.actionPerformed(e);
                }
            }
        });
    }

    public void agregarAgregarListener(ActionListener listener) {
        agregarListeners.add(listener);
    }

    public void agregarGuardarListener(ActionListener listener) {
        guardarListeners.add(listener);
    }

    public void agregarAbrirListener(ActionListener listener) {
        abrirListeners.add(listener);
    }

    public String getNombre() {
        return txtNombre.getText();
    }

    public String getApellido() {
        return txtApellido.getText();
    }

    public void limpiarCampos() {
        txtNombre.setText("");
        txtApellido.setText("");
    }

    public void agregarFila(String[] fila) {
        tableModel.addRow(fila);
    }

    public void limpiarTabla() {
        tableModel.setRowCount(0);
    }
}
