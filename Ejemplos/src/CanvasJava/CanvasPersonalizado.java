package CanvasJava;

import javax.swing.*;
import java.awt.*;

public class CanvasPersonalizado extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Realiza el dibujo personalizado aquí
        g.setColor(Color.RED);
        g.fillRect(50, 50, 100, 100);

        g.setColor(Color.BLUE);
        g.fillRect(0, 0, 50, 50);

        g.fillOval(60, 60, 50, 100);
    }
}

