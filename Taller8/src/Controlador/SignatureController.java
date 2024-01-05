package Controlador;

import Modelo.SignatureUtils;
import Vista.SignatureGUI;

import javax.swing.*;
import java.awt.event.*;
import java.io.File;

public class SignatureController implements ActionListener{
    private final SignatureGUI view;
    private String privateKeyFilePath;

    public SignatureController() {
        view = new SignatureGUI();
        view.setVisible(true);

        view.generateButton.addActionListener(this);
        view.loadButton.addActionListener(this);
        view.signButton.addActionListener(this);
        view.verifyButton.addActionListener(this);
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

    public void signFile() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(view);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {

                String pathFile = String.valueOf(selectedFile.toPath());

                SignatureUtils.signFile(privateKeyFilePath, pathFile);

                view.log("Archivo firmado correctamente.");
            } catch (Exception e) {
                view.log("Error al firmar el archivo: " + e.getMessage());
            }
        }
    }

    public void verifySignature(String publicKeyFilePath) {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(view);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                String pathFile = String.valueOf(selectedFile.toPath());
                String pathFileSignature = pathFile + ".sig";

                boolean isCorrect = SignatureUtils.verifyFileSignature(publicKeyFilePath, pathFile, pathFileSignature);

                if (isCorrect) {
                    view.log("La firma es correcta.");
                } else {
                    view.log("La firma es incorrecta.");
                }
            } catch (Exception e) {
                view.log("Error al verificar la firma: " + e.getMessage());
            }
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == view.generateButton) {
            try {
                SignatureUtils.generateKeyPair("private.key", "private.key.pub");
                view.log("Claves generadas correctamente.");
            } catch (Exception ex) {
                view.log("Error al generar las claves: " + ex.getMessage());
            }
        } else if(e.getSource() == view.loadButton) {
            loadPrivateKey();
        } else if(e.getSource() == view.signButton) {
            signFile();
        } else if(e.getSource() == view.verifyButton) {
            String publicKeyFilePath = loadPublicKey();
            verifySignature(publicKeyFilePath);
        }
    }
}
