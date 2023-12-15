package Controlador;

import Vista.InterfazDatos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class ControladorDatos {
    private InterfazDatos vista;
    private ArrayList<String[]> datos;

    public ControladorDatos(InterfazDatos vista) {
        this.vista = vista;
        this.datos = new ArrayList<>();

        vista.agregarAgregarListener(new AgregarListener());
        vista.agregarGuardarListener(new GuardarListener());
        vista.agregarAbrirListener(new AbrirListener());
    }

    private class AgregarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String nombre = vista.getNombre();
            String apellido = vista.getApellido();

            if (!nombre.isEmpty() && !apellido.isEmpty()) {
                String[] fila = {nombre, apellido};
                datos.add(fila);
                vista.agregarFila(fila);
                vista.limpiarCampos();
            }
        }
    }

    private class GuardarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            guardarDatosEnArchivo();
        }
    }

    private class AbrirListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileChooser = new JFileChooser();
            int resultado = fileChooser.showOpenDialog(null);

            if (resultado == JFileChooser.APPROVE_OPTION) {
                File archivo = fileChooser.getSelectedFile();
                cargarDatosDesdeArchivo(archivo);
            }
        }
    }

    private void guardarDatosEnArchivo() {
        JFileChooser fileChooser = new JFileChooser();
        int resultado = fileChooser.showSaveDialog(null);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
                for (String[] fila : datos) {
                    bw.write(fila[0] + "," + fila[1] + "\n");
                }
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void cargarDatosDesdeArchivo(File archivo) {
        vista.limpiarTabla();
        datos.clear();
        try {
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 2) {
                    datos.add(partes);
                    vista.agregarFila(partes);
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void agregarDatos(String nombre, String apellido) {
        String[] fila = {nombre, apellido};
        datos.add(fila);
        vista.agregarFila(fila);
    }

    public int obtenerCantidadDeDatos() {
        return datos.size();
    }

    public void limpiarDatos() {
        datos.clear();
        vista.limpiarTabla();
    }
}
