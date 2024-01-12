package Vista;

import javax.swing.*;
import java.awt.*;

public class CryptoGUI extends JFrame{
    public JButton generateButton, loadButton, encryptButton, decryptButton;
    private final JTextArea logTextArea;

    public CryptoGUI() {
        setTitle("Encriptado con RSA");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        generateButton = new JButton("Generar Claves");
        loadButton = new JButton("Cargar Clave Privada");
        encryptButton = new JButton("Encriptar Archivo");
        decryptButton = new JButton("Desencriptar Archivo");

        logTextArea = new JTextArea();
        logTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(logTextArea);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(generateButton);
        buttonPanel.add(loadButton);
        buttonPanel.add(encryptButton);
        buttonPanel.add(decryptButton);

        add(buttonPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    public void log(String message) {
        logTextArea.append(message + "\n");
    }
}
