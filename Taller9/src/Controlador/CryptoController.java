package Controlador;

import Modelo.CryptoRSA;
import Vista.CryptoGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class CryptoController implements ActionListener {
    private final CryptoGUI view;
    private String privateKeyFilePath;

    public CryptoController() {
        view = new CryptoGUI();
        view.setVisible(true);

        view.generateButton.addActionListener(this);
        view.loadButton.addActionListener(this);
        view.encryptButton.addActionListener(this);
        view.decryptButton.addActionListener(this);
    }

    public void loadPrivateKey() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(view);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                this.privateKeyFilePath = selectedFile.getName();

                view.log("Clave privada cargada correctamente.");
            } catch (Exception e) {
                view.log("Error al cargar las clave privada: " + e.getMessage());
            }
        }
    }

    public String loadPublicKey() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(view);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                String publicKeyFilePath = selectedFile.getName();

                view.log("Clave publica cargada correctamente.");
                return publicKeyFilePath;
            } catch (Exception e) {
                view.log("Error al cargar las clave publica: " + e.getMessage());
            }
        }
        return null;
    }

    public void decryptFile() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(view);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {

                String pathFile = String.valueOf(selectedFile.toPath());

                CryptoRSA.decryptFile(privateKeyFilePath, pathFile);

                view.log("Archivo desencriptado correctamente.");
            } catch (Exception e) {
                view.log("Error al desencriptar el archivo: " + e.getMessage());
            }
        }
    }

    public void encryptFile(String publicKeyFilePath) {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(view);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                String pathFile = String.valueOf(selectedFile.toPath());

                CryptoRSA.encryptFile(publicKeyFilePath, pathFile);

                view.log("Archivo encriptado correctamente.");
            } catch (Exception e) {
                view.log("Error al encriptar el archivo: " + e.getMessage());
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == view.generateButton) {
            try {
                CryptoRSA.generateKeyPair("private.key", "private.key.pub");
                view.log("Claves generadas correctamente.");
            } catch (Exception ex) {
                view.log("Error al generar las claves: " + ex.getMessage());
            }
        } else if(e.getSource() == view.loadButton) {
            loadPrivateKey();
        } else if(e.getSource() == view.encryptButton) {
            String publicKeyFilePath = loadPublicKey();
            encryptFile(publicKeyFilePath);
        } else if(e.getSource() == view.decryptButton) {
            decryptFile();
        }
    }
}
