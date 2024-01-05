package Vista;

import javax.swing.*;
import java.awt.*;

public class SignatureGUI extends JFrame {
    public JButton generateButton, loadButton, signButton, verifyButton;
    private final JTextArea logTextArea;

    public SignatureGUI() {
        setTitle("Firma Digital");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        generateButton = new JButton("Generar Claves");
        loadButton = new JButton("Cargar Clave Privada");
        signButton = new JButton("Firmar Archivo");
        verifyButton = new JButton("Verificar Archivo");

        logTextArea = new JTextArea();
        logTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(logTextArea);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(generateButton);
        buttonPanel.add(loadButton);
        buttonPanel.add(signButton);
        buttonPanel.add(verifyButton);

        add(buttonPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    public void log(String message) {
        logTextArea.append(message + "\n");
    }
}
