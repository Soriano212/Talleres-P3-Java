package Controlador;

import Modelo.ManejadorDatos;
import Vista.Ventana;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

public class Controlador implements ActionListener {
    Ventana ven1;
    DefaultTableModel modelo;
    ManejadorDatos mjdDatos;

    public Controlador() {
        this.ven1 = new Ventana();
        this.mjdDatos = new ManejadorDatos();

        iniciarVentana();

        //Cargar comboBox
        mjdDatos.agregarPais("México");
        mjdDatos.agregarPais("Estados Unidos");
        mjdDatos.agregarPais("Canadá");
        mjdDatos.agregarPais("España");

        cargarComboBoxPaises();

        //Cargar Listeners
        ven1.buttonAgregar.addActionListener(this);
        ven1.buttonLimpiar.addActionListener(this);

        //Cargar Tabla
        cargarTabla();
    }

    public void iniciarVentana() {
        ven1.setVisible(true);
        ven1.setLocationRelativeTo(null);
        ven1.setTitle("Agencia de viajes");
        ven1.setResizable(false);
        ven1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ven1.pack();
    }

    public void cargarComboBoxPaises(){
        ven1.comboBoxPaises.removeAllItems();
        String[] paises = mjdDatos.obtenerPaises();
        for (String pais : paises) {
            ven1.comboBoxPaises.addItem(pais);
        }
    }

    public void cargarTabla() {
        String[] titulos = {"País", "Paquete", "Extras"};
        String[][] datos = mjdDatos.obtenerSelecciones();
        modelo = new DefaultTableModel(datos, titulos);
        ven1.table.setModel(modelo);
    }

    public void limpiar(){
        ven1.comboBoxPaises.setSelectedIndex(0);
        ven1.buttonGroupPaquetes.clearSelection();
        ven1.autoCheckBox.setSelected(false);
        ven1.comidasCheckBox.setSelected(false);
        ven1.guíaTuristicoCheckBox.setSelected(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ven1.buttonAgregar) {
            String pais = (String) ven1.comboBoxPaises.getSelectedItem();
            String paquete = "";

            Enumeration<AbstractButton> elementos = ven1.buttonGroupPaquetes.getElements();
            while (elementos.hasMoreElements()) {
                JRadioButton radioButton = (JRadioButton) elementos.nextElement();
                if (radioButton.isSelected()) {
                    paquete = radioButton.getText();
                    break;
                }
            }


            String extras = "";
            if (ven1.autoCheckBox.isSelected()) {
                extras += "Auto, ";
            }
            if (ven1.comidasCheckBox.isSelected()) {
                extras += "3 Comidas, ";
            }
            if (ven1.guíaTuristicoCheckBox.isSelected()) {
                extras += "Guía turístico, ";
            }
            if (extras.length() > 0) {
                extras = extras.substring(0, extras.length() - 2);
            }

            mjdDatos.agregarSeleccion(pais, paquete, extras);
            cargarTabla();
            limpiar();
        }
        if (e.getSource() == ven1.buttonLimpiar) {
            limpiar();
        }
    }
}
